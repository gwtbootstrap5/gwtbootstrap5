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
 * Color of the focus ring that {@code Styles.FOCUS_RING} draws ({@code focus-ring-*}).
 *
 * @see <a href="https://getbootstrap.com/docs/5.3/helpers/focus-ring/">Bootstrap 5 documentation</a>
 */
public enum FocusRing implements Style.HasCssName {
    PRIMARY("focus-ring-primary"),
    SECONDARY("focus-ring-secondary"),
    SUCCESS("focus-ring-success"),
    DANGER("focus-ring-danger"),
    WARNING("focus-ring-warning"),
    INFO("focus-ring-info"),
    LIGHT("focus-ring-light"),
    DARK("focus-ring-dark");

    private final String cssClass;

    FocusRing(final String cssClass) {
        this.cssClass = cssClass;
    }

    @Override
    public String getCssName() {
        return cssClass;
    }
}
