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
import org.gwtbootstrap5.client.ui.constants.RatioType;
import org.gwtbootstrap5.client.ui.constants.Styles;
import org.gwtbootstrap5.client.ui.html.Div;

/**
 * Keeps its child, usually an {@code iframe} or {@code video}, at an aspect ratio ({@code ratio});
 * 16:9 by default.
 * <h2>UiBinder example</h2>
 * <pre>{@code
 *     <b:Ratio type="R4X3">
 *         <g:Frame url="https://www.example.com/embed"/>
 *     </b:Ratio>
 * }</pre>
 *
 * @see <a href="https://getbootstrap.com/docs/5.3/helpers/ratio/">Bootstrap 5 documentation</a>
 */
public class Ratio extends Div {

    public Ratio() {
        super();

        setStyleName(Styles.RATIO);
        setType(RatioType.R16X9);
    }

    /**
     * @param type the ratio; {@code null} restores 16:9
     */
    public void setType(final RatioType type) {
        StyleHelper.addUniqueEnumStyleName(this, RatioType.class, type != null ? type : RatioType.R16X9);
    }

    public RatioType getType() {
        for (final RatioType type : RatioType.values()) {
            if (StyleHelper.containsStyle(getStyleName(), type.getCssName())) {
                return type;
            }
        }
        return null;
    }
}
