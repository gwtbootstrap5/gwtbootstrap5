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
public enum ColumnOffset implements Size, Style.HasCssName {
    // Extra small devices (<576px)
    XS_0("offset-0"),
    XS_1("offset-1"),
    XS_2("offset-2"),
    XS_3("offset-3"),
    XS_4("offset-4"),
    XS_5("offset-5"),
    XS_6("offset-6"),
    XS_7("offset-7"),
    XS_8("offset-8"),
    XS_9("offset-9"),
    XS_10("offset-10"),
    XS_11("offset-11"),
    XS_12("offset-12"),

    // Small devices (>=576px)
    SM_0("offset-sm-0"),
    SM_1("offset-sm-1"),
    SM_2("offset-sm-2"),
    SM_3("offset-sm-3"),
    SM_4("offset-sm-4"),
    SM_5("offset-sm-5"),
    SM_6("offset-sm-6"),
    SM_7("offset-sm-7"),
    SM_8("offset-sm-8"),
    SM_9("offset-sm-9"),
    SM_10("offset-sm-10"),
    SM_11("offset-sm-11"),

    // Medium devices (>=768px)
    MD_0("offset-md-0"),
    MD_1("offset-md-1"),
    MD_2("offset-md-2"),
    MD_3("offset-md-3"),
    MD_4("offset-md-4"),
    MD_5("offset-md-5"),
    MD_6("offset-md-6"),
    MD_7("offset-md-7"),
    MD_8("offset-md-8"),
    MD_9("offset-md-9"),
    MD_10("offset-md-10"),
    MD_11("offset-md-11"),

    // Large devices (>=992px)
    LG_0("offset-lg-0"),
    LG_1("offset-lg-1"),
    LG_2("offset-lg-2"),
    LG_3("offset-lg-3"),
    LG_4("offset-lg-4"),
    LG_5("offset-lg-5"),
    LG_6("offset-lg-6"),
    LG_7("offset-lg-7"),
    LG_8("offset-lg-8"),
    LG_9("offset-lg-9"),
    LG_10("offset-lg-10"),
    LG_11("offset-lg-11"),

    // Large devices (>=1200px)
    XL_0("offset-xl-0"),
    XL_1("offset-xl-1"),
    XL_2("offset-xl-2"),
    XL_3("offset-xl-3"),
    XL_4("offset-xl-4"),
    XL_5("offset-xl-5"),
    XL_6("offset-xl-6"),
    XL_7("offset-xl-7"),
    XL_8("offset-xl-8"),
    XL_9("offset-xl-9"),
    XL_10("offset-xl-10"),
    XL_11("offset-xl-11"),

    // Large devices (>=1400px)
    XXL_0("offset-xxl-0"),
    XXL_1("offset-xxl-1"),
    XXL_2("offset-xxl-2"),
    XXL_3("offset-xxl-3"),
    XXL_4("offset-xxl-4"),
    XXL_6("offset-xxl-6"),
    XXL_7("offset-xxl-7"),
    XXL_8("offset-xxl-8"),
    XXL_9("offset-xxl-9"),
    XXL_10("offset-xxl-10"),
    XXL_11("offset-xxl-11");

    private final String cssClass;

    ColumnOffset(final String cssClass) {
        this.cssClass = cssClass;
    }

    @Override
    public String getCssName() {
        return cssClass;
    }
}
