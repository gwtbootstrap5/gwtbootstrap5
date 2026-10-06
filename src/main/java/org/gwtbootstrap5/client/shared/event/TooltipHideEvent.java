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

import org.gwtbootstrap5.client.ui.Tooltip;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.user.client.Event;

/**
 * Event of a tooltip, when a tooltip starts to hide. GwtBootstrap5 doesn't fire it: tooltips fire
 * {@link HideEvent} on their widget.
 *
 * @author Pontus Enmark
 */
public class TooltipHideEvent extends GwtEvent<TooltipHideHandler> implements TooltipEvent {

    private static final Type<TooltipHideHandler> TYPE = new Type<>();

    private final Tooltip tooltip;
    private final Event nativeEvent;

    /**
     * Returns the type of the event, to register its handlers.
     *
     * @return the type
     */
    public static Type<TooltipHideHandler> getType() {
        return TYPE;
    }

    /**
     * Creates the event.
     *
     * @param tooltip the tooltip that fired it
     * @param nativeEvent the Bootstrap event it comes from
     */
    public TooltipHideEvent(final Tooltip tooltip, final Event nativeEvent) {
        this.tooltip = tooltip;
        this.nativeEvent = nativeEvent;
    }

    @Override
    public Tooltip getTooltip() {
        return tooltip;
    }

    @Override
    public Event getNativeEvent() {
        return nativeEvent;
    }

    @Override
    public Type<TooltipHideHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(final TooltipHideHandler handler) {
        handler.onHide(this);
    }
}
