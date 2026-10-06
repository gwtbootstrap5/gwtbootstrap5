package org.gwtbootstrap5.client.ui.base;

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
 * A widget whose items can be stacked vertically.
 *
 * @author Sven Jacobs
 */
public interface HasStacked {
    /**
     * Stacks the items vertically.
     *
     * @param stacked {@code true} to stack them
     */
    void setStacked(boolean stacked);

    /**
     * Returns whether the items are stacked.
     *
     * @return {@code true} if they are stacked
     */
    boolean isStacked();
}
