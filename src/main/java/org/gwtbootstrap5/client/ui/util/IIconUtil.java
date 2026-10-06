package org.gwtbootstrap5.client.ui.util;

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

import com.google.gwt.user.client.ui.UIObject;
import org.gwtbootstrap5.client.ui.constants.IconType;

import java.util.List;

/**
 * Resolves the icons of the icon set in use: Bootstrap Icons by default, Font Awesome with the
 * extras' module.
 */
public interface IIconUtil {

    /**
     * Returns every icon of the set.
     *
     * @return the icons
     */
    List<IconType> getValues();

    /**
     * Returns the icon of a name.
     *
     * @param enumName the name of the constant, such as {@code "STAR_FILL"}
     * @return the icon, or {@code null} if there is none of that name
     */
    IconType fromIconType(final String enumName);

    /**
     * Returns the icon whose class is in a list of style names.
     *
     * @param styleName space-separated style names
     * @return the icon, or {@code null} if none is there
     */
    IconType fromStyleName(final String styleName);

    /**
     * Sets the icon of a widget, replacing the icon classes it had.
     *
     * @param uiObject the widget
     * @param type the icon
     */
    void setType(final UIObject uiObject, final IconType type);

}
