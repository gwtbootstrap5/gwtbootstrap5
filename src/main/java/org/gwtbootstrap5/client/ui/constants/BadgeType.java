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
 * Color of a {@link org.gwtbootstrap5.client.ui.Badge}: a background with a contrasting text,
 * {@code text-bg-primary} to {@code text-bg-dark}.
 *
 * @see <a href="https://getbootstrap.com/docs/5.3/components/badge/#background-colors">Bootstrap 5 documentation</a>
 */
public enum BadgeType implements Style.HasCssName, Type {
    DEFAULT(""),
    PRIMARY("text-bg-primary"),
    SECONDARY("text-bg-secondary"),
    SUCCESS("text-bg-success"),
    DANGER("text-bg-danger"),
    WARNING("text-bg-warning"),
    INFO("text-bg-info"),
    LIGHT("text-bg-light"),
    DARK("text-bg-dark");

    private final String cssClassName;

    BadgeType(String cssClassName) {
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
    public static BadgeType fromStyleName(final String styleName) {
        return EnumHelper.fromStyleName(styleName, BadgeType.class, DEFAULT);
    }
}
