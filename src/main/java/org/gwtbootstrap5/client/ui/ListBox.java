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
import org.gwtbootstrap5.client.ui.base.HasId;
import org.gwtbootstrap5.client.ui.base.mixin.IdMixin;
import org.gwtbootstrap5.client.ui.constants.Styles;
import org.gwtbootstrap5.client.ui.constants.InputSize;

/**
 * Select ({@code select.form-select}) of GWT's {@code ListBox}, styled by Bootstrap and with an id.
 * <h2>UiBinder example</h2>
 * <pre>{@code
 *     <b:ListBox>
 *         <b:item value="1">One</b:item>
 *         <b:item value="2">Two</b:item>
 *     </b:ListBox>
 * }</pre>
 *
 * @author Sven Jacobs
 * @see com.google.gwt.user.client.ui.ListBox
 * @see <a href="https://getbootstrap.com/docs/5.3/forms/select/">Bootstrap 5 documentation</a>
 */
public class ListBox extends com.google.gwt.user.client.ui.ListBox implements HasId {

    private final IdMixin<ListBox> idMixin = new IdMixin<>(this);

    /**
     * Creates an empty list box in single selection mode.
     */
    public ListBox() {
        super();
        setStyleName(Styles.FORM_SELECT);
    }

    @Override
    public void setId(final String id) {
        idMixin.setId(id);
    }

    @Override
    public String getId() {
        return idMixin.getId();
    }

    /**
     * Makes the select larger or smaller ({@code form-select-lg} or {@code form-select-sm}).
     *
     * @param size {@code LARGE}, {@code SMALL}, or {@code DEFAULT} / {@code null} for the normal size
     */
    public void setSize(final InputSize size) {
        removeStyleName(Styles.FORM_SELECT_LG);
        removeStyleName(Styles.FORM_SELECT_SM);
        if (size == InputSize.LARGE) {
            addStyleName(Styles.FORM_SELECT_LG);
        } else if (size == InputSize.SMALL) {
            addStyleName(Styles.FORM_SELECT_SM);
        }
    }

    /**
     * Returns the size of the select.
     *
     * @return {@code LARGE}, {@code SMALL} or {@code DEFAULT}
     */
    public InputSize getSize() {
        if (StyleHelper.containsStyle(getStyleName(), Styles.FORM_SELECT_LG)) {
            return InputSize.LARGE;
        }
        return StyleHelper.containsStyle(getStyleName(), Styles.FORM_SELECT_SM) ? InputSize.SMALL : InputSize.DEFAULT;
    }
}
