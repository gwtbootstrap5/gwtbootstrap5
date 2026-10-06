package org.gwtbootstrap5.client.ui.base;

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

import com.google.gwt.dom.client.Element;
import com.google.gwt.text.shared.Parser;
import com.google.gwt.text.shared.Renderer;
import com.google.gwt.text.shared.testing.PassthroughParser;
import com.google.gwt.text.shared.testing.PassthroughRenderer;

/** Base class of the text inputs: a {@link ValueBoxBase} whose value is its text. */
public class TextBoxBase extends ValueBoxBase<String> {

    /**
     * Creates a text input in the given element.
     *
     * @param elem the input or textarea element
     */
    protected TextBoxBase(final Element elem) {
        this(elem, PassthroughRenderer.instance(), PassthroughParser.instance());
    }

    /**
     * Creates a text input in the given element, with a parser and a renderer of its own.
     *
     * @param elem the input or textarea element
     * @param renderer turns the value into the text of the input
     * @param parser turns the text of the input into the value
     */
    protected TextBoxBase(final Element elem, Renderer<String> renderer, Parser<String> parser) {
        super(elem, renderer, parser);
    }

    @Override
    public String getValue() {
        final String raw = super.getValue();
        return raw == null ? "" : raw;
    }
    
}
