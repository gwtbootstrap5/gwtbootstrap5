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
 * Toggle of a {@link NavbarDropdown}: a button with {@code nav-link dropdown-toggle} that opens its
 * menu.
 *
 * @author Sven Jacobs
 * @author Joshua Godi
 * @see NavbarCollapse
 * @see <a href="https://getbootstrap.com/docs/5.3/components/navbar/#nav">Bootstrap 5 documentation</a>
 */
public class NavbarDropdownButton extends Button {

    /** Creates a toggle for a {@link NavbarDropdown}: a button with {@code nav-link dropdown-toggle}. */
    public NavbarDropdownButton() {
        super();

        addStyleName(Styles.NAV_LINK);
        addStyleName(Styles.DROPDOWN_TOGGLE);
        setDataToggle(Toggle.DROPDOWN);
    }

    /**
     * Sets whether the menu is open ({@code aria-expanded}). Bootstrap updates it when the menu
     * opens and closes.
     *
     * @param ariaExpanded {@code "true"} or {@code "false"}, or {@code null} to remove it
     */
    public void setAriaExpanded(final String ariaExpanded) {
        if (ariaExpanded != null) {
            getElement().setAttribute(Attributes.ARIA_EXPANDED, ariaExpanded);
        } else {
            getElement().removeAttribute(Attributes.ARIA_EXPANDED);
        }
    }

    /**
     * Returns whether the menu is open.
     *
     * @return the {@code aria-expanded} attribute
     */
    public String getAriaExpanded() {
        return getElement().getAttribute(Attributes.ARIA_EXPANDED);
    }

    /**
     * Sets the label of the button for screen readers ({@code aria-label}).
     *
     * @param ariaLabel the label, or {@code null} to remove it
     */
    public void setAriaLabel(final String ariaLabel) {
        if (ariaLabel != null) {
            getElement().setAttribute(Attributes.ARIA_LABEL, ariaLabel);
        } else {
            getElement().removeAttribute(Attributes.ARIA_LABEL);
        }
    }

    /**
     * Returns the label of the button for screen readers.
     *
     * @return the {@code aria-label} attribute
     */
    public String getAriaLabel() {
        return getElement().getAttribute(Attributes.ARIA_LABEL);
    }

}
