package org.gwtbootstrap5.client.ui.base;

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
import org.gwtbootstrap5.client.ui.base.mixin.DropDownMixin;
import org.gwtbootstrap5.client.ui.constants.DropDownAutoClose;
import org.gwtbootstrap5.client.ui.constants.DropDownDirection;
import org.gwtbootstrap5.client.ui.constants.DropDownDisplay;
import org.gwtbootstrap5.client.ui.constants.DropDownReference;
import org.gwtbootstrap5.client.ui.constants.Styles;

import com.google.gwt.dom.client.Element;
import com.google.gwt.event.shared.HandlerRegistration;

/**
 * Base class of the dropdown containers ({@code dropdown} class): a toggle and the
 * {@link org.gwtbootstrap5.client.ui.DropDownMenu} it opens, controlled from Java with
 * {@link #show()}, {@link #hide()} and {@link #toggle()}.
 *
 * @author Sven Jacobs
 * @author Joshua Godi
 */
public class AbstractDropDown extends ComplexWidget implements HasDropDown {

    private final DropDownMixin<AbstractDropDown> dropDownMixin = new DropDownMixin<>(this, DropDownDirection.DOWN);

    /**
     * Creates a dropdown in the given element.
     *
     * @param element the element of the container, such as a {@code div} or an {@code li}
     */
    public AbstractDropDown(final Element element) {
        setElement(element);
        setStyleName(Styles.DROPDOWN);
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
    public void setOffset(final int skidding, final int distance) {
        dropDownMixin.setOffset(skidding, distance);
    }

    @Override
    public void setBoundary(final String boundary) {
        dropDownMixin.setBoundary(boundary);
    }

    @Override
    public void setReference(final DropDownReference reference) {
        dropDownMixin.setReference(reference);
    }

    @Override
    public void setDisplay(final DropDownDisplay display) {
        dropDownMixin.setDisplay(display);
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
