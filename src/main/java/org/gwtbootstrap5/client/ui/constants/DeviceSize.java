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
 * Breakpoints of Bootstrap 5, from phones ({@code XS}) to large desktops ({@code XXL}, 1400px and
 * up), plus print, for the responsive visibility of widgets.
 *
 * @author Joshua Godi
 * @see <a href="https://getbootstrap.com/docs/5.3/layout/breakpoints/">Bootstrap 5 documentation</a>
 */
public enum DeviceSize implements Size {
    PRINT, /* Print Devices */
    XS, /* Phones <576px */
    SM, /* Tablets >=576px */
    MD, /* Desktops >=768px */
    LG, /* Desktops >=992px */
    XL, /* Desktops >=1200px */
    XXL /* Large desktops >=1400px */
}
