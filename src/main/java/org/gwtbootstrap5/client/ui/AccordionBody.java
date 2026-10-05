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
import org.gwtbootstrap5.client.ui.constants.Styles;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.Widget;

/**
 * Collapsible body of an {@link AccordionItem}: a {@code div.accordion-collapse.collapse} wrapping
 * the {@code div.accordion-body} that holds the child widgets.
 *
 * @see Accordion
 */
public class AccordionBody extends ComplexWidget {

    private final Element body;

    public AccordionBody() {
        setElement(Document.get().createDivElement());
        setStyleName(Styles.ACCORDION_COLLAPSE + " " + Styles.COLLAPSE);

        body = Document.get().createDivElement();
        body.setClassName(Styles.ACCORDION_BODY);
        getElement().appendChild(body);
    }

    @Override
    public void add(final Widget child) {
        add(child, body);
    }
}
