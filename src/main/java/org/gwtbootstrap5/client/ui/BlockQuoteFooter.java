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

import org.gwtbootstrap5.client.ui.constants.Styles;
import org.gwtbootstrap5.client.ui.html.FigCaption;
import org.gwtbootstrap5.client.ui.html.Text;

/**
 * Source of a {@link BlockQuote} ({@code figcaption.blockquote-footer}), shown small and grey
 * after a dash. Bootstrap 5 puts it after the quote, both inside a {@code figure}.
 * <h2>UiBinder example</h2>
 * <pre>{@code
 *     <b.html:Figure>
 *         <b:BlockQuote>
 *             <b.html:Paragraph>A well-known quote, contained in a blockquote element.</b.html:Paragraph>
 *         </b:BlockQuote>
 *         <b:BlockQuoteFooter text="Someone famous in Source Title"/>
 *     </b.html:Figure>
 * }</pre>
 *
 * @see <a href="https://getbootstrap.com/docs/5.3/content/typography/#naming-a-source">Bootstrap 5 documentation</a>
 */
public class BlockQuoteFooter extends FigCaption implements com.google.gwt.user.client.ui.HasText {
    private final Text text = new Text();

    /** Creates an empty source ({@code figcaption.blockquote-footer}). */
    public BlockQuoteFooter() {
        super();

        setStyleName(Styles.BLOCKQUOTE_FOOTER);
    }

    /**
     * Creates a source.
     *
     * @param text the text of the source
     */
    public BlockQuoteFooter(final String text) {
        this();
        setText(text);
    }

    /**
     * Sets the text, before any widget added to the source (such as a {@code cite}).
     *
     * @param text the text
     */
    @Override
    public void setText(final String text) {
        this.text.setText(text);
        insert(this.text, 0);
    }

    @Override
    public String getText() {
        return text.getText();
    }
}
