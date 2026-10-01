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

import com.google.gwt.uibinder.client.UiConstructor;
import org.gwtbootstrap5.client.ui.constants.HeadingSize;
import org.gwtbootstrap5.client.ui.constants.Styles;

/**
 * @author Sven Jacobs
 * @author Joshua Godi
 * @see Modal
 */
public class ModalTitle extends Heading implements ModalComponent {

    /**
     * Creates a Heading with the passed in size.
     *
     * @param size size of the heading
     */
    @UiConstructor
    public ModalTitle(final HeadingSize size) {
        super(size);

        setStyleName(Styles.MODAL_TITLE);
    }

    /**
     * Creates a Heading with the passed in size and text.
     *
     * @param size size of the heading
     * @param text text for the heading
     */
    public ModalTitle(final HeadingSize size, final String text) {
        super(size, text);

        setStyleName(Styles.MODAL_TITLE);
    }

    /**
     * Creates a Heading with the passed in size and text.
     *
     * @param size    size of the heading
     * @param text    text for the heading
     * @param subText subtext for the heading
     */
    public ModalTitle(final HeadingSize size, final String text, final String subText) {
        super(size, text, subText);

        setStyleName(Styles.MODAL_TITLE);
    }

}
