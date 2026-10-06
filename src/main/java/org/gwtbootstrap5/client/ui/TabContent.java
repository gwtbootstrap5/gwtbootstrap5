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
import org.gwtbootstrap5.client.ui.html.Div;

import com.google.gwt.user.client.ui.Widget;

/**
 * Container of the {@link TabPanel}s that {@link NavTabItem}s show ({@code div.tab-content}).
 * <h2>UiBinder example</h2>
 * <pre>{@code
 *     <b:TabContent>
 *         <b:TabPanel b:id="home" active="true">...</b:TabPanel>
 *         <b:TabPanel b:id="profile">...</b:TabPanel>
 *     </b:TabContent>
 * }</pre>
 *
 * @author Joshua Godi
 * @see TabPanel
 * @see <a href="https://getbootstrap.com/docs/5.3/components/navs-tabs/#javascript-behavior">Bootstrap 5 documentation</a>
 */
public class TabContent extends Div {

    /**
     * Creates the default widget with the default styles
     */
    public TabContent() {
        super();

        setStyleName(Styles.TAB_CONTENT);
    }

    /**
     * We override the add to make sure only children of type TabPane can be added!
     *
     * @param child widget to be added
     * @see TabPanel
     */
    @Override
    public void add(final Widget child) {
        if (!(child instanceof TabPanel)) {
            throw new IllegalArgumentException("TabContent must have children of type TabPane.");
        }
        super.add(child);
    }
}
