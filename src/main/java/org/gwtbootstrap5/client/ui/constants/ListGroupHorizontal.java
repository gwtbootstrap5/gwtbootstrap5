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
 * When a list group lays its items out horizontally: always, or from a breakpoint up.
 *
 * @see <a href="https://getbootstrap.com/docs/5.3/components/list-group/#horizontal">Bootstrap 5 documentation</a>
 */
public enum ListGroupHorizontal implements Style.HasCssName {
    ALWAYS("list-group-horizontal"),
    SM("list-group-horizontal-sm"),
    MD("list-group-horizontal-md"),
    LG("list-group-horizontal-lg"),
    XL("list-group-horizontal-xl"),
    XXL("list-group-horizontal-xxl");

    private final String cssClass;

    ListGroupHorizontal(final String cssClass) {
        this.cssClass = cssClass;
    }

    @Override
    public String getCssName() {
        return cssClass;
    }

    /**
     * @return the constant whose class is in the style names, or {@code null}
     */
    public static ListGroupHorizontal fromStyleName(final String styleName) {
        return EnumHelper.fromStyleName(styleName, ListGroupHorizontal.class, null);
    }
}
