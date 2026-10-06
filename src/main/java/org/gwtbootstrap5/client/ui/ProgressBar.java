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

import org.gwtbootstrap5.client.ui.base.HasType;
import org.gwtbootstrap5.client.ui.base.helper.StyleHelper;
import org.gwtbootstrap5.client.ui.constants.ProgressBarType;
import org.gwtbootstrap5.client.ui.constants.Styles;
import org.gwtbootstrap5.client.ui.html.Div;
import org.gwtbootstrap5.client.ui.html.Span;

import com.google.gwt.dom.client.Style;

/**
 * Bar of a {@link Progress} ({@code div.progress-bar}): its width is the percentage done, and it
 * can show a text. Several bars in one {@code Progress} stack.
 * <h2>UiBinder example</h2>
 * <pre>{@code
 *     <b:Progress>
 *         <b:ProgressBar type="SUCCESS" percent="40" text="40%"/>
 *     </b:Progress>
 * }</pre>
 *
 * @see <a href="https://getbootstrap.com/docs/5.3/components/progress/">Bootstrap 5 documentation</a>
 *
 * @author Joshua Godi
 */
public class ProgressBar extends Div implements HasType<ProgressBarType> {
    private final Span span = new Span();

    /** Creates an empty bar, with no width. */
    public ProgressBar() {
        super();

        // Default style
        setStyleName(Styles.PROGRESS_BAR);

        // Progress text
        add(span);
    }

    /**
     * Hides the text visually, keeping it for screen readers ({@code visually-hidden}).
     *
     * @param visuallyHidden {@code true} to hide the text
     */
    public void setVisuallyHidden(final boolean visuallyHidden) {
        span.setStyleName(Styles.VISUALLY_HIDDEN, visuallyHidden);
    }

    /**
     * Sets the text shown in the bar.
     *
     * @param text the text
     */
    public void setText(final String text) {
        span.setText(text);
    }

    /**
     * Returns the text shown in the bar.
     *
     * @return the text
     */
    public String getText() {
        return span.getText();
    }

    /**
     * Sets how much is done: the width of the bar.
     *
     * @param percent the percentage, from 0 to 100
     */
    public void setPercent(final double percent) {
        getElement().getStyle().setWidth(percent, Style.Unit.PCT);
    }

    /**
     * Returns how much is done.
     *
     * @return the percentage, 0 if none was set
     */
    public double getPercent() {
        final String width = getElement().getStyle().getWidth();
        return width == null ? 0 : Double.parseDouble(width.substring(0, width.indexOf("%")));
    }

    @Override
    public void setType(final ProgressBarType type) {
        StyleHelper.addUniqueEnumStyleName(this, ProgressBarType.class, type);
    }

    @Override
    public ProgressBarType getType() {
        return ProgressBarType.fromStyleName(getStyleName());
    }

    /**
     * Draws stripes on the bar ({@code progress-bar-striped}).
     *
     * @param isStriped {@code true} for stripes
     */
    public void setStriped(boolean isStriped) {
        if (isStriped) {
            addStyleName(Styles.PROGRESS_BAR_STRIPPED);
        } else {
            removeStyleName(Styles.PROGRESS_BAR_STRIPPED);
        }
    }

    /**
     * Animates the stripes of the bar ({@code progress-bar-animated}); the bar must be striped too.
     *
     * @param isAnimated {@code true} to animate the stripes
     */
    public void setAnimated(boolean isAnimated) {
        if (isAnimated) {
            addStyleName(Styles.PROGRESS_BAR_ANIMATED);
        } else {
            removeStyleName(Styles.PROGRESS_BAR_ANIMATED);
        }
    }
}
