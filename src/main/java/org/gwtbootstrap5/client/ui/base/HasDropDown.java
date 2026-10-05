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

    void setDirection(DropDownDirection direction);

    DropDownDirection getDirection();

    void setAutoClose(DropDownAutoClose autoClose);

    DropDownAutoClose getAutoClose();

    HandlerRegistration addShowHandler(ShowHandler handler);

    HandlerRegistration addShownHandler(ShownHandler handler);

    HandlerRegistration addHideHandler(HideHandler handler);

    HandlerRegistration addHiddenHandler(HiddenHandler handler);
}
