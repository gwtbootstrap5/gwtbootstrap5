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

import org.gwtbootstrap5.client.ui.base.helper.StyleHelper;
import org.gwtbootstrap5.client.ui.constants.ColumnSize;
import org.gwtbootstrap5.client.ui.constants.ContextualBackground;
import org.gwtbootstrap5.client.ui.constants.PlaceholderSize;
import org.gwtbootstrap5.client.ui.constants.Styles;
import org.gwtbootstrap5.client.ui.gwt.Widget;

import com.google.gwt.dom.client.Document;

/**
 * Loading placeholder ({@code span.placeholder}): a grey bar that stands for content still loading.
 * Animate a group of them with {@link StyleHelper#setPlaceholderAnimation} on their container.
 * <h2>UiBinder example</h2>
 * <pre>{@code
 *     <g:HTMLPanel ui:field="card">
 *         <b:Placeholder columnSize="XS_6"/>
 *         <b:Placeholder columnSize="XS_4" size="LG" color="PRIMARY"/>
 *     </g:HTMLPanel>
 * }</pre>
 *
 * @see <a href="https://getbootstrap.com/docs/5.3/components/placeholders/">Bootstrap 5 documentation</a>
 */
public class Placeholder extends Widget {

    /**
     * Creates a placeholder ({@code span.placeholder}); give it a width with
     * {@link #setColumnSize}.
     */
    public Placeholder() {
        setElement(Document.get().createSpanElement());
        setStyleName(Styles.PLACEHOLDER);
    }

    /**
     * Sets the width as a fraction of the container ({@code col-*}).
     *
     * @param columnSize the width, as a column size such as {@code XS_6}
     */
    public void setColumnSize(final ColumnSize columnSize) {
        StyleHelper.addUniqueEnumStyleName(this, ColumnSize.class, columnSize);
    }

    /**
     * Sets the height of the placeholder ({@code placeholder-xs}, {@code -sm} or {@code -lg}).
     *
     * @param size the size, or {@code null} for the default height
     */
    public void setSize(final PlaceholderSize size) {
        StyleHelper.addUniqueEnumStyleName(this, PlaceholderSize.class, size);
    }

    /**
     * Sets the color; {@code null} or {@link ContextualBackground#DEFAULT} for the current text color.
     *
     * @param color the background, such as {@code PRIMARY}
     */
    public void setColor(final ContextualBackground color) {
        StyleHelper.addUniqueEnumStyleName(this, ContextualBackground.class, color);
    }
}
