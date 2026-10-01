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

import org.gwtbootstrap5.client.ui.base.HasFloat;
import org.gwtbootstrap5.client.ui.base.mixin.FloatMixin;
import org.gwtbootstrap5.client.ui.constants.Attributes;
import org.gwtbootstrap5.client.ui.constants.FloatCSS;
import org.gwtbootstrap5.client.ui.constants.Styles;
import org.gwtbootstrap5.client.ui.html.UnorderedList;

/**
 * Container for drop down menu items.
 * <p/>
 * <strong>Must</strong> be encapsulated in a {@link ButtonGroup} to build button dropdowns.
 *
 * @author Sven Jacobs
 * @see ButtonGroup
 */
public class DropDownMenu extends UnorderedList implements HasFloat {
    private static final String MENU = "menu";

    private final FloatMixin<DropDownMenu> floatMixin = new FloatMixin<>(this);

    public DropDownMenu() {
        super();

        setStyleName(Styles.DROPDOWN_MENU);
        getElement().setAttribute(Attributes.ROLE, MENU);
    }

    @Override
    public void setFloat(final FloatCSS aFloatCSS) {
        floatMixin.setFloat(aFloatCSS);
    }

    @Override
    public FloatCSS getFloat() {
        return floatMixin.getFloat();
    }

    public void setDark(final boolean dark) {
        if (dark) {
            getElement().addClassName(Styles.DROPDOWN_MENU_DARK);
        } else {
            getElement().removeClassName(Styles.DROPDOWN_MENU_DARK);
        }
    }

}
