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

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.SpanElement;
import com.google.gwt.uibinder.client.UiConstructor;
import org.gwtbootstrap5.client.ui.base.HasEmphasis;
import org.gwtbootstrap5.client.ui.base.HasType;
import org.gwtbootstrap5.client.ui.base.helper.RoleHelper;
import org.gwtbootstrap5.client.ui.base.helper.StyleHelper;
import org.gwtbootstrap5.client.ui.constants.Emphasis;
import org.gwtbootstrap5.client.ui.constants.Roles;
import org.gwtbootstrap5.client.ui.constants.SpinnerType;
import org.gwtbootstrap5.client.ui.constants.Styles;
import org.gwtbootstrap5.client.ui.html.Div;

public class Spinner extends Div implements HasType<SpinnerType>, HasEmphasis {

    public Spinner(SpinnerType spinnerType) {
        this(spinnerType, "Loading...");
    }

    @UiConstructor
    public Spinner(SpinnerType spinnerType, String defaultText) {
        super();

        RoleHelper.setRole(getElement(), Roles.STATUS);

        SpanElement spanElement = Document.get().createSpanElement();
        spanElement.setClassName(Styles.VISUALLY_HIDDEN);
        spanElement.setInnerText(defaultText);
        getElement().appendChild(spanElement);

        setType(spinnerType);
    }

    @Override
    public void setType(SpinnerType type) {
        StyleHelper.addUniqueEnumStyleName(this, SpinnerType.class, type);
    }

    @Override
    public SpinnerType getType() {
        return SpinnerType.fromStyleName(getStyleName());
    }

    @Override
    public void setEmphasis(Emphasis emphasis) {
        StyleHelper.addUniqueEnumStyleName(this, Emphasis.class, emphasis);
    }

    @Override
    public Emphasis getEmphasis() {
        return Emphasis.fromStyleName(getStyleName());
    }

    public void setSmall(boolean isSmall) {
        if (isSmall) {
            if (getType() == SpinnerType.BORDER) {
                addStyleName(Styles.SPINNER_BORDER_SM);
            } else if (getType() == SpinnerType.GROW) {
                addStyleName(Styles.SPINNER_GROW_SM);
            }
        } else {
            if (getType() == SpinnerType.BORDER) {
                removeStyleName(Styles.SPINNER_BORDER_SM);
            } else if (getType() == SpinnerType.GROW) {
                removeStyleName(Styles.SPINNER_GROW_SM);
            }
        }
    }


}
