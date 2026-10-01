package org.gwtbootstrap5.client.ui.html;

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

import org.gwtbootstrap5.client.ui.base.AbstractTextWidget;
import org.gwtbootstrap5.client.ui.base.mixin.AttributeMixin;
import org.gwtbootstrap5.client.ui.base.mixin.EnabledMixin;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.OptionElement;
import com.google.gwt.user.client.TakesValue;
import com.google.gwt.user.client.ui.HasEnabled;
import com.google.gwt.user.client.ui.HasName;

/**
 * Select option widget.
 *
 * @author Xiaodong Sun
 */
public class Option extends AbstractTextWidget implements HasName, TakesValue<String>, HasEnabled {

    private final AttributeMixin<Option> attrMixin = new AttributeMixin<>(this);
    private final EnabledMixin<Option> enabledMixin = new EnabledMixin<>(this);

    private static final String NAME = "name";
    private static final String VALUE = "value";

    public Option() {
        super(Document.get().createOptionElement());
    }

    /**
     * Returns the {@link OptionElement}.
     *
     * @return the {@link OptionElement}.
     */
    public OptionElement getSelectElement() {
        return getElement().cast();
    }

    /**
     * Returns <code>true</code> if the option is selected.
     *
     * @return <code>true</code> if the option is selected
     */
    public boolean isSelected() {
        return getSelectElement().isSelected();
    }

    /**
     * Selects/deselects the option.
     *
     * @param selected e
     */
    public void setSelected(boolean selected) {
        getSelectElement().setSelected(selected);
    }

    @Override
    public void setName(final String name) {
        if (name != null)
            attrMixin.setAttribute(NAME, name);
        else
            attrMixin.removeAttribute(NAME);
    }

    @Override
    public String getName() {
        String name = attrMixin.getAttribute(NAME);
        return name.isEmpty() ? null : name;
    }

    @Override
    public void setValue(final String value) {
        if (value != null)
            attrMixin.setAttribute(VALUE, value);
        else
            attrMixin.removeAttribute(VALUE);
    }

    /**
     * Returns the value of the option. If no value, fall-back
     * to the displayed option text.
     */
    @Override
    public String getValue() {
        String value = attrMixin.getAttribute(VALUE);
        return value.isEmpty() ? getText() : value;
    }

    @Override
    public boolean isEnabled() {
        return enabledMixin.isEnabled();
    }

    @Override
    public void setEnabled(final boolean enabled) {
        enabledMixin.setEnabled(enabled);
    }

}
