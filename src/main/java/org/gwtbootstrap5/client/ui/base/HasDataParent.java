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
 * A widget with a {@code data-bs-parent} attribute: the accordion whose other items close when
 * this collapsible opens.
 *
 * @author Grant Slender
 */
public interface HasDataParent {
    /**
     * Sets the parent ({@code data-bs-parent}).
     *
     * @param dataParent a selector of the parent, such as {@code "#accordion"}
     */
    void setDataParent(String dataParent);

    /**
     * Returns the parent.
     *
     * @return the {@code data-bs-parent} attribute
     */
    String getDataParent();
}
