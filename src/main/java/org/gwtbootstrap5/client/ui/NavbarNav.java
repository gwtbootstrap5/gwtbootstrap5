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

import org.gwtbootstrap5.client.ui.base.HasRole;
import org.gwtbootstrap5.client.ui.base.helper.RoleHelper;
import org.gwtbootstrap5.client.ui.base.helper.StyleHelper;
import org.gwtbootstrap5.client.ui.constants.Attributes;
import org.gwtbootstrap5.client.ui.constants.Styles;
import org.gwtbootstrap5.client.ui.html.UnorderedList;

import com.google.gwt.user.client.ui.Widget;

import elemental2.dom.HTMLElement;
import jsinterop.base.Js;

/**
 * Links of a {@link Navbar} ({@code ul.nav.navbar-nav}): {@link AnchorListItem}s and
 * {@link NavbarDropdown}s.
 *
 * @author Sven Jacobs
 * @see Navbar
 * @see AnchorListItem
 * @see ListDropDown
 * @see <a href="https://getbootstrap.com/docs/5.3/components/navbar/#nav">Bootstrap 5 documentation</a>
 */
public class NavbarNav extends UnorderedList implements HasRole {
    private static final String SCROLL_HEIGHT = "--bs-scroll-height";

    /** Creates an empty list of navbar links ({@code ul.nav.navbar-nav}). */
    public NavbarNav() {
        super();

        setStyleName(Styles.NAV);
        addStyleName(Styles.NAVBAR_NAV);
    }

    @Override
    public void setRole(final String role) {
        RoleHelper.setRole(getElement(), role);
    }

    @Override
    public String getRole() {
        return RoleHelper.getRole(getElement());
    }

    /**
     * Sets the label of the list for screen readers ({@code aria-label}).
     *
     * @param ariaLabel the label
     */
    public void setAriaLabel(final String ariaLabel) {
        getElement().setAttribute(Attributes.ARIA_LABEL, ariaLabel);
    }

    /**
     * Returns the label of the list for screen readers.
     *
     * @return the {@code aria-label} attribute
     */
    public String getAriaLabel() {
        return getElement().getAttribute(Attributes.ARIA_LABEL);
    }

    /**
     * Makes the links scroll vertically inside a collapsed navbar instead of pushing the page down
     * ({@code navbar-nav-scroll}). The list is at most {@code 75vh} high, or the height set with
     * {@link #setScrollHeight(String)}.
     *
     * @param scroll {@code true} to scroll
     */
    public void setScroll(final boolean scroll) {
        if (scroll) {
            addStyleName(Styles.NAVBAR_NAV_SCROLL);
        } else {
            removeStyleName(Styles.NAVBAR_NAV_SCROLL);
        }
    }

    /**
     * Returns whether the links scroll inside a collapsed navbar.
     *
     * @return {@code true} if it has {@code navbar-nav-scroll}
     */
    public boolean isScroll() {
        return StyleHelper.containsStyle(getStyleName(), Styles.NAVBAR_NAV_SCROLL);
    }

    /**
     * Sets the maximum height of the links when they scroll ({@code --bs-scroll-height}), such as
     * {@code "100px"}. Only applies with {@link #setScroll(boolean)}.
     *
     * @param height a CSS height, or {@code null} for Bootstrap's {@code 75vh}
     */
    public void setScrollHeight(final String height) {
        final HTMLElement element = Js.uncheckedCast(getElement());
        if (height == null || height.isEmpty()) {
            element.style.removeProperty(SCROLL_HEIGHT);
        } else {
            element.style.setProperty(SCROLL_HEIGHT, height);
        }
    }

    /**
     * Returns the maximum height of the links when they scroll.
     *
     * @return the CSS height, or an empty string for Bootstrap's {@code 75vh}
     */
    public String getScrollHeight() {
        final HTMLElement element = Js.uncheckedCast(getElement());
        return element.style.getPropertyValue(SCROLL_HEIGHT);
    }

    @Override
    public void add(final Widget child) {
        super.add(Nav.asNavItem(child));
    }

    @Override
    public void insert(final Widget child, final int beforeIndex) {
        super.insert(Nav.asNavItem(child), beforeIndex);
    }
}
