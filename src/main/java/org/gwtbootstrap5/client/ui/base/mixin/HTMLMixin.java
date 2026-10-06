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
 * Reads and writes the inner HTML and text of a widget's element.
 *
 * @param <T> the type of the widget
 * @author Grant Slender
 */
public class HTMLMixin<T extends UIObject> extends TextMixin<T> {

    /**
     * Creates the mixin of a widget.
     *
     * @param uiObject the widget
     */
    public HTMLMixin(final T uiObject) {
        super(uiObject);
    }

    /**
     * Returns the inner HTML of the element.
     *
     * @return the HTML
     */
    public String getHTML() {
        return uiObject.getElement().getInnerHTML();
    }

    /**
     * Sets the inner HTML of the element.
     *
     * @param html the HTML
     */
    public void setHTML(final String html) {
        uiObject.getElement().setInnerHTML(html);
    }

}
