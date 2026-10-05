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
 * When a modal covers the whole viewport: always, or below a breakpoint.
 *
 * @see <a href="https://getbootstrap.com/docs/5.3/components/modal/#fullscreen-modal">Bootstrap 5 documentation</a>
 */
public enum ModalFullscreen implements Style.HasCssName {
    ALWAYS("modal-fullscreen"),
    SM_DOWN("modal-fullscreen-sm-down"),
    MD_DOWN("modal-fullscreen-md-down"),
    LG_DOWN("modal-fullscreen-lg-down"),
    XL_DOWN("modal-fullscreen-xl-down"),
    XXL_DOWN("modal-fullscreen-xxl-down");

    private final String cssClass;

    ModalFullscreen(final String cssClass) {
        this.cssClass = cssClass;
    }

    @Override
    public String getCssName() {
        return cssClass;
    }

    /**
     * @return the constant whose class is in the style names, or {@code null}
     */
    public static ModalFullscreen fromStyleName(final String styleName) {
        return EnumHelper.fromStyleName(styleName, ModalFullscreen.class, null);
    }
}
