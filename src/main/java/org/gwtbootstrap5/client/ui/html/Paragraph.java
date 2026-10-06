package org.gwtbootstrap5.client.ui.html;

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

import org.gwtbootstrap5.client.ui.base.HasAlignment;
import org.gwtbootstrap5.client.ui.base.HasEmphasis;
import org.gwtbootstrap5.client.ui.base.helper.StyleHelper;
import org.gwtbootstrap5.client.ui.base.mixin.HTMLMixin;
import org.gwtbootstrap5.client.ui.constants.Emphasis;
import org.gwtbootstrap5.client.ui.constants.TextAlignment;
import org.gwtbootstrap5.client.ui.gwt.HTMLPanel;

import com.google.gwt.dom.client.ParagraphElement;

/**
 * Paragraph ({@code p}) with text or HTML and widgets, an alignment and an emphasis color.
 *
 * @author Sven Jacobs
 */
public class Paragraph extends HTMLPanel implements HasAlignment, HasEmphasis {

    private final HTMLMixin<Paragraph> textMixin = new HTMLMixin<>(this);

    /** Creates an empty paragraph. */
    public Paragraph() {
        this("");
    }

    /**
     * Creates a paragraph.
     *
     * @param html the content, as HTML
     */
    public Paragraph(final String html) {
        super(ParagraphElement.TAG, html);
        setHTML(html);
    }

    /**
     * Sets the text of the paragraph, replacing its content.
     *
     * @param text the text
     */
    public void setText(final String text) {
        textMixin.setText(text);
    }

    /**
     * Returns the text of the paragraph.
     *
     * @return the text
     */
    public String getText() {
        return textMixin.getText();
    }

    /**
     * Returns the content of the paragraph, as HTML.
     *
     * @return the HTML
     */
    public String getHTML() {
        return textMixin.getHTML();
    }

    /**
     * Sets the content of the paragraph, as HTML.
     *
     * @param html the HTML
     */
    public void setHTML(final String html) {
        textMixin.setHTML(html);
    }

    @Override
    public void setAlignment(final TextAlignment alignment) {
        StyleHelper.addUniqueEnumStyleName(this, TextAlignment.class, alignment);
    }

    @Override
    public TextAlignment getAlignment() {
        return TextAlignment.fromStyleName(getStyleName());
    }

    @Override
    public void setEmphasis(final Emphasis emphasis) {
        StyleHelper.addUniqueEnumStyleName(this, Emphasis.class, emphasis);
    }

    @Override
    public Emphasis getEmphasis() {
        return Emphasis.fromStyleName(getStyleName());
    }
}
