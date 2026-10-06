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

import org.gwtbootstrap5.client.ui.base.AbstractDropDown;

import com.google.gwt.dom.client.Document;

/**
 * Dropdown ({@code div.dropdown}): a toggle with {@code dataToggle="DROPDOWN"} and the
 * {@link DropDownMenu} it opens.
 * <h2>UiBinder example</h2>
 * <pre>{@code
 *     <b:DropDown>
 *         <b:Button dataToggle="DROPDOWN" text="Dropdown button"/>
 *         <b:DropDownMenu>
 *             <b:AnchorListItem text="Action 1"/>
 *             <b:AnchorListItem text="Action 2"/>
 *         </b:DropDownMenu>
 *     </b:DropDown>
 * }</pre>
 *
 * @author Sven Jacobs
 * @see DropDownMenu
 * @see <a href="https://getbootstrap.com/docs/5.3/components/dropdowns/">Bootstrap 5 documentation</a>
 */
public class DropDown extends AbstractDropDown {

    /** Creates an empty dropdown ({@code div.dropdown}). */
    public DropDown() {
        super(Document.get().createDivElement());
    }
}
