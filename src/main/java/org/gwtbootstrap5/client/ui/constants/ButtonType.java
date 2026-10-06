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
 * Style of a button: a color ({@code btn-primary} to {@code btn-dark}), its outline variant
 * ({@code btn-outline-*}) or a link ({@code btn-link}).
 *
 * @author Sven Jacobs
 * @see <a href="https://getbootstrap.com/docs/5.3/components/buttons/#variants">Bootstrap 5 documentation</a>
 */
public enum ButtonType implements Type, Style.HasCssName {

    LINK("btn-link"),

    PRIMARY("btn-primary"),
    SECONDARY("btn-secondary"),
    SUCCESS("btn-success"),
    DANGER("btn-danger"),
    WARNING("btn-warning"),
    INFO("btn-info"),
    LIGHT("btn-light"),
    DARK("btn-dark"),

    PRIMARY_OUTLINE("btn-outline-primary"),
    SECONDARY_OUTLINE("btn-outline-secondary"),
    SUCCESS_OUTLINE("btn-outline-success"),
    DANGER_OUTLINE("btn-outline-danger"),
    WARNING_OUTLINE("btn-outline-warning"),
    INFO_OUTLINE("btn-outline-info"),
    LIGHT_OUTLINE("btn-outline-light"),
    DARK_OUTLINE("btn-outline-dark");

    private final String cssClass;

    ButtonType(final String cssClass) {
        this.cssClass = cssClass;
    }

    @Override
    public String getCssName() {
        return cssClass;
    }

    /**
     * Returns the constant whose class is in a space-separated list of style names.
     *
     * @param styleName the style names, such as those of a widget
     * @return the constant, or {@code LIGHT} if none
     */
    public static ButtonType fromStyleName(final String styleName) {
        return EnumHelper.fromStyleName(styleName, ButtonType.class, LIGHT);
    }
}
