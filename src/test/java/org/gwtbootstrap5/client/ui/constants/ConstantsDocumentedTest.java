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

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import org.junit.Test;

/**
 * The constants are documented per type, not per constant, which doclint can't check: their
 * package can't join {@code javadoc.documented.packages}. This test keeps it documented instead:
 * every type has a description, and every public method and constructor has javadoc, or overrides
 * one that has.
 */
public class ConstantsDocumentedTest {

    private static final Path SOURCES = Paths.get("src/main/java/org/gwtbootstrap5/client/ui/constants");
    private static final Pattern TYPE = Pattern.compile("^public (?:final |abstract )*(?:class|enum|interface) (\\w+)");
    private static final Pattern MEMBER = Pattern.compile("^\\s+(?:public |protected )(?!static final|final static)[^=;]*\\(.*");

    @Test
    public void everyTypeAndMethodHasJavadoc() throws IOException {
        final List<String> gaps = new ArrayList<>();
        try (Stream<Path> files = Files.list(SOURCES)) {
            files.filter(f -> f.toString().endsWith(".java") && !f.endsWith("package-info.java")).sorted()
                    .forEach(f -> check(f, gaps));
        }
        assertTrue("Undocumented in client/ui/constants:\n" + String.join("\n", gaps), gaps.isEmpty());
    }

    private static void check(final Path file, final List<String> gaps) {
        final List<String> lines;
        try {
            lines = Files.readAllLines(file, StandardCharsets.UTF_8);
        } catch (final IOException e) {
            throw new IllegalStateException(e);
        }
        final String name = file.getFileName().toString();
        for (int i = 0; i < lines.size(); i++) {
            final Matcher type = TYPE.matcher(lines.get(i));
            if (type.find()) {
                if (!hasDescription(lines, i)) {
                    gaps.add(name + ": the type has no description");
                }
                final boolean isClass = lines.get(i).contains(" class ");
                final boolean hasConstructor = lines.stream().anyMatch(l -> l.matches("\\s+(public |protected |private )?"
                        + type.group(1) + "\\(.*"));
                if (isClass && !hasConstructor) {
                    gaps.add(name + ": the default constructor has no javadoc");
                }
            } else if (MEMBER.matcher(lines.get(i)).matches() && !hasJavadoc(lines, i)) {
                gaps.add(name + ":" + (i + 1) + ": " + lines.get(i).trim());
            }
        }
    }

    /** Whether the comment before the declaration at the given line starts with text, not a tag. */
    private static boolean hasDescription(final List<String> lines, final int declaration) {
        int i = previousNonAnnotation(lines, declaration);
        if (i < 0 || !lines.get(i).trim().endsWith("*/")) {
            return false;
        }
        while (i >= 0 && !lines.get(i).trim().startsWith("/**")) {
            i--;
        }
        for (int j = i; j < lines.size(); j++) {
            final String text = lines.get(j).trim().replaceFirst("^/\\*\\*", "").replaceFirst("^\\*(?!/)", "").trim();
            if (!text.isEmpty() && !text.equals("*/")) {
                return !text.startsWith("@");
            }
        }
        return false;
    }

    /** Whether the declaration at the given line has javadoc, or overrides a documented method. */
    private static boolean hasJavadoc(final List<String> lines, final int declaration) {
        for (int i = declaration - 1; i >= 0 && lines.get(i).trim().startsWith("@"); i--) {
            if (lines.get(i).trim().startsWith("@Override")) {
                return true;
            }
        }
        final int i = previousNonAnnotation(lines, declaration);
        return i >= 0 && lines.get(i).trim().endsWith("*/");
    }

    private static int previousNonAnnotation(final List<String> lines, final int declaration) {
        int i = declaration - 1;
        while (i >= 0 && (lines.get(i).trim().startsWith("@") || lines.get(i).trim().isEmpty())) {
            i--;
        }
        return i;
    }
}
