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

import org.gwtbootstrap5.client.shared.event.HiddenEvent;
import org.gwtbootstrap5.client.shared.event.HiddenHandler;
import org.gwtbootstrap5.client.shared.event.HideEvent;
import org.gwtbootstrap5.client.shared.event.HideHandler;
import org.gwtbootstrap5.client.shared.event.HidePreventedEvent;
import org.gwtbootstrap5.client.shared.event.HidePreventedHandler;
import org.gwtbootstrap5.client.shared.event.ShowEvent;
import org.gwtbootstrap5.client.shared.event.ShowHandler;
import org.gwtbootstrap5.client.shared.event.ShownEvent;
import org.gwtbootstrap5.client.shared.event.ShownHandler;
import org.gwtbootstrap5.client.shared.js.BootstrapOffcanvas;
import org.gwtbootstrap5.client.shared.js.DomEventListeners;
import org.gwtbootstrap5.client.ui.base.helper.StyleHelper;
import org.gwtbootstrap5.client.ui.constants.Attributes;
import org.gwtbootstrap5.client.ui.constants.OffcanvasBackdrop;
import org.gwtbootstrap5.client.ui.constants.OffcanvasPlacement;
import org.gwtbootstrap5.client.ui.constants.OffcanvasResponsive;
import org.gwtbootstrap5.client.ui.constants.Styles;
import org.gwtbootstrap5.client.ui.html.Div;

import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.EventTarget;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * Sidebar panel that slides in from an edge of the viewport.
 * <p/>
 * <h3>UiBinder example</h3>
 * <pre>{@code
 *     <b:Button dataToggle="OFFCANVAS" dataTarget="#menu">Menu</b:Button>
 *     <b:Offcanvas id="menu" placement="END">
 *         <b:OffcanvasHeader title="Menu"/>
 *         <b:OffcanvasBody>...</b:OffcanvasBody>
 *     </b:Offcanvas>
 * }</pre>
 *
 * @see <a href="https://getbootstrap.com/docs/5.3/components/offcanvas/">Bootstrap 5 documentation</a>
 */
public class Offcanvas extends Div {

    private final DomEventListeners listeners = new DomEventListeners();
    private OffcanvasResponsive responsive;

    public Offcanvas() {
        super();

        setStyleName(Styles.OFFCANVAS);
        addStyleName(OffcanvasPlacement.START.getCssName());
        getElement().setAttribute(Attributes.TABINDEX, "-1");
    }

    @Override
    protected void onLoad() {
        super.onLoad();
        final Element e = getElement();
        listeners.add(e, "show.bs.offcanvas", evt -> fireOwn(evt, new ShowEvent(evt)));
        listeners.add(e, "shown.bs.offcanvas", evt -> fireOwn(evt, new ShownEvent(evt)));
        listeners.add(e, "hide.bs.offcanvas", evt -> fireOwn(evt, new HideEvent(evt)));
        listeners.add(e, "hidden.bs.offcanvas", evt -> fireOwn(evt, new HiddenEvent(evt)));
        listeners.add(e, "hidePrevented.bs.offcanvas", evt -> fireOwn(evt, new HidePreventedEvent(evt)));
        linkTitle();
    }

    @Override
    protected void onUnload() {
        super.onUnload();
        listeners.removeAll();
        disposeInstance();
    }

    /**
     * Sets the edge the panel slides in from; {@code null} restores {@link OffcanvasPlacement#START}.
     */
    public void setPlacement(final OffcanvasPlacement placement) {
        StyleHelper.addUniqueEnumStyleName(this, OffcanvasPlacement.class,
                placement != null ? placement : OffcanvasPlacement.START);
    }

    public OffcanvasPlacement getPlacement() {
        for (final OffcanvasPlacement placement : OffcanvasPlacement.values()) {
            if (StyleHelper.containsStyle(getStyleName(), placement.getCssName())) {
                return placement;
            }
        }
        return null;
    }

    /**
     * Makes the panel responsive: below the breakpoint it behaves as an offcanvas, from the
     * breakpoint up its content shows in the page. {@code null} makes it an offcanvas at every width.
     */
    public void setResponsive(final OffcanvasResponsive responsive) {
        removeStyleName(responsive(this.responsive));
        this.responsive = responsive;
        addStyleName(responsive(responsive));
    }

    public OffcanvasResponsive getResponsive() {
        return responsive;
    }

    private static String responsive(final OffcanvasResponsive responsive) {
        return responsive != null ? responsive.getCssName() : Styles.OFFCANVAS;
    }

    public void setBackdrop(final OffcanvasBackdrop backdrop) {
        if (backdrop != null) {
            getElement().setAttribute(Attributes.DATA_BACKDROP, backdrop.getBackdrop());
        } else {
            getElement().removeAttribute(Attributes.DATA_BACKDROP);
        }
        disposeInstance();
    }

    /**
     * Whether Escape closes the panel; {@code true} by default.
     */
    public void setKeyboard(final boolean keyboard) {
        getElement().setAttribute(Attributes.DATA_KEYBOARD, Boolean.toString(keyboard));
        disposeInstance();
    }

    /**
     * Whether the page can scroll while the panel is open; {@code false} by default.
     */
    public void setScroll(final boolean scroll) {
        getElement().setAttribute(Attributes.DATA_SCROLL, Boolean.toString(scroll));
        disposeInstance();
    }

    /**
     * Shows the panel, adding it to the {@link RootPanel} first if it isn't attached.
     */
    public void show() {
        if (!isAttached()) {
            RootPanel.get().add(this);
        }
        instance().show();
    }

    public void hide() {
        instance().hide();
    }

    public void toggle() {
        if (!isAttached()) {
            RootPanel.get().add(this);
        }
        instance().toggle();
    }

    /**
     * @return {@code true} if the panel is open, or opening
     */
    public boolean isShown() {
        return StyleHelper.containsStyle(getStyleName(), Styles.SHOW)
                || StyleHelper.containsStyle(getStyleName(), Styles.SHOWING);
    }

    public HandlerRegistration addShowHandler(final ShowHandler handler) {
        return addHandler(handler, ShowEvent.getType());
    }

    public HandlerRegistration addShownHandler(final ShownHandler handler) {
        return addHandler(handler, ShownEvent.getType());
    }

    public HandlerRegistration addHideHandler(final HideHandler handler) {
        return addHandler(handler, HideEvent.getType());
    }

    public HandlerRegistration addHiddenHandler(final HiddenHandler handler) {
        return addHandler(handler, HiddenEvent.getType());
    }

    /**
     * The panel refused to close: a click on a {@link OffcanvasBackdrop#STATIC static} backdrop, or
     * Escape with {@link #setKeyboard(boolean) keyboard} off.
     */
    public HandlerRegistration addHidePreventedHandler(final HidePreventedHandler handler) {
        return addHandler(handler, HidePreventedEvent.getType());
    }

    private void fireOwn(final Event evt, final GwtEvent<?> event) {
        // Ignore the events of nested components, e.g. a collapse inside the body
        final EventTarget target = evt.getEventTarget();
        if (Element.is(target) && Element.as(target) == getElement()) {
            fireEvent(event);
        }
    }

    // Labels the panel with its title, as Bootstrap's examples do
    private void linkTitle() {
        for (final Widget child : getChildren()) {
            if (child instanceof OffcanvasHeader) {
                final OffcanvasTitle title = ((OffcanvasHeader) child).getTitleWidget();
                if (title != null && !getElement().hasAttribute(Attributes.ARIA_LABELLEDBY)) {
                    if (title.getId() == null || title.getId().isEmpty()) {
                        title.setId(DOM.createUniqueId());
                    }
                    getElement().setAttribute(Attributes.ARIA_LABELLEDBY, title.getId());
                }
            }
        }
    }

    private BootstrapOffcanvas instance() {
        return BootstrapOffcanvas.getOrCreateInstance(getElement(), null);
    }

    private void disposeInstance() {
        final BootstrapOffcanvas offcanvas = BootstrapOffcanvas.getInstance(getElement());
        if (offcanvas != null) {
            offcanvas.dispose();
        }
    }
}
