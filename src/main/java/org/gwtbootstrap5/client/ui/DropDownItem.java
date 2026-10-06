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

import org.gwtbootstrap5.client.ui.base.AbstractAnchorListItem;
import org.gwtbootstrap5.client.ui.constants.Styles;

/**
 * Item of a {@link DropDownMenu}: a list item holding a link with {@code dropdown-item}.
 * {@link AnchorListItem} works too, since the menu gives its link the same class.
 * <h2>UiBinder example</h2>
 * <pre>{@code
 *     <b:DropDownMenu>
 *         <b:DropDownItem text="Action" targetHistoryToken="action"/>
 *     </b:DropDownMenu>
 * }</pre>
 *
 * @see <a href="https://getbootstrap.com/docs/5.3/components/dropdowns/">Bootstrap 5 documentation</a>
 *
 * @author Joshua Godi
 */
public class DropDownItem extends AbstractAnchorListItem implements com.google.gwt.user.client.ui.HasText {

    /** Creates an item with an empty link. */
    public DropDownItem() {
        super();

        // Bootstrap 5 styles the link, not the list item
        anchor.removeStyleName(Styles.NAV_LINK);
        anchor.addStyleName(Styles.DROPDOWN_ITEM);
    }

    /**
     * Creates an item.
     *
     * @param text the text of the link
     */
    public DropDownItem(final String text) {
        this();

        setText(text);
    }

    @Override
    public void setText(final String text) {
        anchor.setText(text);
    }

    @Override
    public String getText() {
        return anchor.getText();
    }

}
