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

import com.google.gwt.user.client.Event;

/**
 * An event of a {@link org.gwtbootstrap5.client.ui.Modal}: the modal and the native Bootstrap
 * event.
 *
 * @author Sven Jacobs
 */
public interface ModalEvent {
    /**
     * Returns the modal that fired the event.
     *
     * @return the modal
     */
    Modal getModal();

    /**
     * Returns the Bootstrap event this event comes from.
     *
     * @return the native event
     */
    Event getNativeEvent();
}
