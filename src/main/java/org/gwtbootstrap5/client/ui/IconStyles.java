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

import com.google.gwt.dom.client.StyleInjector;

/**
 * Makes the icon options work with Bootstrap Icons. {@link Icon} and {@link IconStack} write Font
 * Awesome's classes ({@code fa-2x}, {@code fa-spin}, {@code fa-stack}...), which Bootstrap Icons has
 * no CSS for. These rules give them that CSS, only on Bootstrap Icons ({@code .bi}), so icons of the
 * Font Awesome extra keep Font Awesome's own rules.
 */
final class IconStyles {

    private static final String CSS = ""
            // Sizes, also on a stack of Bootstrap Icons
            + ".bi.fa-lg,.fa-stack.fa-lg:has(>.bi){font-size:1.25em;line-height:.05em;vertical-align:-.075em}"
            + ".bi.fa-2x,.fa-stack.fa-2x:has(>.bi){font-size:2em}"
            + ".bi.fa-3x,.fa-stack.fa-3x:has(>.bi){font-size:3em}"
            + ".bi.fa-4x,.fa-stack.fa-4x:has(>.bi){font-size:4em}"
            + ".bi.fa-5x,.fa-stack.fa-5x:has(>.bi){font-size:5em}"
            + ".bi.fa-fw{display:inline-block;width:1.25em;text-align:center}"
            + ".bi.fa-border{border:.08em solid var(--bs-border-color);border-radius:.1em;padding:.2em .25em .15em}"
            + ".bi.fa-inverse{color:#fff}"
            // Animations, rotation and flip need a box: Bootstrap Icons are inline
            + ".bi.fa-spin,.bi.fa-pulse,.bi[class*=fa-rotate-],.bi[class*=fa-flip-]{display:inline-block}"
            + ".bi.fa-spin{animation:gb5-icon-spin 2s linear infinite}"
            + ".bi.fa-pulse{animation:gb5-icon-spin 1s steps(8) infinite}"
            + ".bi.fa-rotate-90{transform:rotate(90deg)}"
            + ".bi.fa-rotate-180{transform:rotate(180deg)}"
            + ".bi.fa-rotate-270{transform:rotate(270deg)}"
            + ".bi.fa-flip-horizontal{transform:scale(-1,1)}"
            + ".bi.fa-flip-vertical{transform:scale(1,-1)}"
            + "@media (prefers-reduced-motion:reduce){.bi.fa-spin,.bi.fa-pulse{animation:none}}"
            + "@keyframes gb5-icon-spin{from{transform:rotate(0)}to{transform:rotate(360deg)}}"
            // Stacks: two icons on top of each other in a 2em square
            + ".fa-stack:has(>.bi){display:inline-block;position:relative;width:2em;height:2em;line-height:2em;"
            + "vertical-align:middle}"
            + ".fa-stack>.bi.fa-stack-1x,.fa-stack>.bi.fa-stack-2x{position:absolute;left:0;width:100%;"
            + "text-align:center;line-height:inherit}"
            + ".fa-stack>.bi.fa-stack-2x{font-size:2em;line-height:1em}"
            + ".fa-stack>.bi::before{vertical-align:middle}";

    private static boolean injected;

    private IconStyles() {
    }

    /**
     * Adds the rules to the page, the first time an icon is created.
     */
    static void ensureInjected() {
        if (!injected) {
            injected = true;
            StyleInjector.inject(CSS);
        }
    }
}
