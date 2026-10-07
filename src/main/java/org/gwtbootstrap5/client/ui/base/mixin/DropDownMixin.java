package org.gwtbootstrap5.client.ui.base.mixin;

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
import org.gwtbootstrap5.client.shared.event.ShowEvent;
import org.gwtbootstrap5.client.shared.event.ShowHandler;
import org.gwtbootstrap5.client.shared.event.ShownEvent;
import org.gwtbootstrap5.client.shared.event.ShownHandler;
import org.gwtbootstrap5.client.shared.js.BootstrapDropdown;
import org.gwtbootstrap5.client.shared.js.DomEventListeners;
import org.gwtbootstrap5.client.ui.base.HasDropDown;
import org.gwtbootstrap5.client.ui.constants.Attributes;
import org.gwtbootstrap5.client.ui.constants.DropDownAutoClose;
import org.gwtbootstrap5.client.ui.constants.DropDownDirection;
import org.gwtbootstrap5.client.ui.constants.DropDownDisplay;
import org.gwtbootstrap5.client.ui.constants.DropDownReference;
import org.gwtbootstrap5.client.ui.constants.Toggle;

import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.EventTarget;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.Widget;

/**
 * Shared implementation of {@link HasDropDown}. The owning widget calls {@link #onLoad()} and
 * {@link #onUnload()} from its own.
 * <p>
 * Bootstrap binds the {@code bootstrap.Dropdown} instance to the toggle and fires its events there;
 * they bubble to the container, where this mixin listens, ignoring those of nested dropdowns.
 *
 * @param <T> the type of the dropdown container
 */
public class DropDownMixin<T extends Widget & HasDropDown> extends AbstractMixin implements HasDropDown {

    private final DomEventListeners listeners = new DomEventListeners();
    private final DropDownDirection defaultDirection;
    private DropDownDirection direction;
    private DropDownAutoClose autoClose;
    private String offset;
    private String boundary;
    private DropDownReference reference;
    private DropDownDisplay display;

    /**
     * Creates the mixin of a dropdown container.
     *
     * @param widget the dropdown container
     * @param defaultDirection the direction its constructor sets, or {@code null} when it sets none
     */
    public DropDownMixin(final T widget, final DropDownDirection defaultDirection) {
        super(widget);
        this.defaultDirection = defaultDirection;
        this.direction = defaultDirection;
    }

    private Widget widget() {
        return (Widget) uiObject;
    }

    /**
     * Listens to the dropdown events and applies the auto close option. Called from the container's
     * {@code onLoad}.
     */
    public void onLoad() {
        final Element e = uiObject.getElement();
        listeners.add(e, "show.bs.dropdown", evt -> fire(evt, new ShowEvent(evt)));
        listeners.add(e, "shown.bs.dropdown", evt -> fire(evt, new ShownEvent(evt)));
        listeners.add(e, "hide.bs.dropdown", evt -> fire(evt, new HideEvent(evt)));
        listeners.add(e, "hidden.bs.dropdown", evt -> fire(evt, new HiddenEvent(evt)));
        applyOptions();
    }

    /**
     * Stops listening and disposes the Bootstrap instance. Called from the container's
     * {@code onUnload}.
     */
    public void onUnload() {
        listeners.removeAll();
        disposeInstance();
    }

    @Override
    public void show() {
        instance().show();
    }

    @Override
    public void hide() {
        instance().hide();
    }

    @Override
    public void toggle() {
        instance().toggle();
    }

    @Override
    public void setDirection(final DropDownDirection direction) {
        for (final DropDownDirection d : DropDownDirection.values()) {
            for (final String cssClass : d.getCssName().split(" ")) {
                uiObject.getElement().removeClassName(cssClass);
            }
        }
        this.direction = direction != null ? direction : defaultDirection;
        if (this.direction != null) {
            for (final String cssClass : this.direction.getCssName().split(" ")) {
                uiObject.getElement().addClassName(cssClass);
            }
        }
    }

    @Override
    public DropDownDirection getDirection() {
        return direction;
    }

    @Override
    public void setAutoClose(final DropDownAutoClose autoClose) {
        this.autoClose = autoClose;
        optionsChanged();
    }

    @Override
    public DropDownAutoClose getAutoClose() {
        return autoClose;
    }

    @Override
    public void setOffset(final int skidding, final int distance) {
        offset = skidding + "," + distance;
        optionsChanged();
    }

    @Override
    public void setBoundary(final String boundary) {
        this.boundary = boundary;
        optionsChanged();
    }

    @Override
    public void setReference(final DropDownReference reference) {
        this.reference = reference;
        optionsChanged();
    }

    @Override
    public void setDisplay(final DropDownDisplay display) {
        this.display = display;
        optionsChanged();
    }

    private void optionsChanged() {
        applyOptions();
        // Bootstrap reads the data-bs-* options when it creates the instance
        disposeInstance();
    }

    @Override
    public HandlerRegistration addShowHandler(final ShowHandler handler) {
        return widget().addHandler(handler, ShowEvent.getType());
    }

    @Override
    public HandlerRegistration addShownHandler(final ShownHandler handler) {
        return widget().addHandler(handler, ShownEvent.getType());
    }

    @Override
    public HandlerRegistration addHideHandler(final HideHandler handler) {
        return widget().addHandler(handler, HideEvent.getType());
    }

    @Override
    public HandlerRegistration addHiddenHandler(final HiddenHandler handler) {
        return widget().addHandler(handler, HiddenEvent.getType());
    }

    private void fire(final Event evt, final GwtEvent<?> gwtEvent) {
        final EventTarget target = evt.getEventTarget();
        if (Element.is(target) && Element.as(target).getParentElement() == uiObject.getElement()) {
            widget().fireEvent(gwtEvent);
        }
    }

    private void applyOptions() {
        final Element toggle = findToggle();
        if (toggle == null) {
            return;
        }
        setOption(toggle, Attributes.DATA_AUTO_CLOSE, autoClose != null ? autoClose.getValue() : null);
        setOption(toggle, "data-bs-offset", offset);
        setOption(toggle, "data-bs-boundary", boundary);
        setOption(toggle, "data-bs-reference", reference != null ? reference.getValue() : null);
        setOption(toggle, "data-bs-display", display != null ? display.getValue() : null);
    }

    private static void setOption(final Element toggle, final String name, final String value) {
        if (value != null) {
            toggle.setAttribute(name, value);
        } else {
            toggle.removeAttribute(name);
        }
    }

    private void disposeInstance() {
        final Element toggle = findToggle();
        if (toggle != null) {
            final BootstrapDropdown dropdown = BootstrapDropdown.getInstance(toggle);
            if (dropdown != null) {
                dropdown.dispose();
            }
        }
    }

    private BootstrapDropdown instance() {
        if (!widget().isAttached()) {
            throw new IllegalStateException("The dropdown must be attached");
        }
        final Element toggle = findToggle();
        if (toggle == null) {
            throw new IllegalStateException("The dropdown has no child with data-bs-toggle=\"dropdown\"");
        }
        return BootstrapDropdown.getOrCreateInstance(toggle, null);
    }

    /**
     * @return the direct child with {@code data-bs-toggle="dropdown"}, or {@code null}
     */
    private Element findToggle() {
        for (Element child = uiObject.getElement().getFirstChildElement(); child != null;
                child = child.getNextSiblingElement()) {
            if (Toggle.DROPDOWN.getToggle().equals(child.getAttribute(Attributes.DATA_TOGGLE))) {
                return child;
            }
        }
        return null;
    }
}
