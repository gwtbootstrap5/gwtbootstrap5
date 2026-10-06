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
import com.google.gwt.user.client.Event;
import com.google.web.bindery.event.shared.HandlerRegistration;
import org.gwtbootstrap5.client.shared.event.*;
import org.gwtbootstrap5.client.shared.js.BootstrapToast;
import org.gwtbootstrap5.client.shared.js.DomEventListeners;
import org.gwtbootstrap5.client.ui.base.helper.RoleHelper;
import org.gwtbootstrap5.client.ui.constants.Attributes;
import org.gwtbootstrap5.client.ui.constants.Styles;
import org.gwtbootstrap5.client.ui.constants.ToastRole;
import org.gwtbootstrap5.client.ui.html.Div;
import org.gwtbootstrap5.client.ui.html.Small;
import org.gwtbootstrap5.client.ui.html.Strong;

/**
 * Toast: a short notification, with a title, a subtitle and a message, that hides itself after
 * a delay. Put toasts in a {@link ToastContainer} to stack them, and call {@link #show()}.
 * <h2>Example</h2>
 * <pre>{@code
 *     Toast toast = new Toast("Saved", "just now", "Your changes were saved.");
 *     container.add(toast);
 *     toast.show();
 * }</pre>
 *
 * @see <a href="https://getbootstrap.com/docs/5.3/components/toasts/">Bootstrap 5 documentation</a>
 */
public class Toast extends Div {

    private final DomEventListeners listeners = new DomEventListeners();

    /** How long a toast stays shown by default, in milliseconds. */
    public static final int DEFAULT_DELAY_MS = 5000;

    private ToastRole toastRole;
    private Boolean isAnimated;
    private Boolean hasAutohide;
    private Integer delayMs;

    /**
     * Creates a toast ({@code div.toast}) that announces itself politely, animates and hides
     * itself after {@link #DEFAULT_DELAY_MS}.
     *
     * @param title the title, in the header
     * @param subtitle the small text next to the title, such as the time
     * @param msg the message, in the body
     */
    public Toast(String title, String subtitle, String msg) {
        super();

        setStyleName(Styles.TOAST);
        setToastRole(ToastRole.STATUS);
        setAnimation(true);
        setAutohide(true);
        setDelay(DEFAULT_DELAY_MS);

        generateToastContent(title, subtitle, msg);
    }

    @Override
    public void onLoad() {
        super.onLoad();

        init(getElement());
        bindJavaScriptEvents(getElement());
    }

    @Override
    public void onUnload() {
        super.onUnload();

        unbindAllHandlers(getElement());
    }

    /** Shows the toast. It must be attached. */
    public void show() {
        show(getElement());
    }

    /** Hides the toast. */
    public void hide() {
        hide(getElement());
    }

    /**
     * Sets how screen readers announce the toast ({@code role} and {@code aria-live}).
     *
     * @param toastRole {@code STATUS} to announce it politely, {@code ALERT} at once
     */
    public void setToastRole(final ToastRole toastRole) {
        this.toastRole = toastRole;

        RoleHelper.setRole(getElement(), toastRole.getRole());

        getElement().setAttribute(Attributes.ARIA_LIVE, toastRole.getAriaLive());
        getElement().setAttribute(Attributes.ARIA_ATOMIC, "true");
    }

    /**
     * Sets whether the toast fades in and out ({@code data-bs-animation}).
     *
     * @param isAnimated {@code true} to fade, or {@code null} for Bootstrap's default
     */
    public void setAnimation(final Boolean isAnimated) {
        this.isAnimated = isAnimated;

        if (isAnimated != null) {
            getElement().setAttribute("data-bs-animation", String.valueOf(isAnimated));
        } else {
            getElement().removeAttribute("data-bs-animation");
        }
    }

    /**
     * Sets how long the toast stays shown when it hides itself ({@code data-bs-delay}).
     *
     * @param delayMs the delay in milliseconds, or {@code null} for Bootstrap's default
     */
    public void setDelay(final Integer delayMs) {
        this.delayMs = delayMs;

        if (delayMs != null) {
            getElement().setAttribute("data-bs-delay", String.valueOf(delayMs));
        } else {
            getElement().removeAttribute("data-bs-delay");
        }
    }

    /**
     * Sets whether the toast hides itself after its delay ({@code data-bs-autohide}).
     *
     * @param hasAutohide {@code true} to hide itself, or {@code null} for Bootstrap's default
     */
    public void setAutohide(final Boolean hasAutohide) {
        this.hasAutohide = hasAutohide;

        if (hasAutohide != null) {
            getElement().setAttribute("data-bs-autohide", String.valueOf(hasAutohide));
        } else {
            getElement().removeAttribute("data-bs-autohide");
        }
    }

    /**
     * Returns whether the toast is shown.
     *
     * @return {@code true} if it is shown
     */
    public boolean isShown() {
        return isShown(getElement());
    }

    /**
     * Adds a handler called when the toast starts to show.
     *
     * @param showHandler the handler
     * @return the registration that removes the handler
     */
    public HandlerRegistration addShowHandler(final ShowHandler showHandler) {
        return addHandler(showHandler, ShowEvent.getType());
    }

    /**
     * Adds a handler called when the toast is shown, after the animation.
     *
     * @param shownHandler the handler
     * @return the registration that removes the handler
     */
    public HandlerRegistration addShownHandler(final ShownHandler shownHandler) {
        return addHandler(shownHandler, ShownEvent.getType());
    }

    /**
     * Adds a handler called when the toast starts to hide.
     *
     * @param hideHandler the handler
     * @return the registration that removes the handler
     */
    public HandlerRegistration addHideHandler(final HideHandler hideHandler) {
        return addHandler(hideHandler, HideEvent.getType());
    }

    /**
     * Adds a handler called when the toast is hidden, after the animation.
     *
     * @param hiddenHandler the handler
     * @return the registration that removes the handler
     */
    public HandlerRegistration addHiddenHandler(final HiddenHandler hiddenHandler) {
        return addHandler(hiddenHandler, HiddenEvent.getType());
    }

    /**
     * Returns how screen readers announce the toast.
     *
     * @return the role
     */
    public ToastRole getToastRole() {
        return toastRole;
    }

    /**
     * Returns whether the toast fades in and out.
     *
     * @return the value set with {@link #setAnimation}
     */
    public Boolean getAnimated() {
        return isAnimated;
    }

    /**
     * Returns whether the toast hides itself.
     *
     * @return the value set with {@link #setAutohide}
     */
    public Boolean getHasAutohide() {
        return hasAutohide;
    }

    /**
     * Returns how long the toast stays shown.
     *
     * @return the value set with {@link #setDelay}, in milliseconds
     */
    public Integer getDelayMs() {
        return delayMs;
    }

    /**
     * Can be override by subclasses to handle "show" event
     * however it's recommended to add an event handler.
     *
     * @param evt Event
     * @see org.gwtbootstrap5.client.shared.event.ShowEvent
     */
    protected void onShow(final Event evt) {
        fireEvent(new ShowEvent(evt));
    }

    /**
     * Can be override by subclasses to handle "shown" event
     * however it's recommended to add an event handler.
     *
     * @param evt Event
     * @see org.gwtbootstrap5.client.shared.event.ShownEvent
     */
    protected void onShown(final Event evt) {
        fireEvent(new ShownEvent(evt));
    }

    /**
     * Can be override by subclasses to handle "hide" event
     * however it's recommended to add an event handler.
     *
     * @param evt Event
     * @see org.gwtbootstrap5.client.shared.event.HideEvent
     */
    protected void onHide(final Event evt) {
        fireEvent(new HideEvent(evt));
    }

    /**
     * Can be override by subclasses to handle "hidden" event
     * however it's recommended to add an event handler.
     *
     * @param evt Event
     * @see org.gwtbootstrap5.client.shared.event.HiddenEvent
     */
    protected void onHidden(final Event evt) {
        fireEvent(new HiddenEvent(evt));
    }

    private void init(Element e) {
        BootstrapToast.getOrCreateInstance(e, null);
    }

    private void show(Element e) {
        BootstrapToast.getOrCreateInstance(e, null).show();
    }

    private void hide(Element e) {
        BootstrapToast.getOrCreateInstance(e, null).hide();
    }

    private boolean isShown(Element e) {
        return BootstrapToast.getOrCreateInstance(e, null).isShown();
    }

    private void bindJavaScriptEvents(final Element e) {
        listeners.add(e, "show.bs.toast", this::onShow);
        listeners.add(e, "shown.bs.toast", this::onShown);
        listeners.add(e, "hide.bs.toast", this::onHide);
        listeners.add(e, "hidden.bs.toast", this::onHidden);
    }

    // Unbinds all the handlers
    private void unbindAllHandlers(final Element e) {
        listeners.removeAll();
    }

    private void generateToastContent(String title, String subtitle, String msg) {
        if ((title != null && !title.isBlank()) || (subtitle != null && !subtitle.isBlank())) {
            Div header = generateToastHeader(title, subtitle);
            header.add(generateCloseButton());
            add(header);
        }

        if (msg != null && !msg.isBlank()) {
            Div body = generateToastBody(msg);

            if ((title != null && !title.isBlank()) || (subtitle != null && !subtitle.isBlank())) {
                add(body);
            } else {
                Div flex = new Div();
                flex.setStyleName("d-flex");
                flex.add(body);
                Button closeButton = generateCloseButton();
                closeButton.addStyleName("me-2 m-auto");
                flex.add(closeButton);
                add(flex);
            }
        }
    }

    private Div generateToastHeader(String title, String subtitle) {
        Div header = new Div();
        header.setStyleName(Styles.TOAST_HEADER);

        if (title != null && !title.isBlank()) {
            Strong titleElement = new Strong();
            titleElement.setStyleName("me-auto");
            titleElement.setText(title);
            header.add(titleElement);
        }

        if (subtitle != null && !subtitle.isBlank()) {
            Small subtitleElement = new Small();
            subtitleElement.setText(subtitle);
            header.add(subtitleElement);
        }

        return header;
    }

    private Div generateToastBody(String msg) {
        Div body = new Div();
        body.setStyleName(Styles.TOAST_BODY);
        body.getElement().setInnerText(msg);

        return body;
    }

    private Button generateCloseButton() {
        Button closeButton = new Button();
        closeButton.getElement().setAttribute(Attributes.TYPE, "button");
        closeButton.getElement().setAttribute(Attributes.ARIA_LABEL, "Close");
        closeButton.getElement().setAttribute("data-bs-dismiss", "toast");
        closeButton.setStyleName("btn-close");

        return closeButton;
    }

}
