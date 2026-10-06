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

import org.gwtbootstrap5.client.shared.js.BootstrapPopover;
import org.gwtbootstrap5.client.ui.base.AbstractTooltip;

import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.Widget;

import jsinterop.base.JsPropertyMap;

/**
 * Popover: a box with a title and content that opens next to its widget, on click by default.
 * <h2>UiBinder example</h2>
 * <pre>{@code
 *     <b:Popover title="Popover title" content="And here's some amazing content." placement="RIGHT">
 *         <b:Button type="DANGER" text="Click to toggle popover"/>
 *     </b:Popover>
 * }</pre>
 *
 * @author Steven Jardine
 * @see <a href="https://getbootstrap.com/docs/5.3/components/popovers/">Bootstrap 5 documentation</a>
 */
public class Popover extends AbstractTooltip {

    private static final String TEMPLATE = "<div class=\"popover\" role=\"tooltip\"><div class=\"popover-arrow\"></div><h3 class=\"popover-header\"></h3><div class=\"popover-body\"></div></div>";

    private String content = null;

    /**
     * Creates the empty Popover
     */
    public Popover() {
        super("bs.popover");
        setAlternateTemplate(TEMPLATE);
    }

    /**
     * Creates the popover with given title. Remember to set the content and widget as well.
     *
     * @param title title for the popover
     */
    public Popover(final String title) {
        this();
        setTitle(title);
    }

    /**
     * Creates the popover with given title and content. Remember to set the widget as well.
     *
     * @param title title for the popover
     * @param content content of the popover
     */
    public Popover(final String title, String content) {
        this();
        setTitle(title);
        setContent(content);
    }

    /**
     * Creates the popover around this widget
     *
     * @param w widget for the popover
     */
    public Popover(final Widget w) {
        this();
        setWidget(w);
    }

    /**
     * Creates the popover around this widget with given title and content.
     *
     * @param w widget for the popover
     * @param title title for the popover
     * @param content content for the popover
     */
    public Popover(final Widget w, final String title, String content) {
        this();
        setWidget(w);
        setTitle(title);
        setContent(content);
    }

    /**
     * Call the native popover method with the given argument.
     *
     * @param e the {@link Element}.
     * @param arg the arg
     */
    private void call(final Element e, final String arg) {
        invoke(BootstrapPopover.getOrCreateInstance(e, null), arg);
    }

    /** {@inheritDoc} */
    @Override
    protected void call(String arg) {
        call(getWidget().getElement(), arg);
    }

    /**
     * Returns the content of the popover.
     *
     * @return the content of the popover.
     */
    public String getContent() {
        return content == null ? "" : content;
    }

    /** {@inheritDoc} */
    @Override
    public void init() {
        Element element = getWidget().getElement();
        createOptions(element, isAnimated(), isHtml(), getSelector(), getTrigger().getCssName(), getShowDelayMs(),
                getHideDelayMs(), getContainer(), prepareTemplate());
        popover(element, getContent());
        bindJavaScriptEvents(element);
        setInitialized(true);
    }

    /**
     * Create the popover.
     */
    @Override
    protected void updateContent() {
        final BootstrapPopover instance = BootstrapPopover.getInstance(getWidget().getElement());
        if (instance != null) {
            instance.setContent(JsPropertyMap.of(".popover-header", getTitle(), ".popover-body", getContent()));
        }
    }

    private void popover(Element e, String content) {
        e.setAttribute("data-bs-content", content);
        BootstrapPopover.getOrCreateInstance(e, null);
    }

    /**
     * Sets the content of the popover. An initialized popover shows the new content at once.
     *
     * @param content the content of the popover to set
     */
    public void setContent(String content) {
        this.content = content;
        if (initialized) {
            widget.getElement().setAttribute("data-bs-content", content);
            // Bootstrap reads the content once, when the instance is created
            updateContent();
        }
    }

}
