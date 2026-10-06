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


import org.gwtbootstrap5.client.ui.base.ComplexWidget;
import org.gwtbootstrap5.client.ui.base.HasHref;
import org.gwtbootstrap5.client.ui.base.helper.StyleHelper;
import org.gwtbootstrap5.client.ui.constants.Attributes;
import org.gwtbootstrap5.client.ui.constants.IconType;
import org.gwtbootstrap5.client.ui.constants.Styles;
import org.gwtbootstrap5.client.ui.html.Span;

import com.google.gwt.dom.client.AnchorElement;
import com.google.gwt.dom.client.Document;
import com.google.gwt.user.client.ui.HasText;

/**
 * Previous or next control of a {@link Carousel}: a link to the carousel's id, with an icon and
 * a visually hidden text for screen readers. Set either {@code prev} or {@code next}.
 * <h2>UiBinder example</h2>
 * <pre>{@code
 *     <b:CarouselControl prev="true" href="#slides" text="Previous"/>
 *     <b:CarouselControl next="true" href="#slides" text="Next"/>
 * }</pre>
 *
 * @see <a href="https://getbootstrap.com/docs/5.3/components/carousel/#with-controls">Bootstrap 5 documentation</a>
 *
 * @author Joshua Godi
 */
public class CarouselControl extends ComplexWidget implements HasHref, HasText {

    private static final String BUTTON = "button";

    private final AnchorElement anchorElem;
    private final Icon icon;
    private final Span span;

    /** Creates a control; set {@code prev} or {@code next} to choose which. */
    public CarouselControl() {
        super();

        // Anchor
        this.anchorElem = Document.get().createAnchorElement();
        setElement(anchorElem);
        anchorElem.setAttribute(Attributes.ROLE, BUTTON);

        // Icon
        icon = new Icon();
        add(icon);

        // Span (SR_ONLY)
        span = new Span();
        span.setStyleName(Styles.VISUALLY_HIDDEN);
        add(span);
    }

    /**
     * Replaces the icon of the control, which by default is Bootstrap's arrow.
     *
     * @param iconType the icon
     */
    public void setIconType(final IconType iconType) {
        icon.setType(iconType);
    }

    /**
     * Makes the control go to the previous slide ({@code data-bs-slide="prev"},
     * {@code carousel-control-prev}).
     *
     * @param prev {@code true} for a previous control
     */
    public void setPrev(final boolean prev) {
        getElement().removeAttribute(Attributes.DATA_SLIDE);
        getElement().setAttribute(Attributes.DATA_SLIDE, Carousel.PREV);
        StyleHelper.toggleStyleName(this, prev, Styles.CAROUSEL_CONTROL_PREV);
        icon.addStyleName(Styles.CAROUSEL_CONTROL_PREV_ICON);
    }

    /**
     * Makes the control go to the next slide ({@code data-bs-slide="next"},
     * {@code carousel-control-next}).
     *
     * @param next {@code true} for a next control
     */
    public void setNext(final boolean next) {
        getElement().removeAttribute(Attributes.DATA_SLIDE);
        getElement().setAttribute(Attributes.DATA_SLIDE, Carousel.NEXT);
        StyleHelper.toggleStyleName(this, next, Styles.CAROUSEL_CONTROL_NEXT);
        icon.addStyleName(Styles.CAROUSEL_CONTROL_NEXT_ICON);
    }

    @Override
    public void setHref(String href) {
        anchorElem.setHref(href);
    }

    @Override
    public String getHref() {
        return anchorElem.getHref();
    }

    @Override
    public String getText() {
        return span.getText();
    }

    @Override
    public void setText(String text) {
        span.setText(text);
    }
}
