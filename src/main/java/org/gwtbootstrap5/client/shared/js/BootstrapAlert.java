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
 * Native binding for Bootstrap 5's {@code bootstrap.Alert} component: dismissible alerts.
 *
 * @see <a href="https://getbootstrap.com/docs/5.3/">Bootstrap 5 documentation</a>
 */
@JsType(isNative = true, namespace = "bootstrap", name = "Alert")
public class BootstrapAlert {

    /**
     * Returns the instance bound to the element, creating it if needed.
     *
     * @param element the component's element
     * @return the instance
     */
    public static native BootstrapAlert getOrCreateInstance(Element element);

    /**
     * Returns the instance bound to the element.
     *
     * @param element the component's element
     * @return the instance, or {@code null} if none was created
     */
    public static native BootstrapAlert getInstance(Element element);

    /** Closes the alert and removes it from the DOM. */
    public native void close();

    /** Destroys the instance and removes its stored data. */
    public native void dispose();

}
