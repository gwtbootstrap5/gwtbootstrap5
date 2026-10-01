package org.gwtbootstrap5.client.ui;

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

import org.gwtbootstrap5.client.ui.constants.Attributes;
import org.gwtbootstrap5.client.ui.constants.Styles;
import org.gwtbootstrap5.client.ui.constants.Toggle;

/**
 * Special button to toggle collapsible area of {@link Navbar}.
 *
 * @author Sven Jacobs
 * @author Joshua Godi
 * @see NavbarCollapse
 */
public class NavbarDropdownButton extends Button {

    public NavbarDropdownButton() {
        super();

        addStyleName(Styles.NAV_LINK);
        addStyleName(Styles.DROPDOWN_TOGGLE);
        setDataToggle(Toggle.DROPDOWN);
    }

    public void setAriaExpanded(final String ariaExpanded) {
        if (ariaExpanded != null) {
            getElement().setAttribute(Attributes.ARIA_EXPANDED, ariaExpanded);
        } else {
            getElement().removeAttribute(Attributes.ARIA_EXPANDED);
        }
    }

    public String getAriaExpanded() {
        return getElement().getAttribute(Attributes.ARIA_EXPANDED);
    }

    public void setAriaLabel(final String ariaLabel) {
        if (ariaLabel != null) {
            getElement().setAttribute(Attributes.ARIA_LABEL, ariaLabel);
        } else {
            getElement().removeAttribute(Attributes.ARIA_LABEL);
        }
    }

    public String getAriaLabel() {
        return getElement().getAttribute(Attributes.ARIA_LABEL);
    }

}
