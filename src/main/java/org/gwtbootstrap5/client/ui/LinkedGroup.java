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

/**
 * List group of links or buttons ({@code div.list-group}), each a {@link LinkedGroupItem}.
 * <h2>UiBinder example</h2>
 * <pre>{@code
 *     <b:LinkedGroup>
 *         <b:LinkedGroupItem text="Inbox" href="#inbox" active="true"/>
 *         <b:LinkedGroupItem text="Sent" href="#sent"/>
 *     </b:LinkedGroup>
 * }</pre>
 *
 * @see <a href="https://getbootstrap.com/docs/5.3/components/list-group/#links-and-buttons">Bootstrap 5 documentation</a>
 *
 * @author Joshua Godi
 */
public class LinkedGroup extends Div {

    /** Creates an empty linked list group. */
    public LinkedGroup() {
        super();

        setStyleName(Styles.LIST_GROUP);
    }
}
