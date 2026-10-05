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
 * Opacity of a link's text ({@code link-opacity-*}). The {@code _HOVER} values apply on hover; add one of each with {@code StyleHelper.addEnumStyleName}, e.g. {@code OPACITY_50} and {@code OPACITY_100_HOVER}.
 *
 * @see <a href="https://getbootstrap.com/docs/5.3/utilities/link/#link-opacity">Bootstrap 5 documentation</a>
 */
public enum LinkOpacity implements Style.HasCssName {
    OPACITY_10("link-opacity-10"),
    OPACITY_25("link-opacity-25"),
    OPACITY_50("link-opacity-50"),
    OPACITY_75("link-opacity-75"),
    OPACITY_100("link-opacity-100"),
    OPACITY_10_HOVER("link-opacity-10-hover"),
    OPACITY_25_HOVER("link-opacity-25-hover"),
    OPACITY_50_HOVER("link-opacity-50-hover"),
    OPACITY_75_HOVER("link-opacity-75-hover"),
    OPACITY_100_HOVER("link-opacity-100-hover");

    private final String cssClass;

    LinkOpacity(final String cssClass) {
        this.cssClass = cssClass;
    }

    @Override
    public String getCssName() {
        return cssClass;
    }
}
