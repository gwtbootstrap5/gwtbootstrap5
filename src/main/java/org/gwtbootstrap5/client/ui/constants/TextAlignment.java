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
import org.gwtbootstrap5.client.ui.base.helper.EnumHelper;

/**
 * Text alignment at a breakpoint: {@code text-start}, {@code text-center} or {@code text-end}, with
 * the breakpoint variants ({@code text-md-start}, ...).
 *
 * @author Sven Jacobs
 * @author Joshua Godi
 * @see <a href="https://getbootstrap.com/docs/5.3/utilities/text/#text-alignment">Bootstrap 5 documentation</a>
 */
public enum TextAlignment implements Style.HasCssName {
    LEFT_XS("text-start"),
    LEFT_SM("text-sm-start"),
    LEFT_MD("text-md-start"),
    LEFT_LG("text-lg-start"),
    LEFT_XL("text-xl-start"),
    LEFT_XXL("text-xxl-start"),
    RIGHT_XS("text-end"),
    RIGHT_SM("text-sm-end"),
    RIGHT_MD("text-md-end"),
    RIGHT_LG("text-lg-end"),
    RIGHT_XL("text-xl-end"),
    RIGHT_XXL("text-xxl-end"),
    CENTER_XS("text-center"),
    CENTER_SM("text-sm-center"),
    CENTER_MD("text-md-center"),
    CENTER_LG("text-lg-center"),
    CENTER_XL("text-xl-center"),
    CENTER_XXL("text-xxl-center");

    private final String cssClass;

    TextAlignment(final String cssClass) {
        this.cssClass = cssClass;
    }

    @Override
    public String getCssName() {
        return cssClass;
    }

    /**
     * Returns the constant whose class is in a space-separated list of style names.
     *
     * @param styleName the style names, such as those of a widget
     * @return the constant, or {@code LEFT_XS} if none
     */
    public static TextAlignment fromStyleName(final String styleName) {
        return EnumHelper.fromStyleName(styleName, TextAlignment.class, LEFT_XS);
    }
}
