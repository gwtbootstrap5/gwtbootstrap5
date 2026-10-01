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
 * @author Sven Jacobs
 */
public enum ColumnPush implements Size, Style.HasCssName {
    // Extra small devices (<576px)
    XS_0("order-2"),
    XS_1("order-2"),
    XS_2("order-2"),
    XS_3("order-2"),
    XS_4("order-2"),
    XS_5("order-2"),
    XS_6("order-2"),
    XS_7("order-2"),
    XS_8("order-2"),
    XS_9("order-2"),
    XS_10("order-2"),
    XS_11("order-2"),
    XS_12("order-2"),

    // Small devices (>=576px)
    SM_0("order-sm-2"),
    SM_1("order-sm-2"),
    SM_2("order-sm-2"),
    SM_3("order-sm-2"),
    SM_4("order-sm-2"),
    SM_5("order-sm-2"),
    SM_6("order-sm-2"),
    SM_7("order-sm-2"),
    SM_8("order-sm-2"),
    SM_9("order-sm-2"),
    SM_10("order-sm-2"),
    SM_11("order-sm-2"),

    // Medium devices (>=768px)
    MD_0("order-md-2"),
    MD_1("order-md-2"),
    MD_2("order-md-2"),
    MD_3("order-md-2"),
    MD_4("order-md-2"),
    MD_5("order-md-2"),
    MD_6("order-md-2"),
    MD_7("order-md-2"),
    MD_8("order-md-2"),
    MD_9("order-md-2"),
    MD_10("order-md-2"),
    MD_11("order-md-2"),

    // Large devices (>=992px)
    LG_0("order-lg-2"),
    LG_1("order-lg-2"),
    LG_2("order-lg-2"),
    LG_3("order-lg-2"),
    LG_4("order-lg-2"),
    LG_5("order-lg-2"),
    LG_6("order-lg-2"),
    LG_7("order-lg-2"),
    LG_8("order-lg-2"),
    LG_9("order-lg-2"),
    LG_10("order-lg-2"),
    LG_11("order-lg-2"),

    // Large devices (>=1200px)
    XL_0("order-xl-2"),
    XL_1("order-xl-2"),
    XL_2("order-xl-2"),
    XL_3("order-xl-2"),
    XL_4("order-xl-2"),
    XL_5("order-xl-2"),
    XL_6("order-xl-2"),
    XL_7("order-xl-2"),
    XL_8("order-xl-2"),
    XL_9("order-xl-2"),
    XL_10("order-xl-2"),
    XL_11("order-xl-2"),

    // Large devices (>=1400px)
    XXL_0("order-xxl-2"),
    XXL_1("order-xxl-2"),
    XXL_2("order-xxl-2"),
    XXL_3("order-xxl-2"),
    XXL_4("order-xxl-2"),
    XXL_5("order-xxl-2"),
    XXL_6("order-xxl-2"),
    XXL_7("order-xxl-2"),
    XXL_8("order-xxl-2"),
    XXL_9("order-xxl-2"),
    XXL_10("order-xxl-2"),
    XXL_11("order-xxl-2");

    private final String cssClass;

    ColumnPush(final String cssClass) {
        this.cssClass = cssClass;
    }

    @Override
    public String getCssName() {
        return cssClass;
    }
}
