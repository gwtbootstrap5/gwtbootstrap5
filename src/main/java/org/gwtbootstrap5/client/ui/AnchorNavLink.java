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
import org.gwtbootstrap5.client.ui.base.HasRole;
import org.gwtbootstrap5.client.ui.base.helper.RoleHelper;
import org.gwtbootstrap5.client.ui.base.mixin.ActiveMixin;
import org.gwtbootstrap5.client.ui.constants.Styles;

/**
 * Anchor with Bootstrap's {@code nav-link} class that can be marked active: the link inside an
 * {@link AnchorListItem}, returned by {@code getAnchor()}. The containers that are not navs replace
 * {@code nav-link} with their own class ({@code dropdown-item}, {@code page-link}) or remove it
 * (breadcrumbs).
 *
 * @see <a href="https://getbootstrap.com/docs/5.3/components/navs-tabs/">Bootstrap 5 documentation</a>
 */
public class AnchorNavLink extends Anchor implements HasActive, HasRole {

    private final ActiveMixin<AnchorNavLink> activeMixin = new ActiveMixin<>(this);

    /** Creates an empty link. */
    public AnchorNavLink() {
        addStyleName(Styles.NAV_LINK);
    }

    @Override
    public void setActive(boolean active) {
        activeMixin.setActive(active);
    }

    @Override
    public boolean isActive() {
        return activeMixin.isActive();
    }

    @Override
    public void setRole(String role) {
        RoleHelper.setRole(getElement(), role);
    }

    @Override
    public String getRole() {
        return RoleHelper.getRole(getElement());
    }
}
