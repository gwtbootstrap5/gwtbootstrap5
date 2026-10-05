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

import org.gwtbootstrap5.client.ui.constants.BadgePosition;
import org.gwtbootstrap5.client.ui.constants.Styles;

import com.google.gwt.core.client.Scheduler;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.NodeList;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * The Bootstrap 5 markup of components whose classes are easy to get wrong.
 */
public class ComponentMarkupGwt extends BaseGwt {

    private static Element link(final AnchorListItem item) {
        return item.getElement().getFirstChildElement();
    }

    public void testBreadcrumbsMarkOnlyTheLastItemActive() {
        final AnchorListItem home = new AnchorListItem("Home");
        final AnchorListItem current = new AnchorListItem("Current");
        final Breadcrumbs breadcrumbs = new Breadcrumbs(home, current);
        RootPanel.get().add(breadcrumbs);
        try {
            assertTrue(home.getElement().hasClassName(Styles.BREADCRUMB_ITEM));
            assertFalse(home.getElement().hasClassName(Styles.ACTIVE));
            assertTrue(current.getElement().hasClassName(Styles.ACTIVE));
            assertEquals("page", current.getElement().getAttribute("aria-current"));
            assertFalse(link(home).hasClassName(Styles.NAV_LINK));
        } finally {
            breadcrumbs.removeFromParent();
        }
    }

    public void testPaginationItemsArePageItems() {
        final Pagination pagination = new Pagination();
        final AnchorListItem page = new AnchorListItem("1");
        pagination.add(page);
        final AnchorListItem previous = pagination.addPreviousLink();
        assertTrue(page.getElement().hasClassName(Styles.PAGINATION_ITEM));
        assertTrue(link(page).hasClassName(Styles.PAGINATION_LINK));
        assertFalse(link(page).hasClassName(Styles.NAV_LINK));
        assertTrue(link(previous).hasClassName(Styles.PAGINATION_LINK));
    }

    public void testDropDownMenuLinksAreDropdownItems() {
        final DropDownMenu menu = new DropDownMenu();
        final AnchorListItem item = new AnchorListItem("Action");
        menu.add(item);
        assertTrue(link(item).hasClassName(Styles.DROPDOWN_ITEM));
        assertFalse(link(item).hasClassName(Styles.NAV_LINK));

        final DropDownItem dropDownItem = new DropDownItem("Other");
        assertTrue(dropDownItem.getElement().getFirstChildElement().hasClassName(Styles.DROPDOWN_ITEM));
        assertFalse(dropDownItem.getElement().hasClassName(Styles.DROPDOWN_ITEM));
    }

    public void testNavChildrenAreNavItems() {
        final Nav nav = new Nav();
        final AnchorListItem item = new AnchorListItem("Link");
        nav.add(item);
        assertTrue(item.getElement().hasClassName(Styles.NAV_ITEM));
        assertTrue(link(item).hasClassName(Styles.NAV_LINK));

        final NavbarNav navbarNav = new NavbarNav();
        final AnchorListItem navbarItem = new AnchorListItem("Link");
        navbarNav.add(navbarItem);
        assertTrue(navbarItem.getElement().hasClassName(Styles.NAV_ITEM));
    }

    public void testListDropDownToggleIsANavLink() {
        final ListDropDown dropDown = new ListDropDown();
        final AnchorButton toggle = new AnchorButton();
        dropDown.add(toggle);
        assertTrue(toggle.getElement().hasClassName(Styles.NAV_LINK));
        assertTrue(toggle.getElement().hasClassName(Styles.DROPDOWN_TOGGLE));
    }

    public void testLinkedGroupItemKeepsListGroupItem() {
        final LinkedGroupItem item = new LinkedGroupItem("Link", "#");
        assertTrue(item.getElement().hasClassName(Styles.LIST_GROUP_ITEM));
        assertTrue(item.getElement().hasClassName(Styles.LIST_GROUP_ITEM_ACTION));
    }

    public void testVerticalButtonGroupIsNotAButtonGroup() {
        final VerticalButtonGroup group = new VerticalButtonGroup();
        assertTrue(group.getElement().hasClassName(Styles.BTN_GROUP_VERTICAL));
        assertFalse(group.getElement().hasClassName(Styles.BTN_GROUP));
        assertTrue(new ButtonGroup().getElement().hasClassName(Styles.BTN_GROUP));
    }

    public void testNavbarCollapseButtonIsAToggler() {
        final Element button = new NavbarCollapseButton().getElement();
        assertEquals(Styles.NAVBAR_TOGGLER, button.getClassName());
        assertEquals("false", button.getAttribute("aria-expanded"));
    }

    public void testCardTextIsAParagraph() {
        final CardText text = new CardText("Some text");
        assertEquals("p", text.getElement().getTagName().toLowerCase());
        assertTrue(text.getElement().hasClassName(Styles.CARD_TEXT));
    }

    public void testCarouselIndicatorsAreButtons() {
        final CarouselIndicators indicators = new CarouselIndicators();
        final CarouselIndicator indicator = new CarouselIndicator();
        indicators.add(indicator);
        assertEquals("div", indicators.getElement().getTagName().toLowerCase());
        assertEquals("button", indicator.getElement().getTagName().toLowerCase());
    }

    public void testButtonBadgeHasAColor() {
        final Button button = new Button("Inbox");
        button.setBadgeText("4");
        button.setBadgePosition(BadgePosition.LEFT);
        // The button lays out its text, icon and badge in a deferred command
        delayTestFinish(5000);
        Scheduler.get().scheduleDeferred(() -> {
            final NodeList<Element> spans = button.getElement().getElementsByTagName("span");
            Element badge = null;
            for (int i = 0; i < spans.getLength(); i++) {
                if (spans.getItem(i).hasClassName(Styles.BADGE)) {
                    badge = spans.getItem(i);
                }
            }
            assertNotNull(badge);
            assertTrue(badge.hasClassName("text-bg-secondary"));
            finishTest();
        });
    }
}
