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

import org.gwtbootstrap5.client.ui.constants.Attributes;
import org.gwtbootstrap5.client.ui.constants.ColorMode;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.UIObject;

import elemental2.dom.DomGlobal;
import elemental2.dom.EventListener;
import elemental2.dom.MediaQueryList;

/**
 * Sets Bootstrap 5.3's color mode ({@code data-bs-theme}) on the page or on one widget, whose
 * descendants follow it.
 *
 * @see <a href="https://getbootstrap.com/docs/5.3/customize/color-modes/">Bootstrap 5 documentation</a>
 */
public final class ColorModeHelper {

    private static final String PREFERS_DARK = "(prefers-color-scheme: dark)";
    private static final String CHANGE = "change";

    private ColorModeHelper() {
    }

    /**
     * Sets the color mode of the whole page, on {@code <html>}.
     *
     * @param mode the mode, or {@code null} for Bootstrap's default (light)
     */
    public static void setPageColorMode(final ColorMode mode) {
        setColorMode(Document.get().getDocumentElement(), mode);
    }

    /**
     * @return the page's color mode, or {@code null} if none is set
     */
    public static ColorMode getPageColorMode() {
        return getColorMode(Document.get().getDocumentElement());
    }

    /**
     * Sets the color mode of a widget and its descendants.
     *
     * @param mode the mode, or {@code null} to inherit the page's
     */
    public static void setColorMode(final UIObject uiObject, final ColorMode mode) {
        setColorMode(uiObject.getElement(), mode);
    }

    /**
     * @return the widget's own color mode, or {@code null} if it inherits it
     */
    public static ColorMode getColorMode(final UIObject uiObject) {
        return getColorMode(uiObject.getElement());
    }

    /**
     * Sets the page's color mode from the browser's {@code prefers-color-scheme} and keeps it in
     * sync when that preference changes.
     *
     * @return a registration whose {@code removeHandler()} stops following the preference
     */
    public static HandlerRegistration followSystem() {
        final MediaQueryList query = DomGlobal.window.matchMedia(PREFERS_DARK);
        final EventListener listener = evt -> applySystem(query);
        applySystem(query);
        query.addEventListener(CHANGE, listener);
        return () -> query.removeEventListener(CHANGE, listener);
    }

    private static void applySystem(final MediaQueryList query) {
        setPageColorMode(query.matches ? ColorMode.DARK : ColorMode.LIGHT);
    }

    private static void setColorMode(final Element element, final ColorMode mode) {
        if (mode == null) {
            element.removeAttribute(Attributes.DATA_BS_THEME);
        } else {
            element.setAttribute(Attributes.DATA_BS_THEME, mode.getTheme());
        }
    }

    private static ColorMode getColorMode(final Element element) {
        return ColorMode.fromTheme(element.getAttribute(Attributes.DATA_BS_THEME));
    }
}
