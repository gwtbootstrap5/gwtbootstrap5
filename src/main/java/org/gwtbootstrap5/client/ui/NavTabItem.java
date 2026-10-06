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

import com.google.gwt.dom.client.Element;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.Widget;
import org.gwtbootstrap5.client.shared.event.TabShowEvent;
import org.gwtbootstrap5.client.shared.event.TabShowHandler;
import org.gwtbootstrap5.client.shared.event.TabShownEvent;
import org.gwtbootstrap5.client.shared.event.TabShownHandler;
import org.gwtbootstrap5.client.shared.js.BootstrapTab;
import org.gwtbootstrap5.client.shared.js.DomEventListeners;
import org.gwtbootstrap5.client.ui.base.HasDataTarget;
import org.gwtbootstrap5.client.ui.base.helper.RoleHelper;
import org.gwtbootstrap5.client.ui.constants.*;

import java.util.List;

/**
 * Tab of a {@link NavTabs}: an item whose link shows the {@link TabPanel} its {@code dataTarget}
 * points to, and hides the others of the {@link TabContent}.
 * <h2>UiBinder example</h2>
 * <pre>{@code
 *     <b:NavTabs>
 *         <b:NavTabItem text="Home" dataTarget="#home" active="true"/>
 *         <b:NavTabItem text="Profile" dataTarget="#profile"/>
 *     </b:NavTabs>
 * }</pre>
 *
 * @author Joshua Godi
 * @author Drew Spencer
 * @see org.gwtbootstrap5.client.ui.NavTabs
 * @see <a href="https://getbootstrap.com/docs/5.3/components/navs-tabs/#javascript-behavior">Bootstrap 5 documentation</a>
 */
public class NavTabItem extends AnchorListItem implements HasDataTarget {

    private final DomEventListeners listeners = new DomEventListeners();

    /**
     * Creates the default widget with no text
     */
    public NavTabItem() {
        this("");
    }

    /**
     * Creates the default widget with the desired text
     *
     * @param text text for the list item
     */
    public NavTabItem(final String text) {
        super(text);

        setDataToggle(Toggle.TAB);
        addStyleName(Styles.NAV_ITEM);

        RoleHelper.setRole(getElement(), Roles.PRESENTATION);
        RoleHelper.setRole(anchor.getElement(), Roles.TAB);
    }

    /**
     * Creates a tab with an icon.
     *
     * @param text the text of the tab
     * @param iconType the icon, before the text
     */
    public NavTabItem(final String text, final IconType iconType) {
        this(text);
        setIcon(iconType);

        addStyleName(Styles.NAV_ITEM);
    }

    /**
     * Creates a tab with an icon of a given size.
     *
     * @param text the text of the tab
     * @param iconType the icon, before the text
     * @param iconSize the size of the icon
     */
    public NavTabItem(final String text, final IconType iconType, final IconSize iconSize) {
        this(text, iconType);
        setIconSize(iconSize);

        addStyleName(Styles.NAV_ITEM);
    }

    /**
     * Creates a tab with a badge.
     *
     * @param text the text of the tab
     * @param badgeText the text of the badge, after the text
     */
    public NavTabItem(final String text, final String badgeText) {
        this(text);
        setBadgeText(badgeText);

        addStyleName(Styles.NAV_ITEM);
    }

    /**
     * Forces the tab pane associated with this list item to be shown and default fires the events
     */
    public void showTab() {
        showTab(true);
    }

    /**
     * Forces the tab pane associated with this list item to be shown
     *
     * @param fireEvents true=fire show/hide events, false=don't fire show/hide events
     */
    public void showTab(final boolean fireEvents) {
        showTab(anchor.getElement());

        if (fireEvents) {
            fireEvent(new TabShowEvent(this, null));
        }
    }

    /**
     * Add a show handler for the tab
     *
     * @param showHandler show handler
     * @return HandlerRegistration to manage handles
     */
    public HandlerRegistration addShowHandler(final TabShowHandler showHandler) {
        return addHandler(showHandler, TabShowEvent.getType());
    }

    /**
     * Add a shown handler for the tab
     *
     * @param shownHandler show handler
     * @return HandlerRegistration to manage handles
     */
    public HandlerRegistration addShownHandler(final TabShownHandler shownHandler) {
        return addHandler(shownHandler, TabShownEvent.getType());
    }

    /**
     * We override set href here because we want to ensure that projects with gwt places and gwtp
     * don't try to execute a place change event with it being clicked
     */
    @Override
    public void setHref(final String href) {
        setDataTarget(href);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getHref() {
        return getDataTarget();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setDataTargetWidgets(final List<Widget> widgets) {
        anchor.setDataTargetWidgets(widgets);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setDataTargetWidget(final Widget widget) {
        anchor.setDataTargetWidget(widget);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setDataTarget(final String dataTarget) {
        anchor.setDataTarget(dataTarget);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getDataTarget() {
        return anchor.getDataTarget();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setEnabled(final boolean enabled) {
        super.setEnabled(enabled);

        // On enable/disable we need to add/remove the data toggle for it to work properly
        if (enabled) {
            setDataToggle(Toggle.TAB);
        } else {
            setDataToggle(null);
        }
    }

    /**
     * Sets the id of the pane the tab controls ({@code aria-controls} of its link).
     *
     * @param ariaControls the id of the pane, or {@code null} for none
     */
    public void setAriaControls(final String ariaControls) {
        if (ariaControls != null) {
            anchor.getElement().setAttribute(Attributes.ARIA_CONTROLS, ariaControls);
        } else {
            anchor.getElement().removeAttribute(Attributes.ARIA_CONTROLS);
        }
    }

    /**
     * Returns the id of the pane the tab controls.
     *
     * @return the {@code aria-controls} of its link
     */
    public String getAriaControls() {
        return anchor.getElement().getAttribute(Attributes.ARIA_CONTROLS);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void onLoad() {
        super.onLoad();

        // Bind JS Events
        bindJavaScriptEvents(anchor.getElement());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void onUnload() {
        super.onUnload();

        // Unbind JS events
        unbindJavaScriptEvents(anchor.getElement());
    }

    /**
     * Returns the content of the tab's link, as HTML.
     *
     * @return the HTML
     */
    public String getHTML() {
        return anchor.getHTML();
    }

    /**
     * Sets the content of the tab's link, as HTML.
     *
     * @param html the HTML
     */
    public void setHTML(final String html) {
        anchor.setHTML(html);
    }

    /**
     * Can be override by subclasses to handle Tabs's "show" event however
     * it's recommended to add an event handler to the tab.
     *
     * @param evt Event
     * @see org.gwtbootstrap5.client.shared.event.ShowEvent
     */
    protected void onShow(final Event evt) {
        fireEvent(new TabShowEvent(this, evt));
    }

    /**
     * Can be override by subclasses to handle Tabs's "shown" event however
     * it's recommended to add an event handler to the tab.
     *
     * @param evt Event
     * @see org.gwtbootstrap5.client.shared.event.ShownEvent
     */
    protected void onShown(final Event evt) {
        fireEvent(new TabShownEvent(this, evt));
    }

    private void showTab(Element e) {
        BootstrapTab.getOrCreateInstance(e).show();
    }

    // @formatter:off
    private void bindJavaScriptEvents(final Element e) {
        listeners.add(e, "show.bs.tab", this::onShow);
        listeners.add(e, "shown.bs.tab", this::onShown);
    }

    private void unbindJavaScriptEvents(final Element e) {
        listeners.removeAll();
    }

}
