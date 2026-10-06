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

import org.gwtbootstrap5.client.ui.base.TextBoxBase;
import org.gwtbootstrap5.client.ui.constants.Styles;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.text.shared.Parser;
import com.google.gwt.text.shared.Renderer;
import com.google.gwt.text.shared.testing.PassthroughParser;
import com.google.gwt.text.shared.testing.PassthroughRenderer;

/**
 * Text input ({@code input.form-control} of type {@code text}).
 * <h2>UiBinder example</h2>
 * <pre>{@code
 *     <b:TextBox placeholder="Email address"/>
 * }</pre>
 *
 * @see <a href="https://getbootstrap.com/docs/5.3/forms/form-control/">Bootstrap 5 documentation</a>
 *
 * @author Sven Jacobs
 * @author Joshua Godi
 * @author Pontus Enmark
 * @author Steven Jardine
 */
public class TextBox extends TextBoxBase {

    /** Creates an empty text box. */
    public TextBox() {
        this(Document.get().createTextInputElement());
    }

    /**
     * Creates a text box in the given input element.
     *
     * @param element the input element
     */
    public TextBox(final Element element) {
        this(element, PassthroughRenderer.instance(), PassthroughParser.instance());
    }

    /**
     * Creates a text box in the given input element, with a parser and a renderer of its own.
     *
     * @param element the input element
     * @param renderer turns the value into the text of the box
     * @param parser turns the text of the box into the value
     */
    public TextBox(Element element, Renderer<String> renderer, Parser<String> parser) {
        super(element, renderer, parser);
        setStyleName(Styles.FORM_CONTROL);
    }

    /** Empties the text box, without firing value change events. */
    public void clear() {
        super.setValue(null);
    }

    /** Cuts the text with an ellipsis when it doesn't fit ({@code text-truncate}). */
    public void setTruncated() {
        addStyleName(Styles.TEXT_TRUNCATE);
    }
}
