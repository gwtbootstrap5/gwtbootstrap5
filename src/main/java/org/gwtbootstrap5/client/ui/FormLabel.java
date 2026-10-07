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

import org.gwtbootstrap5.client.ui.base.helper.StyleHelper;
import org.gwtbootstrap5.client.ui.base.AbstractTextWidget;
import org.gwtbootstrap5.client.ui.constants.*;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Style;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.DomEvent;

/**
 * Label of a form control ({@code label.col-form-label}). It can show a required marker after
 * its text.
 * <h2>UiBinder example</h2>
 * <pre>{@code
 *     <b:FormLabel for="email" text="Email" showRequiredIndicator="true"/>
 *     <b:TextBox b:id="email"/>
 * }</pre>
 *
 * @see <a href="https://getbootstrap.com/docs/5.3/forms/layout/#horizontal-form">Bootstrap 5 documentation</a>
 *
 * @author Sven Jacobs
 * @author Steven Jardine
 */
public class FormLabel extends AbstractTextWidget {

    private Element iconElement = null;

    private boolean showRequiredIndicator = false;

    /**
     * Constructor.
     */
    public FormLabel() {
        super(Document.get().createLabelElement());
        setStyleName(Styles.CONTROL_LABEL);
        addHandler(event -> {
            if (iconElement != null) {
                iconElement.removeFromParent();
            }
            String html = getHTML();
            if (showRequiredIndicator && html != null && !html.isEmpty()) {
                iconElement = createIconElement();
                getElement().appendChild(iconElement);
            }
        }, ChangeEvent.getType());
    }

    /**
     * Creates the required marker: a small red star.
     *
     * @return a new icon element. We only create this when {@link #iconElement} is null or the
     *         {@link #showRequiredIndicator} has changed.
     */
    protected Element createIconElement() {
        Element e = Document.get().createElement(ElementTags.I);
        e.addClassName(IconTypeBI.STAR.getCssName());
        Style s = e.getStyle();
        s.setFontSize(6, Unit.PX);
        s.setPaddingLeft(2, Unit.PX);
        s.setPaddingRight(5, Unit.PX);
        s.setColor("#b94a48");
        Element sup = Document.get().createElement("sup");
        sup.appendChild(e);
        return sup;
    }

    /**
     * Returns whether the label shows the required marker.
     *
     * @return does this label show required?
     */
    public boolean getShowRequiredIndicator() {
        return showRequiredIndicator;
    }

    /**
     * Sets the control the label belongs to ({@code for} attribute).
     *
     * @param f the id of the control, or {@code null} for none
     */
    public void setFor(final String f) {
        if (f != null) {
            getElement().setAttribute(Attributes.FOR, f);
        } else {
            getElement().removeAttribute(Attributes.FOR);
        }
    }

    /** {@inheritDoc} */
    @Override
    public void setHTML(final String html) {
        super.setHTML(html);
        DomEvent.fireNativeEvent(Document.get().createChangeEvent(), this);
    }

    /**
     * Shows or hides the required marker after the text.
     *
     * @param required should this label show as required?
     */
    public void setShowRequiredIndicator(boolean required) {
        this.showRequiredIndicator = required;
        DomEvent.fireNativeEvent(Document.get().createChangeEvent(), this);
    }

    /** {@inheritDoc} */
    @Override
    public void setText(String text) {
        super.setText(text);
        DomEvent.fireNativeEvent(Document.get().createChangeEvent(), this);
    }

    /**
     * Makes the label, to match a large or small control, larger or smaller ({@code col-form-label-lg} or {@code col-form-label-sm}).
     *
     * @param size {@code LARGE}, {@code SMALL}, or {@code DEFAULT} / {@code null} for the normal size
     */
    public void setSize(final InputSize size) {
        removeStyleName(Styles.COL_FORM_LABEL_LG);
        removeStyleName(Styles.COL_FORM_LABEL_SM);
        if (size == InputSize.LARGE) {
            addStyleName(Styles.COL_FORM_LABEL_LG);
        } else if (size == InputSize.SMALL) {
            addStyleName(Styles.COL_FORM_LABEL_SM);
        }
    }

    /**
     * Returns the size of the label, to match a large or small control,.
     *
     * @return {@code LARGE}, {@code SMALL} or {@code DEFAULT}
     */
    public InputSize getSize() {
        if (StyleHelper.containsStyle(getStyleName(), Styles.COL_FORM_LABEL_LG)) {
            return InputSize.LARGE;
        }
        return StyleHelper.containsStyle(getStyleName(), Styles.COL_FORM_LABEL_SM) ? InputSize.SMALL : InputSize.DEFAULT;
    }
}
