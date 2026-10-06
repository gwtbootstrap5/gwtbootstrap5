package org.gwtbootstrap5.client.ui.gwt;

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

import org.gwtbootstrap5.client.ui.base.HasResponsiveness;
import org.gwtbootstrap5.client.ui.base.helper.StyleHelper;
import org.gwtbootstrap5.client.ui.constants.DeviceSize;

import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.NamedFrame;

/** GWT's {@code FormPanel} with an id and the responsive visibility classes. */
public class FormPanel extends com.google.gwt.user.client.ui.FormPanel
        implements HasResponsiveness {

    /** Creates an empty form that submits into a hidden frame. */
    public FormPanel() {
        super();
    }

    /**
     * Creates a form in the given {@code form} element.
     *
     * @param element the form element
     * @param createIFrame {@code true} to submit into a hidden frame
     */
    public FormPanel(Element element, boolean createIFrame) {
        super(element, createIFrame);
    }

    /**
     * Creates a form in the given {@code form} element, submitting into a hidden frame.
     *
     * @param element the form element
     */
    public FormPanel(Element element) {
        super(element);
    }

    /**
     * Creates a form that submits into the given frame.
     *
     * @param frameTarget the frame
     */
    public FormPanel(NamedFrame frameTarget) {
        super(frameTarget);
    }

    /**
     * Creates a form that submits into the window or frame with the given name.
     *
     * @param target the name of the window or frame
     */
    public FormPanel(String target) {
        super(target);
    }

    @Override
    public void setVisibleOn(final DeviceSize deviceSize) {
        StyleHelper.setVisibleOn(this, deviceSize);
    }

    @Override
    public void setHiddenOn(final DeviceSize deviceSize) {
        StyleHelper.setHiddenOn(this, deviceSize);
    }

}
