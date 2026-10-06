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
 * Nav with pills ({@code ul.nav.nav-pills}): the active item is a filled button.
 * <h2>UiBinder example</h2>
 * <pre>{@code
 *     <b:NavPills>
 *         <b:AnchorListItem text="Active" active="true"/>
 *         <b:AnchorListItem text="Link"/>
 *     </b:NavPills>
 * }</pre>
 *
 * @see <a href="https://getbootstrap.com/docs/5.3/components/navs-tabs/#pills">Bootstrap 5 documentation</a>
 *
 * @author Sven Jacobs
 * @see AnchorListItem
 */
public class NavPills extends Nav {

    /** Creates an empty nav with pills. */
    public NavPills() {
        super();

        addStyleName(Styles.NAV_PILLS);
    }

}
