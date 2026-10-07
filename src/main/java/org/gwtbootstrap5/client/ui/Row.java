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

import org.gwtbootstrap5.client.ui.base.helper.EnumHelper;
import org.gwtbootstrap5.client.ui.base.helper.StyleHelper;
import org.gwtbootstrap5.client.ui.constants.Gutter;
import org.gwtbootstrap5.client.ui.constants.GutterX;
import org.gwtbootstrap5.client.ui.constants.GutterY;
import org.gwtbootstrap5.client.ui.constants.RowContentJustifyAlign;
import org.gwtbootstrap5.client.ui.constants.RowContentVerticalAlign;
import org.gwtbootstrap5.client.ui.constants.Styles;
import org.gwtbootstrap5.client.ui.html.Div;

import com.google.gwt.dom.client.Style;

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

    private static final String SEPARATOR = "[, ]+";

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

    /**
     * Sets the gutters of the row on both axes ({@code g-*}), one per breakpoint, replacing the
     * previous ones.
     *
     * @param gutters the gutters, such as {@code Gutter.XS_2, Gutter.MD_4}
     */
    public void setGutter(final Gutter... gutters) {
        setEnumStyleNames(Gutter.class, gutters);
    }

    /**
     * Sets the gutters of the row on both axes ({@code g-*}), replacing the previous ones.
     *
     * @param gutters {@link Gutter} names separated by spaces or commas, e.g. {@code "XS_2 MD_4"}
     */
    public void setGutter(final String gutters) {
        setEnumStyleNames(Gutter.class, gutters);
    }

    /**
     * Sets the horizontal gutters of the row ({@code gx-*}), one per breakpoint, replacing the
     * previous ones.
     *
     * @param gutters the gutters, such as {@code GutterX.XS_0}
     */
    public void setGutterX(final GutterX... gutters) {
        setEnumStyleNames(GutterX.class, gutters);
    }

    /**
     * Sets the horizontal gutters of the row ({@code gx-*}), replacing the previous ones.
     *
     * @param gutters {@link GutterX} names separated by spaces or commas, e.g. {@code "XS_0 LG_3"}
     */
    public void setGutterX(final String gutters) {
        setEnumStyleNames(GutterX.class, gutters);
    }

    /**
     * Sets the vertical gutters of the row ({@code gy-*}), one per breakpoint, replacing the
     * previous ones.
     *
     * @param gutters the gutters, such as {@code GutterY.XS_3}
     */
    public void setGutterY(final GutterY... gutters) {
        setEnumStyleNames(GutterY.class, gutters);
    }

    /**
     * Sets the vertical gutters of the row ({@code gy-*}), replacing the previous ones.
     *
     * @param gutters {@link GutterY} names separated by spaces or commas, e.g. {@code "XS_3"}
     */
    public void setGutterY(final String gutters) {
        setEnumStyleNames(GutterY.class, gutters);
    }

    @SafeVarargs
    private final <E extends Enum<? extends Style.HasCssName>> void setEnumStyleNames(final Class<E> enumClass,
                                                                                      final E... values) {
        StyleHelper.removeEnumStyleNames(this, enumClass);
        for (final E value : values) {
            if (value != null) {
                addStyleName(((Style.HasCssName) value).getCssName());
            }
        }
    }

    private <E extends Enum<? extends Style.HasCssName>> void setEnumStyleNames(final Class<E> enumClass,
                                                                                final String names) {
        StyleHelper.removeEnumStyleNames(this, enumClass);
        for (final String name : names.trim().split(SEPARATOR)) {
            final E value = EnumHelper.fromEnumName(name.toUpperCase(), enumClass, null);
            if (value != null) {
                addStyleName(((Style.HasCssName) value).getCssName());
            }
        }
    }
}
