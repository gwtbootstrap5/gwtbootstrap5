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

import java.util.HashMap;
import java.util.Map;

import org.gwtbootstrap5.client.ui.base.ComplexWidget;
import org.gwtbootstrap5.client.ui.base.mixin.AttributeMixin;
import org.gwtbootstrap5.client.ui.base.mixin.EnabledMixin;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.OptionElement;
import com.google.gwt.user.client.ui.HasEnabled;
import com.google.gwt.user.client.ui.Widget;

/**
 * Select option group widget.
 *
 * @author Xiaodong Sun
 */
public class OptGroup extends ComplexWidget implements HasEnabled {

    private final Map<OptionElement, Option> itemMap = new HashMap<>(0);
    private final AttributeMixin<OptGroup> attrMixin = new AttributeMixin<>(this);
    private final EnabledMixin<OptGroup> enabledMixin = new EnabledMixin<>(this);

    private static final String LABEL = "label";

    public OptGroup() {
        setElement(Document.get().createOptGroupElement());
    }

    /**
     * Set the label of the option group.
     *
     * @param label label
     */
    public void setLabel(final String label) {
        if (label != null)
            attrMixin.setAttribute(LABEL, label);
        else
            attrMixin.removeAttribute(LABEL);
    }

    /**
     * Returns the label of the option group; may be <code>null</code>.
     *
     * @return the label of the option group
     */
    public String getLabel() {
        String label = attrMixin.getAttribute(LABEL);
        return label.isEmpty() ? null : label;
    }

    @Override
    public boolean isEnabled() {
        return enabledMixin.isEnabled();
    }

    @Override
    public void setEnabled(final boolean enabled) {
        enabledMixin.setEnabled(enabled);
    }

    @Override
    public void add(Widget child) {
        super.add(child);
        updateItemMap(child, true);
    }

    @Override
    public void insert(Widget child, int beforeIndex) {
        super.insert(child, beforeIndex);
        updateItemMap(child, true);
    }

    @Override
    public boolean remove(Widget w) {
        boolean removed = super.remove(w);
        if (removed) {
            updateItemMap(w, false);
        }
        return removed;
    }

    public Map<OptionElement, Option> getItemMap() {
        return itemMap;
    }

    private void updateItemMap(Widget widget, boolean toAdd) {
        // Not option element ==> ignore it
        if (!(widget instanceof Option option))
            return;

        // Update item map
        if (toAdd) {
            itemMap.put(option.getSelectElement(), option);
        } else {
            itemMap.remove(option.getSelectElement());
        }
    }
}
