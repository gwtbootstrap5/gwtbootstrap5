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

import org.gwtbootstrap5.client.ui.base.AbstractButtonGroup;

/**
 * Button group ({@code div.btn-group}): buttons side by side, joined together. A button with
 * {@code dataToggle="DROPDOWN"} and a {@link DropDownMenu} in it make a dropdown button.
 * <h2>UiBinder example</h2>
 * <pre>{@code
 *     <b:ButtonGroup>
 *         <b:Button text="Left"/>
 *         <b:Button text="Middle"/>
 *         <b:Button dataToggle="DROPDOWN" text="More"/>
 *         <b:DropDownMenu>
 *             <b:AnchorListItem text="Action"/>
 *         </b:DropDownMenu>
 *     </b:ButtonGroup>
 * }</pre>
 *
 * @author Sven Jacobs
 * @see Button
 * @see VerticalButtonGroup
 * @see <a href="https://getbootstrap.com/docs/5.3/components/button-group/">Bootstrap 5 documentation</a>
 */
public class ButtonGroup extends AbstractButtonGroup {

    /** Creates an empty, horizontal button group ({@code div.btn-group}). */
    public ButtonGroup() {
        super();
    }


}
