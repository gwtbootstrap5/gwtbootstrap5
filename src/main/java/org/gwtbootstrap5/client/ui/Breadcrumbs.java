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

import org.gwtbootstrap5.client.ui.constants.Styles;
import org.gwtbootstrap5.client.ui.html.OrderedList;

import com.google.gwt.user.client.ui.Widget;

/**
 * @author Joshua Godi
 */
public class Breadcrumbs extends OrderedList {

    public Breadcrumbs() {
        super();

        setStyleName(Styles.BREADCRUMB);
    }

    public Breadcrumbs(final Widget... widgets) {
        this();

        for (final Widget widget : widgets) {
            add(widget);
        }
    }

    @Override
    protected void onAttach() {
        if (!isOrWasAttached() && getChildren().size() > 0) {
            final Widget lastWidget = getChildren().get(getChildren().size() - 1);
            lastWidget.addStyleName(Styles.ACTIVE);
        }

        super.onAttach();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void add(final Widget w) {
        w.addStyleName(Styles.BREADCRUMB_ITEM);
        w.addStyleName(Styles.ACTIVE);
        super.add(w);
    }

}
