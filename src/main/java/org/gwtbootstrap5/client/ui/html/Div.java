package org.gwtbootstrap5.client.ui.html;

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

import org.gwtbootstrap5.client.ui.base.ComplexWidget;
import org.gwtbootstrap5.client.ui.base.helper.StickyHelper;
import org.gwtbootstrap5.client.ui.constants.StickyPosition;

import com.google.gwt.dom.client.Document;

/**
 * Simple {@code <div>} tag
 *
 * @author Joshua Godi
 */
public class Div extends ComplexWidget {

    /** Creates an empty {@code div}. */
    public Div() {
        setElement(Document.get().createDivElement());
    }

    /**
     * Makes the div stick to the top or bottom of the viewport while the page scrolls, as
     * {@code sticky="TOP"} in UiBinder. For an offset, use
     * {@link StickyHelper#setSticky(com.google.gwt.user.client.ui.UIObject, StickyPosition, int)}.
     *
     * @param position where it sticks, or {@code null} to make it not sticky
     */
    public void setSticky(final StickyPosition position) {
        StickyHelper.setSticky(this, position);
    }

    /**
     * Returns where the div sticks.
     *
     * @return the position, or {@code null} if it isn't sticky
     */
    public StickyPosition getSticky() {
        return StickyHelper.getSticky(this);
    }
}
