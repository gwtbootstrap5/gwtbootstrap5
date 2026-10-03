package org.gwtbootstrap5.client;

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

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.ScriptInjector;

import jsinterop.base.Js;

/**
 * Provides script injection for Popper and Bootstrap if they aren't already loaded.
 * 
 * @author Sven Jacobs
 * @author Steven Jardine
 */
public class GwtBootstrap5EntryPoint implements EntryPoint {

    /**
     * Check to see if Bootstrap is loaded already.
     * 
     * @return true is Bootstrap loaded, false otherwise.
     */
    static boolean isBootstrapLoaded() {
        return !"undefined".equals(Js.typeof(Js.global().get("bootstrap")));
    }

    /**
     * Check to see if the Popper global is loaded already. Bootstrap's dropdowns, popovers and
     * tooltips need it, and so does Tempus Dominus. {@code bootstrap.bundle.js} embeds Popper
     * without exposing this global.
     *
     * @return true if Popper is loaded, false otherwise.
     */
    static boolean isPopperLoaded() {
        return !"undefined".equals(Js.typeof(Js.global().get("Popper")));
    }

    /** {@inheritDoc} */
    @Override
    public void onModuleLoad() {
        // bootstrap.min.js reads the Popper global when it loads, so Popper must come first
        if (!isPopperLoaded()) {
            ScriptInjector.fromString(GwtBootstrap5ClientBundle.INSTANCE.popper().getText())
                .setWindow(ScriptInjector.TOP_WINDOW)
                .inject();
        }
        if (!isBootstrapLoaded()) {
            ScriptInjector.fromString(GwtBootstrap5ClientBundle.INSTANCE.bootstrap().getText())
                .setWindow(ScriptInjector.TOP_WINDOW)
                .inject();
        }
    }
    
}
