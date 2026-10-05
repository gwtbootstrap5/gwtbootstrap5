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

import org.gwtbootstrap5.client.ui.constants.Styles;

import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.InputElement;
import com.google.gwt.dom.client.LabelElement;

import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLInputElement;
import elemental2.dom.NodeList;
import jsinterop.base.Js;

/**
 * Bootstrap 5 check buttons for {@link CheckBoxButton} and {@link RadioButton}.
 * <p>
 * Bootstrap 5 styles a checked {@code input.btn-check} through its sibling {@code label.btn}
 * ({@code .btn-check:checked + .btn}), but a GWT widget has a single root element. So the root
 * stays the {@code label.btn}, the {@code btn-check} input inside it is hidden by Bootstrap, and
 * the {@code active} class (styled like a checked button) is kept in sync with the input. The
 * keyboard focus ring, which Bootstrap also draws through the sibling selector, is drawn on the
 * button when the input has {@code :focus-visible}.
 */
final class CheckButtons {

    private CheckButtons() {
    }

    /**
     * Turns the input into a hidden {@code btn-check} and unlinks the inner text label: the root
     * {@code label.btn} already toggles the input, and a second linked label would toggle it twice.
     */
    static void init(final InputElement input, final LabelElement text) {
        input.addClassName(Styles.BTN_CHECK);
        input.setAttribute("autocomplete", "off");
        unlinkText(text);

        final HTMLInputElement in = Js.uncheckedCast(input);
        in.addEventListener("focus", evt -> setFocusRing(in, in.matches(":focus-visible")));
        in.addEventListener("blur", evt -> setFocusRing(in, false));
    }

    private static void setFocusRing(final HTMLInputElement input, final boolean show) {
        final HTMLElement button = Js.uncheckedCast(input.parentElement);
        if (button == null) {
            return;
        }
        if (show) {
            // Same ring as Bootstrap's .btn:focus-visible
            button.style.setProperty("box-shadow", "var(--bs-btn-focus-box-shadow)");
        } else {
            button.style.removeProperty("box-shadow");
        }
    }

    static void unlinkText(final LabelElement text) {
        text.removeAttribute("for");
        // A label nested in the root label: Chrome doesn't activate the root when the inner one is
        // clicked, so clicks go through it to the root
        text.getStyle().setProperty("pointerEvents", "none");
    }

    /**
     * Adds or removes {@code active} on the button of the input and, for a radio, on every button of
     * its group: the radio that gets unchecked receives no event.
     */
    static void syncActive(final InputElement input) {
        final String name = input.getName();
        if ("radio".equalsIgnoreCase(input.getType()) && name != null && !name.isEmpty()) {
            final NodeList<elemental2.dom.Element> group = DomGlobal.document.getElementsByName(name);
            for (int i = 0; i < group.length; i++) {
                final HTMLInputElement radio = Js.uncheckedCast(group.item(i));
                syncButton(Js.uncheckedCast(radio));
            }
        }
        syncButton(input);
    }

    private static void syncButton(final InputElement input) {
        final Element button = input.getParentElement();
        if (button == null || !button.hasClassName(Styles.BTN) || !input.hasClassName(Styles.BTN_CHECK)) {
            return;
        }
        if (input.isChecked()) {
            button.addClassName(Styles.ACTIVE);
        } else {
            button.removeClassName(Styles.ACTIVE);
        }
    }
}
