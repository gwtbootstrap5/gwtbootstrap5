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
 * How screen readers announce a {@link org.gwtbootstrap5.client.ui.Toast}: politely
 * ({@code role="status"}) or at once ({@code role="alert"}).
 *
 * @see <a href="https://getbootstrap.com/docs/5.3/components/toasts/#accessibility">Bootstrap 5 documentation</a>
 */
public enum ToastRole {
    ALERT("alert", "assertive"),
    STATUS("status", "polite");

    private final String role;
    private final String ariaLive;

    ToastRole(String role, String ariaLive) {
        this.role = role;
        this.ariaLive = ariaLive;
    }

    /**
     * Returns the ARIA role.
     *
     * @return the value of the {@code role} attribute
     */
    public String getRole() {
        return role;
    }

    /**
     * Returns how screen readers announce the toast.
     *
     * @return the value of {@code aria-live}
     */
    public String getAriaLive() {
        return ariaLive;
    }
}
