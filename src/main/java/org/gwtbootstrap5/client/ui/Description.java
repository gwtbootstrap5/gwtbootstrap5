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

import org.gwtbootstrap5.client.ui.base.ComplexWidget;
import org.gwtbootstrap5.client.ui.base.DescriptionComponent;
import org.gwtbootstrap5.client.ui.constants.Styles;

import com.google.gwt.dom.client.Document;
import com.google.gwt.user.client.ui.Widget;

/**
 * Description list ({@code dl}) of {@link DescriptionTitle}s and {@link DescriptionData}. Made
 * horizontal, it is a grid {@code row}: give the titles and data column classes.
 * <h2>UiBinder example</h2>
 * <pre>{@code
 *     <b:Description horizontal="true">
 *         <b:DescriptionTitle addStyleNames="col-sm-3">Name</b:DescriptionTitle>
 *         <b:DescriptionData addStyleNames="col-sm-9">GwtBootstrap5</b:DescriptionData>
 *     </b:Description>
 * }</pre>
 *
 * @see <a href="https://getbootstrap.com/docs/5.3/content/typography/#description-list-alignment">Bootstrap 5 documentation</a>
 *
 * @author Joshua Godi
 */
public class Description extends ComplexWidget {

    /** Creates an empty description list. */
    public Description() {
        super();

        setElement(Document.get().createDLElement());
    }

    /**
     * Lays the list out as a grid row ({@code row}), with titles and data side by side.
     *
     * @param horizontal {@code true} for a horizontal list
     */
    public void setHorizontal(final boolean horizontal) {
        setStyleName(Styles.ROW, horizontal);
    }

    @Override
    public void add(final Widget child) {
        if (!(child instanceof DescriptionComponent)) {
            throw new IllegalArgumentException(
                    "Description can only have children of type DescriptionData and DescriptionTitle");
        }
        super.add(child);
    }
}
