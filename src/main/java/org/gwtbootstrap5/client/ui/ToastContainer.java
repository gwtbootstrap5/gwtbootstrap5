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

import org.gwtbootstrap5.client.ui.constants.Styles;
import org.gwtbootstrap5.client.ui.html.Div;

/**
 * Container that stacks {@link Toast}s ({@code div.toast-container}). Position it with utility
 * classes, such as {@code position-fixed bottom-0 end-0 p-3}.
 * <h2>UiBinder example</h2>
 * <pre>{@code
 *     <b:ToastContainer ui:field="container" addStyleNames="position-fixed bottom-0 end-0 p-3"/>
 * }</pre>
 *
 * @see <a href="https://getbootstrap.com/docs/5.3/components/toasts/#placement">Bootstrap 5 documentation</a>
 */
public class ToastContainer extends Div {

    /** Creates an empty toast container. */
    public ToastContainer() {
        super();

        getElement().setClassName(Styles.TOAST_CONTAINER);
    }

}
