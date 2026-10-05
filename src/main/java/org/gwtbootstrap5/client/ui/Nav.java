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

import org.gwtbootstrap5.client.ui.base.AbstractListItem;
import org.gwtbootstrap5.client.ui.base.HasJustified;
import org.gwtbootstrap5.client.ui.base.HasRole;
import org.gwtbootstrap5.client.ui.base.helper.RoleHelper;
import org.gwtbootstrap5.client.ui.base.helper.StyleHelper;
import org.gwtbootstrap5.client.ui.constants.Styles;
import org.gwtbootstrap5.client.ui.html.UnorderedList;

import com.google.gwt.user.client.ui.Widget;

/**
 * Nav container and base class for navigations.
 *
 * @author Sven Jacobs
 * @see NavTabs
 * @see NavPills
 * @see Affix
 */
public class Nav extends UnorderedList implements HasJustified, HasRole {

    public Nav() {
        super();

        setStyleName(Styles.NAV);
    }

    @Override
    public void setJustified(final boolean justified) {
        if (justified) {
            addStyleName(Styles.NAV_JUSTIFIED);
        } else {
            removeStyleName(Styles.NAV_JUSTIFIED);
        }
    }

    @Override
    public boolean isJustified() {
        return StyleHelper.containsStyle(getStyleName(), Styles.NAV_JUSTIFIED);
    }

    public void setVertical(final boolean vertical) {
        if (vertical) {
            addStyleName(Styles.FLEX_COLUMN);
        } else {
            removeStyleName(Styles.FLEX_COLUMN);
        }
    }

    public boolean isVertical() {
        return StyleHelper.containsStyle(getStyleName(), Styles.FLEX_COLUMN);
    }

    /**
     * Makes the items fill the nav's width, each as wide as its content ({@code nav-fill}). Use
     * {@link #setJustified} for items of equal width.
     */
    public void setFill(final boolean fill) {
        if (fill) {
            addStyleName(Styles.NAV_FILL);
        } else {
            removeStyleName(Styles.NAV_FILL);
        }
    }

    public boolean isFill() {
        return StyleHelper.containsStyle(getStyleName(), Styles.NAV_FILL);
    }

    @Override
    public void setRole(String role) {
        RoleHelper.setRole(getElement(), role);
    }

    @Override
    public String getRole() {
        return RoleHelper.getRole(getElement());
    }

    /**
     * Adds a link. List items get the {@code nav-item} class, which {@code fill} and
     * {@code justified} stretch.
     */
    @Override
    public void add(final Widget child) {
        super.add(asNavItem(child));
    }

    @Override
    public void insert(final Widget child, final int beforeIndex) {
        super.insert(asNavItem(child), beforeIndex);
    }

    static Widget asNavItem(final Widget child) {
        if (child instanceof AbstractListItem) {
            child.addStyleName(Styles.NAV_ITEM);
        }
        return child;
    }
}
