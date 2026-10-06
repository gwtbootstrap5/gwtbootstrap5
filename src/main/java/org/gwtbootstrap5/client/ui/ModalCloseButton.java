package org.gwtbootstrap5.client.ui;

/*-
 * ==========================LICENSE_START===============================
 * GwtBootstrap5
 * ======================================================================
 * Copyright (C) 2026 GwtBootstrap5
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

/**
 * Close button ({@code button.btn-close}) that closes the {@link Modal} it is in
 * ({@code data-bs-dismiss="modal"}).
 *
 * @see <a href="https://getbootstrap.com/docs/5.3/components/modal/">Bootstrap 5 documentation</a>
 */
public class ModalCloseButton extends CloseButton {

    /** Creates a close button. */
    public ModalCloseButton() {
        super();

        setDataDismiss(ButtonDismiss.MODAL);
    }

}
