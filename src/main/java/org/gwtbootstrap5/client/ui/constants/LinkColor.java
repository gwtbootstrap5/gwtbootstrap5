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
 * Color of a link, including its hover and focus states ({@code link-*}).
 *
 * @see <a href="https://getbootstrap.com/docs/5.3/helpers/colored-links/">Bootstrap 5 documentation</a>
 */
public enum LinkColor implements Style.HasCssName {
    PRIMARY("link-primary"),
    SECONDARY("link-secondary"),
    SUCCESS("link-success"),
    DANGER("link-danger"),
    WARNING("link-warning"),
    INFO("link-info"),
    LIGHT("link-light"),
    DARK("link-dark"),
    BODY_EMPHASIS("link-body-emphasis");

    private final String cssClass;

    LinkColor(final String cssClass) {
        this.cssClass = cssClass;
    }

    @Override
    public String getCssName() {
        return cssClass;
    }
}
