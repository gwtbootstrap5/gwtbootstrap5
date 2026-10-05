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

import org.gwtbootstrap5.client.shared.event.CarouselSlidEvent;
import org.gwtbootstrap5.client.shared.event.CarouselSlidHandler;
import org.gwtbootstrap5.client.shared.event.CarouselSlideEvent;
import org.gwtbootstrap5.client.shared.event.CarouselSlideHandler;
import org.gwtbootstrap5.client.shared.js.BootstrapCarousel;
import org.gwtbootstrap5.client.shared.js.DomEventListeners;
import org.gwtbootstrap5.client.ui.constants.Attributes;
import org.gwtbootstrap5.client.ui.constants.Styles;
import org.gwtbootstrap5.client.ui.html.Div;

import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.Event;

import jsinterop.base.JsPropertyMap;

/**
 * @author Joshua Godi
 */
public class Carousel extends Div {
    public static final String HOVER = "hover";
    public static final String CAROUSEL = "carousel";
    public static final String CYCLE = "cycle";
    public static final String PAUSE = "pause";
    public static final String PREV = "prev";
    public static final String NEXT = "next";

    private final DomEventListeners listeners = new DomEventListeners();

    // Bootstrap default values: http://getbootstrap.com/javascript/#carousel
    private int interval = 5000;
    private String pause = HOVER;
    private boolean wrap = true;
    private boolean autoplay = true;

    public Carousel() {
        super();

        // Set the default styles
        setStyleName(Styles.CAROUSEL);
        addStyleName(Styles.SLIDE);

        // Set the default attribute
        getElement().setAttribute(Attributes.DATA_RIDE, CAROUSEL);
    }

    @Override
    protected void onLoad() {
        super.onLoad();

        // Bind jquery events
        bindJavaScriptEvents(getElement());

        // Configure the carousel
        carousel(getElement(), interval, pause, wrap, autoplay);
    }

    @Override
    protected void onUnload() {
        super.onUnload();

        // Unbind events
        unbindJavaScriptEvents(getElement());
    }

    public void setInterval(final int interval) {
        this.interval = interval;
    }

    public void setPause(final String pause) {
        this.pause = pause;
    }

    public void setWrap(final boolean wrap) {
        this.wrap = wrap;
    }

    /**
     * Whether the carousel starts cycling when it is shown (the default). Without autoplay it
     * moves only through its controls, or from Java.
     */
    public void setAutoplay(final boolean autoplay) {
        this.autoplay = autoplay;
        if (autoplay) {
            getElement().setAttribute(Attributes.DATA_RIDE, CAROUSEL);
        } else {
            getElement().removeAttribute(Attributes.DATA_RIDE);
        }
    }

    public boolean isAutoplay() {
        return autoplay;
    }

    public void setFade(final boolean fade) {
        if (fade) {
            addStyleName(Styles.CAROUSEL_FADE);
        } else {
            removeStyleName(Styles.CAROUSEL_FADE);
        }
    }

    public void setDark(final boolean dark) {
        if (dark) {
            addStyleName(Styles.CAROUSEL_DARK);
        } else {
            removeStyleName(Styles.CAROUSEL_DARK);
        }
    }

    /**
     * Causes the carousel to cycle
     */
    public void cycleCarousel() {
        fireMethod(getElement(), CYCLE);
    }

    /**
     * Causes the carousel to pause movement
     */
    public void pauseCarousel() {
        fireMethod(getElement(), PAUSE);
    }

    /**
     * Causes the carousel to jump to that slide
     */
    public void jumpToSlide(final int slideNumber) {
        fireMethod(getElement(), slideNumber);
    }

    /**
     * Causes the carousel to go back
     */
    public void goToPrev() {
        fireMethod(getElement(), PREV);
    }

    /**
     * Causes the carousel to go to the next slide
     */
    public void goToNext() {
        fireMethod(getElement(), NEXT);
    }

    public HandlerRegistration addSlideHandler(final CarouselSlideHandler carouselSlideHandler) {
        return addHandler(carouselSlideHandler, CarouselSlideEvent.getType());
    }

    public HandlerRegistration addSlidHandler(final CarouselSlidHandler slidHandler) {
        return addHandler(slidHandler, CarouselSlidEvent.getType());
    }

    /**
     * Fired when the carousel is starting to change slides
     *
     * @param evt event
     */
    private void onSlide(final Event evt) {
        fireEvent(new CarouselSlideEvent(this, evt));
    }

    /**
     * Fired when the carousel is finished changing slides
     *
     * @param evt event
     */
    private void onSlid(final Event evt) {
        fireEvent(new CarouselSlidEvent(this, evt));
    }

    private void bindJavaScriptEvents(final com.google.gwt.dom.client.Element e) {
        listeners.add(e, "slide.bs.carousel", this::onSlide);
        listeners.add(e, "slid.bs.carousel", this::onSlid);
    }

    private void unbindJavaScriptEvents(final com.google.gwt.dom.client.Element e) {
        listeners.removeAll();
    }

    private static void carousel(final com.google.gwt.dom.client.Element e, final int interval, final String pause,
                                 final boolean wrap, final boolean autoplay) {
        final JsPropertyMap<Object> config = JsPropertyMap.of("interval", interval, "pause", pause, "wrap", wrap);
        config.set("ride", autoplay ? CAROUSEL : false);
        BootstrapCarousel.getOrCreateInstance(e, config);
    }

    private void fireMethod(final com.google.gwt.dom.client.Element e, String method) {
        final BootstrapCarousel carousel = BootstrapCarousel.getOrCreateInstance(e, null);
        switch (method) {
            case CYCLE:
                carousel.cycle();
                break;
            case PAUSE:
                carousel.pause();
                break;
            case PREV:
                carousel.prev();
                break;
            case NEXT:
                carousel.next();
                break;
            default:
                throw new IllegalArgumentException("Unknown carousel method: " + method);
        }
    }

    private void fireMethod(final com.google.gwt.dom.client.Element e, int slideNumber) {
        BootstrapCarousel.getOrCreateInstance(e, null).to(slideNumber);
    }
}
