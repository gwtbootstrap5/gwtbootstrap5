package org.gwtbootstrap5.client.ui.constants;

/*-
 * ==========================LICENSE_START===============================
 * GwtBootstrap5
 * ======================================================================
 * Copyright (C) 2023 - 2026 GwtBootstrap5
 * ======================================================================
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * ==========================LICENSE_END=================================
 */

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.BeforeClass;
import org.junit.Test;

import com.google.gwt.dom.client.Style;

/**
 * Checks that every CSS class the core writes exists in the bundled Bootstrap 5 and Bootstrap Icons
 * CSS, so classes from Bootstrap 3 or 4 can't creep back in. It covers the {@link Styles} constants
 * and every enum in this package that implements {@link Style.HasCssName}.
 * <p>
 * Runs on the plain JVM (no GWT), in every build.
 */
public class BootstrapClassesTest {

    private static final String CSS_DIR = "/org/gwtbootstrap5/client/resource/css/";
    private static final String[] CSS_FILES = {"bootstrap-5.3.8.min.cache.css", "bootstrap-icons-1.13.1.min.cache.css"};

    /**
     * Enums implementing {@link Style.HasCssName} whose values are attribute values, not classes.
     */
    private static final Set<Class<?>> ATTRIBUTE_VALUE_ENUMS = new HashSet<>(Arrays.asList(
            Placement.class, // data-bs-placement
            Trigger.class // data-bs-trigger
    ));

    /**
     * Classes Bootstrap's JavaScript reads but its CSS doesn't style.
     */
    private static final Set<String> JS_ONLY_CLASSES = new HashSet<>(Arrays.asList(
            "slide" // .carousel.slide turns on the slide animation in carousel.js
    ));

    /**
     * Bootstrap 3/4 classes still in use, removed phase by phase by the Bootstrap 3/4 cleanup.
     * Each entry must still be missing from the CSS, so fixing one fails the test until it's
     * removed from this list. The list must end empty.
     */
    private static final Set<String> KNOWN_MISSING = new TreeSet<>(Arrays.asList(
            "ButtonType.DEFAULT", "ButtonType.LINK_OUTLINE",
            "ColumnOffset.XS_0", "ColumnOffset.XS_12",
            "FormType.INLINE",
            "LabelType.DEFAULT", "LabelType.PRIMARY", "LabelType.SUCCESS", "LabelType.INFO",
            "LabelType.WARNING", "LabelType.DANGER",
            "NavbarPosition.FIXED_TOP", "NavbarPosition.FIXED_BOTTOM", "NavbarPosition.STATIC_TOP",
            "NavbarType.DEFAULT",
            "ProgressType.STRIPED",
            "RowContentJustifyAlign.AROUND", "RowContentJustifyAlign.BETWEEN",
            "SpinnerType.BORDER", "SpinnerType.GROW",
            "Styles.BTN_GROUP_TOGGLE", "Styles.CAPTION", "Styles.CAROUSEL_CONTROL", "Styles.HIDE",
            "Styles.IN", "Styles.MODAL_DIALOG_CENTERED", "Styles.RADIO", "Styles.WIDTH",
            "THeadType.DEFAULT", "THeadType.INVERSE",
            "TableType.INVERSE"
    ));

    private static final Pattern CSS_CLASS = Pattern.compile("\\.(-?[_a-zA-Z][\\w-]*)");

    private static Set<String> cssClasses;

    @BeforeClass
    public static void readCss() throws IOException {
        cssClasses = new HashSet<>();
        for (String file : CSS_FILES) {
            try (InputStream in = BootstrapClassesTest.class.getResourceAsStream(CSS_DIR + file)) {
                assertTrue("Missing " + file, in != null);
                Matcher m = CSS_CLASS.matcher(new String(in.readAllBytes(), StandardCharsets.UTF_8));
                while (m.find()) {
                    cssClasses.add(m.group(1));
                }
            }
        }
    }

    @Test
    public void everyClassExistsInBootstrap5() throws Exception {
        Map<String, String> missing = findMissing();

        List<String> unexpected = new ArrayList<>();
        missing.forEach((owner, classes) -> {
            if (!KNOWN_MISSING.contains(owner)) {
                unexpected.add(owner + " = \"" + classes + "\"");
            }
        });
        assertTrue("Classes not in Bootstrap 5: " + unexpected, unexpected.isEmpty());

        Set<String> fixed = new TreeSet<>(KNOWN_MISSING);
        fixed.removeAll(missing.keySet());
        assertTrue("Fixed, remove from KNOWN_MISSING: " + fixed, fixed.isEmpty());
    }

    /**
     * @return owner ("Styles.IN", "ButtonType.DEFAULT") mapped to its classes missing from the CSS
     */
    private static Map<String, String> findMissing() throws Exception {
        Map<String, String> missing = new TreeMap<>();

        for (Field field : Styles.class.getFields()) {
            if (Modifier.isStatic(field.getModifiers()) && field.getType() == String.class) {
                check("Styles." + field.getName(), (String) field.get(null), missing);
            }
        }

        for (Class<?> type : constantTypes()) {
            if (!type.isEnum() || !Style.HasCssName.class.isAssignableFrom(type)
                    || ATTRIBUTE_VALUE_ENUMS.contains(type)) {
                continue;
            }
            for (Object constant : type.getEnumConstants()) {
                check(type.getSimpleName() + "." + ((Enum<?>) constant).name(),
                        ((Style.HasCssName) constant).getCssName(), missing);
            }
        }
        return missing;
    }

    private static void check(String owner, String value, Map<String, String> missing) {
        if (value == null) {
            return;
        }
        List<String> absent = new ArrayList<>();
        for (String cssClass : value.trim().split("\\s+")) {
            if (cssClass.isEmpty() || isFontAwesome(cssClass) || JS_ONLY_CLASSES.contains(cssClass)) {
                continue;
            }
            if (!cssClasses.contains(cssClass)) {
                absent.add(cssClass);
            }
        }
        if (!absent.isEmpty()) {
            missing.put(owner, String.join(" ", absent));
        }
    }

    /**
     * Font Awesome classes ({@code fa}, {@code fas}, {@code fa-*}) aren't part of Bootstrap.
     */
    private static boolean isFontAwesome(String cssClass) {
        return cssClass.equals("fa") || cssClass.equals("fas") || cssClass.startsWith("fa-");
    }

    private static List<Class<?>> constantTypes() throws ClassNotFoundException, URISyntaxException {
        String pkg = Styles.class.getPackage().getName();
        // The directory of Styles.class itself: the package also exists under test-classes
        URL stylesClass = Styles.class.getResource("Styles.class");
        File dir = new File(stylesClass.toURI()).getParentFile();
        File[] files = dir.listFiles((d, name) -> name.endsWith(".class") && !name.contains("$"));
        List<Class<?>> types = new ArrayList<>();
        for (File file : files) {
            types.add(Class.forName(pkg + "." + file.getName().replace(".class", "")));
        }
        return types;
    }
}
