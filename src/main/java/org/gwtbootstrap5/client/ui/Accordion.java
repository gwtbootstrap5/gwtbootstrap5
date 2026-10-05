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
import org.gwtbootstrap5.client.ui.constants.Styles;
import org.gwtbootstrap5.client.ui.html.Div;

import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.Widget;

/**
 * Accordion: {@link AccordionItem}s whose bodies collapse, by default only one open at a time.
 * <h2>UiBinder example</h2>
 * <pre>{@code
 *     <b:Accordion>
 *         <b:AccordionItem open="true">
 *             <b:AccordionHeader text="First"/>
 *             <b:AccordionBody>...</b:AccordionBody>
 *         </b:AccordionItem>
 *         <b:AccordionItem>
 *             <b:AccordionHeader text="Second"/>
 *             <b:AccordionBody>...</b:AccordionBody>
 *         </b:AccordionItem>
 *     </b:Accordion>
 * }</pre>
 *
 * @see <a href="https://getbootstrap.com/docs/5.3/components/accordion/">Bootstrap 5 documentation</a>
 */
public class Accordion extends Div {

    private boolean alwaysOpen = false;

    public Accordion() {
        super();

        setStyleName(Styles.ACCORDION);
    }

    /**
     * Removes the outer borders and rounded corners, to render the accordion edge to edge with its
     * parent ({@code accordion-flush}).
     */
    public void setFlush(final boolean flush) {
        if (flush) {
            addStyleName(Styles.ACCORDION_FLUSH);
        } else {
            removeStyleName(Styles.ACCORDION_FLUSH);
        }
    }

    public boolean isFlush() {
        return StyleHelper.containsStyle(getStyleName(), Styles.ACCORDION_FLUSH);
    }

    /**
     * When {@code true}, opening an item leaves the others open. By default opening one closes the
     * others: each body gets {@code data-bs-parent} pointing to the accordion.
     */
    public void setAlwaysOpen(final boolean alwaysOpen) {
        this.alwaysOpen = alwaysOpen;
        for (final Widget child : getChildren()) {
            if (child instanceof AccordionItem && child.isAttached()) {
                ((AccordionItem) child).link();
            }
        }
    }

    public boolean isAlwaysOpen() {
        return alwaysOpen;
    }

    /**
     * @return the accordion's id, generated if it has none
     */
    String ensureId() {
        if (getId() == null || getId().isEmpty()) {
            setId(DOM.createUniqueId());
        }
        return getId();
    }
}
