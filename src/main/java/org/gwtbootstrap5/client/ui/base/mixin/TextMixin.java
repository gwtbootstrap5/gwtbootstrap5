package org.gwtbootstrap5.client.ui.base.mixin;

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

import com.google.gwt.user.client.ui.UIObject;

/**
 * Reads and writes the inner text of a widget's element.
 *
 * @param <T> the type of the widget
 * @author Grant Slender
 */
public class TextMixin<T extends UIObject> extends AbstractMixin {

    /**
     * Creates the mixin of a widget.
     *
     * @param uiObject the widget
     */
    public TextMixin(final T uiObject) {
        super(uiObject);
    }

    /**
     * Returns the inner text of the element.
     *
     * @return the text
     */
    public String getText() {
        return uiObject.getElement().getInnerText();
    }

    /**
     * Sets the inner text of the element.
     *
     * @param text the text
     */
    public void setText(final String text) {
        uiObject.getElement().setInnerText(text);
    }
}
