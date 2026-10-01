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

import com.google.gwt.core.client.Callback;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.ScriptInjector;
import jsinterop.annotations.JsMethod;
import org.gwtbootstrap5.client.ui.util.StyleInjector;

/**
 * Provides script injection for jQuery and boostrap if they aren't already loaded.
 * 
 * @author Sven Jacobs
 * @author Steven Jardine
 */
public class GwtBootstrap5URLEntryPoint implements EntryPoint {

    /**
     * Check to see if Bootstrap is loaded already.
     * 
     * @return true is Bootstrap loaded, false otherwise.
     */
    @JsMethod
    private static native boolean isBootstrapLoaded();

    /**
     * Check to see if jQuery is loaded already
     *
     * @return true is jQuery is loaded, false otherwise
     */
    @JsMethod
    private static native boolean isjQueryLoaded();

    /** {@inheritDoc} */
    @Override
    public void onModuleLoad() {
        ScriptInjector.fromString(GwtBootstrap5ClientBundle.INSTANCE.gwtBootstrap5().getText())
                .setWindow(ScriptInjector.TOP_WINDOW)
                .inject();

        ScriptInjector.fromUrl("https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js").setWindow(ScriptInjector.TOP_WINDOW)
                .inject();

        if (!isjQueryLoaded()) {
            ScriptInjector.fromUrl("https://code.jquery.com/jquery-3.7.1.min.js")
                    .setWindow(ScriptInjector.TOP_WINDOW)
                    .setCallback(new Callback<>() {
                        @Override
                        public void onFailure(Exception reason) {
                            GWT.log(reason.getMessage());
                        }

                        @Override
                        public void onSuccess(Void result) {
                            ScriptInjector.fromUrl("https://code.jquery.com/jquery-migrate-3.6.0.min.js").setWindow(ScriptInjector.TOP_WINDOW).inject();

                            if (!isBootstrapLoaded()) {
                                ScriptInjector.fromUrl("https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.min.js").setWindow(ScriptInjector.TOP_WINDOW)
                                        .inject();
                            }
                        }
                    })
                    .inject();

            StyleInjector.injectCSS("https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css");
            StyleInjector.injectCSS("https://cdnjs.cloudflare.com/ajax/libs/font-awesome/7.0.1/css/all.min.css");
        }
    }
    
}
