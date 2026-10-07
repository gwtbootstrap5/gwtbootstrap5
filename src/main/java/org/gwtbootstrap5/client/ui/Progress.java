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

import org.gwtbootstrap5.client.ui.constants.Styles;
import org.gwtbootstrap5.client.ui.html.Div;

import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Style;

/**
 * Progress container ({@code div.progress}) of one or more {@link ProgressBar}s. Stripes and
 * animation are set on each bar with {@link ProgressBar#setStriped(boolean)} and
 * {@link ProgressBar#setAnimated(boolean)}.
 *
 * @author Joshua Godi
 * @see <a href="https://getbootstrap.com/docs/5.3/components/progress/">Bootstrap 5 documentation</a>
 */
public class Progress extends Div {

    /** Creates an empty progress container ({@code div.progress}). */
    public Progress() {
        super();

        setStyleName(Styles.PROGRESS);
    }

    /**
     * Sets the width of the container as a share of its parent, for a segment of a
     * {@link ProgressStacked}. It also writes Bootstrap 5.3's {@code role="progressbar"} and
     * {@code aria-valuenow} / {@code aria-valuemin} / {@code aria-valuemax} on the container.
     *
     * @param percent the share, from 0 to 100
     */
    public void setPercent(final double percent) {
        final Element e = getElement();
        e.getStyle().setWidth(percent, Style.Unit.PCT);
        e.setAttribute("role", "progressbar");
        e.setAttribute("aria-valuenow", String.valueOf(percent));
        e.setAttribute("aria-valuemin", "0");
        e.setAttribute("aria-valuemax", "100");
    }

    /**
     * Returns the width set with {@link #setPercent(double)}.
     *
     * @return the share, 0 if none was set
     */
    public double getPercent() {
        final String width = getElement().getStyle().getWidth();
        return width == null || width.isEmpty() ? 0 : Double.parseDouble(width.substring(0, width.indexOf("%")));
    }
}
