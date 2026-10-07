package org.gwtbootstrap5.client.ui.constants;

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

import org.gwtbootstrap5.client.ui.base.helper.EnumHelper;

import com.google.gwt.dom.client.Style;

/**
 * Where an element sticks while the page scrolls: to the top or bottom of the viewport, always
 * or from a breakpoint up. Set it with {@link org.gwtbootstrap5.client.ui.base.helper.StickyHelper}.
 *
 * @see <a href="https://getbootstrap.com/docs/5.3/helpers/position/#sticky-top">Bootstrap 5 documentation</a>
 */
public enum StickyPosition implements Type, Style.HasCssName {
    /** Sticks to the top ({@code sticky-top}). */
    TOP("sticky-top", true),
    /** Sticks to the bottom ({@code sticky-bottom}). */
    BOTTOM("sticky-bottom", false),
    /** Sticks to the top from the small breakpoint up ({@code sticky-sm-top}). */
    SM_TOP("sticky-sm-top", true),
    /** Sticks to the bottom from the small breakpoint up ({@code sticky-sm-bottom}). */
    SM_BOTTOM("sticky-sm-bottom", false),
    /** Sticks to the top from the medium breakpoint up ({@code sticky-md-top}). */
    MD_TOP("sticky-md-top", true),
    /** Sticks to the bottom from the medium breakpoint up ({@code sticky-md-bottom}). */
    MD_BOTTOM("sticky-md-bottom", false),
    /** Sticks to the top from the large breakpoint up ({@code sticky-lg-top}). */
    LG_TOP("sticky-lg-top", true),
    /** Sticks to the bottom from the large breakpoint up ({@code sticky-lg-bottom}). */
    LG_BOTTOM("sticky-lg-bottom", false),
    /** Sticks to the top from the extra large breakpoint up ({@code sticky-xl-top}). */
    XL_TOP("sticky-xl-top", true),
    /** Sticks to the bottom from the extra large breakpoint up ({@code sticky-xl-bottom}). */
    XL_BOTTOM("sticky-xl-bottom", false),
    /** Sticks to the top from the extra extra large breakpoint up ({@code sticky-xxl-top}). */
    XXL_TOP("sticky-xxl-top", true),
    /** Sticks to the bottom from the extra extra large breakpoint up ({@code sticky-xxl-bottom}). */
    XXL_BOTTOM("sticky-xxl-bottom", false);

    private final String cssClass;
    private final boolean top;

    StickyPosition(final String cssClass, final boolean top) {
        this.cssClass = cssClass;
        this.top = top;
    }

    @Override
    public String getCssName() {
        return cssClass;
    }

    /**
     * Returns whether the element sticks to the top, where its offset is the CSS {@code top}, or
     * to the bottom, where it is {@code bottom}.
     *
     * @return {@code true} for the top positions
     */
    public boolean isTop() {
        return top;
    }

    /**
     * Returns the constant whose class is in a space-separated list of style names.
     *
     * @param styleName the style names, such as those of a widget
     * @return the constant, or {@code null} if none
     */
    public static StickyPosition fromStyleName(final String styleName) {
        return EnumHelper.fromStyleName(styleName, StickyPosition.class, null);
    }
}
