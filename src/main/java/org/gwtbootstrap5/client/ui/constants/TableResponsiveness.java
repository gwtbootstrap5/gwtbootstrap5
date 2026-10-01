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

public enum TableResponsiveness implements Style.HasCssName {
    DEFAULT("table-responsive"),
    SM("table-responsive-sm"),
    MD("table-responsive-md"),
    LG("table-responsive-lg"),
    XL("table-responsive-xl"),
    XXL("table-responsive-xxl");

    private final String cssClass;

    TableResponsiveness(final String cssClass) {
        this.cssClass = cssClass;
    }

    @Override
    public String getCssName() {
        return cssClass;
    }

    public static TableResponsiveness fromStyleName(final String styleName) {
        return EnumHelper.fromStyleName(styleName, TableResponsiveness.class, DEFAULT);
    }

}
