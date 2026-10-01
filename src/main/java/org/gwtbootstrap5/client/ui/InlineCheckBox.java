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

import com.google.gwt.dom.client.Document;
import com.google.gwt.i18n.client.HasDirection.Direction;
import com.google.gwt.i18n.shared.DirectionEstimator;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.user.client.DOM;

/**
 * An inline checkbox widget.
 *
 * @author Sven Jacobs
 * @see org.gwtbootstrap5.client.ui.CheckBox
 */
public class InlineCheckBox extends CheckBox {

    /**
     * Creates a checkbox with the specified text label.
     * 
     * @param label
     *            the checkbox's label
     */
    public InlineCheckBox(SafeHtml label) {
        this(label.asString(), true);
    }

    /**
     * Creates a checkbox with the specified text label.
     * 
     * @param label
     *            the checkbox's label
     * @param dir
     *            the text's direction. Note that {@code DEFAULT} means
     *            direction should be inherited from the widget's parent
     *            element.
     */
    public InlineCheckBox(SafeHtml label, Direction dir) {
        this();
        setHTML(label, dir);
    }

    /**
     * Creates a checkbox with the specified text label.
     * 
     * @param label
     *            the checkbox's label
     * @param directionEstimator
     *            A DirectionEstimator object used for automatic direction
     *            adjustment.
     */
    public InlineCheckBox(SafeHtml label, DirectionEstimator directionEstimator) {
        this();
        setDirectionEstimator(directionEstimator);
        setHTML(label.asString());
    }

    /**
     * Creates a checkbox with the specified text label.
     * 
     * @param label
     *            the checkbox's label
     */
    public InlineCheckBox(String label) {
        this();
        setText(label);
    }

    /**
     * Creates a checkbox with the specified text label.
     * 
     * @param label
     *            the checkbox's label
     * @param dir
     *            the text's direction. Note that {@code DEFAULT} means
     *            direction should be inherited from the widget's parent
     *            element.
     */
    public InlineCheckBox(String label, Direction dir) {
        this();
        setText(label, dir);
    }

    /**
     * Creates a label with the specified text and a default direction
     * estimator.
     * 
     * @param label
     *            the checkbox's label
     * @param directionEstimator
     *            A DirectionEstimator object used for automatic direction
     *            adjustment.
     */
    public InlineCheckBox(String label, DirectionEstimator directionEstimator) {
        this();
        setDirectionEstimator(directionEstimator);
        setText(label);
    }

    /**
     * Creates a checkbox with the specified text label.
     * 
     * @param label
     *            the checkbox's label
     * @param asHTML
     *            <code>true</code> to treat the specified label as html
     */
    public InlineCheckBox(String label, boolean asHTML) {
        this();
        if (asHTML) {
            setHTML(label);
        } else {
            setText(label);
        }
    }

    public InlineCheckBox() {
        super(DOM.createLabel(), Document.get().createCheckInputElement());
        setStyleName(Styles.FORM_CHECK);

        getElement().appendChild(inputElem);
        getElement().appendChild(labelElem);
    }

}
