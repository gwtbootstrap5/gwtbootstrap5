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

import org.gwtbootstrap5.client.shared.event.HiddenHandler;
import org.gwtbootstrap5.client.shared.event.HideHandler;
import org.gwtbootstrap5.client.shared.event.ShowHandler;
import org.gwtbootstrap5.client.shared.event.ShownHandler;
import org.gwtbootstrap5.client.ui.base.AbstractListItem;
import org.gwtbootstrap5.client.ui.base.HasDropDown;
import org.gwtbootstrap5.client.ui.base.button.AbstractToggleButton;
import org.gwtbootstrap5.client.ui.base.mixin.DropDownMixin;
import org.gwtbootstrap5.client.ui.constants.DropDownAutoClose;
import org.gwtbootstrap5.client.ui.constants.DropDownDirection;
import org.gwtbootstrap5.client.ui.constants.Styles;

import com.google.gwt.dom.client.Element;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.Widget;

/**
 * Drop down item within a list, e.g. {@link NavTabs}, {@link NavPills} or
 * {@link Navbar}.
 * <h2>UiBinder example</h2>
 * <pre>
 * {@code
 *     <b:NavTabs>
 *         <b:AnchorListItem active="true">Item 1</b:AnchorListItem>
 *         <b:AnchorListItem>Item 2</b:AnchorListItem>
 *         <b:ListDropDown>
 *             <b:AnchorButton toggle="DROPDOWN">Dropdown</b:AnchorButton>
 *             <b:DropDownMenu>
 *                 <b:AnchorListItem>Dropdown 1</b:AnchorListItem>
 *                 <b:AnchorListItem>Dropdown 2</b:AnchorListItem>
 *                 <b:AnchorListItem>Dropdown 3</b:AnchorListItem>
 *             </b:DropDownMenu>
 *         </b:ListDropDown>
 *         <b:AnchorListItem>Item 3</b:AnchorListItem>
 *     </b:NavTabs>
 * }
 * </pre>
 *
 * @author Sven Jacobs
 * @see NavTabs
 * @see NavPills
 * @see Navbar
 */
public class ListDropDown extends AbstractListItem implements HasDropDown {

    private final DropDownMixin<ListDropDown> dropDownMixin = new DropDownMixin<>(this, DropDownDirection.DOWN);

    public ListDropDown() {
        super();

        setStyleName(Styles.DROPDOWN);
    }

    @Override
    public void add(final Widget child) {
        if (child instanceof AbstractToggleButton) {
            if (!(child instanceof AnchorButton)) {
                throw new IllegalArgumentException("Only buttons of type AnchorButton can be added to ListDropDown");
            }

            child.setStyleName(Styles.DROPDOWN_TOGGLE);
        }

        add(child, (Element) getElement());
    }

    @Override
    protected void onLoad() {
        super.onLoad();
        dropDownMixin.onLoad();
    }

    @Override
    protected void onUnload() {
        super.onUnload();
        dropDownMixin.onUnload();
    }

    @Override
    public void show() {
        dropDownMixin.show();
    }

    @Override
    public void hide() {
        dropDownMixin.hide();
    }

    @Override
    public void toggle() {
        dropDownMixin.toggle();
    }

    /**
     * Sets the direction the menu opens in; {@code null} restores the default.
     */
    @Override
    public void setDirection(final DropDownDirection direction) {
        dropDownMixin.setDirection(direction);
    }

    @Override
    public DropDownDirection getDirection() {
        return dropDownMixin.getDirection();
    }

    /**
     * Sets when the open menu closes; {@code null} restores Bootstrap's default ({@link DropDownAutoClose#TRUE}).
     */
    @Override
    public void setAutoClose(final DropDownAutoClose autoClose) {
        dropDownMixin.setAutoClose(autoClose);
    }

    @Override
    public DropDownAutoClose getAutoClose() {
        return dropDownMixin.getAutoClose();
    }

    @Override
    public HandlerRegistration addShowHandler(final ShowHandler handler) {
        return dropDownMixin.addShowHandler(handler);
    }

    @Override
    public HandlerRegistration addShownHandler(final ShownHandler handler) {
        return dropDownMixin.addShownHandler(handler);
    }

    @Override
    public HandlerRegistration addHideHandler(final HideHandler handler) {
        return dropDownMixin.addHideHandler(handler);
    }

    @Override
    public HandlerRegistration addHiddenHandler(final HiddenHandler handler) {
        return dropDownMixin.addHiddenHandler(handler);
    }
}
