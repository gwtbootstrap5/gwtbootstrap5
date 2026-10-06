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
 * Card: a flexible content container with an optional header, body, footer and images.
 * <h2>UiBinder example</h2>
 * <pre>{@code
 *     <b:Card>
 *         <b:CardHeader text="Featured"/>
 *         <b:CardBody>
 *             <b:CardTitle size="H5">Card title</b:CardTitle>
 *             <b:CardText>Some quick example text.</b:CardText>
 *         </b:CardBody>
 *     </b:Card>
 * }</pre>
 *
 * @see <a href="https://getbootstrap.com/docs/5.3/components/card/">Bootstrap 5 documentation</a>
 *
 * @author Joshua Godi
 */
public class Card extends Div {

    /** Creates an empty card ({@code div.card}). */
    public Card() {
        super();

        setStyleName(Styles.CARD);
    }

}
