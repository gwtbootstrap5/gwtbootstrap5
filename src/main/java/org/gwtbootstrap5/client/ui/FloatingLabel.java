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

import org.gwtbootstrap5.client.ui.constants.Attributes;
import org.gwtbootstrap5.client.ui.constants.Styles;
import org.gwtbootstrap5.client.ui.html.Div;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.LabelElement;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.Widget;

/**
 * Label that sits inside a form control and floats above its value ({@code form-floating}). It
 * takes one control: a {@link TextBox}, {@link TextArea}, {@link Input} or {@link ListBox}.
 * <p>
 * When attached it puts the label after the control, links it with {@code for}, and gives a text
 * control the {@code placeholder} Bootstrap needs to tell an empty control from a filled one.
 * <h2>UiBinder example</h2>
 * <pre>{@code
 *     <b:FloatingLabel text="Email address">
 *         <b:TextBox/>
 *     </b:FloatingLabel>
 * }</pre>
 *
 * @see <a href="https://getbootstrap.com/docs/5.3/forms/floating-labels/">Bootstrap 5 documentation</a>
 */
public class FloatingLabel extends Div {

    private static final String SELECT = "select";

    private final LabelElement label = Document.get().createLabelElement();
    // The placeholder this widget gave the control, replaced when the text changes
    private String generatedPlaceholder;

    /** Creates a floating label without text. */
    public FloatingLabel() {
        super();

        setStyleName(Styles.FORM_FLOATING);
        getElement().appendChild(label);
    }

    /**
     * Creates a floating label.
     *
     * @param text the text of the label
     */
    public FloatingLabel(final String text) {
        this();
        setText(text);
    }

    /**
     * @throws IllegalStateException if the label already has a control
     */
    @Override
    public void add(final Widget child) {
        if (getWidgetCount() > 0) {
            throw new IllegalStateException("A FloatingLabel takes one control");
        }
        insert(child, 0);
        link();
    }

    /**
     * Sets the label's text.
     *
     * @param text the text of the label
     */
    public void setText(final String text) {
        label.setInnerText(text);
        link();
    }

    /**
     * Returns the text of the label.
     *
     * @return the text
     */
    public String getText() {
        return label.getInnerText();
    }

    @Override
    protected void onLoad() {
        super.onLoad();
        link();
    }

    private void link() {
        if (getWidgetCount() == 0) {
            return;
        }
        final Element control = getWidget(0).getElement();
        if (control.getId() == null || control.getId().isEmpty()) {
            control.setId(DOM.createUniqueId());
        }
        label.setHtmlFor(control.getId());
        final String placeholder = control.getAttribute(Attributes.PLACEHOLDER);
        if (!SELECT.equalsIgnoreCase(control.getTagName())
                && (placeholder.isEmpty() || placeholder.equals(generatedPlaceholder))) {
            generatedPlaceholder = label.getInnerText().isEmpty() ? " " : label.getInnerText();
            control.setAttribute(Attributes.PLACEHOLDER, generatedPlaceholder);
        }
        // The label must follow the control for Bootstrap's sibling selectors
        getElement().appendChild(label);
    }
}
