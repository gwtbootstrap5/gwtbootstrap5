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

import org.gwtbootstrap5.client.ui.base.HasSize;
import org.gwtbootstrap5.client.ui.base.helper.StyleHelper;
import org.gwtbootstrap5.client.ui.constants.InputGroupSize;
import org.gwtbootstrap5.client.ui.constants.Styles;
import org.gwtbootstrap5.client.ui.gwt.FlowPanel;

/**
 * Input group ({@code div.input-group}): a form control with {@link InputGroupText}s, buttons or
 * other controls joined before or after it.
 * <h2>UiBinder example</h2>
 * <pre>{@code
 *     <b:InputGroup>
 *         <b:TextBox placeholder="Recipient's username"/>
 *         <b:InputGroupText>@example.com</b:InputGroupText>
 *     </b:InputGroup>
 * }</pre>
 *
 * @author Sven Jacobs
 * @author Joshua Godi
 * @author Tercio Gaudencio Filho (terciofilho [at] gmail.com)
 * @see InputGroupText
 * @see <a href="https://getbootstrap.com/docs/5.3/forms/input-group/">Bootstrap 5 documentation</a>
 */
public class InputGroup extends FlowPanel implements HasSize<InputGroupSize> {

    /** Creates an empty input group ({@code div.input-group}). */
    public InputGroup() {
        super();

        setStyleName(Styles.INPUT_GROUP);
    }

    @Override
    public void setSize(InputGroupSize size) {
        StyleHelper.addUniqueEnumStyleName(this, InputGroupSize.class, size);
    }

    @Override
    public InputGroupSize getSize() {
        return InputGroupSize.fromStyleName(getStyleName());
    }

}
