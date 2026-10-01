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

import org.gwtbootstrap5.client.ui.base.HasPaginationSize;
import org.gwtbootstrap5.client.ui.base.HasResponsiveness;
import org.gwtbootstrap5.client.ui.base.helper.StyleHelper;
import org.gwtbootstrap5.client.ui.constants.IconTypeBI;
import org.gwtbootstrap5.client.ui.constants.PaginationSize;
import org.gwtbootstrap5.client.ui.constants.Styles;
import org.gwtbootstrap5.client.ui.html.UnorderedList;

import com.google.gwt.user.cellview.client.SimplePager;

/**
 * Support for Bootstrap pagination (<a href="http://getbootstrap.com/components/#pagination">...</a>)
 *
 * @author Joshua Godi
 */
public class Pagination extends UnorderedList implements HasResponsiveness, HasPaginationSize {

    public Pagination() {
        super();

        setStyleName(Styles.PAGINATION);
    }

    public Pagination(final PaginationSize paginationSize) {
        this();
        setPaginationSize(paginationSize);
    }

    @Override
    public void setPaginationSize(final PaginationSize paginationSize) {
        StyleHelper.addUniqueEnumStyleName(this, PaginationSize.class, paginationSize);
    }

    @Override
    public PaginationSize getPaginationSize() {
        return PaginationSize.fromStyleName(getStyleName());
    }

    public AnchorListItem addPreviousLink() {
        final AnchorListItem listItem = new AnchorListItem();
        listItem.setIcon(IconTypeBI.CHEVRON_DOUBLE_LEFT);
        insert(listItem, 0);
        return listItem;
    }

    public AnchorListItem addNextLink() {
        final AnchorListItem listItem = new AnchorListItem();
        listItem.setIcon(IconTypeBI.CHEVRON_DOUBLE_RIGHT);
        add(listItem);
        return listItem;
    }

    /**
     * This will help to rebuild the Pagination based on the data inside the SimplePager passed in.
     * <p/>
     * Make sure to all this after adding/remove data from any of the grid to ensure that this stays
     * current with the SimplePager.
     * <p/>
     * ex.
     * dataProvider.getList().addAll(newData);
     * pagination.rebuild(mySimplePager);
     *
     * @param pager the SimplePager of the CellTable/DataGrid
     */
    public void rebuild(final SimplePager pager) {
        clear();

        if (pager.getPageCount() == 0) {
            return;
        }

        final AnchorListItem prev = addPreviousLink();
        prev.addClickHandler(event -> {
            pager.previousPage();
            updatePaginationState(pager);
        });
        prev.setEnabled(pager.hasPreviousPage());

        for (int i = 0; i < pager.getPageCount(); i++) {
            final int display = i + 1;
            final AnchorListItem page = new AnchorListItem(String.valueOf(display));
            page.addClickHandler(event -> {
                pager.setPage(display - 1);
                updatePaginationState(pager);
            });

            if (i == pager.getPage()) {
                page.setActive(true);
            }

            add(page);
        }

        final AnchorListItem next = addNextLink();
        next.addClickHandler(event -> {
            pager.nextPage();
            updatePaginationState(pager);
        });
        next.setEnabled(pager.hasNextPage());
    }

    /**
     * This updates the current active page, and the enabled state
     * of the previous and next buttons in the Pagination based
     * on the state of the given SimplePager.
     * @param pager the SimplePager of the CellTable/DataGrid
     */
    private void updatePaginationState(final SimplePager pager) {
        for (int i = 0; i < getWidgetCount(); i++) {
            if (i == 0) { //previous button
                ((AnchorListItem)getWidget(i)).setEnabled(pager.hasPreviousPage());
            }
            else if (i == getWidgetCount() - 1) { //next button
                ((AnchorListItem)getWidget(i)).setEnabled(pager.hasNextPage());
            }
            else {
                int index = i - 1;
                ((AnchorListItem)getWidget(i)).setActive(index == pager.getPage());
            }
        }
   }
}
