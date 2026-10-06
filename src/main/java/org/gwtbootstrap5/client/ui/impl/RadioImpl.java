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

import org.gwtbootstrap5.client.ui.Radio;

import com.google.gwt.dom.client.Element;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.user.client.Event;

/** Makes a radio fire value change events when its input changes. */
public class RadioImpl {

    /** Creates the implementation; the radio gets it with {@code GWT.create}. */
    public RadioImpl() {
    }

    /**
     * Fires the radio's value change events on the change events of its input.
     *
     * @param radio the radio
     */
    public void ensureDomEventHandlers(final Radio radio) {
        radio.addChangeHandler(event -> ValueChangeEvent.fire(radio, radio.getValue()));
    }

    /**
     * Sinks events on the input of the radio rather than on the widget.
     *
     * @param eventBitsToAdd the events to sink
     * @param inputElem the input of the radio
     */
    public void sinkEvents(int eventBitsToAdd, Element inputElem) {
        Event.sinkEvents(inputElem,
                eventBitsToAdd | Event.getEventsSunk(inputElem));
    }

}
