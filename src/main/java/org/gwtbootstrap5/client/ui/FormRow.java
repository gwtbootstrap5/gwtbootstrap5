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

import com.google.gwt.dom.client.Document;
import org.gwtbootstrap5.client.ui.base.form.FormElementContainer;

/**
 * Plain {@code div} for form controls laid out on one line. Bootstrap 5 has no {@code form-row}
 * class: give it grid classes such as {@code row g-3}, and put the controls in columns.
 *
 * @author Sven Jacobs
 */
public class FormRow extends FormElementContainer {

    /** Creates an empty row. */
    public FormRow() {
        super();

        setElement(Document.get().createDivElement());
    }

}
