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
 * Backdrop of an {@code Offcanvas}, written as {@code data-bs-backdrop}.
 */
public enum OffcanvasBackdrop {
    /** A backdrop that closes the panel when clicked (Bootstrap's default). */
    TRUE("true"),
    /** No backdrop. */
    FALSE("false"),
    /** A backdrop that doesn't close the panel when clicked; the click fires {@code hidePrevented}. */
    STATIC("static");

    private final String backdrop;

    OffcanvasBackdrop(final String backdrop) {
        this.backdrop = backdrop;
    }

    /**
     * Returns the value of {@code data-bs-backdrop}.
     *
     * @return the value
     */
    public String getBackdrop() {
        return backdrop;
    }
}
