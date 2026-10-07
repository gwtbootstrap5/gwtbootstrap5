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

import org.gwtbootstrap5.client.ui.base.HasResponsiveness;
import org.gwtbootstrap5.client.ui.base.helper.StyleHelper;
import org.gwtbootstrap5.client.ui.constants.DeviceSize;
import org.gwtbootstrap5.client.ui.constants.Styles;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Widget;

/**
 * Plain text in a {@link DropDownMenu} ({@code li > span.dropdown-item-text}): spaced like an
 * item, but not a link and not clickable.
 * <h2>UiBinder example</h2>
 * <pre>{@code
 *     <b:DropDownMenu>
 *         <b:DropDownItemText text="Signed in as Ana"/>
 *         <b:DropDownItem text="Sign out" targetHistoryToken="logout"/>
 *     </b:DropDownMenu>
 * }</pre>
 *
 * @see <a href="https://getbootstrap.com/docs/5.3/components/dropdowns/#text">Bootstrap 5 documentation</a>
 */
public class DropDownItemText extends Widget implements HasText, HasResponsiveness {
    private final Element span = Document.get().createSpanElement();

    /** Creates an empty text item ({@code li > span.dropdown-item-text}). */
    public DropDownItemText() {
        super();

        setElement(Document.get().createLIElement());
        span.setClassName(Styles.DROPDOWN_ITEM_TEXT);
        getElement().appendChild(span);
    }

    /**
     * Creates a text item.
     *
     * @param text the text
     */
    public DropDownItemText(final String text) {
        this();
        setText(text);
    }

    @Override
    public void setText(final String text) {
        span.setInnerText(text);
    }

    @Override
    public String getText() {
        return span.getInnerText();
    }

    @Override
    public void setVisibleOn(final DeviceSize deviceSize) {
        StyleHelper.setVisibleOn(this, deviceSize);
    }

    @Override
    public void setHiddenOn(final DeviceSize deviceSize) {
        StyleHelper.setHiddenOn(this, deviceSize);
    }
}
