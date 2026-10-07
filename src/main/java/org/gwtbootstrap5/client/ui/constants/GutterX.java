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
 * The horizontal gutter of a {@link org.gwtbootstrap5.client.ui.Row}, the space between its columns
 * ({@code gx-*}), per breakpoint: 0 (none) to 5. Set it with
 * {@link org.gwtbootstrap5.client.ui.Row#setGutterX(GutterX...)}, or as {@code gutterX="XS_2 MD_4"} in UiBinder.
 *
 * @see <a href="https://getbootstrap.com/docs/5.3/layout/gutters/">Bootstrap 5 documentation</a>
 */
public enum GutterX implements Size, Style.HasCssName {
    // Extra small devices (<576px)
    XS_0("gx-0"),
    XS_1("gx-1"),
    XS_2("gx-2"),
    XS_3("gx-3"),
    XS_4("gx-4"),
    XS_5("gx-5"),
    // Small devices (>=576px)
    SM_0("gx-sm-0"),
    SM_1("gx-sm-1"),
    SM_2("gx-sm-2"),
    SM_3("gx-sm-3"),
    SM_4("gx-sm-4"),
    SM_5("gx-sm-5"),
    // Medium devices (>=768px)
    MD_0("gx-md-0"),
    MD_1("gx-md-1"),
    MD_2("gx-md-2"),
    MD_3("gx-md-3"),
    MD_4("gx-md-4"),
    MD_5("gx-md-5"),
    // Large devices (>=992px)
    LG_0("gx-lg-0"),
    LG_1("gx-lg-1"),
    LG_2("gx-lg-2"),
    LG_3("gx-lg-3"),
    LG_4("gx-lg-4"),
    LG_5("gx-lg-5"),
    // Extra large devices (>=1200px)
    XL_0("gx-xl-0"),
    XL_1("gx-xl-1"),
    XL_2("gx-xl-2"),
    XL_3("gx-xl-3"),
    XL_4("gx-xl-4"),
    XL_5("gx-xl-5"),
    // Extra extra large devices (>=1400px)
    XXL_0("gx-xxl-0"),
    XXL_1("gx-xxl-1"),
    XXL_2("gx-xxl-2"),
    XXL_3("gx-xxl-3"),
    XXL_4("gx-xxl-4"),
    XXL_5("gx-xxl-5");

    private final String cssClass;

    GutterX(final String cssClass) {
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
    public static GutterX fromStyleName(final String styleName) {
        return EnumHelper.fromStyleName(styleName, GutterX.class, null);
    }
}
