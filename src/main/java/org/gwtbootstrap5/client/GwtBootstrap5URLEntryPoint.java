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
import org.gwtbootstrap5.client.ui.util.StyleInjector;

/**
 * Provides script injection for Popper and Bootstrap if they aren't already loaded.
 * 
 * @author Sven Jacobs
 * @author Steven Jardine
 */
public class GwtBootstrap5URLEntryPoint implements EntryPoint {

    /** {@inheritDoc} */
    @Override
    public void onModuleLoad() {
        final boolean bootstrapLoaded = GwtBootstrap5EntryPoint.isBootstrapLoaded();
        if (!bootstrapLoaded) {
            StyleInjector.injectCSS("https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css");
            StyleInjector.injectCSS("https://cdnjs.cloudflare.com/ajax/libs/font-awesome/7.0.1/css/all.min.css");
        }

        final Runnable loadBootstrap = () -> {
            if (!bootstrapLoaded) {
                ScriptInjector.fromUrl("https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.min.js")
                        .setWindow(ScriptInjector.TOP_WINDOW)
                        .inject();
            }
        };

        if (GwtBootstrap5EntryPoint.isPopperLoaded()) {
            loadBootstrap.run();
            return;
        }

        // bootstrap.min.js reads the Popper global when it loads, so Popper must come first.
        // Popper is also loaded when Bootstrap already is, because Tempus Dominus needs the global.
        ScriptInjector.fromUrl("https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js")
                .setWindow(ScriptInjector.TOP_WINDOW)
                .setCallback(new Callback<>() {
                    @Override
                    public void onFailure(Exception reason) {
                        GWT.log(reason.getMessage());
                    }

                    @Override
                    public void onSuccess(Void result) {
                        loadBootstrap.run();
                    }
                })
                .inject();
    }
    
}
