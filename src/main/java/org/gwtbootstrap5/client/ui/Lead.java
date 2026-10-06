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
import org.gwtbootstrap5.client.ui.html.Text;

import com.google.gwt.dom.client.Document;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.HasWidgets;

/**
 * Lead paragraph ({@code p.lead}): larger text that makes a paragraph stand out.
 * <h2>UiBinder example</h2>
 * <pre>{@code
 *     <b:Lead>This is a lead paragraph.</b:Lead>
 * }</pre>
 *
 * @see <a href="https://getbootstrap.com/docs/5.3/content/typography/#lead">Bootstrap 5 documentation</a>
 *
 * @author Joshua Godi
 */
public class Lead extends ComplexWidget implements HasWidgets, HasText {
    private final Text text = new Text();

    /** Creates an empty lead paragraph. */
    public Lead() {
        super();

        setElement(Document.get().createPElement());
        setStyleName(Styles.LEAD);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getText() {
        return text.getText();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setText(final String text) {
        this.text.setText(text);
        insert(this.text, 0);
    }
}
