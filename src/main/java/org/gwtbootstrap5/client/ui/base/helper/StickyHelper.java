package org.gwtbootstrap5.client.ui.base.helper;

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

import org.gwtbootstrap5.client.ui.constants.StickyPosition;

import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Style;
import com.google.gwt.user.client.ui.UIObject;

/**
 * Makes an element stick to the top or bottom of the viewport while the page scrolls, with
 * Bootstrap's sticky classes ({@code sticky-top}, {@code sticky-md-bottom}…). A sticky element
 * sticks within its parent, so the parent must be taller than the element.
 * <p>
 * The offset is the distance from the edge of the viewport at which the element sticks, set as
 * its CSS {@code top} or {@code bottom}. With 0, Bootstrap's own value of 0 applies. In UiBinder,
 * a {@link org.gwtbootstrap5.client.ui.html.Div} takes the position as {@code sticky}:
 *
 * <pre>{@code
 * <b.html:Div sticky="TOP">...</b.html:Div>
 * }</pre>
 *
 * @see <a href="https://getbootstrap.com/docs/5.3/helpers/position/#sticky-top">Bootstrap 5 documentation</a>
 */
public final class StickyHelper {

    private static final String TOP = "top";
    private static final String BOTTOM = "bottom";

    private StickyHelper() {
    }

    /**
     * Makes a widget sticky, replacing the position and offset it had.
     *
     * @param uiObject the widget
     * @param position where it sticks, or {@code null} to make it not sticky
     */
    public static void setSticky(final UIObject uiObject, final StickyPosition position) {
        setSticky(uiObject.getElement(), position, 0);
    }

    /**
     * Makes a widget sticky at a distance from the edge of the viewport, replacing the position
     * and offset it had.
     *
     * @param uiObject the widget
     * @param position where it sticks, or {@code null} to make it not sticky
     * @param offsetPx the distance in pixels from the top or bottom of the viewport
     */
    public static void setSticky(final UIObject uiObject, final StickyPosition position, final int offsetPx) {
        setSticky(uiObject.getElement(), position, offsetPx);
    }

    /**
     * Makes an element sticky at a distance from the edge of the viewport, replacing the position
     * and offset it had.
     *
     * @param element the element
     * @param position where it sticks, or {@code null} to make it not sticky
     * @param offsetPx the distance in pixels from the top or bottom of the viewport
     */
    public static void setSticky(final Element element, final StickyPosition position, final int offsetPx) {
        removeSticky(element);
        if (position == null) {
            return;
        }
        element.addClassName(position.getCssName());
        if (offsetPx != 0) {
            element.getStyle().setPropertyPx(position.isTop() ? TOP : BOTTOM, offsetPx);
        }
    }

    /**
     * Returns where a widget sticks.
     *
     * @param uiObject the widget
     * @return the position, or {@code null} if it isn't sticky
     */
    public static StickyPosition getSticky(final UIObject uiObject) {
        return StickyPosition.fromStyleName(uiObject.getStyleName());
    }

    /**
     * Makes a widget not sticky: removes the sticky class and the CSS {@code top} and
     * {@code bottom} of the element, where the offset is.
     *
     * @param uiObject the widget
     */
    public static void removeSticky(final UIObject uiObject) {
        removeSticky(uiObject.getElement());
    }

    /**
     * Makes an element not sticky: removes the sticky class and the CSS {@code top} and
     * {@code bottom}, where the offset is.
     *
     * @param element the element
     */
    public static void removeSticky(final Element element) {
        for (final StickyPosition position : StickyPosition.values()) {
            element.removeClassName(position.getCssName());
        }
        final Style style = element.getStyle();
        style.clearProperty(TOP);
        style.clearProperty(BOTTOM);
    }
}
