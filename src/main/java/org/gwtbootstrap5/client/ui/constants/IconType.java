package org.gwtbootstrap5.client.ui.constants;

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
 * An icon of an icon set: Bootstrap Icons ({@link IconTypeBI}) in core, Font Awesome in the extras.
 */
public interface IconType extends Type, Style.HasCssName {

    /**
     * Returns the position of the icon in its set.
     *
     * @return the position, as a string
     */
    String getOrdinal();

    /**
     * Returns the name of the icon: the name of its constant.
     *
     * @return the name, such as {@code "STAR_FILL"}
     */
    String getName();

}
