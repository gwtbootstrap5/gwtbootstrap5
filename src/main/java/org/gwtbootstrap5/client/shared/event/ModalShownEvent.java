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

import org.gwtbootstrap5.client.ui.Modal;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.user.client.Event;

/**
 * Fired when a {@link org.gwtbootstrap5.client.ui.Modal} is shown, after its animation:
 * Bootstrap's {@code shown.bs.modal}.
 *
 * @author Sven Jacobs
 */
public class ModalShownEvent extends GwtEvent<ModalShownHandler> implements ModalEvent {

    private static final Type<ModalShownHandler> TYPE = new Type<>();

    private final Modal modal;
    private final Event nativeEvent;

    /**
     * Returns the type of the event, to register its handlers.
     *
     * @return the type
     */
    public static Type<ModalShownHandler> getType() {
        return TYPE;
    }

    /**
     * Creates the event.
     *
     * @param modal the modal that fired it
     * @param nativeEvent the Bootstrap event it comes from
     */
    public ModalShownEvent(final Modal modal, final Event nativeEvent) {
        this.modal = modal;
        this.nativeEvent = nativeEvent;
    }

    @Override
    public Modal getModal() {
        return modal;
    }

    @Override
    public Event getNativeEvent() {
        return nativeEvent;
    }

    @Override
    public Type<ModalShownHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(final ModalShownHandler handler) {
        handler.onShown(this);
    }
}
