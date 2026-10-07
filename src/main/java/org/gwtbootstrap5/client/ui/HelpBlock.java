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

import org.gwtbootstrap5.client.ui.base.AbstractTextWidget;
import org.gwtbootstrap5.client.ui.constants.ElementTags;
import org.gwtbootstrap5.client.ui.constants.IconType;
import org.gwtbootstrap5.client.ui.constants.Styles;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Style.Display;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.DomEvent;
import org.gwtbootstrap5.client.ui.util.IconUtil;

/**
 * Help text of a form control ({@code span.form-text}). When the control fails validation its
 * error handler turns it into the error message ({@code invalid-feedback}), and back into the help
 * text once the error clears; {@link #setError(String)} does the same by hand. With
 * {@link #setValidText(String)}, a control that passes validation shows that text instead
 * ({@code valid-feedback}), and {@link #setFeedbackTooltip(boolean)} shows both messages as
 * tooltips ({@code invalid-tooltip} / {@code valid-tooltip}).
 * <h2>UiBinder example</h2>
 * <pre>{@code
 *     <b:FormGroup>
 *         <b:TextBox b:id="password"/>
 *         <b:HelpBlock text="Eight characters or more."/>
 *     </b:FormGroup>
 * }</pre>
 *
 * @author Joshua Godi
 * @author Steven Jardine
 * @see <a href="https://getbootstrap.com/docs/5.3/forms/form-control/#form-text">Bootstrap 5 documentation</a>
 */
public class HelpBlock extends AbstractTextWidget {

    private boolean error = false;
    private boolean valid = false;
    private boolean tooltip = false;
    private String validText = "";
    // The help text to show again once the error is cleared
    private String helpText = "";

    private Element iconElement = null;

    private IconType iconType = null;

    /**
     * Constructor.
     */
    public HelpBlock() {
        super(Document.get().createSpanElement());
        setStyleName(Styles.FORM_TEXT);
        addHandler(event -> {
            if (iconElement != null) {
                iconElement.removeFromParent();
            }
            if (error && iconType != null) {
                iconElement = createIconElement();
                getElement().insertFirst(iconElement);
            }
        }, ChangeEvent.getType());
    }

    /**
     * Clears the error or valid message and shows the help text again.
     */
    public void clearError() {
        if (!error && !valid) {
            return;
        }
        error = false;
        valid = false;
        removeFeedbackStyles();
        addStyleName(Styles.FORM_TEXT);
        getElement().getStyle().clearDisplay();
        setText(helpText);
    }

    /**
     * Sets the message shown when the control passes validation, in place of the help text
     * ({@code valid-feedback}). With a text, the error handler also marks the control as valid
     * ({@code is-valid}).
     *
     * @param validText the message, or {@code null} / empty to keep showing the help text
     */
    public void setValidText(final String validText) {
        this.validText = validText == null ? "" : validText;
    }

    /**
     * Returns the message shown when the control passes validation.
     *
     * @return the message, empty if none
     */
    public String getValidText() {
        return validText;
    }

    /**
     * Shows the error and valid messages as tooltips ({@code invalid-tooltip} /
     * {@code valid-tooltip}) instead of text under the control. The tooltip is positioned
     * against the closest positioned parent: give the form group {@code position-relative}.
     *
     * @param tooltip {@code true} for tooltips
     */
    public void setFeedbackTooltip(final boolean tooltip) {
        this.tooltip = tooltip;
        if (error) {
            setError(getText());
        } else if (valid) {
            setValid(getText());
        }
    }

    /**
     * Returns whether the messages show as tooltips.
     *
     * @return {@code true} for tooltips
     */
    public boolean isFeedbackTooltip() {
        return tooltip;
    }

    /**
     * Shows a message for a valid control in place of the help text, styled as Bootstrap's
     * {@code valid-feedback} (or {@code valid-tooltip}).
     *
     * @param message the message
     */
    public void setValid(final String message) {
        if (!error && !valid) {
            helpText = getText();
        }
        error = false;
        valid = true;
        removeStyleName(Styles.FORM_TEXT);
        removeFeedbackStyles();
        addStyleName(tooltip ? Styles.VALID_TOOLTIP : Styles.VALID_FEEDBACK);
        getElement().getStyle().setDisplay(Display.BLOCK);
        setText(message);
    }

    /**
     * Returns whether the block shows a valid message.
     *
     * @return {@code true} after {@link #setValid(String)}
     */
    public boolean isValid() {
        return valid;
    }

    private void removeFeedbackStyles() {
        removeStyleName(Styles.INVALID_FEEDBACK);
        removeStyleName(Styles.INVALID_TOOLTIP);
        removeStyleName(Styles.VALID_FEEDBACK);
        removeStyleName(Styles.VALID_TOOLTIP);
    }

    /**
     * Creates the icon shown before the error message.
     *
     * @return a new icon element. We only create this when {@link #iconElement}
     *         is null or the {@link #iconType} has changed.
     */
    protected Element createIconElement() {
        Element e = Document.get().createElement(ElementTags.I);
        e.addClassName(iconType.getCssName());
        e.getStyle().setPaddingRight(5, Unit.PX);
        return e;
    }

    /**
     * Returns the icon shown before the error message.
     *
     * @return the icon type
     */
    public IconType getIconType() {
        return iconType;
    }

    /**
     * Checks if this block is in the error state.
     *
     * @return true, if is error
     */
    public boolean isError() {
        return error;
    }

    /**
     * Shows an error message in place of the help text, styled as Bootstrap's
     * {@code invalid-feedback} (or {@code invalid-tooltip}).
     *
     * @param message the error message
     */
    public void setError(String message) {
        if (!error && !valid) {
            helpText = getText();
        }
        error = true;
        valid = false;
        removeStyleName(Styles.FORM_TEXT);
        removeFeedbackStyles();
        // invalid-feedback is hidden unless it follows an .is-invalid control; show it wherever it is
        addStyleName(tooltip ? Styles.INVALID_TOOLTIP : Styles.INVALID_FEEDBACK);
        getElement().getStyle().setDisplay(Display.BLOCK);
        setText(message);
    }

    /** {@inheritDoc} */
    @Override
    public void setHTML(String value) {
        String oldValue = getHTML();
        if (!oldValue.equals(value)) {
            super.setHTML(value);
            DomEvent.fireNativeEvent(Document.get().createChangeEvent(), this);
        }
    }

    /**
     * Sets the icon type. If the icon type changes programatically then the
     * icon is removed from the dom and recreated.
     *
     * @param type
     *            the new icon type
     */
    public void setIconType(IconType type) {
        IconType prevType = iconType;
        iconType = type;
        if (iconType != prevType && iconElement != null) {
            iconElement.removeFromParent();
            iconElement = null;
            DomEvent.fireNativeEvent(Document.get().createChangeEvent(), this);
        }
    }

    /**
     * Sets the icon shown before the error message, by name.
     *
     * @param icon the name of an {@link IconType} constant
     */
    public void setIcon(String icon) {
        setIconType(IconUtil.getInstance().fromIconType(icon));
    }

    /** {@inheritDoc} */
    @Override
    public void setText(String value) {
        String oldValue = getText();
        if (!oldValue.equals(value)) {
            super.setText(value);
            DomEvent.fireNativeEvent(Document.get().createChangeEvent(), this);
        }
    }

}
