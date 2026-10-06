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

import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.Widget;

/**
 * Breadcrumb: the location of the current page in a navigational hierarchy, as an
 * {@code ol.breadcrumb} of items. Each child gets {@code breadcrumb-item}, and the last one is the
 * current page: when the breadcrumb is first attached it gets {@code active} and
 * {@code aria-current="page"}.
 * <h2>UiBinder example</h2>
 * <pre>{@code
 *     <b:Breadcrumbs>
 *         <b:AnchorListItem text="Home" targetHistoryToken="home"/>
 *         <b:AnchorListItem text="Library" targetHistoryToken="library"/>
 *         <b:AnchorListItem text="Data"/>
 *     </b:Breadcrumbs>
 * }</pre>
 *
 * @see <a href="https://getbootstrap.com/docs/5.3/components/breadcrumb/">Bootstrap 5 documentation</a>
 *
 * @author Joshua Godi
 */
public class Breadcrumbs extends OrderedList {

    /** Creates an empty breadcrumb. */
    public Breadcrumbs() {
        super();

        setStyleName(Styles.BREADCRUMB);
    }

    /**
     * Creates a breadcrumb with the given items.
     *
     * @param widgets the items, the last one being the current page
     */
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
            lastWidget.getElement().setAttribute("aria-current", "page");
        }

        super.onAttach();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void add(final Widget w) {
        w.addStyleName(Styles.BREADCRUMB_ITEM);
        // An AnchorListItem's link is a nav-link, which is a padded block that squeezes the item
        final Element link = w.getElement().getFirstChildElement();
        if (link != null && link.hasClassName(Styles.NAV_LINK)) {
            link.removeClassName(Styles.NAV_LINK);
        }
        super.add(w);
    }

}
