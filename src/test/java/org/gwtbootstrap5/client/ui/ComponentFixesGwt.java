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

import org.gwtbootstrap5.client.ui.constants.AlertType;
import org.gwtbootstrap5.client.ui.constants.Attributes;
import org.gwtbootstrap5.client.ui.constants.SpinnerType;
import org.gwtbootstrap5.client.ui.constants.Styles;

import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Markup that 0.2.0 fixed for Bootstrap 5 in popovers, spinners, alerts and collapse.
 */
public class ComponentFixesGwt extends BaseGwt {

    public void testPopoverTemplateHasHeaderAndBody() {
        final Button button = new Button("Info");
        new Popover(button, "Title", "Content");
        RootPanel.get().add(button);
        final String template = button.getElement().getAttribute("data-bs-template");
        button.removeFromParent();
        assertTrue(template.contains("class=\"popover\""));
        assertTrue(template.contains("class=\"popover-arrow\""));
        assertTrue(template.contains("class=\"popover-header\""));
        assertTrue(template.contains("class=\"popover-body\""));
        assertFalse(template.contains("popover-title"));
        assertFalse(template.contains("popover-content"));
    }

    public void testPopoverWritesItsOptionsWhenAttached() {
        final Button button = new Button("Info");
        final Popover popover = new Popover(button, "Title", "Content");
        RootPanel.get().add(button);
        try {
            final Element element = button.getElement();
            assertTrue(popover.isInitialized());
            assertEquals("Title", element.getAttribute("data-bs-title"));
            assertEquals("Content", element.getAttribute("data-bs-content"));
            assertTrue(element.getAttribute("data-bs-template").contains("popover-body"));

            // An initialized popover takes a new title and content
            popover.setTitle("Other title");
            popover.setContent("Other content");
            assertEquals("Other title", popover.getTitle());
            assertEquals("Other content", element.getAttribute("data-bs-content"));
        } finally {
            button.removeFromParent();
        }
        assertFalse(popover.isInitialized());
    }

    public void testTooltipIsDestroyedWithItsWidget() {
        final Button button = new Button("Hover");
        final Tooltip tooltip = new Tooltip(button, "Help");
        RootPanel.get().add(button);
        assertTrue(tooltip.isInitialized());
        assertEquals("Help", button.getElement().getAttribute("data-bs-title"));
        button.removeFromParent();
        assertFalse(tooltip.isInitialized());
    }

    public void testSpinnerTypes() {
        final Spinner spinner = new Spinner(SpinnerType.BORDER);
        final Element element = spinner.getElement();
        assertTrue(element.hasClassName("spinner-border"));
        assertEquals("status", element.getAttribute(Attributes.ROLE));
        final Element label = element.getFirstChildElement();
        assertTrue(label.hasClassName(Styles.VISUALLY_HIDDEN));
        assertEquals("Loading...", label.getInnerText());

        spinner.setSmall(true);
        assertTrue(element.hasClassName(Styles.SPINNER_BORDER_SM));
        spinner.setSmall(false);
        assertFalse(element.hasClassName(Styles.SPINNER_BORDER_SM));

        spinner.setType(SpinnerType.GROW);
        assertTrue(element.hasClassName("spinner-grow"));
        assertFalse(element.hasClassName("spinner-border"));
        spinner.setSmall(true);
        assertTrue(element.hasClassName(Styles.SPINNER_GROW_SM));
    }

    public void testAlertTypeDismissAndFade() {
        final Alert alert = new Alert("Careful");
        final Element element = alert.getElement();
        assertTrue(element.hasClassName(Styles.ALERT));
        assertTrue(element.hasClassName(AlertType.WARNING.getCssName()));
        assertEquals("Careful", alert.getText());

        alert.setType(AlertType.DANGER);
        assertTrue(element.hasClassName(AlertType.DANGER.getCssName()));
        assertFalse(element.hasClassName(AlertType.WARNING.getCssName()));

        alert.setDismissable(true);
        assertTrue(element.hasClassName(Styles.ALERT_DISMISSIBLE));
        final Element close = element.getFirstChildElement();
        assertEquals("button", close.getTagName().toLowerCase());
        assertTrue(close.hasClassName(Styles.CLOSE));
        assertEquals("alert", close.getAttribute(Attributes.DATA_DISMISS));
        alert.setDismissable(false);
        assertFalse(element.hasClassName(Styles.ALERT_DISMISSIBLE));
        assertFalse(alert.isDismissable());

        alert.setFade(true);
        assertTrue(element.hasClassName(Styles.FADE));
        assertTrue(element.hasClassName(Styles.SHOW));
        assertFalse(element.hasClassName("in"));
        alert.setFade(false);
        assertFalse(element.hasClassName(Styles.SHOW));
    }

    public void testCollapseUsesShow() {
        final Collapse shown = new Collapse();
        RootPanel.get().add(shown);
        try {
            assertTrue(shown.getElement().hasClassName(Styles.COLLAPSE));
            assertTrue(shown.getElement().hasClassName(Styles.SHOW));
            assertTrue(shown.isShown());
            assertFalse(shown.getElement().hasClassName("in"));
        } finally {
            shown.removeFromParent();
        }

        final Collapse hidden = new Collapse();
        hidden.setToggle(false);
        RootPanel.get().add(hidden);
        try {
            assertFalse(hidden.getElement().hasClassName(Styles.SHOW));
            assertTrue(hidden.isHidden());
            hidden.setIn(true);
            assertTrue(hidden.getElement().hasClassName(Styles.SHOW));
            hidden.setHorizontal(true);
            assertTrue(hidden.getElement().hasClassName(Styles.COLLAPSE_HORIZONTAL));
        } finally {
            hidden.removeFromParent();
        }
    }
}
