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

import org.gwtbootstrap5.client.ui.base.helper.StyleHelper;
import org.gwtbootstrap5.client.ui.constants.RowContentJustifyAlign;
import org.gwtbootstrap5.client.ui.constants.RowContentVerticalAlign;
import org.gwtbootstrap5.client.ui.constants.Styles;
import org.gwtbootstrap5.client.ui.html.Div;

/**
 * Row of Bootstrap's grid ({@code div.row}), holding {@link Column}s.
 * <h2>UiBinder example</h2>
 * <pre>{@code
 *     <b:Row>
 *         <b:Column size="XS_6 MD_3">...</b:Column>
 *         <b:Column size="XS_6 MD_9">...</b:Column>
 *     </b:Row>
 * }</pre>
 *
 * @author Sven Jacobs
 * @author Joshua Godi
 * @see Column
 * @see <a href="https://getbootstrap.com/docs/5.3/layout/grid/">Bootstrap 5 documentation</a>
 */
public class Row extends Div {

    /** Creates an empty row ({@code div.row}). */
    public Row() {
        super();

        setStyleName(Styles.ROW);
    }

    /**
     * Aligns the columns vertically in the row ({@code align-items-*}).
     *
     * @param rowContentVerticalAlign the alignment
     */
    public void setContentVerticalAlign(RowContentVerticalAlign rowContentVerticalAlign) {
        StyleHelper.addUniqueEnumStyleName(this, RowContentVerticalAlign.class, rowContentVerticalAlign);
    }

    /**
     * Returns how the columns are aligned vertically.
     *
     * @return the alignment
     */
    public RowContentVerticalAlign getContentVerticalAlign() {
        return RowContentVerticalAlign.fromStyleName(getStyleName());
    }

    /**
     * Aligns the columns horizontally in the row ({@code justify-content-*}).
     *
     * @param rowContentJustifyAlign the alignment
     */
    public void setContentJustifyAlign(RowContentJustifyAlign rowContentJustifyAlign) {
        StyleHelper.addUniqueEnumStyleName(this, RowContentJustifyAlign.class, rowContentJustifyAlign);
    }

    /**
     * Returns how the columns are aligned horizontally.
     *
     * @return the alignment
     */
    public RowContentJustifyAlign getContentJustifyAlign() {
        return RowContentJustifyAlign.fromStyleName(getStyleName());
    }

}
