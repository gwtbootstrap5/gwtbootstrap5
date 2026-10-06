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

import org.gwtbootstrap5.client.ui.base.helper.ColorModeHelper;
import org.gwtbootstrap5.client.ui.constants.Attributes;
import org.gwtbootstrap5.client.ui.constants.ColorMode;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;

import elemental2.dom.DomGlobal;

/**
 * Color modes write {@code data-bs-theme} on the page or on the widget they are given.
 */
public class ColorModeGwt extends BaseGwt {

    @Override
    protected void gwtTearDown() throws Exception {
        ColorModeHelper.setPageColorMode(null);
        super.gwtTearDown();
    }

    public void testPageColorModeIsOnTheHtmlElement() {
        final Element html = Document.get().getDocumentElement();
        ColorModeHelper.setPageColorMode(ColorMode.DARK);
        assertEquals("dark", html.getAttribute(Attributes.DATA_BS_THEME));
        assertFalse(Document.get().getBody().hasAttribute(Attributes.DATA_BS_THEME));
        assertEquals(ColorMode.DARK, ColorModeHelper.getPageColorMode());
        ColorModeHelper.setPageColorMode(null);
        assertFalse(html.hasAttribute(Attributes.DATA_BS_THEME));
        assertNull(ColorModeHelper.getPageColorMode());
    }

    public void testWidgetColorModeIsOnTheWidget() {
        final Card card = new Card();
        ColorModeHelper.setColorMode(card, ColorMode.LIGHT);
        assertEquals("light", card.getElement().getAttribute(Attributes.DATA_BS_THEME));
        assertEquals(ColorMode.LIGHT, ColorModeHelper.getColorMode(card));
        assertFalse(Document.get().getDocumentElement().hasAttribute(Attributes.DATA_BS_THEME));
        ColorModeHelper.setColorMode(card, null);
        assertFalse(card.getElement().hasAttribute(Attributes.DATA_BS_THEME));
    }

    public void testNavbarThemeIsAColorMode() {
        final Navbar navbar = new Navbar();
        navbar.setType(ColorMode.DARK);
        assertEquals("dark", navbar.getElement().getAttribute(Attributes.DATA_BS_THEME));
        assertEquals(ColorMode.DARK, navbar.getType());
    }

    public void testFollowSystem() {
        final boolean dark = DomGlobal.window.matchMedia("(prefers-color-scheme: dark)").matches;
        ColorModeHelper.followSystem().removeHandler();
        assertEquals(dark ? ColorMode.DARK : ColorMode.LIGHT, ColorModeHelper.getPageColorMode());
    }
}
