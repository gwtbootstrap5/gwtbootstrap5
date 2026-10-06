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

import java.util.List;

import org.gwtbootstrap5.client.ui.base.ComplexWidget;
import org.gwtbootstrap5.client.ui.base.HasActive;
import org.gwtbootstrap5.client.ui.base.HasDataTarget;
import org.gwtbootstrap5.client.ui.base.mixin.ActiveMixin;
import org.gwtbootstrap5.client.ui.base.mixin.DataTargetMixin;
import org.gwtbootstrap5.client.ui.constants.Attributes;

import com.google.gwt.dom.client.Document;
import com.google.gwt.user.client.ui.Widget;

/**
 * Indicator of a {@link Carousel}: a button that shows which slide is active and goes to its slide
 * when clicked. It needs {@code dataTarget}, the carousel's id, and {@code dataSlideTo}, the index
 * of its slide.
 * <h2>UiBinder example</h2>
 * <pre>{@code
 *     <b:CarouselIndicators>
 *         <b:CarouselIndicator dataTarget="#slides" dataSlideTo="0" active="true"/>
 *         <b:CarouselIndicator dataTarget="#slides" dataSlideTo="1"/>
 *     </b:CarouselIndicators>
 * }</pre>
 *
 * @see <a href="https://getbootstrap.com/docs/5.3/components/carousel/#indicators">Bootstrap 5 documentation</a>
 *
 * @author Joshua Godi
 */
public class CarouselIndicator extends ComplexWidget implements HasDataTarget, HasActive {

    private final DataTargetMixin<CarouselIndicator> targetMixin = new DataTargetMixin<>(this);
    private final ActiveMixin<CarouselIndicator> activeMixin = new ActiveMixin<>(this);

    /** Creates an indicator ({@code button}). */
    public CarouselIndicator() {
        super();

        // Bootstrap 5 indicators are buttons in a div, not list items
        setElement(Document.get().createPushButtonElement());
        getElement().setAttribute(Attributes.TYPE, "button");
    }

    /**
     * Sets the slide the indicator goes to ({@code data-bs-slide-to}).
     *
     * @param dataSlideTo the index of the slide, from 0
     */
    public void setDataSlideTo(final String dataSlideTo) {
        getElement().setAttribute(Attributes.DATA_SLIDE_TO, dataSlideTo);
    }

    /**
     * Returns the slide the indicator goes to.
     *
     * @return the index of the slide ({@code data-bs-slide-to})
     */
    public String getDataSlideTo() {
        return getElement().getAttribute(Attributes.DATA_SLIDE_TO);
    }

    @Override
    public void setActive(final boolean active) {
        activeMixin.setActive(active);
    }

    @Override
    public boolean isActive() {
        return activeMixin.isActive();
    }

    @Override
    public void setDataTargetWidgets(final List<Widget> widgets) {
        targetMixin.setDataTargetWidgets(widgets);
    }

    @Override
    public void setDataTargetWidget(final Widget widget) {
        targetMixin.setDataTargetWidget(widget);
    }

    @Override
    public void setDataTarget(final String dataTarget) {
        targetMixin.setDataTarget(dataTarget);
    }

    @Override
    public String getDataTarget() {
        return targetMixin.getDataTarget();
    }
}
