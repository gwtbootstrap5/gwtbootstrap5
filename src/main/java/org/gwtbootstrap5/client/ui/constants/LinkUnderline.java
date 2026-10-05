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
 * Color and opacity of a link's underline ({@code link-underline-*}). Combine a color with an opacity with {@code StyleHelper.addEnumStyleName}; the {@code _HOVER} opacities apply on hover. {@link #DEFAULT} sets the underline to the link color, ready for an opacity.
 *
 * @see <a href="https://getbootstrap.com/docs/5.3/utilities/link/#link-underlines">Bootstrap 5 documentation</a>
 */
public enum LinkUnderline implements Style.HasCssName {
    DEFAULT("link-underline"),
    PRIMARY("link-underline-primary"),
    SECONDARY("link-underline-secondary"),
    SUCCESS("link-underline-success"),
    DANGER("link-underline-danger"),
    WARNING("link-underline-warning"),
    INFO("link-underline-info"),
    LIGHT("link-underline-light"),
    DARK("link-underline-dark"),
    OPACITY_0("link-underline-opacity-0"),
    OPACITY_10("link-underline-opacity-10"),
    OPACITY_25("link-underline-opacity-25"),
    OPACITY_50("link-underline-opacity-50"),
    OPACITY_75("link-underline-opacity-75"),
    OPACITY_100("link-underline-opacity-100"),
    OPACITY_0_HOVER("link-underline-opacity-0-hover"),
    OPACITY_10_HOVER("link-underline-opacity-10-hover"),
    OPACITY_25_HOVER("link-underline-opacity-25-hover"),
    OPACITY_50_HOVER("link-underline-opacity-50-hover"),
    OPACITY_75_HOVER("link-underline-opacity-75-hover"),
    OPACITY_100_HOVER("link-underline-opacity-100-hover");

    private final String cssClass;

    LinkUnderline(final String cssClass) {
        this.cssClass = cssClass;
    }

    @Override
    public String getCssName() {
        return cssClass;
    }
}
