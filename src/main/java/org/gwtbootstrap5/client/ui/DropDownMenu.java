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

import org.gwtbootstrap5.client.ui.base.AbstractAnchorListItem;
import org.gwtbootstrap5.client.ui.base.helper.StyleHelper;
import org.gwtbootstrap5.client.ui.constants.Attributes;
import org.gwtbootstrap5.client.ui.constants.DropDownMenuAlignment;
import org.gwtbootstrap5.client.ui.constants.FloatCSS;
import org.gwtbootstrap5.client.ui.constants.Styles;
import org.gwtbootstrap5.client.ui.html.UnorderedList;

import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.Widget;

/**
 * Menu of a dropdown ({@code ul.dropdown-menu}), opened by the toggle before it in a
 * {@link DropDown}, a {@link ButtonGroup}, a {@link ListDropDown} or a {@link NavbarDropdown}. Its
 * items are {@link AnchorListItem}s or {@link DropDownItem}s, {@link DropDownHeader}s and
 * {@link Divider}s.
 *
 * @author Sven Jacobs
 * @see ButtonGroup
 * @see <a href="https://getbootstrap.com/docs/5.3/components/dropdowns/">Bootstrap 5 documentation</a>
 */
public class DropDownMenu extends UnorderedList {
    private static final String MENU = "menu";

    /** Creates an empty menu ({@code ul.dropdown-menu}). */
    public DropDownMenu() {
        super();

        setStyleName(Styles.DROPDOWN_MENU);
        getElement().setAttribute(Attributes.ROLE, MENU);
    }

    /**
     * Aligns the menu against its toggle at every width.
     *
     * @param alignment {@link DropDownMenuAlignment#START} or {@link DropDownMenuAlignment#END}, or
     *                  {@code null} for Bootstrap's default (start)
     * @throws IllegalArgumentException for a breakpoint alignment; use {@link #setBreakpointAlignment}
     */
    /**
     * Adds an item. The link of an {@link AnchorListItem} becomes a {@code dropdown-item}.
     */
    @Override
    public void add(final Widget child) {
        super.add(asMenuItem(child));
    }

    @Override
    public void insert(final Widget child, final int beforeIndex) {
        super.insert(asMenuItem(child), beforeIndex);
    }

    private static Widget asMenuItem(final Widget child) {
        if (child instanceof AbstractAnchorListItem) {
            final Element link = child.getElement().getFirstChildElement();
            if (link != null && link.hasClassName(Styles.NAV_LINK)) {
                link.removeClassName(Styles.NAV_LINK);
                link.addClassName(Styles.DROPDOWN_ITEM);
            }
        }
        return child;
    }

    /**
     * Aligns the menu with the start or the end of its toggle, at every screen size
     * ({@code dropdown-menu-start} or {@code dropdown-menu-end}).
     *
     * @param alignment {@link DropDownMenuAlignment#START} or {@link DropDownMenuAlignment#END}, or
     *     {@code null} for Bootstrap's default
     * @throws IllegalArgumentException for a breakpoint alignment; use {@link #setBreakpointAlignment}
     */
    public void setAlignment(final DropDownMenuAlignment alignment) {
        if (alignment != null && alignment.isResponsive()) {
            throw new IllegalArgumentException(alignment + " is a breakpoint alignment, use setBreakpointAlignment");
        }
        replaceAlignment(false, alignment);
    }

    /**
     * Returns the alignment set with {@link #setAlignment}.
     *
     * @return the alignment, or {@code null} if none
     */
    public DropDownMenuAlignment getAlignment() {
        return findAlignment(false);
    }

    /**
     * Aligns the menu from a breakpoint up, overriding {@link #setAlignment} there, e.g.
     * {@code alignment="END" breakpointAlignment="LG_START"}.
     *
     * @param alignment {@link DropDownMenuAlignment#SM_START} to {@link DropDownMenuAlignment#XXL_END},
     *                  or {@code null} for none
     * @throws IllegalArgumentException for {@code START} or {@code END}; use {@link #setAlignment}
     */
    public void setBreakpointAlignment(final DropDownMenuAlignment alignment) {
        if (alignment != null && !alignment.isResponsive()) {
            throw new IllegalArgumentException(alignment + " is not a breakpoint alignment, use setAlignment");
        }
        replaceAlignment(true, alignment);
    }

    /**
     * Returns the alignment set with {@link #setBreakpointAlignment}.
     *
     * @return the alignment, or {@code null} if none
     */
    public DropDownMenuAlignment getBreakpointAlignment() {
        return findAlignment(true);
    }

    private void replaceAlignment(final boolean responsive, final DropDownMenuAlignment alignment) {
        for (final DropDownMenuAlignment a : DropDownMenuAlignment.values()) {
            if (a.isResponsive() == responsive) {
                removeStyleName(a.getCssName());
            }
        }
        StyleHelper.addEnumStyleName(this, alignment);
    }

    private DropDownMenuAlignment findAlignment(final boolean responsive) {
        for (final DropDownMenuAlignment a : DropDownMenuAlignment.values()) {
            if (a.isResponsive() == responsive && StyleHelper.containsStyle(getStyleName(), a.getCssName())) {
                return a;
            }
        }
        return null;
    }

    /**
     * Not supported: Bootstrap 5 positions the menu with Popper, so {@code float} has no effect.
     *
     * @throws UnsupportedOperationException always; use {@link #setAlignment(DropDownMenuAlignment)}
     */
    @Override
    public void setFloat(final FloatCSS aFloatCSS) {
        throw new UnsupportedOperationException("DropDownMenu.setFloat has no effect in Bootstrap 5, use setAlignment");
    }

    /**
     * Gives the menu a dark background ({@code dropdown-menu-dark}). Bootstrap 5.3 prefers a dark
     * color mode on the dropdown, see {@code ColorModeHelper}.
     *
     * @param dark {@code true} for a dark menu
     */
    public void setDark(final boolean dark) {
        if (dark) {
            getElement().addClassName(Styles.DROPDOWN_MENU_DARK);
        } else {
            getElement().removeClassName(Styles.DROPDOWN_MENU_DARK);
        }
    }

}
