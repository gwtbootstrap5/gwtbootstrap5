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
 * Distance between a link's text and its underline ({@code link-offset-*}). The {@code _HOVER} values apply on hover.
 *
 * @see <a href="https://getbootstrap.com/docs/5.3/utilities/link/#link-underlines">Bootstrap 5 documentation</a>
 */
public enum LinkOffset implements Style.HasCssName {
    OFFSET_1("link-offset-1"),
    OFFSET_2("link-offset-2"),
    OFFSET_3("link-offset-3"),
    OFFSET_1_HOVER("link-offset-1-hover"),
    OFFSET_2_HOVER("link-offset-2-hover"),
    OFFSET_3_HOVER("link-offset-3-hover");

    private final String cssClass;

    LinkOffset(final String cssClass) {
        this.cssClass = cssClass;
    }

    @Override
    public String getCssName() {
        return cssClass;
    }
}
