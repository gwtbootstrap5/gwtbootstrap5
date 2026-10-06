package org.gwtbootstrap5.client.ui.impl;

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

import org.gwtbootstrap5.client.ui.CheckBox;

import com.google.gwt.event.logical.shared.ValueChangeEvent;

/** Makes a checkbox fire value change events when its input changes. */
public class CheckBoxImpl {

    /** Creates the implementation; the checkbox gets it with {@code GWT.create}. */
    public CheckBoxImpl() {
    }

    /**
     * Fires the checkbox's value change events on the change events of its input.
     *
     * @param checkBox the checkbox
     */
    public void ensureDomEventHandlers(final CheckBox checkBox) {
        checkBox.addChangeHandler(event -> ValueChangeEvent.fire(checkBox, checkBox.getValue()));
    }

}
