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
import org.gwtbootstrap5.client.ui.constants.Attributes;
import org.gwtbootstrap5.client.ui.constants.Styles;
import org.gwtbootstrap5.client.ui.constants.Toggle;
import org.gwtbootstrap5.client.ui.html.Text;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.Widget;

/**
 * Header of an {@link AccordionItem}: an {@code h2.accordion-header} wrapping the
 * {@code button.accordion-button} that opens and closes the item. Text and child widgets go inside
 * the button. It doesn't implement {@code HasText}, which would make UiBinder reject child widgets.
 *
 * @see Accordion
 */
public class AccordionHeader extends ComplexWidget {

    private static final String BUTTON = "button";

    private final Element button;
    private Text text = null;

    public AccordionHeader() {
        setElement(Document.get().createHElement(2));
        setStyleName(Styles.ACCORDION_HEADER);

        button = Document.get().createElement(BUTTON);
        button.setAttribute(Attributes.TYPE, BUTTON);
        button.setClassName(Styles.ACCORDION_BUTTON + " " + Styles.COLLAPSED);
        button.setAttribute(Attributes.DATA_TOGGLE, Toggle.COLLAPSE.getToggle());
        button.setAttribute(Attributes.ARIA_EXPANDED, "false");
        getElement().appendChild(button);
    }

    public AccordionHeader(final String text) {
        this();
        setText(text);
    }

    @Override
    public void add(final Widget child) {
        add(child, button);
    }

    public String getText() {
        return text == null ? "" : text.getText();
    }

    public void setText(final String text) {
        if (this.text == null) {
            this.text = new Text(text);
            add(this.text);
        } else {
            this.text.setText(text);
        }
    }

    /**
     * @return the {@code button.accordion-button}
     */
    Element getButton() {
        return button;
    }
}
