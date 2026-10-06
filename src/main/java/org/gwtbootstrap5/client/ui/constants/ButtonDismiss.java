package org.gwtbootstrap5.client.ui.constants;

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
 * Component a button closes ({@code data-bs-dismiss}): the modal, alert or offcanvas it is in.
 *
 * @author Sven Jacobs
 */
public enum ButtonDismiss {
    MODAL("modal"),
    ALERT("alert"),
    OFFCANVAS("offcanvas");

    private final String dismiss;

    ButtonDismiss(final String dismiss) {
        this.dismiss = dismiss;
    }

    /**
     * Returns the value of {@code data-bs-dismiss}.
     *
     * @return the value, such as {@code "modal"}
     */
    public String getDismiss() {
        return dismiss;
    }
}
