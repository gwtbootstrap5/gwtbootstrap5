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

import org.gwtbootstrap5.client.shared.event.ModalHiddenEvent;
import org.gwtbootstrap5.client.shared.event.ModalHiddenHandler;
import org.gwtbootstrap5.client.shared.event.ModalHideEvent;
import org.gwtbootstrap5.client.shared.event.ModalHideHandler;
import org.gwtbootstrap5.client.shared.event.ModalShowEvent;
import org.gwtbootstrap5.client.shared.event.ModalShowHandler;
import org.gwtbootstrap5.client.shared.event.ModalShownEvent;
import org.gwtbootstrap5.client.shared.event.ModalShownHandler;
import org.gwtbootstrap5.client.shared.js.BootstrapModal;
import org.gwtbootstrap5.client.shared.js.DomEventListeners;
import org.gwtbootstrap5.client.ui.base.helper.StyleHelper;
import org.gwtbootstrap5.client.ui.base.modal.ModalContent;
import org.gwtbootstrap5.client.ui.base.modal.ModalDialog;
import org.gwtbootstrap5.client.ui.constants.Attributes;
import org.gwtbootstrap5.client.ui.constants.ModalBackdrop;
import org.gwtbootstrap5.client.ui.constants.ModalFullscreen;
import org.gwtbootstrap5.client.ui.constants.ModalSize;
import org.gwtbootstrap5.client.ui.constants.Styles;
import org.gwtbootstrap5.client.ui.html.Div;

import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.web.bindery.event.shared.HandlerRegistration;

import elemental2.dom.DomGlobal;
import elemental2.dom.NodeList;
import jsinterop.base.Js;

/**
 * Modal dialog, shown over the page with a backdrop. A button with {@code dataToggle="MODAL"}
 * targeting its id opens it, or {@link #show()} from Java; a button with
 * {@code dataDismiss="MODAL"} inside closes it.
 * <h2>UiBinder example</h2>
 * <pre>
 * {@code
 *     <b:Button type="PRIMARY" dataToggle="MODAL" dataTarget="#modal1" text="Show modal"/>
 *     <b:Modal b:id="modal1" title="Important information" closable="true" fade="true">
 *         <b:ModalBody>
 *             <b.html:Paragraph>Lorem ipsum...</b.html:Paragraph>
 *         </b:ModalBody>
 *         <b:ModalFooter>
 *             <b:Button type="SECONDARY" dataDismiss="MODAL" text="Close"/>
 *             <b:Button type="PRIMARY" text="Save changes"/>
 *         </b:ModalFooter>
 *     </b:Modal>
 * }
 * </pre>
 * <p>
 * It's also possible to specify a custom modal header:
 * <pre>
 * {@code
 *     <b:Modal>
 *         <b:ModalHeader>
 *             <g:HTML>
 *                 <h4>Custom header</h4>
 *             </g:HTML>
 *         </b:ModalHeader>
 *         ...
 *     </b:Modal>
 * }
 * </pre>
 *
 * @author Sven Jacobs
 * @author Joshua Godi
 * @see ModalHeader
 * @see ModalBody
 * @see ModalFooter
 * @see org.gwtbootstrap5.client.shared.event.ModalShowEvent
 * @see org.gwtbootstrap5.client.shared.event.ModalShownEvent
 * @see org.gwtbootstrap5.client.shared.event.ModalHideEvent
 * @see org.gwtbootstrap5.client.shared.event.ModalHiddenEvent
 */
public class Modal extends Div implements IsClosable {

    private static final String TOGGLE = "toggle";
    private static final String HIDE = "hide";
    private static final String SHOW = "show";

    private final DomEventListeners listeners = new DomEventListeners();

    private final ModalContent content = new ModalContent();
    private final ModalDialog dialog = new ModalDialog();
    private ModalHeader header = new ModalHeader();

    private HandlerRegistration removeOnHideHandlerReg = null;

    private boolean hideOtherModals = false;

    /**
     * Creates an empty modal ({@code div.modal}) with a header, holding its title and close
     * button.
     */
    public Modal() {
        super();

        setStyleName(Styles.MODAL);

        content.add(header);
        dialog.add(content);

        add(dialog);
    }

    @Override
    public void setWidth(final String width) {
        dialog.setWidth(width);
    }

    /**
     * Centers the modal vertically in the viewport.
     *
     * @param centered {@code true} to center the modal
     */
    public void setCentered(final boolean centered) {
        dialog.setCentered(centered);
    }

    /**
     * Makes the modal body scroll instead of the page when the content is too long.
     *
     * @param scrollable {@code true} to scroll the modal body
     */
    public void setScrollable(final boolean scrollable) {
        dialog.setScrollable(scrollable);
    }

    /**
     * Sets the width of the modal dialog ({@code modal-sm}, {@code modal-lg} or {@code modal-xl}).
     *
     * @param size the size
     */
    public void setSize(ModalSize size) {
        StyleHelper.addUniqueEnumStyleName(dialog, ModalSize.class, size);
    }

    /**
     * Makes the modal cover the viewport, always or below a breakpoint. Independent of
     * {@link #setSize}, which applies above that breakpoint.
     *
     * @param fullscreen when to cover the viewport, or {@code null} never
     */
    public void setFullscreen(final ModalFullscreen fullscreen) {
        StyleHelper.addUniqueEnumStyleName(dialog, ModalFullscreen.class, fullscreen);
    }

    /**
     * Returns when the modal covers the viewport.
     *
     * @return the breakpoint below which it is fullscreen, {@code ALWAYS}, or {@code null} if never
     */
    public ModalFullscreen getFullscreen() {
        return ModalFullscreen.fromStyleName(dialog.getStyleName());
    }

    @Override
    protected void onLoad() {
        super.onLoad();
        bindJavaScriptEvents(getElement());
    }

    @Override
    protected void onUnload() {
        super.onUnload();
        unbindAllHandlers(getElement());
    }

    @Override
    public void add(final Widget w) {
        // User can supply own ModalHeader
        if (w instanceof ModalHeader m) {
            header.removeFromParent();
            header = m;
        }

        if (w instanceof ModalComponent) {
            content.add(w);
        } else {
            super.add(w);
        }
    }

    @Override
    public void setTitle(final String title) {
        header.setTitle(title);
    }

    @Override
    public void setClosable(final boolean closable) {
        header.setClosable(closable);
    }

    @Override
    public boolean isClosable() {
        return header.isClosable();
    }

    /**
     * If set to true, when the modal is shown it will force hide all other modals
     *
     * @param hideOtherModals - true to force hide other modals, false to keep them shown
     */
    public void setHideOtherModals(final boolean hideOtherModals) {
        this.hideOtherModals = hideOtherModals;
    }

    /**
     * If set to true, will remove the modal from the DOM completely and unbind any events to the modal
     *
     * @param removeOnHide - true to remove modal and unbind events on hide, false to keep it in the DOM
     */
    public void setRemoveOnHide(final boolean removeOnHide) {
        if (removeOnHideHandlerReg != null) {
            removeOnHideHandlerReg.removeHandler();
            removeOnHideHandlerReg = null;
        }
        if (removeOnHide) {
            removeOnHideHandlerReg = addHiddenHandler(evt -> {
                // Do logical detach
                removeFromParent();
            });
        }
    }

    /**
     * If set Modal will fade in/out.
     *
     * @param fade If {@code true} modal will fade in/out
     */
    public void setFade(final boolean fade) {
        if (fade) {
            addStyleName(Styles.FADE);
        } else {
            removeStyleName(Styles.FADE);
        }
    }

    /**
     * Sets backdrop of modal.
     *
     * @param backdrop Backdrop of modal
     * @see org.gwtbootstrap5.client.ui.constants.ModalBackdrop
     */
    public void setDataBackdrop(final ModalBackdrop backdrop) {
        if (backdrop != null) {
            getElement().setAttribute(Attributes.DATA_BACKDROP, backdrop.getBackdrop());
        } else {
            getElement().removeAttribute(Attributes.DATA_BACKDROP);
        }
    }

    /**
     * Sets whether the modal takes the focus when it opens ({@code data-bs-focus}, on by
     * default). Read by Bootstrap when the modal is first shown.
     *
     * @param focus {@code false} to leave the focus where it is
     */
    public void setDataFocus(final boolean focus) {
        getElement().setAttribute("data-bs-focus", Boolean.toString(focus));
    }

    /**
     * Sets whether the Escape key closes the modal ({@code data-bs-keyboard}).
     *
     * @param keyboard {@code true} to close on Escape
     */
    public void setDataKeyboard(final boolean keyboard) {
        getElement().setAttribute(Attributes.DATA_KEYBOARD, Boolean.toString(keyboard));

        // tabindex must be set to -1 for ESC key to work
        if (keyboard) {
            getElement().setAttribute(Attributes.TABINDEX, "-1");
        }
    }

    /** Shows the modal if it is hidden, hides it otherwise. */
    public void toggle() {
        modal(getElement(), TOGGLE);
    }

    /** Shows the modal, adding it to the page first if it isn't attached. */
    public void show() {
        checkIsAttached();
        modal(getElement(), SHOW);
    }

    /** Hides the modal. */
    public void hide() {
        modal(getElement(), HIDE);
    }

    /**
     * Adds a handler called when the modal starts to show.
     *
     * @param modalShowHandler the handler
     * @return the registration that removes the handler
     */
    public HandlerRegistration addShowHandler(final ModalShowHandler modalShowHandler) {
        return addHandler(modalShowHandler, ModalShowEvent.getType());
    }

    /**
     * Adds a handler called when the modal is shown, after the animation.
     *
     * @param modalShownHandler the handler
     * @return the registration that removes the handler
     */
    public HandlerRegistration addShownHandler(final ModalShownHandler modalShownHandler) {
        return addHandler(modalShownHandler, ModalShownEvent.getType());
    }

    /**
     * Adds a handler called when the modal starts to hide.
     *
     * @param modalHideHandler the handler
     * @return the registration that removes the handler
     */
    public HandlerRegistration addHideHandler(final ModalHideHandler modalHideHandler) {
        return addHandler(modalHideHandler, ModalHideEvent.getType());
    }

    /**
     * Adds a handler called when the modal is hidden, after the animation.
     *
     * @param modalHiddenHandler the handler
     * @return the registration that removes the handler
     */
    public HandlerRegistration addHiddenHandler(final ModalHiddenHandler modalHiddenHandler) {
        return addHandler(modalHiddenHandler, ModalHiddenEvent.getType());
    }

    /**
     * Can be override by subclasses to handle Modal's "show" event however it's
     * recommended to add an event handler to the modal.
     *
     * @param evt Event
     * @see org.gwtbootstrap5.client.shared.event.ModalShowEvent
     */
    protected void onShow(final Event evt) {
        if (hideOtherModals) {
            hideOtherModals();
        }
        fireEvent(new ModalShowEvent(this, evt));
    }

    /**
     * Can be override by subclasses to handle Modal's "shown" event however
     * it's recommended to add an event handler to the modal.
     *
     * @param evt Event
     * @see org.gwtbootstrap5.client.shared.event.ModalShownEvent
     */
    protected void onShown(final Event evt) {
        fireEvent(new ModalShownEvent(this, evt));
    }

    /**
     * Can be override by subclasses to handle Modal's "hide" event however it's
     * recommended to add an event handler to the modal.
     *
     * @param evt Event
     * @see org.gwtbootstrap5.client.shared.event.ModalHideEvent
     */
    protected void onHide(final Event evt) {
        fireEvent(new ModalHideEvent(this, evt));
    }

    /**
     * Can be override by subclasses to handle Modal's "hidden" event however
     * it's recommended to add an event handler to the modal.
     *
     * @param evt Event
     * @see org.gwtbootstrap5.client.shared.event.ModalHiddenEvent
     */
    protected void onHidden(final Event evt) {
        fireEvent(new ModalHiddenEvent(this, evt));
    }

    private void checkIsAttached() {
        if (!this.isAttached()) {
            RootPanel.get().add(this);
        }
    }

    private void bindJavaScriptEvents(final Element e) {
        listeners.add(e, "show.bs.modal", this::onShow);
        listeners.add(e, "shown.bs.modal", this::onShown);
        listeners.add(e, "hide.bs.modal", this::onHide);
        listeners.add(e, "hidden.bs.modal", this::onHidden);
    }

    private void modal(final Element e, final String arg) {
        final BootstrapModal modal = BootstrapModal.getOrCreateInstance(e, null);
        switch (arg) {
            case SHOW:
                modal.show();
                break;
            case HIDE:
                modal.hide();
                break;
            default:
                modal.toggle();
                break;
        }
    }

    // Will iterate over all the modals, if they are visible it will hide them
    private void hideOtherModals() {
        final NodeList<elemental2.dom.Element> shown = DomGlobal.document.querySelectorAll(".modal.show");
        for (int i = 0; i < shown.length; i++) {
            final Element other = Js.uncheckedCast(shown.getAt(i));
            if (other != getElement()) {
                final BootstrapModal modal = BootstrapModal.getInstance(other);
                if (modal != null) {
                    modal.hide();
                }
            }
        }
    }

    // Unbinds all the handlers
    private void unbindAllHandlers(final Element e) {
        listeners.removeAll();
    }
}
