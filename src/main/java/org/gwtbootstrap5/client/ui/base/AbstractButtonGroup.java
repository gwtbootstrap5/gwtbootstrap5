package org.gwtbootstrap5.client.ui.base;

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
import org.gwtbootstrap5.client.ui.base.mixin.DataToggleMixin;
import org.gwtbootstrap5.client.ui.base.mixin.FloatMixin;
import org.gwtbootstrap5.client.ui.constants.*;
import org.gwtbootstrap5.client.ui.constants.FloatCSS;
import org.gwtbootstrap5.client.ui.gwt.FlowPanel;

import com.google.gwt.user.client.ui.HasName;
import com.google.gwt.user.client.ui.Widget;

/**
 * Abstract base class for button groups.
 *
 * @author Sven Jacobs
 * @author Joshua Godi
 * @see org.gwtbootstrap5.client.ui.ButtonGroup
 * @see org.gwtbootstrap5.client.ui.VerticalButtonGroup
 */
public abstract class AbstractButtonGroup extends FlowPanel implements HasName, HasSize<ButtonGroupSize>,
        HasDataToggle, HasFloat, HasResponsiveness {

    private final FloatMixin<AbstractButtonGroup> floatMixin = new FloatMixin<>(this);
    private final DataToggleMixin<AbstractButtonGroup> toggleMixin = new DataToggleMixin<>(this);
    private String name;

    protected AbstractButtonGroup() {
        setStyleName(Styles.BTN_GROUP);
    }

    protected AbstractButtonGroup(final String styleName) {
        setStyleName(Styles.BTN_GROUP);
        addStyleName(styleName);
    }

    /**
     * Convenience method that will set the name of all child widgets that can have a name
     *
     * @param name Name of group
     * @see #add(com.google.gwt.user.client.ui.Widget)
     */
    @Override
    public void setName(final String name) {
        this.name = name;

        if (name == null) {
            return;
        }

        for (final Widget w : getChildren()) {
            if (w instanceof HasName) {
                ((HasName) w).setName(name);
            }
        }
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setSize(ButtonGroupSize size) {
        StyleHelper.addUniqueEnumStyleName(this, ButtonGroupSize.class, size);
    }

    @Override
    public ButtonGroupSize getSize() {
        return ButtonGroupSize.fromStyleName(getStyleName());
    }

    @Override
    public void setDataToggle(final Toggle toggle) {
        toggleMixin.setDataToggle(toggle);
    }

    @Override
    public Toggle getDataToggle() {
        return toggleMixin.getDataToggle();
    }

    @Override
    public void setFloat(final FloatCSS aFloatCSS) {
        floatMixin.setFloat(aFloatCSS);
    }

    @Override
    public FloatCSS getFloat() {
        return floatMixin.getFloat();
    }

    @Override
    public void setVisibleOn(final DeviceSize deviceSize) {
        StyleHelper.setVisibleOn(this, deviceSize);
    }

    @Override
    public void setHiddenOn(final DeviceSize deviceSize) {
        StyleHelper.setHiddenOn(this, deviceSize);
    }

    /**
     * Makes this a "drop up" container for dropdown menus where the menu opens upwards.
     *
     * @param dropUp display up or not
     */
    public void setDropUp(final boolean dropUp) {
        if (dropUp) {
            addStyleName(Styles.DROP_UP);
        } else {
            removeStyleName(Styles.DROP_UP);
        }
    }

    @Override
    public void add(final Widget w) {
        super.add(w);

        if (name == null) {
            return;
        }

        // Add group's name to child widgets that can have a name
        if (w instanceof HasName) {
            ((HasName) w).setName(name);
        }
    }
}
