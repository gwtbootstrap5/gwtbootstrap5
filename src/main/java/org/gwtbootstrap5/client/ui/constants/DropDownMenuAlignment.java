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
 * Horizontal alignment of a dropdown menu against its toggle. {@code START} and {@code END} apply at
 * every width; the others from a breakpoint up and combine with one of those, e.g. {@code END} and
 * {@code LG_START}.
 *
 * @see <a href="https://getbootstrap.com/docs/5.3/components/dropdowns/#menu-alignment">Bootstrap 5 documentation</a>
 */
public enum DropDownMenuAlignment implements Style.HasCssName {
    START("dropdown-menu-start"),
    END("dropdown-menu-end"),
    SM_START("dropdown-menu-sm-start"),
    SM_END("dropdown-menu-sm-end"),
    MD_START("dropdown-menu-md-start"),
    MD_END("dropdown-menu-md-end"),
    LG_START("dropdown-menu-lg-start"),
    LG_END("dropdown-menu-lg-end"),
    XL_START("dropdown-menu-xl-start"),
    XL_END("dropdown-menu-xl-end"),
    XXL_START("dropdown-menu-xxl-start"),
    XXL_END("dropdown-menu-xxl-end");

    private final String cssClass;

    DropDownMenuAlignment(final String cssClass) {
        this.cssClass = cssClass;
    }

    @Override
    public String getCssName() {
        return cssClass;
    }

    /**
     * @return {@code true} for the alignments that apply from a breakpoint up
     */
    public boolean isResponsive() {
        return this != START && this != END;
    }
}
