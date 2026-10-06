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

/**
 * Figure ({@code figure.figure}): an image with its caption.
 * <h2>UiBinder example</h2>
 * <pre>{@code
 *     <b:Figure>
 *         <b:FigImg url="photo.jpg" addStyleNames="img-fluid rounded" altText="A photo"/>
 *         <b:FigCaption><b.html:Text text="A caption for the image above."/></b:FigCaption>
 *     </b:Figure>
 * }</pre>
 *
 * @author Sven Jacobs
 * @author Joshua Godi
 * @see Column
 * @see <a href="https://getbootstrap.com/docs/5.3/content/figures/">Bootstrap 5 documentation</a>
 */
public class Figure extends org.gwtbootstrap5.client.ui.html.Figure {

    /** Creates an empty figure ({@code figure.figure}). */
    public Figure() {
        super();

        setStyleName(Styles.FIGURE);
    }

}
