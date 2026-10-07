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
 * The horizontal and vertical gutter of a {@link org.gwtbootstrap5.client.ui.Row}, the space between its columns
 * ({@code g-*}), per breakpoint: 0 (none) to 5. Set it with
 * {@link org.gwtbootstrap5.client.ui.Row#setGutter(Gutter...)}, or as {@code gutter="XS_2 MD_4"} in UiBinder.
 *
 * @see <a href="https://getbootstrap.com/docs/5.3/layout/gutters/">Bootstrap 5 documentation</a>
 */
public enum Gutter implements Size, Style.HasCssName {
    // Extra small devices (<576px)
    XS_0("g-0"),
    XS_1("g-1"),
    XS_2("g-2"),
    XS_3("g-3"),
    XS_4("g-4"),
    XS_5("g-5"),
    // Small devices (>=576px)
    SM_0("g-sm-0"),
    SM_1("g-sm-1"),
    SM_2("g-sm-2"),
    SM_3("g-sm-3"),
    SM_4("g-sm-4"),
    SM_5("g-sm-5"),
    // Medium devices (>=768px)
    MD_0("g-md-0"),
    MD_1("g-md-1"),
    MD_2("g-md-2"),
    MD_3("g-md-3"),
    MD_4("g-md-4"),
    MD_5("g-md-5"),
    // Large devices (>=992px)
    LG_0("g-lg-0"),
    LG_1("g-lg-1"),
    LG_2("g-lg-2"),
    LG_3("g-lg-3"),
    LG_4("g-lg-4"),
    LG_5("g-lg-5"),
    // Extra large devices (>=1200px)
    XL_0("g-xl-0"),
    XL_1("g-xl-1"),
    XL_2("g-xl-2"),
    XL_3("g-xl-3"),
    XL_4("g-xl-4"),
    XL_5("g-xl-5"),
    // Extra extra large devices (>=1400px)
    XXL_0("g-xxl-0"),
    XXL_1("g-xxl-1"),
    XXL_2("g-xxl-2"),
    XXL_3("g-xxl-3"),
    XXL_4("g-xxl-4"),
    XXL_5("g-xxl-5");

    private final String cssClass;

    Gutter(final String cssClass) {
        this.cssClass = cssClass;
    }

    @Override
    public String getCssName() {
        return cssClass;
    }

    /**
     * Returns the first constant whose class is in a space-separated list of style names.
     *
     * @param styleName the style names, such as those of a widget
     * @return the constant, or {@code null} if none
     */
    public static Gutter fromStyleName(final String styleName) {
        return EnumHelper.fromStyleName(styleName, Gutter.class, null);
    }
}
