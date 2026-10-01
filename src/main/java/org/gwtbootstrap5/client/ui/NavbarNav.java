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
import org.gwtbootstrap5.client.ui.constants.Attributes;
import org.gwtbootstrap5.client.ui.constants.Styles;
import org.gwtbootstrap5.client.ui.html.UnorderedList;

/**
 * Container for {@link AnchorListItem} or {@link ListDropDown} within {@link Navbar}.
 *
 * @author Sven Jacobs
 * @see Navbar
 * @see AnchorListItem
 * @see ListDropDown
 */
public class NavbarNav extends UnorderedList implements HasRole {

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

    public void setAriaLabel(final String ariaLabel) {
        getElement().setAttribute(Attributes.ARIA_LABEL, ariaLabel);
    }

    public String getAriaLabel() {
        return getElement().getAttribute(Attributes.ARIA_LABEL);
    }

}
