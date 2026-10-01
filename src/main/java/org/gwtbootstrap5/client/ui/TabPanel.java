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

import org.gwtbootstrap5.client.ui.base.HasActive;
import org.gwtbootstrap5.client.ui.base.helper.RoleHelper;
import org.gwtbootstrap5.client.ui.base.mixin.ActiveMixin;
import org.gwtbootstrap5.client.ui.constants.Attributes;
import org.gwtbootstrap5.client.ui.constants.Roles;
import org.gwtbootstrap5.client.ui.constants.Styles;
import org.gwtbootstrap5.client.ui.html.Div;

/**
 * Container widget for the tab pane
 * <p/>
 * <a href="http://getbootstrap.com/javascript/#tabs">Bootstrap Documentation</a>
 * <p/>
 * <h3>UiBinder example</h3>
 * <p/>
 * <pre>
 * {@code
 * <b:TabContent>
 *    <b:TabPanel/>
 *    <b:TabPanel/>
 * </b:TabContent>
 * }
 * </pre>
 *
 * @author Joshua Godi
 * @see org.gwtbootstrap5.client.ui.TabContent
 */
public class TabPanel extends Div implements HasActive {

    private final ActiveMixin<TabPanel> activeMixin = new ActiveMixin<>(this);

    /**
     * Creates the default widget with the default styles
     */
    public TabPanel() {
        super();

        setStyleName(Styles.TAB_PANEL);
        RoleHelper.setRole(getElement(), Roles.TABPANEL);
    }

    /**
     * Sets whether to fade the tab pane in/out when clicked
     * Must set in="true" on the first tab if using fade!!
     *
     * @param fade true=fade content in/out, false=don't fade
     */
    public void setFade(final boolean fade) {
        if (fade) {
            addStyleName(Styles.FADE);
        } else {
            removeStyleName(Styles.FADE);
        }
    }

    /**
     * When using fade, but set the first tabpanel with in="true" to work properly
     *
     * @param show whether the first tab pane will be faded properly
     */
    public void setShow(final boolean show) {
        if (show) {
            addStyleName(Styles.SHOW);
        } else {
            removeStyleName(Styles.SHOW);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setActive(final boolean active) {
        activeMixin.setActive(active);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isActive() {
        return activeMixin.isActive();
    }

    /**
     * {@inheritDoc}
     */
    public void setAriaLabelledBy(final String ariaLabelledBy) {
        if (ariaLabelledBy != null) {
            getElement().setAttribute(Attributes.ARIA_LABELLEDBY, ariaLabelledBy);
        } else {
            getElement().removeAttribute(Attributes.ARIA_LABELLEDBY);
        }
    }

    /**
     * {@inheritDoc}
     */
    public String getAriaLabelledBy() {
        return getElement().getAttribute(Attributes.ARIA_LABELLEDBY);
    }
}
