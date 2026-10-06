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

import com.google.gwt.dom.client.Style;
import org.gwtbootstrap5.client.ui.base.helper.EnumHelper;

/**
 * Size of a display heading, larger and lighter than a normal one ({@code display-1} to
 * {@code display-6}).
 *
 * @author Joshua Godi
 * @see <a href="https://getbootstrap.com/docs/5.3/content/typography/#display-headings">Bootstrap 5 documentation</a>
 */
public enum DisplaySize implements Style.HasCssName {
    DEFAULT(""),
    D_1("display-1"),
    D_2("display-2"),
    D_3("display-3"),
    D_4("display-4"),
    D_5("display-5"),
    D_6("display-6");

    private final String cssClass;

    DisplaySize(final String cssClass) {
        this.cssClass = cssClass;
    }

    @Override
    public String getCssName() {
        return cssClass;
    }

    /**
     * Returns the constant whose class is in a space-separated list of style names.
     *
     * @param styleName the style names, such as those of a widget
     * @return the constant, or {@code DEFAULT} if none
     */
    public static DisplaySize fromStyleName(final String styleName) {
        return EnumHelper.fromStyleName(styleName, DisplaySize.class, DEFAULT);
    }

}
