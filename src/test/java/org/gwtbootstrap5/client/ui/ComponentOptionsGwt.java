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

import java.util.Arrays;
import java.util.Collections;

import org.gwtbootstrap5.client.ui.constants.ListGroupHorizontal;
import org.gwtbootstrap5.client.ui.constants.ModalFullscreen;
import org.gwtbootstrap5.client.ui.constants.ModalSize;
import org.gwtbootstrap5.client.ui.constants.Styles;
import org.gwtbootstrap5.client.ui.constants.ValidationState;
import org.gwtbootstrap5.client.ui.form.error.BasicEditorError;

import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.InputElement;
import com.google.gwt.editor.client.EditorError;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * The Bootstrap 5.3 options added in 0.2.0: each one writes its class, and stops writing it
 * when it is turned off.
 */
public class ComponentOptionsGwt extends BaseGwt {

    private static Element dialog(final Modal modal) {
        final Element dialog = modal.getElement().getFirstChildElement();
        assertTrue(dialog.hasClassName(Styles.MODAL_DIALOG));
        return dialog;
    }

    public void testModalFullscreen() {
        final Modal modal = new Modal();
        final Element dialog = dialog(modal);
        modal.setFullscreen(ModalFullscreen.ALWAYS);
        assertTrue(dialog.hasClassName(ModalFullscreen.ALWAYS.getCssName()));
        assertEquals(ModalFullscreen.ALWAYS, modal.getFullscreen());
        modal.setFullscreen(ModalFullscreen.MD_DOWN);
        assertTrue(dialog.hasClassName(ModalFullscreen.MD_DOWN.getCssName()));
        assertFalse(dialog.hasClassName(ModalFullscreen.ALWAYS.getCssName()));

        // Independent of the size, which applies above the breakpoint
        modal.setSize(ModalSize.LARGE);
        assertTrue(dialog.hasClassName(ModalSize.LARGE.getCssName()));
        assertTrue(dialog.hasClassName(ModalFullscreen.MD_DOWN.getCssName()));

        modal.setFullscreen(null);
        assertFalse(dialog.hasClassName(ModalFullscreen.MD_DOWN.getCssName()));
        assertTrue(dialog.hasClassName(ModalSize.LARGE.getCssName()));
    }

    public void testModalCenteredAndScrollable() {
        final Modal modal = new Modal();
        final Element dialog = dialog(modal);
        modal.setCentered(true);
        modal.setScrollable(true);
        assertTrue(dialog.hasClassName(Styles.MODAL_DIALOG_CENTERED));
        assertTrue(dialog.hasClassName(Styles.MODAL_DIALOG_SCROLLABLE));
        modal.setCentered(false);
        modal.setScrollable(false);
        assertFalse(dialog.hasClassName(Styles.MODAL_DIALOG_CENTERED));
        assertFalse(dialog.hasClassName(Styles.MODAL_DIALOG_SCROLLABLE));
    }

    public void testListGroupHorizontalAndFlush() {
        final ListGroup group = new ListGroup();
        final Element element = group.getElement();
        group.setHorizontal(ListGroupHorizontal.ALWAYS);
        assertTrue(element.hasClassName(ListGroupHorizontal.ALWAYS.getCssName()));
        group.setHorizontal(ListGroupHorizontal.MD);
        assertTrue(element.hasClassName(ListGroupHorizontal.MD.getCssName()));
        assertFalse(element.hasClassName(ListGroupHorizontal.ALWAYS.getCssName()));
        assertEquals(ListGroupHorizontal.MD, group.getHorizontal());
        group.setHorizontal(null);
        assertFalse(element.hasClassName(ListGroupHorizontal.MD.getCssName()));
        assertTrue(element.hasClassName(Styles.LIST_GROUP));

        group.setFlush(true);
        assertTrue(element.hasClassName(Styles.LIST_GROUP_FLUSH));
        assertTrue(group.isFlush());
        group.setFlush(false);
        assertFalse(element.hasClassName(Styles.LIST_GROUP_FLUSH));
    }

    public void testCheckAndRadioButtonsUseBtnCheck() {
        final CheckBoxButton check = new CheckBoxButton("Bold");
        final RadioButton radio = new RadioButton("align", "Left");
        for (final Element button : new Element[] {check.getElement(), radio.getElement()}) {
            assertEquals("label", button.getTagName().toLowerCase());
            assertTrue(button.hasClassName(Styles.BTN));
            final InputElement input = InputElement.as(button.getFirstChildElement());
            assertTrue(input.hasClassName(Styles.BTN_CHECK));
            assertEquals("off", input.getAttribute("autocomplete"));
        }

        // The button is active while its input is checked
        check.setValue(true);
        assertTrue(check.getElement().hasClassName(Styles.ACTIVE));
        check.setValue(false);
        assertFalse(check.getElement().hasClassName(Styles.ACTIVE));
    }

    public void testValidationMessages() {
        final FormGroup group = new FormGroup();
        final TextBox box = new TextBox();
        final HelpBlock help = new HelpBlock();
        help.setText("We never share it");
        group.add(box);
        group.add(help);
        RootPanel.get().add(group);
        try {
            box.getErrorHandler().showErrors(Arrays.<EditorError>asList(
                    new BasicEditorError(null, null, "Required"),
                    new BasicEditorError(null, null, "Too short")));
            // Bootstrap 5 marks the control, and the help block becomes its feedback
            assertTrue(box.getElement().hasClassName(ValidationState.ERROR.getCssName()));
            assertTrue(help.getElement().hasClassName(Styles.INVALID_FEEDBACK));
            assertFalse(help.getElement().hasClassName(Styles.FORM_TEXT));
            assertEquals("Required; Too short", help.getText());

            box.getErrorHandler().showErrors(Collections.<EditorError>emptyList());
            assertFalse(box.getElement().hasClassName(ValidationState.ERROR.getCssName()));
            assertFalse(help.getElement().hasClassName(Styles.INVALID_FEEDBACK));
            assertTrue(help.getElement().hasClassName(Styles.FORM_TEXT));
            assertEquals("We never share it", help.getText());
        } finally {
            group.removeFromParent();
        }
    }
}
