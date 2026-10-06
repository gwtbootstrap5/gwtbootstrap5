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
import org.gwtbootstrap5.client.ui.gwt.FlowPanel;

/**
 * Button toolbar ({@code div.btn-toolbar}): several {@link ButtonGroup}s on one line. Space the
 * groups with margin classes such as {@code me-2}.
 * <h2>UiBinder example</h2>
 * <pre>{@code
 *     <b:ButtonToolBar>
 *         <b:ButtonGroup addStyleNames="me-2">
 *             <b:Button text="1"/>
 *             <b:Button text="2"/>
 *         </b:ButtonGroup>
 *         <b:ButtonGroup>
 *             <b:Button text="3"/>
 *         </b:ButtonGroup>
 *     </b:ButtonToolBar>
 * }</pre>
 *
 * @author Sven Jacobs
 * @author Joshua Godi
 * @see ButtonGroup
 * @see <a href="https://getbootstrap.com/docs/5.3/components/button-group/#button-toolbar">Bootstrap 5 documentation</a>
 */
public class ButtonToolBar extends FlowPanel {

    /** Creates an empty toolbar ({@code div.btn-toolbar}). */
    public ButtonToolBar() {
        super();

        setStyleName(Styles.BTN_TOOLBAR);
    }
}
