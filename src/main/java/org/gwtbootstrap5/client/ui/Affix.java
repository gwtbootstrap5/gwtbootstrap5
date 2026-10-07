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

import org.gwtbootstrap5.client.ui.base.helper.StickyHelper;
import org.gwtbootstrap5.client.ui.constants.StickyPosition;

import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.UIObject;

/**
 * Pins an element to the top of the viewport once the page has been scrolled up to it, usually
 * a sidebar navigation.
 * <p>
 * Bootstrap 5 removed the affix plugin of Bootstrap 3. This class uses CSS sticky positioning
 * (Bootstrap's {@code sticky-top} class), and the offset is the distance in pixels from the top
 * of the viewport at which the element sticks: 10 when none is given. Sticky elements stick
 * within their parent, so the parent must be taller than the element.
 *
 * @author Sven Jacobs
 * @deprecated use {@link StickyHelper}, which also sticks to the bottom and from a breakpoint up:
 *             {@code Affix.affix(widget)} is {@code StickyHelper.setSticky(widget, StickyPosition.TOP, 10)}.
 *             Affix will be removed in 0.4.0.
 * @see <a href="https://getbootstrap.com/docs/5.3/helpers/position/#sticky-top">Bootstrap 5 documentation</a>
 */
@Deprecated
public class Affix {

    private static final int DEFAULT_OFFSET = 10;

    /** Creates an instance. Every method is static, so there is no need to. */
    public Affix() {
    }

    /**
     * Pins an element to the top of the viewport, 10 pixels from it.
     *
     * @param element the element
     */
    public static void affix(final Element element) {
        affix(element, DEFAULT_OFFSET);
    }

    /**
     * Pins an element to the top of the viewport.
     *
     * @param element the element
     * @param offset  the distance in pixels from the top of the viewport
     */
    public static void affix(final Element element, final int offset) {
        StickyHelper.setSticky(element, StickyPosition.TOP, offset);
    }

    /**
     * Pins a widget to the top of the viewport, 10 pixels from it.
     *
     * @param object the widget
     */
    public static void affix(final UIObject object) {
        affix(object.getElement());
    }

    /**
     * Pins a widget to the top of the viewport.
     *
     * @param object the widget
     * @param offset the distance in pixels from the top of the viewport
     */
    public static void affix(final UIObject object, final int offset) {
        affix(object.getElement(), offset);
    }

    /**
     * Unpins an element: removes the sticky class and its offset.
     *
     * @param element the element
     */
    public static void unaffix(final Element element) {
        StickyHelper.removeSticky(element);
    }

    /**
     * Unpins a widget: removes the sticky class and its offset.
     *
     * @param object the widget
     */
    public static void unaffix(final UIObject object) {
        unaffix(object.getElement());
    }
}
