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

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.gwtbootstrap5.client.ui.constants.Attributes;
import org.gwtbootstrap5.client.ui.constants.ColumnOffset;
import org.gwtbootstrap5.client.ui.constants.ColumnSize;
import org.gwtbootstrap5.client.ui.constants.DropDownDisplay;
import org.gwtbootstrap5.client.ui.constants.DropDownReference;
import org.gwtbootstrap5.client.ui.constants.Gutter;
import org.gwtbootstrap5.client.ui.constants.GutterX;
import org.gwtbootstrap5.client.ui.constants.GutterY;
import org.gwtbootstrap5.client.ui.constants.InputSize;
import org.gwtbootstrap5.client.ui.constants.Placement;
import org.gwtbootstrap5.client.ui.constants.RowColSize;
import org.gwtbootstrap5.client.ui.constants.Styles;
import org.gwtbootstrap5.client.ui.constants.TableResponsiveBreakpoint;
import org.gwtbootstrap5.client.ui.constants.Toggle;
import org.gwtbootstrap5.client.ui.constants.ValidationState;
import org.gwtbootstrap5.client.ui.form.error.BasicEditorError;
import org.gwtbootstrap5.client.ui.html.Div;
import org.gwtbootstrap5.client.ui.html.Figure;

import com.google.gwt.dom.client.Element;
import com.google.gwt.editor.client.EditorError;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * The Bootstrap 5.3 gaps closed in 0.4.0 (phase 3 of its spec): each class, attribute or option
 * GwtBootstrap5 now writes.
 */
public class Bootstrap53GapsGwt extends BaseGwt {

    /** Rows 2 to 4: the grid constants that were missing. */
    public void testGridConstants() {
        assertEquals("offset-xxl-5", ColumnOffset.XXL_5.getCssName());
        assertEquals("col-auto", ColumnSize.XS_AUTO.getCssName());
        assertEquals("col-md-auto", ColumnSize.MD_AUTO.getCssName());
        assertEquals("col-xxl-auto", ColumnSize.XXL_AUTO.getCssName());
        assertEquals("row-cols-auto", RowColSize.XS_AUTO.getCssName());
        assertEquals("row-cols-xxl-auto", RowColSize.XXL_AUTO.getCssName());

        final Column column = new Column(ColumnSize.XS_AUTO, ColumnSize.LG_AUTO);
        assertTrue(column.getElement().hasClassName("col-auto"));
        assertTrue(column.getElement().hasClassName("col-lg-auto"));
    }

    /** Row 5: gutters per axis and breakpoint, each setter replacing its previous gutters. */
    public void testRowGutters() {
        final Row row = new Row();
        final Element element = row.getElement();
        row.setGutter(Gutter.XS_2, Gutter.MD_4);
        assertTrue(element.hasClassName("g-2"));
        assertTrue(element.hasClassName("g-md-4"));
        row.setGutter("SM_0");
        assertTrue(element.hasClassName("g-sm-0"));
        assertFalse(element.hasClassName("g-2"));
        assertFalse(element.hasClassName("g-md-4"));

        row.setGutterX(GutterX.XS_0);
        row.setGutterY("xs_3, lg_5");
        assertTrue(element.hasClassName("gx-0"));
        assertTrue(element.hasClassName("gy-3"));
        assertTrue(element.hasClassName("gy-lg-5"));
        // Each axis keeps its own gutters
        assertTrue(element.hasClassName("g-sm-0"));
        assertTrue(element.hasClassName(Styles.ROW));

        row.setGutterY();
        assertFalse(element.hasClassName("gy-3"));
        assertFalse(element.hasClassName("gy-lg-5"));
        assertTrue(element.hasClassName("gx-0"));
    }

    /** Row 6: a wrapper that scrolls the table, at every width or below a breakpoint. */
    public void testTableResponsive() {
        final TableResponsive wrapper = new TableResponsive();
        final Element element = wrapper.getElement();
        assertEquals("div", element.getTagName().toLowerCase());
        assertTrue(element.hasClassName(Styles.TABLE_RESPONSIVE));
        assertEquals(TableResponsiveBreakpoint.ALWAYS, wrapper.getBreakpoint());

        wrapper.setBreakpoint(TableResponsiveBreakpoint.MD);
        assertTrue(element.hasClassName("table-responsive-md"));
        assertFalse(element.hasClassName(Styles.TABLE_RESPONSIVE));
        assertEquals(TableResponsiveBreakpoint.MD, wrapper.getBreakpoint());

        wrapper.setBreakpoint(null);
        assertTrue(element.hasClassName(Styles.TABLE_RESPONSIVE));
        assertFalse(element.hasClassName("table-responsive-md"));
    }

    /** Row 8: stacked progress bars, each segment a progress with its share of the width. */
    public void testProgressStacked() {
        final ProgressStacked stack = new ProgressStacked();
        final Progress first = new Progress();
        final Progress second = new Progress();
        first.add(new ProgressBar());
        second.add(new ProgressBar());
        stack.add(first);
        stack.add(second);
        first.setPercent(15);
        second.setPercent(30);

        assertTrue(stack.getElement().hasClassName(Styles.PROGRESS_STACKED));
        final Element segment = first.getElement();
        assertTrue(segment.hasClassName(Styles.PROGRESS));
        assertEquals("15%", segment.getStyle().getWidth());
        assertEquals("progressbar", segment.getAttribute(Attributes.ROLE));
        assertEquals("0", segment.getAttribute("aria-valuemin"));
        assertEquals("100", segment.getAttribute("aria-valuemax"));
        assertEquals(15.0, first.getPercent());
        assertEquals(30.0, second.getPercent());
        assertEquals(0.0, new Progress().getPercent());
    }

    /** Rows 1 and 9: the tip options, written as data-bs-* or passed in the configuration. */
    public void testTooltipOptions() {
        final Button button = new Button("Hover");
        final Tooltip tooltip = new Tooltip(button, "Help");
        tooltip.setOffset(0, 8);
        tooltip.setFallbackPlacements(Placement.TOP, Placement.BOTTOM);
        tooltip.setBoundary("window");
        tooltip.setCustomClass("my-tip");
        RootPanel.get().add(button);
        try {
            final Element element = button.getElement();
            assertEquals("0,8", element.getAttribute("data-bs-offset"));
            assertEquals("[\"top\",\"bottom\"]", element.getAttribute("data-bs-fallback-placements"));
            assertEquals("window", element.getAttribute("data-bs-boundary"));
            assertEquals("my-tip", element.getAttribute("data-bs-custom-class"));
            // setViewportSelector wrote data-bs-selector, Bootstrap's delegation option
            assertFalse(element.hasAttribute("data-bs-selector"));
            // With Bootstrap's sanitizer and allow list, no configuration is passed
            assertNull(config(element, "Tooltip", "sanitize"));

            // Changed on an initialized tip, the attribute follows
            tooltip.setFallbackPlacements("left right");
            assertEquals("[\"left\",\"right\"]", element.getAttribute("data-bs-fallback-placements"));
            tooltip.setCustomClass(null);
            assertFalse(element.hasAttribute("data-bs-custom-class"));
        } finally {
            button.removeFromParent();
        }

        // sanitize and allowList only exist in the configuration
        final Button other = new Button("Hover");
        final Tooltip unsafe = new Tooltip(other, "<b>Help</b>");
        final Map<String, List<String>> allowList = new HashMap<>();
        allowList.put("b", Collections.<String>emptyList());
        unsafe.setSanitize(false);
        unsafe.setAllowList(allowList);
        RootPanel.get().add(other);
        try {
            assertEquals("false", config(other.getElement(), "Tooltip", "sanitize"));
            assertEquals("", config(other.getElement(), "Tooltip", "allowList.b"));
        } finally {
            other.removeFromParent();
        }
    }

    /** Row 10: the dropdown options, written as data-bs-* on the toggle. */
    public void testDropDownOptions() {
        final ListDropDown dropDown = new ListDropDown();
        final AnchorButton toggle = new AnchorButton();
        toggle.setDataToggle(Toggle.DROPDOWN);
        dropDown.add(toggle);
        dropDown.add(new DropDownMenu());
        RootPanel.get().add(dropDown);
        try {
            dropDown.setOffset(10, 20);
            dropDown.setBoundary("viewport");
            dropDown.setReference(DropDownReference.PARENT);
            dropDown.setDisplay(DropDownDisplay.STATIC);
            final Element element = toggle.getElement();
            assertEquals("10,20", element.getAttribute("data-bs-offset"));
            assertEquals("viewport", element.getAttribute("data-bs-boundary"));
            assertEquals("parent", element.getAttribute("data-bs-reference"));
            assertEquals("static", element.getAttribute("data-bs-display"));

            dropDown.setDisplay(null);
            dropDown.setBoundary(null);
            assertFalse(element.hasAttribute("data-bs-display"));
            assertFalse(element.hasAttribute("data-bs-boundary"));
        } finally {
            dropDown.removeFromParent();
        }
    }

    /** Row 11: the ScrollSpy options, passed in the configuration. */
    public void testScrollSpyOptions() {
        final Div content = new Div();
        RootPanel.get().add(content);
        try {
            final ScrollSpy spy = ScrollSpy.scrollSpy(content, "#nav");
            spy.setRootMargin("0px 0px -40%");
            spy.setSmoothScroll(true);
            spy.setThreshold(0.5, 1);
            final Element element = content.getElement();
            assertEquals("#nav", config(element, "ScrollSpy", "target"));
            assertEquals("0px 0px -40%", config(element, "ScrollSpy", "rootMargin"));
            assertEquals("true", config(element, "ScrollSpy", "smoothScroll"));
            assertEquals("0.5,1", config(element, "ScrollSpy", "threshold"));
        } finally {
            content.removeFromParent();
        }
    }

    /** Row 12: keyboard and touch of the carousel, focus of the modal. */
    public void testCarouselAndModalOptions() {
        final Carousel carousel = new Carousel();
        carousel.setKeyboard(false);
        carousel.setTouch(false);
        RootPanel.get().add(carousel);
        try {
            assertEquals("false", config(carousel.getElement(), "Carousel", "keyboard"));
            assertEquals("false", config(carousel.getElement(), "Carousel", "touch"));
        } finally {
            carousel.removeFromParent();
        }

        final Modal modal = new Modal();
        modal.setDataFocus(false);
        assertEquals("false", modal.getElement().getAttribute("data-bs-focus"));
    }

    /** Row 13: sizes of the select and of the label of a horizontal form. */
    public void testFormSizes() {
        final ListBox list = new ListBox();
        list.setSize(InputSize.LARGE);
        assertTrue(list.getElement().hasClassName(Styles.FORM_SELECT_LG));
        assertEquals(InputSize.LARGE, list.getSize());
        list.setSize(InputSize.SMALL);
        assertTrue(list.getElement().hasClassName(Styles.FORM_SELECT_SM));
        assertFalse(list.getElement().hasClassName(Styles.FORM_SELECT_LG));
        list.setSize(null);
        assertFalse(list.getElement().hasClassName(Styles.FORM_SELECT_SM));
        assertEquals(InputSize.DEFAULT, list.getSize());
        assertTrue(list.getElement().hasClassName(Styles.FORM_SELECT));

        final FormLabel label = new FormLabel();
        label.setSize(InputSize.SMALL);
        assertTrue(label.getElement().hasClassName(Styles.COL_FORM_LABEL_SM));
        assertEquals(InputSize.SMALL, label.getSize());
        label.setSize(InputSize.LARGE);
        assertTrue(label.getElement().hasClassName(Styles.COL_FORM_LABEL_LG));
        assertFalse(label.getElement().hasClassName(Styles.COL_FORM_LABEL_SM));
        label.setSize(InputSize.DEFAULT);
        assertEquals(InputSize.DEFAULT, label.getSize());
    }

    /** Row 14: success message and tooltip style of the validation feedback. */
    public void testValidFeedbackAndTooltips() {
        final FormGroup group = new FormGroup();
        final TextBox box = new TextBox();
        final HelpBlock help = new HelpBlock();
        help.setText("We never share it");
        help.setValidText("Looks good");
        group.add(box);
        group.add(help);
        RootPanel.get().add(group);
        try {
            box.getErrorHandler().showErrors(Collections.<EditorError>emptyList());
            assertTrue(box.getElement().hasClassName(ValidationState.SUCCESS.getCssName()));
            assertTrue(help.getElement().hasClassName(Styles.VALID_FEEDBACK));
            assertFalse(help.getElement().hasClassName(Styles.FORM_TEXT));
            assertTrue(help.isValid());
            assertEquals("Looks good", help.getText());

            box.getErrorHandler().showErrors(Arrays.<EditorError>asList(new BasicEditorError(null, null, "Required")));
            assertTrue(box.getElement().hasClassName(ValidationState.ERROR.getCssName()));
            assertFalse(box.getElement().hasClassName(ValidationState.SUCCESS.getCssName()));
            assertTrue(help.getElement().hasClassName(Styles.INVALID_FEEDBACK));
            assertFalse(help.getElement().hasClassName(Styles.VALID_FEEDBACK));

            // The tooltip style swaps the class of the message being shown
            help.setFeedbackTooltip(true);
            assertTrue(help.getElement().hasClassName(Styles.INVALID_TOOLTIP));
            assertFalse(help.getElement().hasClassName(Styles.INVALID_FEEDBACK));
            assertEquals("Required", help.getText());
            help.setValid("Fine");
            assertTrue(help.getElement().hasClassName(Styles.VALID_TOOLTIP));
            assertFalse(help.getElement().hasClassName(Styles.INVALID_TOOLTIP));

            // Clearing brings back the help text
            help.clearError();
            assertFalse(help.isValid());
            assertFalse(help.getElement().hasClassName(Styles.VALID_TOOLTIP));
            assertTrue(help.getElement().hasClassName(Styles.FORM_TEXT));
            assertEquals("We never share it", help.getText());
        } finally {
            group.removeFromParent();
        }
    }

    /** Row 15: text in a dropdown menu. */
    public void testDropDownItemText() {
        final DropDownMenu menu = new DropDownMenu();
        final DropDownItemText text = new DropDownItemText("Signed in as Ana");
        menu.add(text);
        final Element item = text.getElement();
        assertEquals("li", item.getTagName().toLowerCase());
        final Element span = item.getFirstChildElement();
        assertEquals("span", span.getTagName().toLowerCase());
        assertTrue(span.hasClassName(Styles.DROPDOWN_ITEM_TEXT));
        assertFalse(span.hasClassName(Styles.DROPDOWN_ITEM));
        assertEquals("Signed in as Ana", text.getText());
    }

    /** Row 15: tabs and pills in a card header. */
    public void testCardHeaderNavs() {
        final CardHeader header = new CardHeader();
        final NavTabs tabs = new NavTabs();
        header.add(tabs);
        assertTrue(tabs.getElement().hasClassName(Styles.CARD_HEADER_TABS));
        assertFalse(tabs.getElement().hasClassName(Styles.CARD_HEADER_PILLS));

        final CardHeader other = new CardHeader();
        final NavPills pills = new NavPills();
        other.insert(pills, 0);
        assertTrue(pills.getElement().hasClassName(Styles.CARD_HEADER_PILLS));

        // A plain nav keeps its classes
        final Nav nav = new Nav();
        new CardHeader().add(nav);
        assertFalse(nav.getElement().hasClassName(Styles.CARD_HEADER_TABS));
        assertFalse(nav.getElement().hasClassName(Styles.CARD_HEADER_PILLS));
    }

    /** Row 15: navbar links that scroll, with an optional height. */
    public void testNavbarNavScroll() {
        final NavbarNav nav = new NavbarNav();
        final Element element = nav.getElement();
        nav.setScroll(true);
        assertTrue(element.hasClassName(Styles.NAVBAR_NAV_SCROLL));
        assertTrue(nav.isScroll());
        // HtmlUnit drops CSS custom properties such as --bs-scroll-height, so only check that
        // setting and clearing the height don't fail and don't touch the class
        nav.setScrollHeight("100px");
        nav.setScrollHeight(null);
        assertTrue(nav.isScroll());
        nav.setScroll(false);
        assertFalse(element.hasClassName(Styles.NAVBAR_NAV_SCROLL));
        assertFalse(nav.isScroll());
    }

    /** Row 15: the source of a quote, after it in a figure. */
    public void testBlockQuoteFooter() {
        final Figure figure = new Figure();
        figure.add(new BlockQuote());
        final BlockQuoteFooter footer = new BlockQuoteFooter("Someone famous");
        figure.add(footer);
        final Element element = footer.getElement();
        assertEquals("figcaption", element.getTagName().toLowerCase());
        assertTrue(element.hasClassName(Styles.BLOCKQUOTE_FOOTER));
        assertEquals("Someone famous", footer.getText());
        assertEquals("Someone famous", element.getInnerText());
        assertTrue(element.getPreviousSiblingElement().hasClassName(Styles.BLOCKQUOTE));

        // The text stays first, before any widget added later
        final Div cite = new Div();
        footer.add(cite);
        footer.setText("Someone else");
        assertEquals("Someone else", footer.getText());
        assertEquals(cite.getElement(), element.getLastChild());
    }

    /**
     * Returns an option of the configuration the fake Bootstrap instance was created with, as a
     * string, or {@code null} without one. A dotted name reads a nested option.
     */
    private static native String config(Element e, String plugin, String option) /*-{
        var instance = e['__fake' + plugin];
        var value = instance ? instance.config : null;
        var names = option.split('.');
        for (var i = 0; i < names.length && value != null; i++) {
            value = value[names[i]];
        }
        return value == null ? null : String(value);
    }-*/;
}
