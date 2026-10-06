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

/**
 * Horizontal alignment of the columns of a row ({@code justify-content-*}).
 *
 * @see <a href="https://getbootstrap.com/docs/5.3/layout/columns/#horizontal-alignment">Bootstrap 5 documentation</a>
 */
public enum RowContentJustifyAlign implements Style.HasCssName {
    DEFAULT(""),
    START("justify-content-start"),
    CENTER("justify-content-center"),
    END("justify-content-end"),
    AROUND("justify-content-around"),
    BETWEEN("justify-content-between"),
    EVENLY("justify-content-evenly");

    private final String cssClassName;

    RowContentJustifyAlign(String cssClassName) {
        this.cssClassName = cssClassName;
    }

    @Override
    public String getCssName() {
        return cssClassName;
    }

    /**
     * Returns the constant whose class is in a space-separated list of style names.
     *
     * @param styleName the style names, such as those of a widget
     * @return the constant, or {@code DEFAULT} if none
     */
    public static RowContentJustifyAlign fromStyleName(final String styleName) {
        return EnumHelper.fromStyleName(styleName, RowContentJustifyAlign.class, DEFAULT);
    }
}
