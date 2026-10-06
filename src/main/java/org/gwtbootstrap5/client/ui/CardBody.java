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
 * Body of a {@link Card} ({@code div.card-body}), where its title, text and other content go.
 *
 * @see <a href="https://getbootstrap.com/docs/5.3/components/card/#body">Bootstrap 5 documentation</a>
 *
 * @author Joshua Godi
 */
public class CardBody extends Div {

    /** Creates an empty card body. */
    public CardBody() {
        super();

        setStyleName(Styles.CARD_BODY);
    }

    /**
     * Lays the body over the card's image instead of below it ({@code card-img-overlay}).
     *
     * @param overlay {@code true} to overlay the image
     */
    public void setOverlay(boolean overlay) {
        if (overlay) {
            addStyleName(Styles.CARD_IMG_OVERLAY);
        } else {
            removeStyleName(Styles.CARD_IMG_OVERLAY);
        }
    }

}
