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

import org.gwtbootstrap5.client.ui.base.AbstractTextWidget;
import org.gwtbootstrap5.client.ui.constants.ElementTags;

import com.google.gwt.dom.client.Document;
import com.google.gwt.uibinder.client.UiConstructor;

/**
 * Abbreviation ({@code abbr}): a word whose full text shows on hover, from its {@code title}.
 * <h2>UiBinder example</h2>
 * <pre>{@code
 *     <b.html:Paragraph><b:Abbreviation title="HyperText Markup Language">HTML</b:Abbreviation></b.html:Paragraph>
 * }</pre>
 *
 * @author Joshua Godi
 * @see <a href="https://getbootstrap.com/docs/5.3/content/typography/#abbreviations">Bootstrap 5 documentation</a>
 */
public class Abbreviation extends AbstractTextWidget {

    /**
     * Creates an abbreviation.
     *
     * @param title the full text, shown on hover ({@code title} attribute)
     */
    @UiConstructor
    public Abbreviation(final String title) {
        super(Document.get().createElement(ElementTags.ABBR));
        setTitle(title);
    }
}
