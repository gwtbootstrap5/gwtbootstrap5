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
import org.gwtbootstrap5.client.ui.html.Div;

/**
 * Sticky positions write Bootstrap's sticky class and the offset, and can be removed.
 */
public class StickyGwt extends BaseGwt {

    public void testEveryPositionWritesItsClass() {
        for (final StickyPosition position : StickyPosition.values()) {
            final Div div = new Div();
            StickyHelper.setSticky(div, position);
            assertEquals(position.getCssName(), div.getStyleName());
            assertEquals(position, StickyHelper.getSticky(div));
            assertEquals("", div.getElement().getStyle().getProperty("top"));
        }
    }

    public void testOffsetGoesToTheEdgeItSticksTo() {
        final Div div = new Div();
        StickyHelper.setSticky(div, StickyPosition.MD_TOP, 56);
        assertEquals("56px", div.getElement().getStyle().getProperty("top"));
        StickyHelper.setSticky(div, StickyPosition.BOTTOM, 8);
        assertEquals("sticky-bottom", div.getStyleName());
        assertEquals("", div.getElement().getStyle().getProperty("top"));
        assertEquals("8px", div.getElement().getStyle().getProperty("bottom"));
    }

    public void testRemoveStickyKeepsTheOtherClasses() {
        final Div div = new Div();
        div.addStyleName("p-2");
        StickyHelper.setSticky(div, StickyPosition.XXL_BOTTOM, 4);
        StickyHelper.removeSticky(div);
        assertEquals("p-2", div.getStyleName());
        assertNull(StickyHelper.getSticky(div));
        assertEquals("", div.getElement().getStyle().getProperty("bottom"));
    }

    public void testDivSticky() {
        final Div div = new Div();
        div.setSticky(StickyPosition.LG_TOP);
        assertEquals(StickyPosition.LG_TOP, div.getSticky());
        assertEquals("sticky-lg-top", div.getStyleName());
        div.setSticky(null);
        assertNull(div.getSticky());
        assertEquals("", div.getStyleName());
    }

    @SuppressWarnings("deprecation")
    public void testAffixKeepsItsTenPixels() {
        final Div div = new Div();
        Affix.affix(div);
        assertEquals("sticky-top", div.getStyleName());
        assertEquals("10px", div.getElement().getStyle().getProperty("top"));
        Affix.affix(div, 30);
        assertEquals("30px", div.getElement().getStyle().getProperty("top"));
        Affix.unaffix(div);
        assertEquals("", div.getStyleName());
        assertEquals("", div.getElement().getStyle().getProperty("top"));
    }
}
