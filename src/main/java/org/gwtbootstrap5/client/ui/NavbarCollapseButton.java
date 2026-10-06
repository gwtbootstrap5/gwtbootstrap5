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
import org.gwtbootstrap5.client.ui.html.Span;

/**
 * Toggler of a {@link Navbar} ({@code button.navbar-toggler}): shows and hides its
 * {@link NavbarCollapse} on small screens.
 *
 * @author Sven Jacobs
 * @author Joshua Godi
 * @see NavbarCollapse
 * @see <a href="https://getbootstrap.com/docs/5.3/components/navbar/#toggler">Bootstrap 5 documentation</a>
 */
public class NavbarCollapseButton extends Button {

    /**
     * Creates a toggler ({@code button.navbar-toggler}) with Bootstrap's icon; set its
     * {@code dataTarget} to the id of the {@link NavbarCollapse}.
     */
    public NavbarCollapseButton() {
        super();

        // Bootstrap 5's toggler is a plain button.navbar-toggler, without btn classes
        setStyleName(Styles.NAVBAR_TOGGLER);
        setDataToggle(Toggle.COLLAPSE);
        setAriaExpanded("false");
        setAriaLabel("Toggle navigation");

        Span navbarIcon = new Span();
        navbarIcon.setStyleName(Styles.NAVBAR_TOGGLER_ICON);
        add(navbarIcon);
    }

    /**
     * Sets the id of the content the button controls ({@code aria-controls}).
     *
     * @param ariaControls the id, or {@code null} for none
     */
    public void setAriaControls(final String ariaControls) {
        if (ariaControls != null) {
            getElement().setAttribute(Attributes.ARIA_CONTROLS, ariaControls);
        } else {
            getElement().removeAttribute(Attributes.ARIA_CONTROLS);
        }
    }

    /**
     * Returns the id of the content the button controls.
     *
     * @return the {@code aria-controls} attribute
     */
    public String getAriaControls() {
        return getElement().getAttribute(Attributes.ARIA_CONTROLS);
    }

    /**
     * Sets whether the content is expanded ({@code aria-expanded}). Bootstrap updates it when the
     * button is clicked.
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
     * Returns whether the content is expanded.
     *
     * @return the {@code aria-expanded} attribute
     */
    public String getAriaExpanded() {
        return getElement().getAttribute(Attributes.ARIA_EXPANDED);
    }

    /**
     * Sets the label of the button for screen readers ({@code aria-label}). The default is
     * "Toggle navigation".
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
