package org.gwtbootstrap5.client.ui.base;

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

import com.google.gwt.dom.client.Document;

/**
 * Base class for {@link org.gwtbootstrap5.client.ui.InputGroupText}
 * and {@link org.gwtbootstrap5.client.ui.InputGroupAppend}
 * and {@link org.gwtbootstrap5.client.ui.InputGroupPrepend}
 *
 * @author Sven Jacobs
 * @author Joshua Godi
 * @see org.gwtbootstrap5.client.ui.InputGroupAppend
 * @see org.gwtbootstrap5.client.ui.InputGroupPrepend
 */
public abstract class AbstractInputGroupAddon extends ComplexWidget {

    protected AbstractInputGroupAddon(final String styleName) {
        setElement(Document.get().createSpanElement());
        setStyleName(styleName);
    }
}
