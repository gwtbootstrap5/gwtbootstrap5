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

import org.gwtbootstrap5.client.ui.base.HasInputType;
import org.gwtbootstrap5.client.ui.base.ValueBoxBase;
import org.gwtbootstrap5.client.ui.constants.ElementTags;
import org.gwtbootstrap5.client.ui.constants.InputType;
import org.gwtbootstrap5.client.ui.constants.Styles;

import com.google.gwt.dom.client.Document;
import com.google.gwt.text.shared.Parser;
import com.google.gwt.text.shared.Renderer;
import com.google.gwt.text.shared.testing.PassthroughParser;
import com.google.gwt.text.shared.testing.PassthroughRenderer;
import com.google.gwt.uibinder.client.UiConstructor;

/**
 * Input ({@code input.form-control}) of any HTML type, set with {@code type}. Text boxes,
 * number boxes and the other inputs of this package are inputs of a fixed type.
 * <h2>UiBinder example</h2>
 * <pre>{@code
 *     <b:Input type="DATE" min="2026-01-01" max="2026-12-31"/>
 * }</pre>
 *
 * @see <a href="https://getbootstrap.com/docs/5.3/forms/form-control/">Bootstrap 5 documentation</a>
 *
 * @author Joshua Godi
 */
public class Input extends ValueBoxBase<String> implements HasInputType {

    private static final String MIN = "min";

    private static final String MAX = "max";

    /** Creates a text input whose value is its text. */
    public Input() {
        this(PassthroughRenderer.instance(), PassthroughParser.instance());
    }

    /**
     * Creates a text input with a parser and a renderer of its own.
     *
     * @param renderer turns the value into the text of the input
     * @param parser turns the text of the input into the value
     */
    public Input(Renderer<String> renderer, Parser<String> parser) {
        super(Document.get().createElement(ElementTags.INPUT), renderer, parser);
        addStyleName(Styles.FORM_CONTROL);
    }

    /**
     * Creates an input of the given type.
     *
     * @param type the HTML type of the input
     */
    @UiConstructor
    public Input(final InputType type) {
        this();
        setType(type);
    }

    /**
     * Sets the smallest value the input takes ({@code min} attribute).
     *
     * @param min the minimum, in the format of the input's type
     */
    public void setMin(final String min) {
        getElement().setAttribute(MIN, min);
    }

    /**
     * Sets the largest value the input takes ({@code max} attribute).
     *
     * @param max the maximum, in the format of the input's type
     */
    public void setMax(final String max) {
        getElement().setAttribute(MAX, max);
    }

    @Override
    public void setType(final InputType inputType) {
        getElement().setAttribute(TYPE, inputType.getType());
    }

    @Override
    public InputType getType() {
        if (getElement().getAttribute(TYPE) == null || getElement().getAttribute(TYPE).isEmpty()) { return null; }
        return InputType.valueOf(getElement().getAttribute(TYPE));
    }

    @Override
    public void setPlaceholder(final String placeHolder) {
        getElement().setAttribute(PLACEHOLDER, placeHolder != null ? placeHolder : "");
    }

    @Override
    public String getPlaceholder() {
        return getElement().getAttribute(PLACEHOLDER);
    }

}
