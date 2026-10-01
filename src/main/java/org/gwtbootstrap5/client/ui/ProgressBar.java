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
 * @author Joshua Godi
 */
public class ProgressBar extends Div implements HasType<ProgressBarType> {
    private final Span span = new Span();

    public ProgressBar() {
        super();

        // Default style
        setStyleName(Styles.PROGRESS_BAR);

        // Progress text
        add(span);
    }

    public void setVisuallyHidden(final boolean visuallyHidden) {
        span.setStyleName(Styles.VISUALLY_HIDDEN, visuallyHidden);
    }

    public void setText(final String text) {
        span.setText(text);
    }

    public String getText() {
        return span.getText();
    }

    public void setPercent(final double percent) {
        getElement().getStyle().setWidth(percent, Style.Unit.PCT);
    }

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

    public void setStriped(boolean isStriped) {
        if (isStriped) {
            addStyleName(Styles.PROGRESS_BAR_STRIPPED);
        } else {
            removeStyleName(Styles.PROGRESS_BAR_STRIPPED);
        }
    }

    public void setAnimated(boolean isAnimated) {
        if (isAnimated) {
            addStyleName(Styles.PROGRESS_BAR_ANIMATED);
        } else {
            removeStyleName(Styles.PROGRESS_BAR_ANIMATED);
        }
    }
}
