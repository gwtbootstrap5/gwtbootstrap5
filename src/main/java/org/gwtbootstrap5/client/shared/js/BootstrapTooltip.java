package org.gwtbootstrap5.client.shared.js;

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

import com.google.gwt.dom.client.Element;

import jsinterop.annotations.JsOptional;
import jsinterop.annotations.JsType;

/**
 * Native binding for Bootstrap 5's {@code bootstrap.Tooltip} component: tooltips.
 *
 * @see <a href="https://getbootstrap.com/docs/5.3/">Bootstrap 5 documentation</a>
 */
@JsType(isNative = true, namespace = "bootstrap", name = "Tooltip")
public class BootstrapTooltip {

    /** Don't call it: get the instance of an element with {@code getOrCreateInstance}. */
    public BootstrapTooltip() {
    }

    /**
     * Returns the instance bound to the element, creating it with the given config if needed.
     * The config is ignored when an instance already exists.
     *
     * @param element the component's element
     * @param config options object, or {@code null} to read them from {@code data-bs-*} attributes
     * @return the instance
     */
    public static native BootstrapTooltip getOrCreateInstance(Element element, @JsOptional Object config);

    /**
     * Returns the instance bound to the element.
     *
     * @param element the component's element
     * @return the instance, or {@code null} if none was created
     */
    public static native BootstrapTooltip getInstance(Element element);

    /** Shows the element's tooltip. */
    public native void show();

    /** Hides the element's tooltip. */
    public native void hide();

    /** Shows or hides the element's tooltip. */
    public native void toggle();

    /** Lets the tooltip be shown. */
    public native void enable();

    /** Stops the tooltip from being shown. */
    public native void disable();

    /** Toggles whether the tooltip can be shown. */
    public native void toggleEnabled();

    /** Updates the tooltip's position. */
    public native void update();

    /**
     * Replaces the content of the tooltip's template, shown at once if the tooltip is open.
     *
     * @param content map from a selector of the template to its new text or HTML, e.g.
     *            {@code {".tooltip-inner": "text"}}
     */
    public native void setContent(Object content);

    /** Destroys the instance and removes its stored data. */
    public native void dispose();

}
