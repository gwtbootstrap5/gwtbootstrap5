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
import org.gwtbootstrap5.client.ui.base.HasSize;
import org.gwtbootstrap5.client.ui.constants.RowColSize;
import org.gwtbootstrap5.client.ui.constants.Styles;
import org.gwtbootstrap5.client.ui.html.Div;

/**
 * Row of Bootstrap's grid ({@code div.row}) that sets how many columns fit on a line
 * ({@code row-cols-*}), so its columns only need {@code size="XS_DEFAULT"} ({@code col}).
 * <h2>UiBinder example</h2>
 * <pre>{@code
 *     <b:RowCols rowColSize="MD_4">
 *         <b:Column size="XS_DEFAULT">...</b:Column>
 *         <b:Column size="XS_DEFAULT">...</b:Column>
 *     </b:RowCols>
 * }</pre>
 *
 * @author Sven Jacobs
 * @author Joshua Godi
 * @see Column
 * @see <a href="https://getbootstrap.com/docs/5.3/layout/grid/#row-columns">Bootstrap 5 documentation</a>
 */
public class RowCols extends Div implements HasSize<RowColSize> {

    /** Creates an empty row ({@code div.row}); {@code setSize} sets how many columns fit on a line. */
    public RowCols() {
        super();

        setStyleName(Styles.ROW);
        addStyleName(RowColSize.DEFAULT.getCssName());
    }

    /**
     * Creates an empty row with a number of columns per line.
     *
     * @param rowColSize how many columns fit on a line ({@code row-cols-*})
     */
    @UiConstructor
    public RowCols(RowColSize rowColSize) {
        setStyleName(Styles.ROW);
        addStyleName(rowColSize.getCssName());
    }

    @Override
    public void setSize(RowColSize size) {
        setStyleName(Styles.ROW);
        addStyleName(size.getCssName());
    }

    @Override
    public RowColSize getSize() {
        return RowColSize.fromStyleName(getStyleName());
    }

}
