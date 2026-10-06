package org.gwtbootstrap5.client.shared.event;

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

import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.event.shared.GwtEvent;

/**
 * Fired when a component starts to show. {@link org.gwtbootstrap5.client.ui.Collapse},
 * {@link org.gwtbootstrap5.client.ui.NavbarCollapse}, {@link org.gwtbootstrap5.client.ui.Offcanvas},
 * {@link org.gwtbootstrap5.client.ui.Toast}, the dropdowns, tooltips and popovers fire it, and so do
 * the date pickers of the extras.
 * {@link #preventDefault()} cancels it.
 *
 * @author Joshua Godi
 */
public class ShowEvent extends GwtEvent<ShowHandler> {
    private static final Type<ShowHandler> TYPE = new Type<>();
    private final NativeEvent nativeEvent;

    /**
     * Returns the type of the event, to register its handlers.
     *
     * @return the type
     */
    public static Type<ShowHandler> getType() {
        return TYPE;
    }

    /** Creates the event without a native event, when it is fired from code. */
    public ShowEvent() {
        this(null);
    }

    /**
     * Creates the event.
     *
     * @param nativeEvent the Bootstrap event it comes from
     */
    public ShowEvent(final NativeEvent nativeEvent) {
        this.nativeEvent = nativeEvent;
    }

    @Override
    public final Type<ShowHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(final ShowHandler handler) {
        handler.onShow(this);
    }

    /**
     * Cancels the action: Bootstrap doesn't show or hide the component. Only works on the events
     * fired before the action, and does nothing when the event has no native event.
     */
    public final void preventDefault() {
        if (nativeEvent == null) return;
        nativeEvent.preventDefault();
    }

    /**
     * Stops the native event from reaching the ancestors of the element. Does nothing when the
     * event has no native event.
     */
    public final void stopPropagation() {
        if (nativeEvent == null) return;
        nativeEvent.stopPropagation();
    }
}
