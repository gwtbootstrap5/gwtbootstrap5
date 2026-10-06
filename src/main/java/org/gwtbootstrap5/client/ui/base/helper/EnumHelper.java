package org.gwtbootstrap5.client.ui.base.helper;

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

import com.google.gwt.dom.client.Style;

/**
 * Finds the enum constant of a name or of a style name, for the {@code fromStyleName} methods of
 * the constants.
 *
 * @author Sven Jacobs
 */
public final class EnumHelper {

    /**
     * Returns the enum constant with the given name.
     *
     * @param <E> the enum type
     * @param enumName the name of the constant, such as {@code "PRIMARY"}
     * @param enumClass the enum
     * @param defaultValue returned when no constant has that name
     * @return the constant, or the default value
     */
    @SuppressWarnings("unchecked")
    public static <E extends Enum<?>> E fromEnumName(final String enumName,
                                                   final Class<E> enumClass,
                                                   final E defaultValue) {
        if (enumName == null || enumClass == null) {
            return defaultValue;
        }

        for (final E constant : enumClass.getEnumConstants()) {
            if (constant != null && constant.name().equals(enumName)) {
                return constant;
            }
        }

        return defaultValue;
    }

    /**
     * Returns the first enum constant whose CSS class is in a space-separated list of style names.
     *
     * @param <E> the enum type
     * @param styleName    Space-separated list of styles
     * @param enumClass    Type of enum
     * @param defaultValue Default value of no match was found
     * @return First enum constant found or default value
     */
    @SuppressWarnings("unchecked")
    public static <E extends Enum<? extends Style.HasCssName>> E fromStyleName(final String styleName,
                                                                               final Class<E> enumClass,
                                                                               final E defaultValue) {
        if (styleName == null || enumClass == null) {
            return defaultValue;
        }

        for (final Enum<? extends Style.HasCssName> constant : enumClass.getEnumConstants()) {
            final Style.HasCssName anEnum = (Style.HasCssName) constant;
            final String cssClass = anEnum.getCssName();

            if (cssClass != null && StyleHelper.containsStyle(styleName, cssClass)) {
                return (E) anEnum;
            }
        }

        return defaultValue;
    }

    private EnumHelper() {
    }
}
