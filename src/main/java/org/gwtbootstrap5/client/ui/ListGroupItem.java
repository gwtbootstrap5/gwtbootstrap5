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
import org.gwtbootstrap5.client.ui.base.HasType;
import org.gwtbootstrap5.client.ui.base.helper.StyleHelper;
import org.gwtbootstrap5.client.ui.constants.ListGroupItemType;
import org.gwtbootstrap5.client.ui.constants.Styles;
import org.gwtbootstrap5.client.ui.html.Span;

import com.google.gwt.dom.client.Document;

/**
 * Item of a {@link ListGroup} ({@code li.list-group-item}), with text or HTML and widgets after
 * it.
 *
 * @see <a href="https://getbootstrap.com/docs/5.3/components/list-group/">Bootstrap 5 documentation</a>
 *
 * @author Joshua Godi
 */
public class ListGroupItem extends ComplexWidget implements HasType<ListGroupItemType> {
    private final Span span = new Span();

    /** Creates an empty item. */
    public ListGroupItem() {
        super();

        setElement(Document.get().createLIElement());
        setStyleName(Styles.LIST_GROUP_ITEM);

        add(span);
    }

    /**
     * Returns the text of the item.
     *
     * @return the text
     */
    public String getText() {
        return span.getText();
    }

    /**
     * Sets the text of the item.
     *
     * @param text the text
     */
    public void setText(final String text) {
        span.setText(text);
    }

    /**
     * Returns the content of the item, as HTML.
     *
     * @return the HTML
     */
    public String getHTML() {
        return span.getHTML();
    }

    /**
     * Sets the content of the item, as HTML.
     *
     * @param html the HTML
     */
    public void setHTML(String html) {
        span.setHTML(html);
    }

    @Override
    public void setType(final ListGroupItemType type) {
        StyleHelper.addUniqueEnumStyleName(this, ListGroupItemType.class, type);
    }

    @Override
    public ListGroupItemType getType() {
        return ListGroupItemType.fromStyleName(getStyleName());
    }

}
