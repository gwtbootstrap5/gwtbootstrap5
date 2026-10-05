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
 * @author Sven Jacobs
 * @author Joshua Godi
 * @see NavbarBrand
 * @see NavbarNav
 * @see NavbarForm
 * @see NavbarText
 */
public class Navbar extends ComplexWidget implements HasType<ColorMode> {
    private static final String NAVIGATION = "navigation";

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

    public void setExpand(NavbarExpand expand) {
        StyleHelper.addUniqueEnumStyleName(this, NavbarExpand.class, expand);
    }

    public NavbarExpand getExpand() {
        return NavbarExpand.fromStyleName(getStyleName());
    }

    public void setPosition(final NavbarPosition type) {
        StyleHelper.addUniqueEnumStyleName(this, NavbarPosition.class, type);
    }

    public NavbarPosition getPosition() {
        return NavbarPosition.fromStyleName(getStyleName());
    }
}
