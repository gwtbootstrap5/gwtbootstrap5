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
import org.gwtbootstrap5.client.ui.constants.BadgeType;
import org.gwtbootstrap5.client.ui.constants.Styles;
import org.gwtbootstrap5.client.ui.html.Text;

import com.google.gwt.dom.client.Document;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.HasWidgets;

/**
 * Badge ({@code span.badge.rounded-pill}): a small count or label, colored by its {@code type}.
 * <h2>UiBinder example</h2>
 * <pre>{@code
 *     <b:Badge type="PRIMARY" text="New"/>
 * }</pre>
 *
 * @author Sven Jacobs
 * @see <a href="https://getbootstrap.com/docs/5.3/components/badge/">Bootstrap 5 documentation</a>
 */
public class Badge extends ComplexWidget implements HasWidgets, HasText, HasType<BadgeType> {
    private final Text text = new Text();

    /** Creates an empty badge ({@code span.badge.rounded-pill}). */
    public Badge() {
        super();

        setElement(Document.get().createSpanElement());
        addStyleName(Styles.BADGE);
        addStyleName(Styles.ROUNDED_PILL);
    }

    /**
     * Creates a badge.
     *
     * @param text the text of the badge
     */
    public Badge(final String text) {
        this();
        setText(text);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getText() {
        return text.getText();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setText(final String text) {
        this.text.setText(text);
        insert(this.text, 0);
    }

    @Override
    public void setType(BadgeType type) {
        StyleHelper.addUniqueEnumStyleName(this, BadgeType.class, type);
    }

    @Override
    public BadgeType getType() {
        return BadgeType.fromStyleName(getStyleName());
    }

}
