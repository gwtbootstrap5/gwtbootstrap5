package org.gwtbootstrap5.client.ui.constants;

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

/**
 * Classes that make an element look like a heading of a level, {@code h1} to {@code h6}, whatever
 * its tag.
 *
 * @author Joshua Godi
 * @see <a href="https://getbootstrap.com/docs/5.3/content/typography/#headings">Bootstrap 5 documentation</a>
 */
public enum HeadingStyle {
    H1("h1"),
    H2("h2"),
    H3("h3"),
    H4("h4"),
    H5("h5"),
    H6("h6");

    private final String cssClass;

    HeadingStyle(final String cssClass) {
        this.cssClass = cssClass;
    }

    /**
     * Returns the class that styles an element as a heading of the level.
     *
     * @return the class, such as {@code "h1"}
     */
    public String getCssClass() {
        return cssClass;
    }
}
