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
import org.gwtbootstrap5.client.ui.base.HasValidationState;
import org.gwtbootstrap5.client.ui.base.form.FormElementContainer;
import org.gwtbootstrap5.client.ui.base.helper.StyleHelper;
import org.gwtbootstrap5.client.ui.constants.FormGroupSize;

import com.google.gwt.dom.client.Document;
import org.gwtbootstrap5.client.ui.constants.ValidationState;

/**
 * Group of a form control with its {@link FormLabel} and {@link HelpBlock}. Bootstrap 5 has no
 * {@code form-group} class: the group is a plain {@code div}, with spacing classes as needed. Its
 * validation state is what the controls' error handlers set when validation fails.
 * <h2>UiBinder example</h2>
 * <pre>{@code
 *     <b:FormGroup addStyleNames="mb-3">
 *         <b:FormLabel for="email" text="Email"/>
 *         <b:TextBox b:id="email"/>
 *         <b:HelpBlock text="We'll never share your email."/>
 *     </b:FormGroup>
 * }</pre>
 *
 * @author Sven Jacobs
 */
public class FormGroup extends FormElementContainer implements HasSize<FormGroupSize>, HasValidationState {

    /** Creates an empty group. */
    public FormGroup() {
        super();

        setElement(Document.get().createDivElement());
    }

    @Override
    public void setSize(FormGroupSize size) {
        StyleHelper.addUniqueEnumStyleName(this, FormGroupSize.class, size);
    }

    @Override
    public FormGroupSize getSize() {
        return FormGroupSize.fromStyleName(getStyleName());
    }

    @Override
    public void setValidationState(final ValidationState state) {
        StyleHelper.addUniqueEnumStyleName(this, ValidationState.class, state);
    }

    @Override
    public ValidationState getValidationState() {
        return ValidationState.fromStyleName(getStyleName());
    }
}
