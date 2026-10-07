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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.gwtbootstrap5.client.shared.event.HiddenEvent;
import org.gwtbootstrap5.client.shared.event.HiddenHandler;
import org.gwtbootstrap5.client.shared.event.HideEvent;
import org.gwtbootstrap5.client.shared.event.HideHandler;
import org.gwtbootstrap5.client.shared.event.InsertedEvent;
import org.gwtbootstrap5.client.shared.event.ShowEvent;
import org.gwtbootstrap5.client.shared.event.ShowHandler;
import org.gwtbootstrap5.client.shared.event.ShownEvent;
import org.gwtbootstrap5.client.shared.event.ShownHandler;
import org.gwtbootstrap5.client.shared.js.BootstrapTooltip;
import org.gwtbootstrap5.client.shared.js.DomEventListeners;
import org.gwtbootstrap5.client.ui.base.helper.EnumHelper;
import org.gwtbootstrap5.client.ui.constants.Placement;
import org.gwtbootstrap5.client.ui.constants.Trigger;

import com.google.gwt.dom.client.Element;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.HasOneWidget;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.google.web.bindery.event.shared.HandlerRegistration;

import jsinterop.base.JsPropertyMap;

/**
 * Common implementation for the Bootstrap tooltip and popover.
 *
 * @author Joshua Godi
 * @author Pontus Enmark
 * @author Steven Jardine
 */
public abstract class AbstractTooltip implements IsWidget, HasWidgets, HasOneWidget, HasId, HasHover {

    private final DomEventListeners listeners = new DomEventListeners();
    
    private static final String TOGGLE = "toggle";
    private static final String SHOW = "show";
    private static final String HIDE = "hide";
    private static final String DESTROY = "dispose";

    // Defaults from https://getbootstrap.com/docs/5.3/components/tooltips/
    private boolean isAnimated = true;
    private boolean isHTML = false;
    private Placement placement = Placement.TOP;
    private Trigger trigger = Trigger.HOVER;
    private String title = "";
    private int hideDelayMs = 0;
    private int showDelayMs = 0;
    private String container = "body";
    private String selector = null;
    private String offset = null;
    private String fallbackPlacements = null;
    private String boundary = null;
    private String customClass = null;
    private boolean sanitize = true;
    private Map<String, List<String>> allowList = null;

    private String tooltipClassNames = "tooltip";
    private String tooltipArrowClassNames = "tooltip-arrow";
    private String tooltipInnerClassNames = "tooltip-inner";

    private static final String DEFAULT_TEMPLATE = "<div class=\"{0}\" role=\"{0}\"><div class=\"{1}\"></div><div class=\"{2}\"></div></div>";
    private String alternateTemplate = null;

    /** The widget the tooltip or popover belongs to. */
    protected Widget widget;
    private String id;
    private final String dataTarget;
    /** Whether the Bootstrap instance has been created, when the widget was attached. */
    protected boolean initialized = false;
    private boolean showing = false;

    /**
     * Creates the empty Tooltip
     *
     * @param dataTarget the Bootstrap event namespace, {@code bs.tooltip} or {@code bs.popover}
     */
    protected AbstractTooltip(String dataTarget) {
        this.dataTarget = dataTarget;
    }

    /**
     * Creates the tooltip with given title. Remember to set the widget as well
     *
     * @param dataTarget the Bootstrap event namespace, {@code bs.tooltip} or {@code bs.popover}
     * @param title title for the tooltip
     */
    protected AbstractTooltip(String dataTarget, final String title) {
        this(dataTarget);
        setTitle(title);
    }

    /**
     * Creates the tooltip around this widget
     *
     * @param dataTarget the Bootstrap event namespace, {@code bs.tooltip} or {@code bs.popover}
     * @param w widget for the tooltip
     */
    protected AbstractTooltip(String dataTarget, final Widget w) {
        this(dataTarget);
        setWidget(w);
    }

    /**
     * Creates the tooltip around this widget with given title
     *
     * @param dataTarget the Bootstrap event namespace, {@code bs.tooltip} or {@code bs.popover}
     * @param w     widget for the tooltip
     * @param title title for the tooltip
     */
    protected AbstractTooltip(String dataTarget, final Widget w, final String title) {
        this(dataTarget);
        setWidget(w);
        setTitle(title);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void add(final Widget child) {
        if (getWidget() != null) {
            throw new IllegalStateException("Can only contain one child widget");
        }
        setWidget(child);
    }

    /**
     * Adds a hidden handler to the Tooltip that will be fired when the Tooltip's hidden event is fired
     *
     * @param hiddenHandler HiddenHandler to handle the hidden event
     * @return HandlerRegistration of the handler
     */
    public HandlerRegistration addHiddenHandler(final HiddenHandler hiddenHandler) {
        return widget.addHandler(hiddenHandler, HiddenEvent.getType());
    }

    /**
     * Adds a hide handler to the Tooltip that will be fired when the Tooltip's hide event is fired
     *
     * @param hideHandler HideHandler to handle the hide event
     * @return HandlerRegistration of the handler
     */
    public HandlerRegistration addHideHandler(final HideHandler hideHandler) {
        return widget.addHandler(hideHandler, HideEvent.getType());
    }

    /**
     * Adds a show handler to the Tooltip that will be fired when the Tooltip's show event is fired
     *
     * @param showHandler ShowHandler to handle the show event
     * @return HandlerRegistration of the handler
     */
    public HandlerRegistration addShowHandler(final ShowHandler showHandler) {
        return widget.addHandler(showHandler, ShowEvent.getType());
    }

    /**
     * Adds a shown handler to the Tooltip that will be fired when the Tooltip's shown event is fired
     *
     * @param shownHandler ShownHandler to handle the shown event
     * @return HandlerRegistration of the handler
     */
    public HandlerRegistration addShownHandler(final ShownHandler shownHandler) {
        return widget.addHandler(shownHandler, ShownEvent.getType());
    }

    /**
     * Add a tooltip arrow div class name
     *
     * @param tooltipArrowClassName a tooltip arrow div class name
     */
    public void addTooltipArrowClassName(String tooltipArrowClassName) {
        this.tooltipArrowClassNames += " " + tooltipArrowClassName;
    }

    /**
     * Add a tooltip div class name
     *
     * @param tooltipClassName a tooltip div class name
     */
    public void addTooltipClassName(String tooltipClassName) {
        this.tooltipClassNames += " " + tooltipClassName;
    }

    /**
     * Add a tooltip inner div class name
     *
     * @param tooltipInnerClassName a tooltip inner div class name
     */
    public void addTooltipInnerClassName(String tooltipInnerClassName) {
        this.tooltipInnerClassNames += " " + tooltipInnerClassName;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Widget asWidget() {
        return widget;
    }

    // @formatter:off
    /**
     * Listens to the Bootstrap events of the element, to fire them on the widget.
     *
     * @param e the element of the widget
     */
    protected void bindJavaScriptEvents(final Element e) {
        listeners.removeAll();
        listeners.add(e, "show." + dataTarget, this::onShow);
        listeners.add(e, "shown." + dataTarget, this::onShown);
        listeners.add(e, "hide." + dataTarget, this::onHide);
        listeners.add(e, "hidden." + dataTarget, this::onHidden);
        listeners.add(e, "inserted." + dataTarget, this::onInserted);
    }

    /**
     * Runs a tooltip/popover command, mirroring Bootstrap's former jQuery plugin interface.
     *
     * @param instance the Bootstrap tooltip or popover instance
     * @param command one of show, hide, toggle, enable, disable, toggleEnabled, update, dispose
     */
    protected static void invoke(final BootstrapTooltip instance, final String command) {
        switch (command) {
            case "show": instance.show(); break;
            case "hide": instance.hide(); break;
            case "toggle": instance.toggle(); break;
            case "enable": instance.enable(); break;
            case "disable": instance.disable(); break;
            case "toggleEnabled": instance.toggleEnabled(); break;
            case "update": instance.update(); break;
            case "dispose": instance.dispose(); break;
            default: throw new IllegalArgumentException("Unknown tooltip command: " + command);
        }
    }
    
    /**
     * Calls a method of the Bootstrap instance, such as {@code show} or {@code dispose}.
     *
     * @param arg the name of the method
     */
    protected abstract void call(final String arg);

    /**
     * Passes the current title (and content) to the Bootstrap instance, which redraws an open
     * tooltip. Called after the title changes on an initialized tooltip; does nothing by default.
     */
    protected void updateContent() {
    }

    /** {@inheritDoc} */
    @Override
    public void clear() {
        widget = null;
    }

    /**
     * Create the options for the tooltip.
     *
     * @param e the element of the widget
     * @param animation whether the tip fades in and out
     * @param html whether the title is HTML
     * @param selector the selector of the descendants that get the tip, or {@code null}
     * @param trigger how the tip is opened, such as {@code "hover focus"}
     * @param showDelay the delay before showing, in milliseconds
     * @param hideDelay the delay before hiding, in milliseconds
     * @param container where the tip is appended, or {@code null} for the body
     * @param template the HTML template of the tip
     */
    protected void createOptions(Element e, boolean animation, boolean html, String selector,
            String trigger, int showDelay, int hideDelay, String container, String template) {
        e.setAttribute("data-bs-toggle", "tooltip");

        e.setAttribute("data-bs-animation", Boolean.toString(animation));
        if (container != null) {
            e.setAttribute("data-bs-container", container);
        }
        e.setAttribute("data-bs-delay", "{ \"show\": " + showDelay + ", \"hide\": " + hideDelay + " }");
        e.setAttribute("data-bs-html", Boolean.toString(html));
        e.setAttribute("data-bs-placement", getPlacementCssName());
        if (selector != null) {
            e.setAttribute("data-bs-selector", selector);
        }
        e.setAttribute("data-bs-template", template);
        e.setAttribute("data-bs-title", getTitle());
        e.setAttribute("data-bs-trigger", trigger);
        setOptionalAttribute(e, "data-bs-offset", offset);
        setOptionalAttribute(e, "data-bs-fallback-placements", fallbackPlacements);
        setOptionalAttribute(e, "data-bs-boundary", boundary);
        setOptionalAttribute(e, "data-bs-custom-class", customClass);
    }

    /**
     * Returns the options that Bootstrap only reads from the JavaScript configuration, not from
     * {@code data-bs-*} attributes: {@code sanitize} and {@code allowList}. Pass it to
     * {@code getOrCreateInstance} when creating the tip.
     *
     * @return the configuration, or {@code null} when both keep Bootstrap's defaults
     */
    protected Object createConfig() {
        if (sanitize && allowList == null) {
            return null;
        }
        final JsPropertyMap<Object> config = JsPropertyMap.of();
        config.set("sanitize", sanitize);
        if (allowList != null) {
            final JsPropertyMap<Object> list = JsPropertyMap.of();
            for (final Map.Entry<String, List<String>> entry : allowList.entrySet()) {
                list.set(entry.getKey(), entry.getValue().toArray(new String[0]));
            }
            config.set("allowList", list);
        }
        return config;
    }

    /**
     * Moves the tip away from its widget ({@code offset}): along the widget and away from it.
     * It applies when the tip is created, as the widget is attached.
     *
     * @param skidding the shift along the widget, in pixels
     * @param distance the distance from the widget, in pixels; Bootstrap's default is 0 for
     *                 tooltips and 8 for popovers
     */
    public void setOffset(final int skidding, final int distance) {
        offset = skidding + "," + distance;
        updateAttribute("data-bs-offset", offset);
    }

    /**
     * Sets the placements to try when the tip doesn't fit where {@link #setPlacement(Placement)}
     * puts it ({@code fallbackPlacements}). It applies when the tip is created.
     *
     * @param placements the placements in the order to try them; none for Bootstrap's default
     */
    public void setFallbackPlacements(final Placement... placements) {
        final List<String> names = new ArrayList<>();
        for (final Placement placement : placements) {
            if (placement != null && !placement.getCssName().isEmpty()) {
                names.add("\"" + placement.getCssName() + "\"");
            }
        }
        fallbackPlacements = names.isEmpty() ? null : "[" + String.join(",", names) + "]";
        updateAttribute("data-bs-fallback-placements", fallbackPlacements);
    }

    /**
     * Sets the placements to try when the tip doesn't fit, as in UiBinder.
     *
     * @param placements {@link Placement} names separated by spaces or commas, e.g. {@code "BOTTOM RIGHT"}
     */
    public void setFallbackPlacements(final String placements) {
        final List<Placement> list = new ArrayList<>();
        for (final String name : placements.trim().split("[, ]+")) {
            final Placement placement = EnumHelper.fromEnumName(name.toUpperCase(), Placement.class, null);
            if (placement != null) {
                list.add(placement);
            }
        }
        setFallbackPlacements(list.toArray(new Placement[0]));
    }

    /**
     * Sets the area the tip must stay inside ({@code boundary}): {@code "clippingParents"},
     * Bootstrap's default, or {@code "viewport"}. It applies when the tip is created.
     *
     * @param boundary the boundary, or {@code null} for Bootstrap's default
     */
    public void setBoundary(final String boundary) {
        this.boundary = boundary;
        updateAttribute("data-bs-boundary", boundary);
    }

    /**
     * Adds classes to the tip when it shows ({@code customClass}), for styling it. It applies
     * when the tip is created.
     *
     * @param customClass the classes separated by spaces, or {@code null} for none
     */
    public void setCustomClass(final String customClass) {
        this.customClass = customClass;
        updateAttribute("data-bs-custom-class", customClass);
    }

    /**
     * Sets whether Bootstrap sanitizes the HTML of the tip ({@code sanitize}), which is on by
     * default. <strong>Turning it off lets any HTML of the title or content run, scripts
     * included</strong>: only do it for content you fully control. It applies when the tip is
     * created.
     *
     * @param sanitize {@code false} to show the HTML as it is
     * @see <a href="https://getbootstrap.com/docs/5.3/getting-started/javascript/#sanitizer">Bootstrap's sanitizer</a>
     */
    public void setSanitize(final boolean sanitize) {
        this.sanitize = sanitize;
    }

    /**
     * Replaces the tags and attributes that the sanitizer keeps ({@code allowList}). Anything
     * not listed is removed from the HTML of the tip; the key {@code "*"} lists the attributes
     * allowed on every tag. It applies when the tip is created.
     *
     * @param allowList the allowed attributes of each tag, or {@code null} for Bootstrap's list
     * @see <a href="https://getbootstrap.com/docs/5.3/getting-started/javascript/#sanitizer">Bootstrap's sanitizer</a>
     */
    public void setAllowList(final Map<String, List<String>> allowList) {
        this.allowList = allowList;
    }

    private void updateAttribute(final String name, final String value) {
        if (initialized && getWidget() != null) {
            setOptionalAttribute(getWidget().getElement(), name, value);
        }
    }

    private static void setOptionalAttribute(final Element e, final String name, final String value) {
        if (value == null) {
            e.removeAttribute(name);
        } else {
            e.setAttribute(name, value);
        }
    }
    
    /**
     * Force the Tooltip to be destroyed
     */
    public void destroy() {
        call(DESTROY);
        listeners.removeAll();
        setInitialized(false);
    }

    /**
     * Get the alternate template used to render the tooltip. If null,
     * the default template will be used.
     *
     * @return String the alternate template used to render the tooltip
     */
    public String getAlternateTemplate() {
        return alternateTemplate;
    }

    /** {@inheritDoc} */
    @Override
    public String getContainer() {
        return container;
    }

    /** {@inheritDoc} */
    @Override
    public int getHideDelayMs() {
        return hideDelayMs;
    }

    /** {@inheritDoc} */
    @Override
    public String getId() {
        return (widget == null) ? id : widget.getElement().getId();
    }

    /** {@inheritDoc} */
    @Override
    public Placement getPlacement() {
        return placement;
    }

    /**
     * Gets the placement css name.
     *
     * @return the placement css name
     */
    private String getPlacementCssName() {
        return placement == null ? Placement.TOP.getCssName() : placement.getCssName();
    }

    /**
     * Get the tooltip's selector
     *
     * @return String the tooltip's selector
     */
    public String getSelector() {
        return selector;
    }

    /** {@inheritDoc} */
    @Override
    public int getShowDelayMs() {
        return showDelayMs;
    }

    /**
     * Gets the tooltip's display string
     *
     * @return String tooltip display string
     */
    public String getTitle() {
        return title;
    }

    /**
     * Get the tooltip arrow div class names
     *
     * @return String Get the tooltip arrow div class names
     */
    public String getTooltipArrowClassNames() {
        return tooltipArrowClassNames;
    }

    /**
     * Get the tooltip div class names
     *
     * @return String the tooltip div class names
     */
    public String getTooltipClassNames() {
        return tooltipClassNames;
    }

    /**
     * Get the tooltip inner div class names
     *
     * @return String the tooltip inner div class names
     */
    public String getTooltipInnerClassNames() {
        return tooltipInnerClassNames;
    }

    /** {@inheritDoc} */
    @Override
    public Trigger getTrigger() {
        return trigger;
    }


    /** {@inheritDoc} */
    @Override
    public Widget getWidget() {
        return widget;
    }

    /**
     * Force hide the Tooltip
     */
    public void hide() {
        call(HIDE);
    }

    /**
     * Initializes the tooltip for use.
     */
    public abstract void init();

    /** {@inheritDoc} */
    @Override
    public boolean isAnimated() {
        return isAnimated;
    }

    /** {@inheritDoc} */
    @Override
    public boolean isHtml() {
        return isHTML;
    }

    /**
     * Returns whether the Bootstrap instance has been created.
     *
     * @return the initialized
     */
    public boolean isInitialized() {
        return initialized;
    }

    /** {@inheritDoc} */
    @Override
    public Iterator<Widget> iterator() {
        // Simple iterator for the widget
        return new Iterator<>() {

            boolean hasElement = widget != null;

            Widget returned = null;

            /**
             * {@inheritDoc}
             */
            @Override
            public boolean hasNext() {
                return hasElement;
            }

            /**
             * {@inheritDoc}
             */
            @Override
            public Widget next() {
                if (!hasElement || (widget == null)) {
                    throw new NoSuchElementException();
                }
                hasElement = false;
                returned = widget;
                return returned;
            }

            /**
             * {@inheritDoc}
             */
            @Override
            public void remove() {
                if (returned != null) {
                    AbstractTooltip.this.remove(returned);
                }
            }
        };
    }

    /**
     * Can be overridden by subclasses to handle Tooltip's "hidden" event however
     * it's recommended to add an event handler to the tooltip.
     *
     * @param evt Event
     * @see org.gwtbootstrap5.client.shared.event.HiddenEvent
     */
    protected void onHidden(final Event evt) {
        showing = false;
        widget.fireEvent(new HiddenEvent(evt));
    }

    /**
     * Can be overridden by subclasses to handle Tooltip's "hide" event however
     * it's recommended to add an event handler to the tooltip.
     *
     * @param evt Event
     * @see org.gwtbootstrap5.client.shared.event.HideEvent
     */
    protected void onHide(final Event evt) {
        widget.fireEvent(new HideEvent(evt));
    }

    /**
     * Can be overridden by subclasses to handle Tooltip's "inserted" event however
     * it's recommended to add an event handler to the tooltip.
     *
     * @param evt Event
     * @see org.gwtbootstrap5.client.shared.event.InsertedEvent
     */
    protected void onInserted(final Event evt) {
        widget.fireEvent(new InsertedEvent(evt));
    }

    /**
     * Can be overridden by subclasses to handle Tooltip's "show" event however
     * it's recommended to add an event handler to the tooltip.
     *
     * @param evt Event
     * @see org.gwtbootstrap5.client.shared.event.ShowEvent
     */
    protected void onShow(final Event evt) {
        widget.fireEvent(new ShowEvent(evt));
    }

    /**
     * Can be overridden by subclasses to handle Tooltip's "shown" event however
     * it's recommended to add an event handler to the tooltip.
     *
     * @param evt Event
     * @see ShownEvent
     */
    protected void onShown(final Event evt) {
        showing = true;
        widget.fireEvent(new ShownEvent(evt));
    }

    /**
     * Returns the HTML template of the tip: the alternate template if one is set, or the default
     * one with the class names added with {@link #addTooltipClassName(String)} and the like.
     *
     * @return the template
     */
    protected String prepareTemplate() {
        String template;
        if (alternateTemplate == null) {
            template = DEFAULT_TEMPLATE.replace("{0}", getTooltipClassNames());
            template = template.replace("{1}", getTooltipArrowClassNames());
            template = template.replace("{2}", getTooltipInnerClassNames());
        } else {
            template = alternateTemplate;
        }
        return template;
    }

    /**
     * Recreate the tooltip/popover with a default dealy of 300ms between the call to destroy and init.
     */
    public void recreate() {
        recreate(300);
    }

    /**
     * Recreate the tooltip/popover. The delay is necessary because the destroy of the tooltip needs to be complete
     * prior to calling init.
     *
     * @param delay the delay in ms between the call to destroy and init.
     */
    public void recreate(int delay) {
        destroy();
        new Timer() {
            @Override
            public void run() {
                init();
            }
        }.schedule(delay);
    }

    /** {@inheritDoc} */
    @Override
    public boolean remove(final Widget w) {
        // Validate.
        if (widget != w) {
            return false;
        }
        // Logical detach.
        clear();
        return true;
    }

    /**
     * Sets the tooltip's display string in HTML format
     *
     * @param html String display string in HTML format
     */
    public void setHtml(final SafeHtml html) {
        setIsHtml(true);
        if (html == null) {
            setTitle("");
        } else {
            setTitle(html.asString());
        }
    }

    /** {@inheritDoc} */
    @Override
    public void setId(final String id) {
        this.id = id;
        if (widget != null) {
            widget.getElement().setId(id);
        }
    }

    /**
     * Sets whether the Bootstrap instance has been created. Used by {@link #init()} and
     * {@link #destroy()}.
     *
     * @param initialized the initialized to set
     */
    public void setInitialized(boolean initialized) {
        this.initialized = initialized;
    }

    /** {@inheritDoc} */
    @Override
    public void setIsAnimated(final boolean isAnimated) {
        this.isAnimated = isAnimated;
        if (initialized) {
            getWidget().getElement().setAttribute("data-bs-animation", String.valueOf(isAnimated));
        }
    }

    /** {@inheritDoc} */
    @Override
    public void setContainer(final String container) {
        this.container = container;
        if (initialized) {
            getWidget().getElement().setAttribute("data-bs-container", container);
        }
    }

    /** {@inheritDoc} */
    @Override
    public void setShowDelayMs(final int showDelayMs) {
        this.showDelayMs = showDelayMs;
        if (initialized) {
            getWidget().getElement().setAttribute("data-bs-delay", "{\"show\": " + showDelayMs + ", \"hide\": " + hideDelayMs + "}");
        }
    }

    /** {@inheritDoc} */
    @Override
    public void setHideDelayMs(final int hideDelayMs) {
        this.hideDelayMs = hideDelayMs;
        if (initialized) {
            getWidget().getElement().setAttribute("data-bs-delay", "{\"show\": " + showDelayMs + ", \"hide\": " + hideDelayMs + "}");
        }
    }

    /** {@inheritDoc} */
    @Override
    public void setIsHtml(final boolean isHTML) {
        this.isHTML = isHTML;
        if (initialized) {
            getWidget().getElement().setAttribute("data-bs-html", String.valueOf(isHTML));
        }

    }

    /** {@inheritDoc} */
    @Override
    public void setPlacement(final Placement placement) {
        this.placement = placement;
        if (initialized) {
            getWidget().getElement().setAttribute("data-bs-placement", getPlacementCssName());
        }
    }

    /**
     * Set the tooltip's selector
     *
     * @param selector the tooltip's selector
     */
    public void setSelector(String selector) {
        this.selector = selector;
        if (initialized) {
            getWidget().getElement().setAttribute("data-bs-selector", selector);
        }
    }

    /**
     * Set the alternate template used to render the tooltip. The template should contain
     * divs with classes 'tooltip', 'tooltip-inner', and 'tooltip-arrow'. If an alternate
     * template is configured, the 'tooltipClassNames', 'tooltipArrowClassNames', and
     * 'tooltipInnerClassNames' properties are not used.
     *
     * @param alternateTemplate the alternate template used to render the tooltip
     */
    public void setAlternateTemplate(String alternateTemplate) {
        this.alternateTemplate = alternateTemplate;
        if (initialized) {
            getWidget().getElement().setAttribute("data-bs-template", prepareTemplate());
        }
    }

    /**
     * Sets the tooltip's display string
     *
     * @param title String display string
     */
    public void setTitle(final String title) {
        this.title = title;
        if (initialized) {
            getWidget().getElement().setAttribute("data-bs-title", this.title);
            // Bootstrap reads the title once, when the instance is created
            updateContent();
        }
    }

    /** {@inheritDoc} */
    @Override
    public void setTrigger(final Trigger trigger) {
        this.trigger = trigger;
        if (initialized) {
            getWidget().getElement().setAttribute("data-bs-trigger", trigger == null ? Trigger.HOVER.getCssName() : trigger.getCssName());
        }
    }


    /**
     * Set the tooltip arrow div class names
     *
     * @param tooltipArrowClassNames the tooltip arrow div class names
     */
    public void setTooltipArrowClassNames(String tooltipArrowClassNames) {
        this.tooltipArrowClassNames = tooltipArrowClassNames;
    }

    /**
     * Set the tooltip div class names
     *
     * @param tooltipClassNames the tooltip div class names
     */
    public void setTooltipClassNames(String tooltipClassNames) {
        this.tooltipClassNames = tooltipClassNames;
    }

    /**
     * Set the tooltip inner div class names
     *
     * @param tooltipInnerClassNames the tooltip inner div class names
     */
    public void setTooltipInnerClassNames(String tooltipInnerClassNames) {
        this.tooltipInnerClassNames = tooltipInnerClassNames;
    }

    /** {@inheritDoc} */
    @Override
    public void setWidget(final IsWidget w) {
        setWidget(w.asWidget());
    }

    /** {@inheritDoc} */
    @Override
    public void setWidget(final Widget w) {
        // Validate
        if (w == widget) {
            return;
        }

        // Detach new child
        if (w != null) {
            w.removeFromParent();
        }

        // Remove old child
        if (widget != null) {
            remove(widget);
        }

        // Logical attach, but don't physical attach; done by jquery.
        widget = w;
        if (widget == null) {
            return;
        }

        // When we attach it, configure the tooltip
        widget.addAttachHandler(event -> {
            if (event.isAttached()) {
                init();
            } else if (initialized) {
                // The tip lives in the container (body by default): remove it with the widget
                destroy();
            }
        });
    }

    /**
     * Force show the Tooltip
     */
    public void show() {
        call(SHOW);
    }

    /**
     * Toggle the Tooltip to either show/hide
     */
    public void toggle() {
        call(TOGGLE);
    }

    /** {@inheritDoc} */
    @Override
    public String toString() {
        return asWidget().toString();
    }

}
