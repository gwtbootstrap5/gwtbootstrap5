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
 * {@code display: block} from a breakpoint up ({@code d-block}, {@code d-md-block}, ...), for the
 * responsive visibility of widgets.
 *
 * @see <a href="https://getbootstrap.com/docs/5.3/utilities/display/">Bootstrap 5 documentation</a>
 */
public enum ResponsivenessBlock implements Type, Style.HasCssName {
    XS("d-block"),
    SM("d-sm-block"),
    MD("d-md-block"),
    LG("d-lg-block"),
    XL("d-xl-block"),
    XXL("d-xxl-block"),
    PRINT("d-print-block");

    private final String cssClass;

    ResponsivenessBlock(final String cssClass) {
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
     * @return the constant, or {@code XS} if none
     */
    public static ResponsivenessBlock fromStyleName(final String styleName) {
        return EnumHelper.fromStyleName(styleName, ResponsivenessBlock.class, XS);
    }

}
