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
import org.gwtbootstrap5.client.ui.base.mixin.ActiveMixin;
import org.gwtbootstrap5.client.ui.constants.Styles;
import org.gwtbootstrap5.client.ui.html.Div;

/**
 * Slide of a {@link Carousel} ({@code div.carousel-item}). One slide must be active when the
 * carousel is shown.
 *
 * @see <a href="https://getbootstrap.com/docs/5.3/components/carousel/">Bootstrap 5 documentation</a>
 *
 * @author Joshua Godi
 */
public class CarouselSlide extends Div implements HasActive {
    private final ActiveMixin<CarouselSlide> activeMixin = new ActiveMixin<>(this);

    /** Creates an empty, inactive slide. */
    public CarouselSlide() {
        super();

        setStyleName(Styles.CAROUSEL_ITEM);
    }

    @Override
    public void setActive(final boolean active) {
        activeMixin.setActive(active);
    }

    @Override
    public boolean isActive() {
        return activeMixin.isActive();
    }
}
