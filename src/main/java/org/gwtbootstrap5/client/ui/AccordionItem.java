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

import org.gwtbootstrap5.client.shared.js.BootstrapCollapse;
import org.gwtbootstrap5.client.ui.base.helper.StyleHelper;
import org.gwtbootstrap5.client.ui.constants.Attributes;
import org.gwtbootstrap5.client.ui.constants.Styles;
import org.gwtbootstrap5.client.ui.html.Div;

import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.Widget;

import jsinterop.base.JsPropertyMap;

/**
 * An item of an {@link Accordion}: an {@link AccordionHeader} and the {@link AccordionBody} it
 * opens and closes. The header and the body are linked when the item is attached, through an id
 * generated for the body unless it has one.
 *
 * @see Accordion
 * @see <a href="https://getbootstrap.com/docs/5.3/components/accordion/">Bootstrap 5 documentation</a>
 */
public class AccordionItem extends Div {

    private boolean open = false;
    // After the first attach the classes Bootstrap toggles are the state, not the open field
    private boolean initialized = false;

    /** Creates an empty, closed item. */
    public AccordionItem() {
        super();

        setStyleName(Styles.ACCORDION_ITEM);
    }

    @Override
    protected void onLoad() {
        super.onLoad();
        link();
        if (!initialized) {
            applyState();
            initialized = true;
        }
    }

    /**
     * Opens or closes the body. Before the item is attached this sets its initial state; after, it
     * animates like a click on the header, closing the other items unless the accordion is
     * {@link Accordion#setAlwaysOpen always open}.
     *
     * @param open {@code true} to open the body
     */
    public void setOpen(final boolean open) {
        this.open = open;
        final AccordionBody body = findBody();
        if (isAttached() && body != null) {
            final BootstrapCollapse collapse = BootstrapCollapse.getOrCreateInstance(body.getElement(),
                    JsPropertyMap.of("toggle", false));
            if (open) {
                collapse.show();
            } else {
                collapse.hide();
            }
        } else {
            applyState();
        }
    }

    /**
     * Returns whether the body is open.
     *
     * @return {@code true} if the body is open, or opening
     */
    public boolean isOpen() {
        final AccordionBody body = findBody();
        return initialized && body != null ? isShown(body) : open;
    }

    /**
     * Links the header to the body and the body to the accordion. Called on attach, and by the
     * accordion when {@link Accordion#setAlwaysOpen} changes.
     */
    void link() {
        final AccordionHeader header = findHeader();
        final AccordionBody body = findBody();
        if (body == null) {
            return;
        }
        if (body.getId() == null || body.getId().isEmpty()) {
            body.setId(DOM.createUniqueId());
        }
        if (header != null) {
            header.getButton().setAttribute(Attributes.DATA_TARGET, "#" + body.getId());
            header.getButton().setAttribute(Attributes.ARIA_CONTROLS, body.getId());
        }

        final Widget parent = getParent();
        final String parentSelector = parent instanceof Accordion && !((Accordion) parent).isAlwaysOpen()
                ? "#" + ((Accordion) parent).ensureId() : null;
        final String current = body.getElement().getAttribute(Attributes.DATA_PARENT);
        if (parentSelector != null) {
            body.getElement().setAttribute(Attributes.DATA_PARENT, parentSelector);
        } else {
            body.getElement().removeAttribute(Attributes.DATA_PARENT);
        }
        if (!current.equals(parentSelector == null ? "" : parentSelector)) {
            // Bootstrap reads data-bs-parent when it creates the instance
            final BootstrapCollapse collapse = BootstrapCollapse.getInstance(body.getElement());
            if (collapse != null) {
                collapse.dispose();
            }
        }
    }

    private void applyState() {
        final AccordionHeader header = findHeader();
        final AccordionBody body = findBody();
        if (body != null) {
            if (open) {
                body.addStyleName(Styles.SHOW);
            } else {
                body.removeStyleName(Styles.SHOW);
            }
        }
        if (header != null) {
            if (open) {
                header.getButton().removeClassName(Styles.COLLAPSED);
            } else {
                header.getButton().addClassName(Styles.COLLAPSED);
            }
            header.getButton().setAttribute(Attributes.ARIA_EXPANDED, String.valueOf(open));
        }
    }

    private static boolean isShown(final AccordionBody body) {
        final String styles = body.getStyleName();
        return StyleHelper.containsStyle(styles, Styles.SHOW) || StyleHelper.containsStyle(styles, Styles.COLLAPSING);
    }

    private AccordionHeader findHeader() {
        for (final Widget child : getChildren()) {
            if (child instanceof AccordionHeader) {
                return (AccordionHeader) child;
            }
        }
        return null;
    }

    private AccordionBody findBody() {
        for (final Widget child : getChildren()) {
            if (child instanceof AccordionBody) {
                return (AccordionBody) child;
            }
        }
        return null;
    }
}
