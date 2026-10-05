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

import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.UIObject;

/**
 * An Affix is an element/container that stays "pinned" to the top of the viewport
 * once the page has been scrolled up to it.
 * <p>
 * Any element/container can become an Affix. Usually used for sidebar
 * navigation.
 * <p>
 * <strong>Note:</strong> Bootstrap 5 removed the affix plugin. This class uses CSS
 * sticky positioning instead (Bootstrap's {@code sticky-top} class), and the offset is the
 * distance in pixels from the top of the viewport at which the element sticks. Sticky
 * elements stick within their parent, so the parent must be taller than the element. See
 * Bootstrap's <a href="https://getbootstrap.com/docs/5.3/helpers/position/#sticky-top">documentation</a>.
 *
 * @author Sven Jacobs
 */
public class Affix {

    private static final String STICKY_TOP = "sticky-top";

    /**
     * Applys affix functionality to specified element.
     *
     * @param element Element to "affixnize"
     */
    public static void affix(final Element element) {
        internalAffix(element, 10);
    }

    /**
     * Applys affix functionality to specified element.
     *
     * @param element Element to "affixnize"
     * @param offset  Offset of affix
     */
    public static void affix(final Element element, final int offset) {
        internalAffix(element, offset);
    }

    /**
     * Applys affix functionality to specified object.
     *
     * @param object Object to "affixnize"
     */
    public static void affix(final UIObject object) {
        affix(object.getElement());
    }

    /**
     * Applys affix functionality to specified object.
     *
     * @param object Object to "affixnize"
     * @param offset Offset of affix
     */
    public static void affix(final UIObject object, final int offset) {
        affix(object.getElement(), offset);
    }

    private static void internalAffix(final Element e, final int offset) {
        e.addClassName(STICKY_TOP);
        e.getStyle().setPropertyPx("top", offset);
    }
}
