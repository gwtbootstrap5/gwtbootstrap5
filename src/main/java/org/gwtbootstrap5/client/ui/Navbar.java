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

import org.gwtbootstrap5.client.ui.base.ComplexWidget;
import org.gwtbootstrap5.client.ui.base.HasType;
import org.gwtbootstrap5.client.ui.base.helper.StyleHelper;
import org.gwtbootstrap5.client.ui.constants.*;

import com.google.gwt.dom.client.Document;

/**
 * Navbar ({@code nav.navbar}): the responsive header of a site, with a brand, navigation links
 * and forms, that collapses behind a toggler on small screens. It expands from {@code LG} up by
 * default, and its color mode is set with {@code type}.
 * <h2>UiBinder example</h2>
 * <pre>{@code
 *     <b:Navbar addStyleNames="bg-body-tertiary">
 *         <b:Container size="FLUID">
 *             <b:NavbarBrand href="#" text="Brand"/>
 *             <b:NavbarCollapseButton dataTarget="#main-nav" ariaControls="main-nav"/>
 *             <b:NavbarCollapse b:id="main-nav">
 *                 <b:NavbarNav>
 *                     <b:AnchorListItem text="Home" active="true"/>
 *                     <b:AnchorListItem text="Link"/>
 *                 </b:NavbarNav>
 *             </b:NavbarCollapse>
 *         </b:Container>
 *     </b:Navbar>
 * }</pre>
 *
 * @see <a href="https://getbootstrap.com/docs/5.3/components/navbar/">Bootstrap 5 documentation</a>
 *
 * @author Sven Jacobs
 * @author Joshua Godi
 * @see NavbarBrand
 * @see NavbarNav
 * @see NavbarForm
 * @see NavbarText
 */
public class Navbar extends ComplexWidget implements HasType<ColorMode> {
    private static final String NAVIGATION = "navigation";

    /** Creates an empty navbar that expands from {@code LG} up. */
    public Navbar() {
        super();

        setElement(Document.get().createElement(ElementTags.NAV));
        setStyleName(Styles.NAVBAR);
        setExpand(NavbarExpand.LG);
        getElement().setAttribute(Attributes.ROLE, NAVIGATION);
    }

    /**
     * Sets the color mode of the navbar and its dropdowns with Bootstrap 5.3's
     * {@code data-bs-theme} attribute. {@code null} inherits the page's mode.
     *
     * @param type the navbar's color mode
     */
    @Override
    public void setType(final ColorMode type) {
        if (type == null) {
            getElement().removeAttribute(Attributes.DATA_BS_THEME);
        } else {
            getElement().setAttribute(Attributes.DATA_BS_THEME, type.getTheme());
        }
    }

    /**
     * @return the navbar's color mode, or {@code null} when it inherits the page's
     */
    @Override
    public ColorMode getType() {
        return ColorMode.fromTheme(getElement().getAttribute(Attributes.DATA_BS_THEME));
    }

    /**
     * Sets the breakpoint from which the navbar is expanded instead of collapsed
     * ({@code navbar-expand-*}).
     *
     * @param expand the breakpoint; {@code XS} keeps it always expanded
     */
    public void setExpand(NavbarExpand expand) {
        StyleHelper.addUniqueEnumStyleName(this, NavbarExpand.class, expand);
    }

    /**
     * Returns the breakpoint from which the navbar is expanded.
     *
     * @return the breakpoint
     */
    public NavbarExpand getExpand() {
        return NavbarExpand.fromStyleName(getStyleName());
    }

    /**
     * Fixes the navbar to the top or bottom of the viewport, or makes it sticky.
     *
     * @param type the position ({@code fixed-*} or {@code sticky-*}), {@code DEFAULT} for none
     */
    public void setPosition(final NavbarPosition type) {
        StyleHelper.addUniqueEnumStyleName(this, NavbarPosition.class, type);
    }

    /**
     * Returns the position of the navbar.
     *
     * @return the position, {@code DEFAULT} if it isn't fixed or sticky
     */
    public NavbarPosition getPosition() {
        return NavbarPosition.fromStyleName(getStyleName());
    }
}
