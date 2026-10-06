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

import org.gwtbootstrap5.client.ui.base.ComplexWidget;

import com.google.gwt.dom.client.Document;
import com.google.gwt.user.client.ui.HasEnabled;

/**
 * Field set ({@code fieldset}): groups form controls, and disables all of them at once with
 * {@link #setEnabled}.
 * <h2>UiBinder example</h2>
 * <pre>{@code
 *     <b:FieldSet enabled="false">
 *         <b:Legend>Disabled fields</b:Legend>
 *         <b:TextBox placeholder="Disabled input"/>
 *     </b:FieldSet>
 * }</pre>
 *
 * @see <a href="https://getbootstrap.com/docs/5.3/forms/overview/#disabled-forms">Bootstrap 5 documentation</a>
 *
 * @author Sven Jacobs
 * @author Joshua Godi
 * @see Form
 */
public class FieldSet extends ComplexWidget implements HasEnabled {
    private static final String DISABLED = "disabled";

    /** Creates an empty, enabled field set. */
    public FieldSet() {
        super();

        setElement(Document.get().createFieldSetElement());
    }

    @Override
    public void setEnabled(final boolean enabled) {
        getElement().setPropertyBoolean(DISABLED, !enabled);
    }

    @Override
    public boolean isEnabled() {
        return !getElement().getPropertyBoolean(DISABLED);
    }
}
