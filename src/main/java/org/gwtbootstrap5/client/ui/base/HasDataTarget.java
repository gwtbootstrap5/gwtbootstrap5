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

import java.util.List;

import com.google.gwt.user.client.ui.Widget;


/**
 * A widget with a {@code data-bs-target} attribute: the element its toggle opens, such as a
 * modal, a collapse or a tab pane.
 *
 * @author Sven Jacobs
 */
public interface HasDataTarget {

    /**
     * Targets a widget, giving it an id if it has none.
     *
     * @param widget the target
     */
    void setDataTargetWidget(Widget widget);

    /**
     * Targets several widgets, through a class generated and added to each of them.
     *
     * @param widget the targets
     */
    void setDataTargetWidgets(List<Widget> widget);

    /**
     * Sets the data target for the widget
     *
     * @param dataTarget data target string
     */
    void setDataTarget(String dataTarget);

    /**
     * Gets the data target of the widget
     *
     * @return data target
     */
    String getDataTarget();
}
