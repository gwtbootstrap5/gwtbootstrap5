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

import org.gwtbootstrap5.client.ui.html.Div;

/**
 * Flexbox stack with a {@code gap-*} between its children.
 *
 * @see org.gwtbootstrap5.client.ui.HStack
 * @see org.gwtbootstrap5.client.ui.VStack
 */
public abstract class AbstractStack extends Div {

    private static final String GAP = "gap-";
    private static final int MAX_GAP = 5;

    private int gap = -1;

    protected AbstractStack(final String stackClass) {
        super();

        setStyleName(stackClass);
    }

    /**
     * Sets the space between children, from 0 to 5 ({@code gap-0} to {@code gap-5}); -1 for none.
     *
     * @throws IllegalArgumentException outside -1 to 5
     */
    public void setGap(final int gap) {
        if (gap < -1 || gap > MAX_GAP) {
            throw new IllegalArgumentException("Gap must be between 0 and " + MAX_GAP + ", or -1 for none: " + gap);
        }
        if (this.gap >= 0) {
            removeStyleName(GAP + this.gap);
        }
        this.gap = gap;
        if (gap >= 0) {
            addStyleName(GAP + gap);
        }
    }

    public int getGap() {
        return gap;
    }
}
