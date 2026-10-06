package org.gwtbootstrap5.client.ui;

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

/**
 * A widget that can show a button to close it, such as a {@link Modal}.
 *
 * @author Sven Jacobs
 */
public interface IsClosable {
    /**
     * Shows or hides the close button.
     *
     * @param closable {@code true} to show the close button
     */
    void setClosable(boolean closable);

    /**
     * Returns whether the close button is shown.
     *
     * @return {@code true} if it is shown
     */
    boolean isClosable();
}
