package org.gwtbootstrap5.client.ui.base;

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
 * A widget with setters for some properties of its inline style, in pixels. Bootstrap's spacing
 * and color utility classes are usually better.
 *
 * @author Joshua Godi
 */
public interface HasInlineStyle {
    /**
     * Sets the top margin.
     *
     * @param margin the margin, in pixels
     */
    void setMarginTop(double margin);

    /**
     * Sets the left margin.
     *
     * @param margin the margin, in pixels
     */
    void setMarginLeft(double margin);

    /**
     * Sets the right margin.
     *
     * @param margin the margin, in pixels
     */
    void setMarginRight(double margin);

    /**
     * Sets the bottom margin.
     *
     * @param margin the margin, in pixels
     */
    void setMarginBottom(double margin);

    /**
     * Sets the top padding.
     *
     * @param padding the padding, in pixels
     */
    void setPaddingTop(double padding);

    /**
     * Sets the left padding.
     *
     * @param padding the padding, in pixels
     */
    void setPaddingLeft(double padding);

    /**
     * Sets the right padding.
     *
     * @param padding the padding, in pixels
     */
    void setPaddingRight(double padding);

    /**
     * Sets the bottom padding.
     *
     * @param padding the padding, in pixels
     */
    void setPaddingBottom(double padding);

    /**
     * Sets the text color.
     *
     * @param color a CSS color
     */
    void setColor(String color);
}
