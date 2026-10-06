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

import com.google.gwt.dom.client.Document;
import org.gwtbootstrap5.client.ui.constants.Styles;

/**
 * Block quotation: a {@code blockquote.blockquote} for quoting content from another source.
 * <h2>UiBinder example</h2>
 * <pre>{@code
 *     <b:BlockQuote>
 *         <b.html:Paragraph>A well-known quote, contained in a blockquote element.</b.html:Paragraph>
 *     </b:BlockQuote>
 * }</pre>
 *
 * @see <a href="https://getbootstrap.com/docs/5.3/content/typography/#blockquotes">Bootstrap 5 documentation</a>
 *
 * @author Joshua Godi
 */
public class BlockQuote extends ComplexWidget {

    /** Creates an empty block quotation. */
    public BlockQuote() {
        super();

        setElement(Document.get().createBlockQuoteElement());
        setStyleName(Styles.BLOCKQUOTE);
    }

}
