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

import org.gwtbootstrap5.client.ui.base.HasHref;
import org.gwtbootstrap5.client.ui.base.HasTargetHistoryToken;
import org.gwtbootstrap5.client.ui.base.button.AbstractToggleButton;
import org.gwtbootstrap5.client.ui.constants.ButtonType;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.AnchorElement;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.impl.HyperlinkImpl;

/**
 * Link ({@code a}) styled as a button ({@code btn btn-*}), for actions that navigate.
 * <h2>UiBinder example</h2>
 * <pre>{@code
 *     <b:AnchorButton type="PRIMARY" href="https://getbootstrap.com" text="Bootstrap"/>
 *     <b:AnchorButton type="SECONDARY" targetHistoryToken="settings" text="Settings"/>
 * }</pre>
 *
 * @author Sven Jacobs
 * @see Button
 * @see org.gwtbootstrap5.client.ui.base.button.AbstractToggleButton
 * @see <a href="https://getbootstrap.com/docs/5.3/components/buttons/#button-tags">Bootstrap 5 documentation</a>
 */
public class AnchorButton extends AbstractToggleButton implements HasHref, HasTargetHistoryToken {

    private static final HyperlinkImpl impl = GWT.create(HyperlinkImpl.class);

    private String targetHistoryToken;

    /**
     * Creates a link styled as a button of the given type.
     *
     * @param type the button type, which sets the {@code btn-*} class
     */
    public AnchorButton(final ButtonType type) {
        super(type);
        setHref(EMPTY_HREF);
        sinkEvents(Event.ONCLICK);
    }

    @Override
    public void onBrowserEvent(Event event) {
        super.onBrowserEvent(event);
        if (getTargetHistoryToken() != null) {
            // implementation is based on Hyperlink#onBrowserEvent
            if (DOM.eventGetType(event) == Event.ONCLICK && impl.handleAsClick(event)) {
                History.newItem(getTargetHistoryToken());
                event.preventDefault();
            }
        }
    }

    /**
     * Set the target history token for the widget. Note, that you should use either {@link #setTargetHistoryToken(String)}
     * or {@link #setHref(String)}, but not both as {@link #setHref(String)} resets the target history token.
     * @param targetHistoryToken String target history token of the widget
     */
    @Override
    public void setTargetHistoryToken(final String targetHistoryToken) {
        this.targetHistoryToken = targetHistoryToken;
        if (targetHistoryToken != null) {
            final String hash = History.encodeHistoryToken(targetHistoryToken);
            getAnchorElement().setHref("#" + hash);
        }
    }

    /**
     * Get the target history token for the widget. May return {@code null} if no history token has been set or if
     * it has been reset by {@link #setHref(String)}
     * @return String the widget's target history token
     */
    @Override
    public String getTargetHistoryToken() {
        return targetHistoryToken;
    }

    /** Creates a link styled as a light button ({@code btn-light}). */
    public AnchorButton() {
        this(ButtonType.LIGHT);
    }

    /**
     * Set's the HREF of the widget. Note, that you should use either {@link #setTargetHistoryToken(String)}
     * or {@link #setHref(String)}, but not both as {@link #setHref(String)} resets the target history token.
     * @param href String href
     */
    @Override
    public void setHref(final String href) {
        this.targetHistoryToken = null;
        getAnchorElement().setHref(href);
    }

    @Override
    public String getHref() {
        return getAnchorElement().getHref();
    }

    @Override
    protected Element createElement() {
        return Document.get().createAnchorElement();
    }

    private AnchorElement getAnchorElement() {
        return AnchorElement.as(getElement());
    }
}
