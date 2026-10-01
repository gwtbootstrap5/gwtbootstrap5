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

import com.google.gwt.user.client.ui.Widget;
import org.gwtbootstrap5.client.ui.constants.HeadingSize;
import org.gwtbootstrap5.client.ui.constants.Styles;
import org.gwtbootstrap5.client.ui.gwt.FlowPanel;

/**
 * @author Sven Jacobs
 * @author Joshua Godi
 * @see Modal
 */
public class ModalHeader extends FlowPanel implements ModalComponent, IsClosable {

    private ModalTitle modalTitle;
    private ModalCloseButton modalCloseButton;

    public ModalHeader() {
        super();

        setStyleName(Styles.MODAL_HEADER);

        addModalTitle(null);
        addModalCloseButton(null);
    }

    @Override
    public void add(Widget w) {
        if (w instanceof ModalTitle mt) {
            removeModalTitle();
            addModalTitle(mt);
        } else if (w instanceof ModalCloseButton mcb) {
            removeModalCloseButton();
            addModalCloseButton(mcb);
        } else {
            super.add(w);
        }
    }

    @Override
    public void setTitle(final String title) {
        if (title != null && !title.isBlank()) {
            addModalTitle(this.modalTitle);
        } else {
            removeModalTitle();
        }

        modalTitle.setText(title);
    }

    @Override
    public void setClosable(final boolean closable) {
        if (closable) {
            addModalCloseButton(this.modalCloseButton);
        } else {
            removeModalCloseButton();
        }
    }

    @Override
    public boolean isClosable() {
        return modalCloseButton != null && modalCloseButton.getParent() != null;
    }

    private void addModalTitle(ModalTitle modalTitle) {
        if (modalTitle == null) {
            modalTitle = new ModalTitle(HeadingSize.H4);
        }

        this.modalTitle = modalTitle;

        if (!getChildren().contains(modalTitle)) {
            insert(modalTitle, 0);
        }
    }

    private void removeModalTitle() {
        if (modalTitle != null && getChildren().contains(modalTitle)) {
            modalTitle.removeFromParent();
        }
    }

    private void addModalCloseButton(ModalCloseButton modalCloseButton) {
        if (modalCloseButton == null) {
            modalCloseButton = new ModalCloseButton();
        }

        this.modalCloseButton = modalCloseButton;

        if (!getChildren().contains(modalCloseButton)) {
            insert(modalCloseButton, getWidgetCount());
        }
    }

    private void removeModalCloseButton() {
        if (modalCloseButton != null && getChildren().contains(modalCloseButton)) {
            modalCloseButton.removeFromParent();
        }
    }

}
