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

import org.gwtbootstrap5.client.ui.base.helper.EnumHelper;

import com.google.gwt.dom.client.Style;

/**
 * Float of a widget at a breakpoint: {@code float-start}, {@code float-end} or {@code float-none},
 * with the breakpoint variants ({@code float-md-start}, ...).
 *
 * @author Sven Jacobs
 * @author Joshua Godi
 * @see <a href="https://getbootstrap.com/docs/5.3/utilities/float/">Bootstrap 5 documentation</a>
 */
public enum FloatCSS implements Style.HasCssName {
    NONE_XS("float-none"),
    NONE_SM("float-sm-none"),
    NONE_MD("float-md-none"),
    NONE_LG("float-lg-none"),
    NONE_XL("float-xl-none"),
    NONE_XXL("float-xxl-none"),
    LEFT_XS("float-start"),
    LEFT_SM("float-sm-start"),
    LEFT_MD("float-md-start"),
    LEFT_LG("float-lg-start"),
    LEFT_XL("float-xl-start"),
    LEFT_XXL("float-xxl-start"),
    RIGHT_XS("float-end"),
    RIGHT_SM("float-sm-end"),
    RIGHT_MD("float-md-end"),
    RIGHT_LG("float-lg-end"),
    RIGHT_XL("float-xl-end"),
    RIGHT_XXL("float-xxl-end");

    private final String cssClass;

    FloatCSS(final String cssClass) {
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
     * @return the constant, or {@code NONE_XS} if none
     */
    public static FloatCSS fromStyleName(final String styleName) {
        return EnumHelper.fromStyleName(styleName, FloatCSS.class, NONE_XS);
    }
}
