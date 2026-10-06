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
 * Fired when a component refuses to hide: a click on a static backdrop, or Escape with the keyboard
 * option off.
 */
public class HidePreventedEvent extends GwtEvent<HidePreventedHandler> {
    private static final Type<HidePreventedHandler> TYPE = new Type<>();
    private final NativeEvent nativeEvent;

    /**
     * Returns the type of the event, to register its handlers.
     *
     * @return the type
     */
    public static Type<HidePreventedHandler> getType() {
        return TYPE;
    }

    /** Creates the event without a native event, when it is fired from code. */
    public HidePreventedEvent() {
        this(null);
    }

    /**
     * Creates the event.
     *
     * @param nativeEvent the Bootstrap event it comes from
     */
    public HidePreventedEvent(final NativeEvent nativeEvent) {
        this.nativeEvent = nativeEvent;
    }

    /**
     * Fired when a component refuses to hide: by {@link org.gwtbootstrap5.client.ui.Offcanvas}.
     *
     * @return the native event, or {@code null}
     */
    public NativeEvent getNativeEvent() {
        return nativeEvent;
    }

    @Override
    public final Type<HidePreventedHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(final HidePreventedHandler handler) {
        handler.onHidePrevented(this);
    }
}
