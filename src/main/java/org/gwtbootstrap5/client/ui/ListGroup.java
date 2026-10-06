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
import org.gwtbootstrap5.client.ui.constants.ListGroupHorizontal;
import org.gwtbootstrap5.client.ui.constants.Styles;
import org.gwtbootstrap5.client.ui.html.UnorderedList;

import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.Widget;

/**
 * List group ({@code ul.list-group}): a list of {@link ListGroupItem}s, which can be flush,
 * numbered or horizontal.
 * <h2>UiBinder example</h2>
 * <pre>{@code
 *     <b:ListGroup flush="true">
 *         <b:ListGroupItem text="An item"/>
 *         <b:ListGroupItem text="A second item" type="PRIMARY"/>
 *     </b:ListGroup>
 * }</pre>
 *
 * @see <a href="https://getbootstrap.com/docs/5.3/components/list-group/">Bootstrap 5 documentation</a>
 *
 * @author Joshua Godi
 */
public class ListGroup extends UnorderedList {

    /** Creates an empty, vertical list group. */
    public ListGroup() {
        super();

        setStyleName(Styles.LIST_GROUP);
    }

    @Override
    public void add(final Widget child) {
        if (!(child instanceof ListGroupItem)) {
            throw new IllegalArgumentException("Only ListGroupItems can be inside a ListGroup.");
        }

        add(child, (Element) getElement());
    }

    /**
     * Numbers the items ({@code list-group-numbered}). Use it on an ordered list for the numbers to
     * be announced by screen readers.
     *
     * @param numbered {@code true} to number the items
     */
    public void setNumbered(final boolean numbered) {
        if (numbered) {
            getElement().addClassName(Styles.LIST_GROUP_NUMBERED);
        } else {
            getElement().removeClassName(Styles.LIST_GROUP_NUMBERED);
        }
    }

    /**
     * Removes the outer borders and rounded corners, to render the list edge to edge with its
     * parent, e.g. inside a {@link Card} ({@code list-group-flush}).
     *
     * @param flush {@code true} to render the list flush
     */
    public void setFlush(final boolean flush) {
        if (flush) {
            addStyleName(Styles.LIST_GROUP_FLUSH);
        } else {
            removeStyleName(Styles.LIST_GROUP_FLUSH);
        }
    }

    /**
     * Returns whether the list is flush.
     *
     * @return {@code true} if it has {@code list-group-flush}
     */
    public boolean isFlush() {
        return StyleHelper.containsStyle(getStyleName(), Styles.LIST_GROUP_FLUSH);
    }

    /**
     * Lays the items out horizontally, always or from a breakpoint up.
     *
     * @param horizontal the breakpoint, or {@code null} for a vertical list
     */
    public void setHorizontal(final ListGroupHorizontal horizontal) {
        StyleHelper.addUniqueEnumStyleName(this, ListGroupHorizontal.class, horizontal);
    }

    /**
     * Returns how the items are laid out horizontally.
     *
     * @return the breakpoint from which the list is horizontal, or {@code null} if it is vertical
     */
    public ListGroupHorizontal getHorizontal() {
        return ListGroupHorizontal.fromStyleName(getStyleName());
    }

}
