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

import org.gwtbootstrap5.client.ui.base.button.AbstractToggleButton;
import org.gwtbootstrap5.client.ui.constants.IconType;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.dom.client.ClickHandler;
import org.gwtbootstrap5.client.ui.constants.Styles;

/**
 * Button ({@code button.btn}) with a type, a size, an optional icon and badge. With
 * {@code dataToggle} and {@code dataTarget} it opens Bootstrap components such as modals and
 * collapses.
 * <h2>UiBinder example</h2>
 * <pre>{@code
 *     <b:Button type="PRIMARY" text="Save"/>
 *     <b:Button type="DANGER_OUTLINE" size="SMALL" icon="TRASH" text="Delete"/>
 * }</pre>
 *
 * @author Sven Jacobs
 * @see org.gwtbootstrap5.client.ui.base.button.AbstractToggleButton
 * @see SubmitButton
 * @see <a href="https://getbootstrap.com/docs/5.3/components/buttons/">Bootstrap 5 documentation</a>
 */
public class Button extends AbstractToggleButton {

    /**
     * Creates button with DEFAULT type.
     */
    public Button() {
        super();
    }

    /**
     * Creates button with specified text
     *
     * @param text Text contents of button
     */
    public Button(final String text) {
        this();
        setText(text);
    }

    /**
     * Creates a button with a click handler.
     *
     * @param text the text of the button
     * @param handler called when the button is clicked
     */
    public Button(final String text, final ClickHandler handler) {
        this(text);
        super.addClickHandler(handler);
    }

    /**
     * Creates a button with an icon and a click handler.
     *
     * @param text the text of the button
     * @param iconType the icon, shown before the text
     * @param clickHandler called when the button is clicked
     */
    public Button(final String text, final IconType iconType, final ClickHandler clickHandler) {
        this(text, clickHandler);
        setIcon(iconType);
    }

    @Override
    protected Element createElement() {
        return Document.get().createPushButtonElement().cast();
    }

    /**
     * Keeps the text of the button on one line ({@code text-nowrap}).
     *
     * @param noWrap {@code true} to keep the text from wrapping
     */
    public void setNoWrap(boolean noWrap) {
        if (noWrap) {
            addStyleName(Styles.TEXT_NOWRAP);
        } else {
            removeStyleName(Styles.TEXT_NOWRAP);
        }
    }
}
