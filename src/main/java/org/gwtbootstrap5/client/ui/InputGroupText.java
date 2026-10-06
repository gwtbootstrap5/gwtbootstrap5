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
import org.gwtbootstrap5.client.ui.html.Span;

/**
 * Text or icon next to the controls of an {@link InputGroup} ({@code span.input-group-text}).
 * <h2>UiBinder example</h2>
 * <pre>{@code
 *     <b:InputGroup>
 *         <b:InputGroupText>@</b:InputGroupText>
 *         <b:TextBox placeholder="Username"/>
 *     </b:InputGroup>
 * }</pre>
 *
 * @see <a href="https://getbootstrap.com/docs/5.3/forms/input-group/">Bootstrap 5 documentation</a>
 */
public class InputGroupText extends Span {

    /** Creates an empty text. */
    public InputGroupText() {
        super();

        setStyleName(Styles.INPUT_GROUP_TEXT);
    }

    /**
     * Creates a text.
     *
     * @param html the content, as HTML
     */
    public InputGroupText(String html) {
        super(html);

        setStyleName(Styles.INPUT_GROUP_TEXT);
    }

}
