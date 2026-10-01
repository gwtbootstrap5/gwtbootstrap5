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
import org.gwtbootstrap5.client.shared.js.JQuery;
import org.gwtbootstrap5.client.ui.base.helper.RoleHelper;
import org.gwtbootstrap5.client.ui.constants.Attributes;
import org.gwtbootstrap5.client.ui.constants.Styles;
import org.gwtbootstrap5.client.ui.constants.ToastRole;
import org.gwtbootstrap5.client.ui.html.Div;
import org.gwtbootstrap5.client.ui.html.Small;
import org.gwtbootstrap5.client.ui.html.Strong;

public class Toast extends Div {

    public static final int DEFAULT_DELAY_MS = 5000;

    private ToastRole toastRole;
    private Boolean isAnimated;
    private Boolean hasAutohide;
    private Integer delayMs;

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

    public void show() {
        show(getElement());
    }

    public void hide() {
        hide(getElement());
    }

    public void setToastRole(final ToastRole toastRole) {
        this.toastRole = toastRole;

        RoleHelper.setRole(getElement(), toastRole.getRole());

        getElement().setAttribute(Attributes.ARIA_LIVE, toastRole.getAriaLive());
        getElement().setAttribute(Attributes.ARIA_ATOMIC, "true");
    }

    public void setAnimation(final Boolean isAnimated) {
        this.isAnimated = isAnimated;

        if (isAnimated != null) {
            getElement().setAttribute("data-bs-animation", String.valueOf(isAnimated));
        } else {
            getElement().removeAttribute("data-bs-animation");
        }
    }

    public void setDelay(final Integer delayMs) {
        this.delayMs = delayMs;

        if (delayMs != null) {
            getElement().setAttribute("data-bs-delay", String.valueOf(delayMs));
        } else {
            getElement().removeAttribute("data-bs-delay");
        }
    }

    public void setAutohide(final Boolean hasAutohide) {
        this.hasAutohide = hasAutohide;

        if (hasAutohide != null) {
            getElement().setAttribute("data-bs-autohide", String.valueOf(hasAutohide));
        } else {
            getElement().removeAttribute("data-bs-autohide");
        }
    }

    public boolean isShown() {
        return isShown(getElement());
    }

    public HandlerRegistration addShowHandler(final ShowHandler showHandler) {
        return addHandler(showHandler, ShowEvent.getType());
    }

    public HandlerRegistration addShownHandler(final ShownHandler shownHandler) {
        return addHandler(shownHandler, ShownEvent.getType());
    }

    public HandlerRegistration addHideHandler(final HideHandler hideHandler) {
        return addHandler(hideHandler, HideEvent.getType());
    }

    public HandlerRegistration addHiddenHandler(final HiddenHandler hiddenHandler) {
        return addHandler(hiddenHandler, HiddenEvent.getType());
    }

    public ToastRole getToastRole() {
        return toastRole;
    }

    public Boolean getAnimated() {
        return isAnimated;
    }

    public Boolean getHasAutohide() {
        return hasAutohide;
    }

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

    private native void init(Element e) /*-{
        $wnd.jQuery(e).toast();
    }-*/;

    private native void show(Element e) /*-{
        $wnd.jQuery(e).toast("show");
    }-*/;

    private native void hide(Element e) /*-{
        $wnd.jQuery(e).toast("hide");
    }-*/;

    private native boolean isShown(Element e) /*-{
        return $wnd.jQuery(e).toast("isShown");
    }-*/;

    private void bindJavaScriptEvents(final Element e) {
        JQuery j = JQuery.jQuery(e);

        j.on("show.bs.toast", this::onShow);
        j.on("shown.bs.toast", this::onShown);
        j.on("hide.bs.toast", this::onHide);
        j.on("hidden.bs.toast", this::onHidden);
    }

    // Unbinds all the handlers
    private void unbindAllHandlers(final Element e) {
        JQuery j = JQuery.jQuery(e);
        j.off("show.bs.toast");
        j.off("shown.bs.toast");
        j.off("hide.bs.toast");
        j.off("hidden.bs.toast");
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
