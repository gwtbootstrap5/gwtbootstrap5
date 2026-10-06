package org.gwtbootstrap5.client.ui.util;

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

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.LinkElement;

/** Adds style sheets to the page. */
public class StyleInjector {

    /** Creates an instance. Every method is static, so there is no need to. */
    public StyleInjector() {
    }

    /**
     * Adds a style sheet to the page, as a {@code link} in its head.
     *
     * @param cssURL the URL of the style sheet
     */
    public static void injectCSS(String cssURL) {
        LinkElement link = Document.get().createLinkElement();
        link.setRel("stylesheet");
        link.setHref(cssURL);

        Document.get().getHead().appendChild(link);
    }

}
