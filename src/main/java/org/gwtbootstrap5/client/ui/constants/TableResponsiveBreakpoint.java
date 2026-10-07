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

import org.gwtbootstrap5.client.ui.base.helper.EnumHelper;

import com.google.gwt.dom.client.Style;

/**
 * Up to which breakpoint a {@link org.gwtbootstrap5.client.ui.TableResponsive} scrolls its table
 * horizontally ({@code table-responsive}, {@code table-responsive-md}…): always, or below the
 * breakpoint only.
 *
 * @see <a href="https://getbootstrap.com/docs/5.3/content/tables/#responsive-tables">Bootstrap 5 documentation</a>
 */
public enum TableResponsiveBreakpoint implements Style.HasCssName {
    /** Scrolls at every width ({@code table-responsive}). */
    ALWAYS("table-responsive"),
    /** Scrolls below the small breakpoint ({@code table-responsive-sm}). */
    SM("table-responsive-sm"),
    /** Scrolls below the medium breakpoint ({@code table-responsive-md}). */
    MD("table-responsive-md"),
    /** Scrolls below the large breakpoint ({@code table-responsive-lg}). */
    LG("table-responsive-lg"),
    /** Scrolls below the extra large breakpoint ({@code table-responsive-xl}). */
    XL("table-responsive-xl"),
    /** Scrolls below the extra extra large breakpoint ({@code table-responsive-xxl}). */
    XXL("table-responsive-xxl");

    private final String cssClass;

    TableResponsiveBreakpoint(final String cssClass) {
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
     * @return the constant, or {@code null} if none
     */
    public static TableResponsiveBreakpoint fromStyleName(final String styleName) {
        return EnumHelper.fromStyleName(styleName, TableResponsiveBreakpoint.class, null);
    }
}
