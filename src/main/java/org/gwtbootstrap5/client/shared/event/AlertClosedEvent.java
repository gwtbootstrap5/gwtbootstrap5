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

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.user.client.Event;

/**
 * Fired when an {@link org.gwtbootstrap5.client.ui.Alert} has closed and left the page:
 * Bootstrap's {@code closed.bs.alert}.
 *
 * @author Sven Jacobs
 */
public class AlertClosedEvent extends GwtEvent<AlertClosedHandler> {

    private static final Type<AlertClosedHandler> TYPE = new Type<>();

    private final Event nativeEvent;

    /**
     * Returns the type of the event, to register its handlers.
     *
     * @return the type
     */
    public static Type<AlertClosedHandler> getType() {
        return TYPE;
    }

    /**
     * Creates the event.
     *
     * @param nativeEvent the Bootstrap event it comes from
     */
    public AlertClosedEvent(final Event nativeEvent) {
        this.nativeEvent = nativeEvent;
    }

    /**
     * Returns the Bootstrap event this event comes from.
     *
     * @return the native event
     */
    public Event getNativeEvent() {
        return nativeEvent;
    }

    @Override
    public Type<AlertClosedHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(final AlertClosedHandler handler) {
        handler.onClosed(this);
    }
}
