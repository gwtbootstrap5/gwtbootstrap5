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
