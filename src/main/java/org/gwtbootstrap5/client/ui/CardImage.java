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
import org.gwtbootstrap5.client.ui.constants.CardImagePosition;

/**
 * Image of a {@link Card}. The position says where it goes: at the top or bottom edge of the
 * card, or anywhere ({@code card-img}), for example under a body laid over it.
 * <h2>UiBinder example</h2>
 * <pre>{@code
 *     <b:Card>
 *         <b:CardImage cardImagePosition="TOP" url="photo.jpg"/>
 *         <b:CardBody>...</b:CardBody>
 *     </b:Card>
 * }</pre>
 *
 * @see <a href="https://getbootstrap.com/docs/5.3/components/card/#images">Bootstrap 5 documentation</a>
 */
public class CardImage extends Image {

    /**
     * Creates a card image.
     *
     * @param cardImagePosition where the image goes in the card
     */
    @UiConstructor
    public CardImage(CardImagePosition cardImagePosition) {
        super();

        setStyleName(cardImagePosition.getCssName());
    }

    /**
     * Sets where the image goes in the card, replacing any other style name of the image.
     *
     * @param cardImagePosition the position, which sets {@code card-img}, {@code card-img-top} or
     *     {@code card-img-bottom}
     */
    public void setImagePosition(CardImagePosition cardImagePosition) {
        setStyleName(cardImagePosition.getCssName());
    }

}
