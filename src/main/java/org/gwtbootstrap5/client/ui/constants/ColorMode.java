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
 * Bootstrap 5.3 color mode, written as {@code data-bs-theme} on the page or on a widget.
 *
 * @see org.gwtbootstrap5.client.ui.base.helper.ColorModeHelper
 * @see <a href="https://getbootstrap.com/docs/5.3/customize/color-modes/">Bootstrap 5 documentation</a>
 */
public enum ColorMode implements Type {
    LIGHT("light"),
    DARK("dark");

    private final String theme;

    ColorMode(final String theme) {
        this.theme = theme;
    }

    /**
     * Returns the value of {@code data-bs-theme} of the mode.
     *
     * @return the {@code data-bs-theme} value
     */
    public String getTheme() {
        return theme;
    }

    /**
     * Returns the mode of a {@code data-bs-theme} value.
     *
     * @param theme a {@code data-bs-theme} value
     * @return the matching mode, or {@code null}
     */
    public static ColorMode fromTheme(final String theme) {
        for (final ColorMode mode : values()) {
            if (mode.theme.equals(theme)) {
                return mode;
            }
        }
        return null;
    }
}
