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

/**
 * Visual order of a column ({@code order-*}), per breakpoint: 0 to 5, first or last. Replaces
 * Bootstrap 3's pull / push classes.
 */
public enum ColumnOrder implements Size, Style.HasCssName {
    // Extra small devices (<576px)
    XS_0("order-0"),
    XS_1("order-1"),
    XS_2("order-2"),
    XS_3("order-3"),
    XS_4("order-4"),
    XS_5("order-5"),
    XS_FIRST("order-first"),
    XS_LAST("order-last"),
    // Small devices (>=576px)
    SM_0("order-sm-0"),
    SM_1("order-sm-1"),
    SM_2("order-sm-2"),
    SM_3("order-sm-3"),
    SM_4("order-sm-4"),
    SM_5("order-sm-5"),
    SM_FIRST("order-sm-first"),
    SM_LAST("order-sm-last"),
    // Medium devices (>=768px)
    MD_0("order-md-0"),
    MD_1("order-md-1"),
    MD_2("order-md-2"),
    MD_3("order-md-3"),
    MD_4("order-md-4"),
    MD_5("order-md-5"),
    MD_FIRST("order-md-first"),
    MD_LAST("order-md-last"),
    // Large devices (>=992px)
    LG_0("order-lg-0"),
    LG_1("order-lg-1"),
    LG_2("order-lg-2"),
    LG_3("order-lg-3"),
    LG_4("order-lg-4"),
    LG_5("order-lg-5"),
    LG_FIRST("order-lg-first"),
    LG_LAST("order-lg-last"),
    // Extra large devices (>=1200px)
    XL_0("order-xl-0"),
    XL_1("order-xl-1"),
    XL_2("order-xl-2"),
    XL_3("order-xl-3"),
    XL_4("order-xl-4"),
    XL_5("order-xl-5"),
    XL_FIRST("order-xl-first"),
    XL_LAST("order-xl-last"),
    // Extra extra large devices (>=1400px)
    XXL_0("order-xxl-0"),
    XXL_1("order-xxl-1"),
    XXL_2("order-xxl-2"),
    XXL_3("order-xxl-3"),
    XXL_4("order-xxl-4"),
    XXL_5("order-xxl-5"),
    XXL_FIRST("order-xxl-first"),
    XXL_LAST("order-xxl-last");

    private final String cssClass;

    ColumnOrder(final String cssClass) {
        this.cssClass = cssClass;
    }

    @Override
    public String getCssName() {
        return cssClass;
    }
}
