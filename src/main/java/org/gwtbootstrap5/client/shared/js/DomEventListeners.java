package org.gwtbootstrap5.client.shared.js;

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

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.Event;

import elemental2.dom.EventListener;
import jsinterop.base.Js;

/**
 * Keeps the DOM event listeners a widget adds, so they can all be removed when it is detached.
 * Replaces jQuery's {@code on()} / {@code off()} for Bootstrap 5 events, which are dispatched as
 * native DOM events.
 */
public final class DomEventListeners {

    /** Creates an empty set of listeners. */
    public DomEventListeners() {
    }

    /**
     * Handler receiving the native event as a GWT {@link Event}.
     */
    @FunctionalInterface
    public interface Handler {
        /**
         * Called with the event.
         *
         * @param event the native event
         */
        void onEvent(Event event);
    }

    private final List<Runnable> removers = new ArrayList<>();

    /**
     * Adds a listener for the given event type.
     *
     * @param element the element to listen on
     * @param type the event type, e.g. {@code "shown.bs.modal"}
     * @param handler the handler
     */
    public void add(final Element element, final String type, final Handler handler) {
        final elemental2.dom.Element target = Js.uncheckedCast(element);
        final EventListener listener = evt -> handler.onEvent(Js.uncheckedCast(evt));
        target.addEventListener(type, listener);
        removers.add(() -> target.removeEventListener(type, listener));
    }

    /**
     * Removes every listener added through this instance.
     */
    public void removeAll() {
        for (final Runnable remover : removers) {
            remover.run();
        }
        removers.clear();
    }
}
