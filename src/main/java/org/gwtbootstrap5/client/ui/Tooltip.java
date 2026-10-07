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

import org.gwtbootstrap5.client.shared.js.BootstrapTooltip;
import org.gwtbootstrap5.client.ui.base.AbstractTooltip;

import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.Widget;

import jsinterop.base.JsPropertyMap;

/**
 * Tooltip: a small text that shows next to its widget on hover and focus.
 * <h2>UiBinder example</h2>
 * <pre>{@code
 *     <b:Tooltip title="Tooltip on top" placement="TOP">
 *         <b:Button type="SECONDARY" text="Hover me"/>
 *     </b:Tooltip>
 * }</pre>
 *
 * @author Steven Jardine
 * @see <a href="https://getbootstrap.com/docs/5.3/components/tooltips/">Bootstrap 5 documentation</a>
 */
public class Tooltip extends AbstractTooltip {

    /**
     * Creates the empty Popover
     */
    public Tooltip() {
        super("bs.tooltip");
    }

    /**
     * Creates the tooltip with given title. Remember to set the content and widget as well.
     *
     * @param title title for the tooltip
     */
    public Tooltip(final String title) {
        this();
        setTitle(title);
    }

    /**
     * Creates the tooltip around this widget
     *
     * @param w widget for the tooltip
     */
    public Tooltip(final Widget w) {
        this();
        setWidget(w);
    }

    /**
     * Creates the tooltip around this widget with given title and content.
     *
     * @param w widget for the tooltip
     * @param title title for the tooltip
     */
    public Tooltip(final Widget w, final String title) {
        this();
        setWidget(w);
        setTitle(title);
    }

    /**
     * Call the native tooltip method with the given argument.
     *
     * @param e the {@link Element}.
     * @param arg the arg
     */
    private void call(final Element e, final String arg) {
        invoke(BootstrapTooltip.getOrCreateInstance(e, null), arg);
    }

    /** {@inheritDoc} */
    @Override
    protected void call(String arg) {
        call(getWidget().getElement(), arg);
    }

    /** {@inheritDoc} */
    @Override
    public void init() {
        Element element = getWidget().getElement();
        createOptions(element, isAnimated(), isHtml(), getSelector(), getTrigger().getCssName(), getShowDelayMs(),
                getHideDelayMs(), getContainer(), prepareTemplate());
        tooltip(element);
        bindJavaScriptEvents(element);
        setInitialized(true);
    }

    /**
     * Create the tooltip.
     */
    @Override
    protected void updateContent() {
        final BootstrapTooltip instance = BootstrapTooltip.getInstance(getWidget().getElement());
        if (instance != null) {
            instance.setContent(JsPropertyMap.of(".tooltip-inner", getTitle()));
        }
    }

    private void tooltip(Element e) {
        BootstrapTooltip.getOrCreateInstance(e, createConfig());
    }

}
