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

public enum RowColSize implements Size, Style.HasCssName {
    DEFAULT(""),

    XS_1("row-cols-1"),
    XS_2("row-cols-2"),
    XS_3("row-cols-3"),
    XS_4("row-cols-4"),
    XS_5("row-cols-5"),
    XS_6("row-cols-6"),

    SM_1("row-cols-sm-1"),
    SM_2("row-cols-sm-2"),
    SM_3("row-cols-sm-3"),
    SM_4("row-cols-sm-4"),
    SM_5("row-cols-sm-5"),
    SM_6("row-cols-sm-6"),

    MD_1("row-cols-md-1"),
    MD_2("row-cols-md-2"),
    MD_3("row-cols-md-3"),
    MD_4("row-cols-md-4"),
    MD_5("row-cols-md-5"),
    MD_6("row-cols-md-6"),

    LG_1("row-cols-lg-1"),
    LG_2("row-cols-lg-2"),
    LG_3("row-cols-lg-3"),
    LG_4("row-cols-lg-4"),
    LG_5("row-cols-lg-5"),
    LG_6("row-cols-lg-6"),

    XL_1("row-cols-xl-1"),
    XL_2("row-cols-xl-2"),
    XL_3("row-cols-xl-3"),
    XL_4("row-cols-xl-4"),
    XL_5("row-cols-xl-5"),
    XL_6("row-cols-xl-6"),

    XXL_1("row-cols-xxl-1"),
    XXL_2("row-cols-xxl-2"),
    XXL_3("row-cols-xxl-3"),
    XXL_4("row-cols-xxl-4"),
    XXL_5("row-cols-xxl-5"),
    XXL_6("row-cols-xxl-6");

    private final String cssClassName;

    RowColSize(String cssClassName) {
        this.cssClassName = cssClassName;
    }

    @Override
    public String getCssName() {
        return cssClassName;
    }

    public static RowColSize fromStyleName(final String styleName) {
        return EnumHelper.fromStyleName(styleName, RowColSize.class, DEFAULT);
    }

}
