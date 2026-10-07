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
 * Carousel: a slideshow cycling through {@link CarouselSlide}s, with optional
 * {@link CarouselIndicators}, {@link CarouselControl}s and captions. The options set with
 * {@link #setInterval}, {@link #setPause} and {@link #setWrap} are passed to Bootstrap when the
 * carousel is attached.
 * <h2>UiBinder example</h2>
 * <pre>{@code
 *     <b:Carousel b:id="slides">
 *         <b:CarouselInner>
 *             <b:CarouselSlide active="true">
 *                 <b:Image url="first.jpg" addStyleNames="d-block w-100"/>
 *             </b:CarouselSlide>
 *             <b:CarouselSlide>
 *                 <b:Image url="second.jpg" addStyleNames="d-block w-100"/>
 *             </b:CarouselSlide>
 *         </b:CarouselInner>
 *         <b:CarouselControl prev="true" href="#slides" text="Previous"/>
 *         <b:CarouselControl next="true" href="#slides" text="Next"/>
 *     </b:Carousel>
 * }</pre>
 *
 * @see <a href="https://getbootstrap.com/docs/5.3/components/carousel/">Bootstrap 5 documentation</a>
 *
 * @author Joshua Godi
 */
public class Carousel extends Div {
    /** Value of {@link #setPause} that pauses the carousel while the mouse is over it. */
    public static final String HOVER = "hover";
    /** Value of {@code data-bs-ride} that starts cycling when the page loads. */
    public static final String CAROUSEL = "carousel";
    /** Name of the method that starts cycling. */
    public static final String CYCLE = "cycle";
    /** Name of the method that stops cycling. */
    public static final String PAUSE = "pause";
    /** Value of {@code data-bs-slide} that goes to the previous slide. */
    public static final String PREV = "prev";
    /** Value of {@code data-bs-slide} that goes to the next slide. */
    public static final String NEXT = "next";

    private final DomEventListeners listeners = new DomEventListeners();

    // Bootstrap default values: https://getbootstrap.com/docs/5.3/components/carousel/
    private int interval = 5000;
    private String pause = HOVER;
    private boolean wrap = true;
    private boolean autoplay = true;
    private boolean keyboard = true;
    private boolean touch = true;

    /** Creates an empty carousel ({@code div.carousel.slide}) that cycles on its own. */
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
        carousel(getElement(), interval, pause, wrap, autoplay, keyboard, touch);
    }

    @Override
    protected void onUnload() {
        super.onUnload();

        // Unbind events
        unbindJavaScriptEvents(getElement());
    }

    /**
     * Sets how long each slide is shown before the next one. Bootstrap's default is 5000.
     *
     * @param interval the delay in milliseconds
     */
    public void setInterval(final int interval) {
        this.interval = interval;
    }

    /**
     * Sets when the carousel pauses: {@link #HOVER} (the default) pauses it while the mouse is over
     * it.
     *
     * @param pause {@link #HOVER}, or {@code "false"} never to pause
     */
    public void setPause(final String pause) {
        this.pause = pause;
    }

    /**
     * Sets whether the carousel goes back to the first slide after the last one, or stops there.
     *
     * @param wrap {@code true} (the default) to cycle continuously
     */
    public void setWrap(final boolean wrap) {
        this.wrap = wrap;
    }

    /**
     * Whether the carousel starts cycling when it is shown (the default). Without autoplay it
     * moves only through its controls, or from Java.
     *
     * @param autoplay {@code true} (the default) to start cycling on its own
     */
    public void setAutoplay(final boolean autoplay) {
        this.autoplay = autoplay;
        if (autoplay) {
            getElement().setAttribute(Attributes.DATA_RIDE, CAROUSEL);
        } else {
            getElement().removeAttribute(Attributes.DATA_RIDE);
        }
    }

    /**
     * Returns whether the carousel starts cycling on its own.
     *
     * @return {@code true} if it has {@code data-bs-ride="carousel"}
     */
    public boolean isAutoplay() {
        return autoplay;
    }

    /**
     * Sets whether the arrow keys move between slides when the carousel has the focus
     * ({@code keyboard}, on by default). Passed to Bootstrap when the carousel is attached.
     *
     * @param keyboard {@code false} to ignore the arrow keys
     */
    public void setKeyboard(final boolean keyboard) {
        this.keyboard = keyboard;
    }

    /**
     * Sets whether swiping left or right on a touch screen moves between slides ({@code touch},
     * on by default). Passed to Bootstrap when the carousel is attached.
     *
     * @param touch {@code false} to ignore swipes
     */
    public void setTouch(final boolean touch) {
        this.touch = touch;
    }

    /**
     * Cross-fades the slides instead of sliding them ({@code carousel-fade}).
     *
     * @param fade {@code true} to fade
     */
    public void setFade(final boolean fade) {
        if (fade) {
            addStyleName(Styles.CAROUSEL_FADE);
        } else {
            removeStyleName(Styles.CAROUSEL_FADE);
        }
    }

    /**
     * Makes the controls, indicators and captions dark, for light slides ({@code carousel-dark}).
     *
     * @param dark {@code true} for dark controls
     */
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
     *
     * @param slideNumber the index of the slide, from 0
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

    /**
     * Adds a handler called when the carousel starts moving to another slide.
     *
     * @param carouselSlideHandler the handler
     * @return the registration that removes the handler
     */
    public HandlerRegistration addSlideHandler(final CarouselSlideHandler carouselSlideHandler) {
        return addHandler(carouselSlideHandler, CarouselSlideEvent.getType());
    }

    /**
     * Adds a handler called when the carousel has moved to another slide.
     *
     * @param slidHandler the handler
     * @return the registration that removes the handler
     */
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
                                 final boolean wrap, final boolean autoplay, final boolean keyboard,
                                 final boolean touch) {
        final JsPropertyMap<Object> config = JsPropertyMap.of("interval", interval, "pause", pause, "wrap", wrap);
        config.set("ride", autoplay ? CAROUSEL : false);
        config.set("keyboard", keyboard);
        config.set("touch", touch);
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
