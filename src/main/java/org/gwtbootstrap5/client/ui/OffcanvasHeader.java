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

import org.gwtbootstrap5.client.ui.base.button.CloseButton;
import org.gwtbootstrap5.client.ui.constants.ButtonDismiss;
import org.gwtbootstrap5.client.ui.constants.Styles;
import org.gwtbootstrap5.client.ui.html.Div;

import com.google.gwt.user.client.ui.Widget;

/**
 * Header of an {@link Offcanvas}: an optional {@link OffcanvasTitle}, then any widgets, then a
 * close button unless {@link #setClosable(boolean) closable} is {@code false}.
 *
 * @see Offcanvas
 */
public class OffcanvasHeader extends Div {

    private OffcanvasTitle title;
    private final CloseButton closeButton = new CloseButton();

    public OffcanvasHeader() {
        super();

        setStyleName(Styles.OFFCANVAS_HEADER);
        closeButton.setDataDismiss(ButtonDismiss.OFFCANVAS);
        super.add(closeButton);
    }

    @Override
    public void add(final Widget w) {
        if (w instanceof OffcanvasTitle) {
            if (title != null) {
                title.removeFromParent();
            }
            title = (OffcanvasTitle) w;
            insert(w, 0);
        } else if (closeButton.getParent() == this) {
            insert(w, getWidgetIndex(closeButton));
        } else {
            super.add(w);
        }
    }

    /**
     * Sets the title text, creating the {@link OffcanvasTitle} if needed; {@code null} or blank
     * removes it.
     */
    public void setTitle(final String text) {
        if (text == null || text.isBlank()) {
            if (title != null) {
                title.removeFromParent();
                title = null;
            }
        } else if (title == null) {
            add(new OffcanvasTitle(text));
        } else {
            title.setText(text);
        }
    }

    @Override
    public String getTitle() {
        return title == null ? null : title.getText();
    }

    /**
     * Shows or removes the close button ({@code btn-close} with {@code data-bs-dismiss="offcanvas"}).
     * Closable by default.
     */
    public void setClosable(final boolean closable) {
        if (closable && closeButton.getParent() != this) {
            super.add(closeButton);
        } else if (!closable) {
            closeButton.removeFromParent();
        }
    }

    public boolean isClosable() {
        return closeButton.getParent() == this;
    }

    /**
     * @return the title widget, or {@code null} if there is none
     */
    OffcanvasTitle getTitleWidget() {
        return title;
    }
}
