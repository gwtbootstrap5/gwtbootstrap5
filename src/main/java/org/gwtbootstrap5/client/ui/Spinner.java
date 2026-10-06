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

/**
 * Spinner: a loading indicator, a spinning border or a growing dot, with a text for screen
 * readers.
 * <h2>UiBinder example</h2>
 * <pre>{@code
 *     <b:Spinner spinnerType="BORDER" defaultText="Loading..." emphasis="PRIMARY"/>
 * }</pre>
 *
 * @see <a href="https://getbootstrap.com/docs/5.3/components/spinners/">Bootstrap 5 documentation</a>
 */
public class Spinner extends Div implements HasType<SpinnerType>, HasEmphasis {

    /**
     * Creates a spinner with the text "Loading..." for screen readers.
     *
     * @param spinnerType a spinning border or a growing dot
     */
    public Spinner(SpinnerType spinnerType) {
        this(spinnerType, "Loading...");
    }

    /**
     * Creates a spinner ({@code div} with role {@code status}).
     *
     * @param spinnerType a spinning border or a growing dot
     * @param defaultText the text for screen readers
     */
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

    /**
     * Makes the spinner small ({@code spinner-border-sm} or {@code spinner-grow-sm}). Set the type
     * first.
     *
     * @param isSmall {@code true} for a small spinner
     */
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
