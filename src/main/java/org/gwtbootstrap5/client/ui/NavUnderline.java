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

import org.gwtbootstrap5.client.ui.constants.Styles;

/**
 * Nav whose active link is underlined ({@code nav-underline}, new in Bootstrap 5.3).
 *
 * @see AnchorListItem
 * @see <a href="https://getbootstrap.com/docs/5.3/components/navs-tabs/#underline">Bootstrap 5 documentation</a>
 */
public class NavUnderline extends Nav {

    public NavUnderline() {
        super();

        addStyleName(Styles.NAV_UNDERLINE);
    }

}
