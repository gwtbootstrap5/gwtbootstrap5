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

import org.gwtbootstrap5.client.ui.constants.ColumnOffset;
import org.gwtbootstrap5.client.ui.constants.ColumnOrder;
import org.gwtbootstrap5.client.ui.constants.ColumnSize;
import org.gwtbootstrap5.client.ui.html.Div;

import com.google.gwt.dom.client.Style;
import com.google.gwt.uibinder.client.UiConstructor;
import com.google.gwt.user.client.ui.Widget;

/**
 * Column of Bootstrap's grid ({@code col-*}), inside a {@link Row}: its sizes say how many of the
 * twelve columns it spans at each breakpoint, and it can be offset and reordered.
 * <h2>UiBinder example</h2>
 * <pre>{@code
 *     <b:Row>
 *         <b:Column size="XS_12 MD_8">Main</b:Column>
 *         <b:Column size="XS_12 MD_4">Side</b:Column>
 *     </b:Row>
 * }</pre>
 *
 * @author Sven Jacobs
 * @author Joshua Godi
 * @author Pontus Enmark
 * @see Row
 * @see <a href="https://getbootstrap.com/docs/5.3/layout/columns/">Bootstrap 5 documentation</a>
 */
public class Column extends Div {

    private static final String SEPARATOR = "[, ]+";

    /**
     * Creates a column with one size, and with one or more additional widgets added.
     * <p>
     * Additional sizes can be added with {@link #addSize(ColumnSize...)}.
     * Additional widgets can be added with {@link #add(Widget)}.
     *
     * @param size         Size of column
     * @param firstWidget  Widget to add
     * @param otherWidgets Other widgets to add
     */
    public Column(final ColumnSize size, final Widget firstWidget, final Widget... otherWidgets) {
        this(size);

        add(firstWidget);
        for (final Widget widget : otherWidgets) {
            add(widget);
        }
    }

    /**
     * Creates column with one or more additional sizes.
     * <p>
     * Additional sizes can be added with {@link #addSize(ColumnSize...)}
     *
     * @param firstSize  Size of column
     * @param otherSizes Other sizes of column
     * @see #addSize(ColumnSize...)
     */
    public Column(final ColumnSize firstSize, final ColumnSize... otherSizes) {
        super();

        setSize(firstSize, otherSizes);
    }

    /**
     * Convenience constructor for UiBinder to create a Column with one or more
     * sizes.
     * <p>
     * Size needs to be a space-separated String of {@link ColumnSize} enum
     * names, e.g. "SM_3 LG_3"
     *
     * @param size Space-separated String of {@link ColumnSize}
     * @see ColumnSize
     */
    @UiConstructor
    public Column(final String size) {
        super();

        setSize(size);
    }

    /**
     * Adds one or more additional column sizes.
     *
     * @param firstSize  Column size
     * @param otherSizes Additional column sizes
     */
    public void setSize(final ColumnSize firstSize, final ColumnSize... otherSizes) {
        addEnumVarargsValues(new ColumnSize[]{firstSize}, ColumnSize.class, true);
        addEnumVarargsValues(otherSizes, ColumnSize.class, false);
    }

    /**
     * Sets the sizes of the column, replacing the previous ones.
     *
     * @param sizes {@link ColumnSize} names separated by spaces or commas, e.g. {@code "XS_12 MD_6"}
     */
    public void setSize(final String sizes) {
        addEnumStringValues(sizes, ColumnSize.class, true);
    }

    /**
     * Adds sizes to the column.
     *
     * @param sizes the sizes to add
     */
    public void addSize(final ColumnSize... sizes) {
        addEnumVarargsValues(sizes, ColumnSize.class, false);
    }

    /**
     * Adds sizes to the column.
     *
     * @param sizes {@link ColumnSize} names separated by spaces or commas
     */
    public void addSize(final String sizes) {
        addEnumStringValues(sizes, ColumnSize.class, false);
    }

    /**
     * Sets the order of the column in its row ({@code order-*}), replacing the previous one.
     *
     * @param orders the orders, one per breakpoint
     */
    public void setOrder(final ColumnOrder... orders) {
        addEnumVarargsValues(orders, ColumnOrder.class, true);
    }

    /**
     * Sets the order of the column in its row ({@code order-*}), replacing the previous one.
     *
     * @param orders {@link ColumnOrder} names separated by spaces or commas, e.g. {@code "XS_2 MD_1"}
     */
    public void setOrder(final String orders) {
        addEnumStringValues(orders, ColumnOrder.class, true);
    }

    /**
     * Adds orders to the column, one per breakpoint.
     *
     * @param orders the orders to add
     */
    public void addOrder(final ColumnOrder... orders) {
        addEnumVarargsValues(orders, ColumnOrder.class, false);
    }

    /**
     * Adds orders to the column, one per breakpoint.
     *
     * @param orders {@link ColumnOrder} names separated by spaces or commas
     */
    public void addOrder(final String orders) {
        addEnumStringValues(orders, ColumnOrder.class, false);
    }

    /**
     * Sets the offset of the column ({@code offset-*}), replacing the previous one.
     *
     * @param offsets the offsets, one per breakpoint
     */
    public void setOffset(final ColumnOffset... offsets) {
        addEnumVarargsValues(offsets, ColumnOffset.class, true);
    }

    /**
     * Sets the offset of the column ({@code offset-*}), replacing the previous one.
     *
     * @param offsets {@link ColumnOffset} names separated by spaces or commas, e.g. {@code "MD_2"}
     */
    public void setOffset(final String offsets) {
        addEnumStringValues(offsets, ColumnOffset.class, true);
    }

    /**
     * Adds offsets to the column, one per breakpoint.
     *
     * @param offsets the offsets to add
     */
    public void addOffset(final ColumnOffset... offsets) {
        addEnumVarargsValues(offsets, ColumnOffset.class, false);
    }

    /**
     * Adds offsets to the column, one per breakpoint.
     *
     * @param offsets {@link ColumnOffset} names separated by spaces or commas
     */
    public void addOffset(final String offsets) {
        addEnumStringValues(offsets, ColumnOffset.class, false);
    }

    private <E extends Enum<? extends Style.HasCssName>> void addEnumVarargsValues(final E[] values,
                                                                                   final Class<E> enumClass,
                                                                                   final boolean clearOld) {
        if (clearOld) {
            // Remove the previous values
            removeStyleNames(enumClass);
        }

        for (final E value : values) {
            addStyleName(((Style.HasCssName) value).getCssName());
        }
    }

    private <E extends Enum<? extends Style.HasCssName>> void addEnumStringValues(final String values,
                                                                                  final Class<E> enumClass,
                                                                                  final boolean clearOld) {
        if (clearOld) {
            // Remove the previous values
            removeStyleNames(enumClass);
        }

        // Add new ones
        final String[] valuesSplit = values.split(SEPARATOR);
        for (final String value : valuesSplit) {
            for (final E constant : enumClass.getEnumConstants()) {
                if (value.equalsIgnoreCase(constant.name())) {
                    addStyleName(((Style.HasCssName) constant).getCssName());
                }
            }
        }
    }

    private <E extends Enum<? extends Style.HasCssName>> void removeStyleNames(final Class<E> enumClass) {
        for (final E constant : enumClass.getEnumConstants()) {
            removeStyleName(((Style.HasCssName) constant).getCssName());
        }
    }
}
