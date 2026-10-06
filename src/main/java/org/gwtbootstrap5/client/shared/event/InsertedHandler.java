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

import com.google.gwt.event.shared.EventHandler;

/**
 * Handler of {@link InsertedEvent}, fired when the element of a tooltip or popover is added to the
 * page, before it shows.
 *
 * @author Steven Jardine
 */
public interface InsertedHandler extends EventHandler {
    /**
     * Called when the element of a tooltip or popover is added to the page, before it shows.
     *
     * @param event the event
     */
    void onInserted(InsertedEvent event);
}
