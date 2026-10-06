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

import org.gwtbootstrap5.client.ui.constants.Attributes;
import org.gwtbootstrap5.client.ui.constants.ColumnSize;
import org.gwtbootstrap5.client.ui.constants.ContextualBackground;
import org.gwtbootstrap5.client.ui.constants.OffcanvasBackdrop;
import org.gwtbootstrap5.client.ui.constants.OffcanvasPlacement;
import org.gwtbootstrap5.client.ui.constants.OffcanvasResponsive;
import org.gwtbootstrap5.client.ui.constants.PlaceholderSize;
import org.gwtbootstrap5.client.ui.constants.RatioType;
import org.gwtbootstrap5.client.ui.constants.Styles;
import org.gwtbootstrap5.client.ui.html.Paragraph;

import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Markup of the components that are new in 0.2.0.
 */
public class NewComponentsGwt extends BaseGwt {

    public void testOffcanvas() {
        final Offcanvas offcanvas = new Offcanvas();
        final OffcanvasHeader header = new OffcanvasHeader();
        header.setTitle("Menu");
        final OffcanvasBody body = new OffcanvasBody();
        offcanvas.add(header);
        offcanvas.add(body);
        final Element element = offcanvas.getElement();
        assertTrue(element.hasClassName(Styles.OFFCANVAS));
        assertTrue(element.hasClassName(OffcanvasPlacement.START.getCssName()));
        assertEquals("-1", element.getAttribute(Attributes.TABINDEX));
        assertTrue(header.getElement().hasClassName(Styles.OFFCANVAS_HEADER));
        assertTrue(body.getElement().hasClassName(Styles.OFFCANVAS_BODY));

        // The title comes first, as an h5, and the close button dismisses the offcanvas
        final Element title = header.getElement().getFirstChildElement();
        assertEquals("h5", title.getTagName().toLowerCase());
        assertTrue(title.hasClassName(Styles.OFFCANVAS_TITLE));
        final Element close = title.getNextSiblingElement();
        assertTrue(close.hasClassName(Styles.CLOSE));
        assertEquals("offcanvas", close.getAttribute(Attributes.DATA_DISMISS));

        offcanvas.setPlacement(OffcanvasPlacement.END);
        assertTrue(element.hasClassName(OffcanvasPlacement.END.getCssName()));
        assertFalse(element.hasClassName(OffcanvasPlacement.START.getCssName()));

        // Responsive offcanvas replace offcanvas with offcanvas-{breakpoint}
        offcanvas.setResponsive(OffcanvasResponsive.LG);
        assertTrue(element.hasClassName(OffcanvasResponsive.LG.getCssName()));
        assertFalse(element.hasClassName(Styles.OFFCANVAS));
        offcanvas.setResponsive(null);
        assertTrue(element.hasClassName(Styles.OFFCANVAS));
        assertFalse(element.hasClassName(OffcanvasResponsive.LG.getCssName()));

        offcanvas.setBackdrop(OffcanvasBackdrop.STATIC);
        assertEquals("static", element.getAttribute(Attributes.DATA_BACKDROP));
        offcanvas.setScroll(true);
        assertEquals("true", element.getAttribute(Attributes.DATA_SCROLL));
        offcanvas.setKeyboard(false);
        assertEquals("false", element.getAttribute(Attributes.DATA_KEYBOARD));

        // Attached, the offcanvas is labelled by its title
        RootPanel.get().add(offcanvas);
        try {
            assertFalse(title.getId().isEmpty());
            assertEquals(title.getId(), element.getAttribute(Attributes.ARIA_LABELLEDBY));
        } finally {
            offcanvas.removeFromParent();
        }
    }

    public void testAccordionLinksHeaderAndBody() {
        final Accordion accordion = new Accordion();
        final AccordionItem first = item("First", true);
        final AccordionItem second = item("Second", false);
        accordion.add(first);
        accordion.add(second);
        RootPanel.get().add(accordion);
        try {
            assertTrue(accordion.getElement().hasClassName(Styles.ACCORDION));
            assertTrue(first.getElement().hasClassName(Styles.ACCORDION_ITEM));
            final String accordionId = accordion.getElement().getId();
            assertFalse(accordionId.isEmpty());

            for (final AccordionItem item : new AccordionItem[] {first, second}) {
                final Element header = item.getElement().getFirstChildElement();
                final Element button = header.getFirstChildElement();
                final Element body = header.getNextSiblingElement();
                assertEquals("h2", header.getTagName().toLowerCase());
                assertTrue(header.hasClassName(Styles.ACCORDION_HEADER));
                assertTrue(button.hasClassName(Styles.ACCORDION_BUTTON));
                assertEquals("collapse", button.getAttribute(Attributes.DATA_TOGGLE));
                assertTrue(body.hasClassName(Styles.ACCORDION_COLLAPSE));
                assertTrue(body.hasClassName(Styles.COLLAPSE));
                assertTrue(body.getFirstChildElement().hasClassName(Styles.ACCORDION_BODY));

                // The button targets its own body, and the body closes the others of the accordion
                assertFalse(body.getId().isEmpty());
                assertEquals("#" + body.getId(), button.getAttribute(Attributes.DATA_TARGET));
                assertEquals(body.getId(), button.getAttribute(Attributes.ARIA_CONTROLS));
                assertEquals("#" + accordionId, body.getAttribute(Attributes.DATA_PARENT));
            }
            final Element firstBody = first.getElement().getFirstChildElement().getNextSiblingElement();
            final Element secondBody = second.getElement().getFirstChildElement().getNextSiblingElement();
            assertFalse(firstBody.getId().equals(secondBody.getId()));

            // Open state: show on the body, no collapsed on the button, aria-expanded
            final Element firstButton = first.getElement().getFirstChildElement().getFirstChildElement();
            final Element secondButton = second.getElement().getFirstChildElement().getFirstChildElement();
            assertTrue(firstBody.hasClassName(Styles.SHOW));
            assertFalse(firstButton.hasClassName(Styles.COLLAPSED));
            assertEquals("true", firstButton.getAttribute(Attributes.ARIA_EXPANDED));
            assertFalse(secondBody.hasClassName(Styles.SHOW));
            assertTrue(secondButton.hasClassName(Styles.COLLAPSED));
            assertEquals("false", secondButton.getAttribute(Attributes.ARIA_EXPANDED));
            assertTrue(first.isOpen());
            assertFalse(second.isOpen());

            // Always open: the bodies don't close each other
            accordion.setAlwaysOpen(true);
            assertFalse(firstBody.hasAttribute(Attributes.DATA_PARENT));
            accordion.setAlwaysOpen(false);
            assertEquals("#" + accordionId, firstBody.getAttribute(Attributes.DATA_PARENT));

            accordion.setFlush(true);
            assertTrue(accordion.getElement().hasClassName(Styles.ACCORDION_FLUSH));
        } finally {
            accordion.removeFromParent();
        }
    }

    private static AccordionItem item(final String text, final boolean open) {
        final AccordionItem item = new AccordionItem();
        item.add(new AccordionHeader(text));
        final AccordionBody body = new AccordionBody();
        body.add(new Paragraph(text));
        item.add(body);
        item.setOpen(open);
        return item;
    }

    public void testSwitch() {
        final Switch toggle = new Switch("Wi-Fi");
        final Element element = toggle.getElement();
        assertTrue(element.hasClassName(Styles.FORM_CHECK));
        assertTrue(element.hasClassName(Styles.FORM_SWITCH));
        final Element input = element.getFirstChildElement();
        assertEquals("checkbox", input.getAttribute(Attributes.TYPE));
        assertEquals("switch", input.getAttribute(Attributes.ROLE));
        assertTrue(input.hasClassName(Styles.FORM_CHECK_INPUT));
        assertTrue(input.getNextSiblingElement().hasClassName(Styles.FORM_CHECK_LABEL));
    }

    public void testFloatingLabelFollowsItsControl() {
        final FloatingLabel floating = new FloatingLabel("Email");
        final TextBox box = new TextBox();
        floating.add(box);
        final Element element = floating.getElement();
        assertTrue(element.hasClassName(Styles.FORM_FLOATING));
        // Bootstrap's selectors need the control first, the label after it, and a placeholder
        assertEquals(box.getElement(), element.getFirstChildElement());
        final Element label = box.getElement().getNextSiblingElement();
        assertEquals("label", label.getTagName().toLowerCase());
        assertEquals("Email", label.getInnerText());
        assertFalse(box.getElement().getId().isEmpty());
        assertEquals(box.getElement().getId(), label.getAttribute("for"));
        assertEquals("Email", box.getElement().getAttribute(Attributes.PLACEHOLDER));

        floating.setText("Work email");
        assertEquals("Work email", box.getElement().getAttribute(Attributes.PLACEHOLDER));

        try {
            floating.add(new TextBox());
            fail("A FloatingLabel takes one control");
        } catch (final IllegalStateException expected) {
            // expected
        }
    }

    public void testPlaceholder() {
        final Placeholder placeholder = new Placeholder();
        final Element element = placeholder.getElement();
        assertEquals("span", element.getTagName().toLowerCase());
        assertTrue(element.hasClassName(Styles.PLACEHOLDER));
        placeholder.setColumnSize(ColumnSize.XS_6);
        placeholder.setSize(PlaceholderSize.LG);
        placeholder.setColor(ContextualBackground.PRIMARY);
        assertTrue(element.hasClassName(ColumnSize.XS_6.getCssName()));
        assertTrue(element.hasClassName(PlaceholderSize.LG.getCssName()));
        assertTrue(element.hasClassName(ContextualBackground.PRIMARY.getCssName()));
        placeholder.setSize(PlaceholderSize.SM);
        assertFalse(element.hasClassName(PlaceholderSize.LG.getCssName()));
    }

    public void testInputColor() {
        final Element element = new InputColor().getElement();
        assertEquals("color", element.getAttribute(Attributes.TYPE));
        assertTrue(element.hasClassName(Styles.FORM_CONTROL));
        assertTrue(element.hasClassName(Styles.FORM_CONTROL_COLOR));
    }

    public void testRatio() {
        final Ratio ratio = new Ratio();
        final Element element = ratio.getElement();
        assertTrue(element.hasClassName(Styles.RATIO));
        assertTrue(element.hasClassName(RatioType.R16X9.getCssName()));
        ratio.setType(RatioType.R4X3);
        assertTrue(element.hasClassName(RatioType.R4X3.getCssName()));
        assertFalse(element.hasClassName(RatioType.R16X9.getCssName()));
        assertEquals(RatioType.R4X3, ratio.getType());
    }

    public void testStacksAndVerticalRule() {
        final HStack hstack = new HStack();
        assertTrue(hstack.getElement().hasClassName(Styles.HSTACK));
        hstack.setGap(3);
        assertTrue(hstack.getElement().hasClassName("gap-3"));
        hstack.setGap(1);
        assertTrue(hstack.getElement().hasClassName("gap-1"));
        assertFalse(hstack.getElement().hasClassName("gap-3"));
        hstack.setGap(-1);
        assertFalse(hstack.getElement().hasClassName("gap-1"));
        try {
            hstack.setGap(6);
            fail("Bootstrap has gaps 0 to 5");
        } catch (final IllegalArgumentException expected) {
            // expected
        }

        assertTrue(new VStack().getElement().hasClassName(Styles.VSTACK));
        assertTrue(new VerticalRule().getElement().hasClassName(Styles.VR));
    }

    public void testNavUnderlineAndCardGroup() {
        final Element nav = new NavUnderline().getElement();
        assertTrue(nav.hasClassName(Styles.NAV));
        assertTrue(nav.hasClassName(Styles.NAV_UNDERLINE));
        assertTrue(new CardGroup().getElement().hasClassName(Styles.CARD_GROUP));
    }
}
