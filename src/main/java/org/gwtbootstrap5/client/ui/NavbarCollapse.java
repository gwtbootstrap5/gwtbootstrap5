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

import org.gwtbootstrap5.client.shared.event.HiddenEvent;
import org.gwtbootstrap5.client.shared.event.HiddenHandler;
import org.gwtbootstrap5.client.shared.event.HideEvent;
import org.gwtbootstrap5.client.shared.event.HideHandler;
import org.gwtbootstrap5.client.shared.event.ShowEvent;
import org.gwtbootstrap5.client.shared.event.ShowHandler;
import org.gwtbootstrap5.client.shared.event.ShownEvent;
import org.gwtbootstrap5.client.shared.event.ShownHandler;
import org.gwtbootstrap5.client.shared.js.BootstrapCollapse;
import org.gwtbootstrap5.client.shared.js.DomEventListeners;

import jsinterop.base.JsPropertyMap;
import org.gwtbootstrap5.client.ui.base.helper.StyleHelper;
import org.gwtbootstrap5.client.ui.constants.CollapseParam;
import org.gwtbootstrap5.client.ui.constants.Styles;
import org.gwtbootstrap5.client.ui.gwt.FlowPanel;

/**
 * Collapsible part of a {@link Navbar} ({@code div.collapse.navbar-collapse}): its links and forms,
 * hidden behind the {@link NavbarCollapseButton} below the breakpoint where the navbar expands.
 *
 * @author Sven Jacobs
 * @author Joshua Godi
 * @see NavbarCollapseButton
 * @see <a href="https://getbootstrap.com/docs/5.3/components/navbar/#responsive-behaviors">Bootstrap 5 documentation</a>
 */
public class NavbarCollapse extends FlowPanel {

    private final DomEventListeners listeners = new DomEventListeners();

    // Default hidden
    private final boolean toggle = false;

    /** Creates an empty, hidden collapse ({@code div.collapse.navbar-collapse}). */
    public NavbarCollapse() {
        super();

        setStyleName(Styles.COLLAPSE);
        addStyleName(Styles.NAVBAR_COLLAPSE);
    }

    @Override
    protected void onLoad() {
        super.onLoad();

        // Bind jquery events
        bindJavaScriptEvents(getElement());

        // Configure the collapse
        if (toggle) {
            addStyleName(Styles.SHOW);
        }
    }

    @Override
    protected void onUnload() {
        super.onUnload();

        // Unbind the events
        unbindJavaScriptEvents(getElement());
    }

    /**
     * Causes the collapse to show or hide without animation and events
     *
     * @param in show or hide the collapse
     */
    public void setIn(final boolean in) {
        if (in) {
            addStyleName(Styles.SHOW);
        } else {
            removeStyleName(Styles.SHOW);
        }
    }

    /**
     * Causes the collapse to show or hide
     */
    public void toggle() {
        fireMethod(getElement(), CollapseParam.TOGGLE);
    }

    /**
     * Causes the collapse to show
     */
    public void show() {
        fireMethod(getElement(), CollapseParam.SHOW);
    }

    /**
     * Causes the collapse to hide
     */
    public void hide() {
        fireMethod(getElement(), CollapseParam.HIDE);
    }

    /**
     * Returns whether the content is shown.
     *
     * @return {@code true} if it has {@code show}
     */
    public boolean isShown() {
        return StyleHelper.containsStyle(getStyleName(), Styles.SHOW);
    }

    /**
     * Returns whether the content is hidden.
     *
     * @return {@code true} if it doesn't have {@code show}
     */
    public boolean isHidden() {
        return !isShown();
    }

    /**
     * Returns whether the content is being shown or hidden.
     *
     * @return {@code true} during the animation ({@code collapsing})
     */
    public boolean isCollapsing() {
        return StyleHelper.containsStyle(getStyleName(), Styles.COLLAPSING);
    }

    /**
     * Adds a handler called when the content starts to show.
     *
     * @param showHandler the handler
     * @return the registration that removes the handler
     */
    public HandlerRegistration addShowHandler(final ShowHandler showHandler) {
        return addHandler(showHandler, ShowEvent.getType());
    }

    /**
     * Adds a handler called when the content is shown, after the animation.
     *
     * @param shownHandler the handler
     * @return the registration that removes the handler
     */
    public HandlerRegistration addShownHandler(final ShownHandler shownHandler) {
        return addHandler(shownHandler, ShownEvent.getType());
    }

    /**
     * Adds a handler called when the content starts to hide.
     *
     * @param hideHandler the handler
     * @return the registration that removes the handler
     */
    public HandlerRegistration addHideHandler(final HideHandler hideHandler) {
        return addHandler(hideHandler, HideEvent.getType());
    }

    /**
     * Adds a handler called when the content is hidden, after the animation.
     *
     * @param hiddenHandler the handler
     * @return the registration that removes the handler
     */
    public HandlerRegistration addHiddenHandler(final HiddenHandler hiddenHandler) {
        return addHandler(hiddenHandler, HiddenEvent.getType());
    }

    /**
     * Fired when the collapse is starting to show
     */
    private void onShow(final Event evt) {
        fireEvent(new ShowEvent(evt));
    }

    /**
     * Fired when the collapse has shown
     */
    private void onShown(final Event evt) {
        fireEvent(new ShownEvent(evt));
    }

    /**
     * Fired when the collapse is starting to hide
     */
    private void onHide(final Event evt) {
        fireEvent(new HideEvent(evt));
    }

    /**
     * Fired when the collapse has hidden
     */
    private void onHidden(final Event evt) {
        fireEvent(new HiddenEvent(evt));
    }

    private void bindJavaScriptEvents(final com.google.gwt.dom.client.Element e) {
        listeners.add(e, "show.bs.collapse", this::onShow);
        listeners.add(e, "shown.bs.collapse", this::onShown);
        listeners.add(e, "hide.bs.collapse", this::onHide);
        listeners.add(e, "hidden.bs.collapse", this::onHidden);
    }

    private void unbindJavaScriptEvents(final com.google.gwt.dom.client.Element e) {
        listeners.removeAll();
    }

    private void fireMethod(final Element e, final String command) {
        final BootstrapCollapse collapse = BootstrapCollapse.getOrCreateInstance(e, JsPropertyMap.of("toggle", false));
        switch (command) {
            case CollapseParam.SHOW:
                collapse.show();
                break;
            case CollapseParam.HIDE:
                collapse.hide();
                break;
            default:
                collapse.toggle();
                break;
        }
    }
}
