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
 * The vertical gutter of a {@link org.gwtbootstrap5.client.ui.Row}, the space between its columns
 * ({@code gy-*}), per breakpoint: 0 (none) to 5. Set it with
 * {@link org.gwtbootstrap5.client.ui.Row#setGutterY(GutterY...)}, or as {@code gutterY="XS_2 MD_4"} in UiBinder.
 *
 * @see <a href="https://getbootstrap.com/docs/5.3/layout/gutters/">Bootstrap 5 documentation</a>
 */
public enum GutterY implements Size, Style.HasCssName {
    // Extra small devices (<576px)
    XS_0("gy-0"),
    XS_1("gy-1"),
    XS_2("gy-2"),
    XS_3("gy-3"),
    XS_4("gy-4"),
    XS_5("gy-5"),
    // Small devices (>=576px)
    SM_0("gy-sm-0"),
    SM_1("gy-sm-1"),
    SM_2("gy-sm-2"),
    SM_3("gy-sm-3"),
    SM_4("gy-sm-4"),
    SM_5("gy-sm-5"),
    // Medium devices (>=768px)
    MD_0("gy-md-0"),
    MD_1("gy-md-1"),
    MD_2("gy-md-2"),
    MD_3("gy-md-3"),
    MD_4("gy-md-4"),
    MD_5("gy-md-5"),
    // Large devices (>=992px)
    LG_0("gy-lg-0"),
    LG_1("gy-lg-1"),
    LG_2("gy-lg-2"),
    LG_3("gy-lg-3"),
    LG_4("gy-lg-4"),
    LG_5("gy-lg-5"),
    // Extra large devices (>=1200px)
    XL_0("gy-xl-0"),
    XL_1("gy-xl-1"),
    XL_2("gy-xl-2"),
    XL_3("gy-xl-3"),
    XL_4("gy-xl-4"),
    XL_5("gy-xl-5"),
    // Extra extra large devices (>=1400px)
    XXL_0("gy-xxl-0"),
    XXL_1("gy-xxl-1"),
    XXL_2("gy-xxl-2"),
    XXL_3("gy-xxl-3"),
    XXL_4("gy-xxl-4"),
    XXL_5("gy-xxl-5");

    private final String cssClass;

    GutterY(final String cssClass) {
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
    public static GutterY fromStyleName(final String styleName) {
        return EnumHelper.fromStyleName(styleName, GutterY.class, null);
    }
}
