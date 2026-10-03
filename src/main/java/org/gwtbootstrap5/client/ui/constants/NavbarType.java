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
 * @author Sven Jacobs
 */
public enum NavbarType implements Type {
    LIGHT("light"),
    DARK("dark");

    private final String theme;

    NavbarType(final String theme) {
        this.theme = theme;
    }

    /**
     * @return the value of the navbar's {@code data-bs-theme} attribute
     */
    public String getTheme() {
        return theme;
    }

    /**
     * @param theme a {@code data-bs-theme} value
     * @return the matching type, or {@code null}
     */
    public static NavbarType fromTheme(final String theme) {
        for (NavbarType type : values()) {
            if (type.theme.equals(theme)) {
                return type;
            }
        }
        return null;
    }
}
