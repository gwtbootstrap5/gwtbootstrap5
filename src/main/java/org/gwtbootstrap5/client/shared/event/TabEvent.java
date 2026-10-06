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

import org.gwtbootstrap5.client.ui.NavTabItem;

import com.google.gwt.user.client.Event;

/**
 * An event of a {@link org.gwtbootstrap5.client.ui.NavTabItem}: the tab and the native Bootstrap
 * event.
 *
 * @author Joshua Godi
 */
public interface TabEvent {
    /**
     * Returns the tab that fired the event.
     *
     * @return the tab
     */
    NavTabItem getTab();

    /**
     * Returns the Bootstrap event this event comes from.
     *
     * @return the native event
     */
    Event getNativeEvent();
}
