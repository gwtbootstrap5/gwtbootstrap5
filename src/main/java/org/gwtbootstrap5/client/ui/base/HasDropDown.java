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
import org.gwtbootstrap5.client.ui.constants.DropDownAutoClose;
import org.gwtbootstrap5.client.ui.constants.DropDownDisplay;
import org.gwtbootstrap5.client.ui.constants.DropDownReference;
import org.gwtbootstrap5.client.ui.constants.DropDownDirection;

import com.google.gwt.event.shared.HandlerRegistration;

/**
 * A dropdown container: a toggle with {@code data-bs-toggle="dropdown"} and a
 * {@link org.gwtbootstrap5.client.ui.DropDownMenu} as direct children.
 */
public interface HasDropDown {

    /** Shows the menu. The widget must be attached. */
    void show();

    /** Hides the menu. The widget must be attached. */
    void hide();

    /** Shows or hides the menu. The widget must be attached. */
    void toggle();

    /**
     * Sets the direction the menu opens in ({@code dropup}, {@code dropend}, {@code dropstart} and
     * the centered variants).
     *
     * @param direction the direction, or {@code null} for down
     */
    void setDirection(DropDownDirection direction);

    /**
     * Returns the direction the menu opens in.
     *
     * @return the direction
     */
    DropDownDirection getDirection();

    /**
     * Sets when the menu closes ({@code data-bs-auto-close} of the toggle).
     *
     * @param autoClose on clicks inside, outside, both or neither
     */
    void setAutoClose(DropDownAutoClose autoClose);

    /**
     * Returns when the menu closes.
     *
     * @return the value of {@code data-bs-auto-close}
     */
    DropDownAutoClose getAutoClose();

    /**
     * Moves the menu away from its toggle ({@code data-bs-offset} of the toggle).
     *
     * @param skidding the shift along the toggle, in pixels
     * @param distance the distance from the toggle, in pixels; Bootstrap's default is 2
     */
    void setOffset(int skidding, int distance);

    /**
     * Sets the area the menu must stay inside ({@code data-bs-boundary} of the toggle):
     * {@code "clippingParents"}, Bootstrap's default, or {@code "viewport"}.
     *
     * @param boundary the boundary, or {@code null} for Bootstrap's default
     */
    void setBoundary(String boundary);

    /**
     * Sets what the menu is positioned against ({@code data-bs-reference} of the toggle).
     *
     * @param reference the toggle or its parent, or {@code null} for Bootstrap's default
     */
    void setReference(DropDownReference reference);

    /**
     * Sets how the menu is positioned ({@code data-bs-display} of the toggle).
     *
     * @param display dynamic, with Popper, or static, or {@code null} for Bootstrap's default
     */
    void setDisplay(DropDownDisplay display);

    /**
     * Adds a handler called when the menu starts to open.
     *
     * @param handler the handler
     * @return the registration that removes the handler
     */
    HandlerRegistration addShowHandler(ShowHandler handler);

    /**
     * Adds a handler called when the menu is open.
     *
     * @param handler the handler
     * @return the registration that removes the handler
     */
    HandlerRegistration addShownHandler(ShownHandler handler);

    /**
     * Adds a handler called when the menu starts to close.
     *
     * @param handler the handler
     * @return the registration that removes the handler
     */
    HandlerRegistration addHideHandler(HideHandler handler);

    /**
     * Adds a handler called when the menu is closed.
     *
     * @param handler the handler
     * @return the registration that removes the handler
     */
    HandlerRegistration addHiddenHandler(HiddenHandler handler);
}
