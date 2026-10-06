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

import org.gwtbootstrap5.client.ui.base.helper.RoleHelper;
import org.gwtbootstrap5.client.ui.constants.Roles;
import org.gwtbootstrap5.client.ui.constants.Styles;

/**
 * Nav with tabs ({@code ul.nav.nav-tabs}, role {@code tablist}). With {@link NavTabItem}s and a
 * {@link TabContent} it switches between panes.
 * <h2>UiBinder example</h2>
 * <pre>{@code
 *     <b:NavTabs>
 *         <b:NavTabItem text="Home" dataTarget="#home" active="true"/>
 *         <b:NavTabItem text="Profile" dataTarget="#profile"/>
 *     </b:NavTabs>
 *     <b:TabContent>
 *         <b:TabPanel b:id="home" active="true">...</b:TabPanel>
 *         <b:TabPanel b:id="profile">...</b:TabPanel>
 *     </b:TabContent>
 * }</pre>
 *
 * @see <a href="https://getbootstrap.com/docs/5.3/components/navs-tabs/#tabs">Bootstrap 5 documentation</a>
 *
 * @author Sven Jacobs
 * @see AnchorListItem
 */
public class NavTabs extends Nav {

    /** Creates an empty nav with tabs. */
    public NavTabs() {
        super();

        addStyleName(Styles.NAV_TABS);
        RoleHelper.setRole(getElement(), Roles.TABLIST);
    }

}
