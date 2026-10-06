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

import org.gwtbootstrap5.client.ui.base.ValueBoxBase;
import org.gwtbootstrap5.client.ui.constants.Styles;

import com.google.gwt.dom.client.Document;
import com.google.gwt.text.client.IntegerParser;
import com.google.gwt.text.client.IntegerRenderer;
import com.google.gwt.text.shared.Parser;
import com.google.gwt.text.shared.Renderer;

/**
 * Text box for an {@code Integer}, with Bootstrap's {@code form-control} class.
 *
 * @see <a href="https://getbootstrap.com/docs/5.3/forms/form-control/">Bootstrap 5 documentation</a>
 */
public class IntegerBox extends ValueBoxBase<Integer> {

    /** Creates an empty box that parses and renders the number with GWT's default format. */
    public IntegerBox() {
        this(IntegerRenderer.instance(), IntegerParser.instance());
    }

    /**
     * Creates an empty box with a parser and a renderer of its own.
     *
     * @param renderer turns the value into the text of the box
     * @param parser turns the text of the box into the value
     */
    public IntegerBox(Renderer<Integer> renderer, Parser<Integer> parser) {
        super(Document.get().createTextInputElement(), renderer, parser);
        addStyleName(Styles.FORM_CONTROL);
    }

}
