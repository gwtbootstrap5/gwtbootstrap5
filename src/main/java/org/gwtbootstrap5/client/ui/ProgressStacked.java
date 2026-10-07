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

/**
 * Bars stacked in one row ({@code div.progress-stacked}), Bootstrap 5.3's markup for several
 * values in one progress bar. Each segment is a {@link Progress} whose
 * {@link Progress#setPercent(double) percent} is its share of the row, with one
 * {@link ProgressBar} inside that fills it.
 * <h2>UiBinder example</h2>
 * <pre>{@code
 * <b:ProgressStacked>
 *     <b:Progress percent="15"><b:ProgressBar/></b:Progress>
 *     <b:Progress percent="30"><b:ProgressBar type="SUCCESS"/></b:Progress>
 * </b:ProgressStacked>
 * }</pre>
 *
 * @see <a href="https://getbootstrap.com/docs/5.3/components/progress/#multiple-bars">Bootstrap 5 documentation</a>
 */
public class ProgressStacked extends Div {

    /** Creates an empty stack ({@code div.progress-stacked}). */
    public ProgressStacked() {
        setStyleName(Styles.PROGRESS_STACKED);
    }
}
