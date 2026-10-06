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

import org.gwtbootstrap5.client.ui.base.AbstractTextWidget;
import org.gwtbootstrap5.client.ui.constants.Styles;

import com.google.gwt.dom.client.Document;

/**
 * Read-only text styled as plain text in a form ({@code p.form-control-plaintext}), aligned with
 * the form's labels and controls.
 * <h2>UiBinder example</h2>
 * <pre>{@code
 *     <b:FormGroup>
 *         <b:FormLabel text="Email"/>
 *         <b:FormControlStatic text="email@example.com"/>
 *     </b:FormGroup>
 * }</pre>
 *
 * @see <a href="https://getbootstrap.com/docs/5.3/forms/form-control/#readonly-plain-text">Bootstrap 5 documentation</a>
 *
 * @author Sven Jacobs
 */
public class FormControlStatic extends AbstractTextWidget {

    /** Creates an empty static control. */
    public FormControlStatic() {
        super(Document.get().createPElement());
        setStyleName(Styles.FORM_CONTROL_PLAINTEXT);
    }

    /**
     * Creates a static control.
     *
     * @param text the text
     */
    public FormControlStatic(final String text) {
        this();
        setText(text);
    }
}
