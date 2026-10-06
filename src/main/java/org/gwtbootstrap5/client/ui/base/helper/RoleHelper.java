package org.gwtbootstrap5.client.ui.base.helper;

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


import com.google.gwt.dom.client.Element;
import org.gwtbootstrap5.client.ui.constants.Attributes;

/** Reads and writes the ARIA role of elements ({@code role} attribute). */
public class RoleHelper {

    /** Creates an instance. Every method is static, so there is no need to. */
    public RoleHelper() {
    }

    /**
     * Sets the role of an element.
     *
     * @param element the element
     * @param role the role, such as {@code "tab"}
     */
    public static void setRole(Element element, String role) {
        element.setAttribute(Attributes.ROLE, role);
    }

    /**
     * Removes the role of an element.
     *
     * @param element the element
     */
    public static void removeRole(Element element) {
        element.removeAttribute(Attributes.ROLE);
    }

    /**
     * Returns the role of an element.
     *
     * @param element the element
     * @return the {@code role} attribute, or an empty string if none
     */
    public static String getRole(Element element) {
        return element.getAttribute(Attributes.ROLE);
    }

    /**
     * Returns whether an element has a role.
     *
     * @param element the element
     * @return {@code true} if it has a {@code role} attribute
     */
    public static boolean hasRole(Element element) {
        // GWT returns an empty string, not null, for a missing attribute
        return !element.getAttribute(Attributes.ROLE).isEmpty();
    }

}
