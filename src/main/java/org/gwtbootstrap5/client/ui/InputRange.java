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

import org.gwtbootstrap5.client.ui.constants.InputType;
import org.gwtbootstrap5.client.ui.constants.Styles;

/**
 * Range input ({@code input.form-range}): a slider to pick a number between {@code min} and
 * {@code max}.
 * <h2>UiBinder example</h2>
 * <pre>{@code
 *     <b:InputRange min="0" max="10"/>
 * }</pre>
 *
 * @see <a href="https://getbootstrap.com/docs/5.3/forms/range/">Bootstrap 5 documentation</a>
 */
public class InputRange extends Input {

    /** Creates a range input. */
    public InputRange() {
        super();
        setType(InputType.RANGE);
        // Bootstrap 5 styles range inputs with form-range alone; form-control would add a text-field border
        removeStyleName(Styles.FORM_CONTROL);
        addStyleName(Styles.FORM_RANGE);
    }

}
