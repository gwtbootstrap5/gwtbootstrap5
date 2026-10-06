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
import org.gwtbootstrap5.client.ui.base.helper.SourceCodeHelper;
import org.gwtbootstrap5.client.ui.constants.ElementTags;

import com.google.gwt.dom.client.Document;

/**
 * Inline code ({@code code}). For a block of code, see {@link Pre}.
 * <h2>UiBinder example</h2>
 * <pre>{@code
 *     <b.html:Paragraph>Wrap inline snippets in <b:Code>&lt;code&gt;</b:Code>.</b.html:Paragraph>
 * }</pre>
 *
 * @author Sven Jacobs
 * @see Pre
 * @see <a href="https://getbootstrap.com/docs/5.3/content/reboot/#code">Bootstrap 5 documentation</a>
 */
public class Code extends AbstractTextWidget {

    /** Creates an empty {@code code} element. */
    public Code() {
        super(Document.get().createElement(ElementTags.CODE));
    }

    /**
     * Sets HTML contents.
     * <p>
     * If HTML contains "\n" it will be replaced by a {@code <br>} element
     * and "\s" will be replaced by a whitespace.
     *
     * @param html HTML contents
     */
    @Override
    public void setHTML(final String html) {
        getElement().setInnerHTML(SourceCodeHelper.parseCode(html).asString());
    }
}
