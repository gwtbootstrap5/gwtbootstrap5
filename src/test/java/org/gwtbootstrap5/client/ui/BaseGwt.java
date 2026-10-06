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

import org.gwtbootstrap5.client.ui.base.HasActive;
import org.gwtbootstrap5.client.ui.base.HasFormValue;
import org.gwtbootstrap5.client.ui.constants.Styles;

import com.google.gwt.core.client.ScriptInjector;
import com.google.gwt.dom.client.Element;
import com.google.gwt.junit.client.GWTTestCase;
import com.google.gwt.user.client.ui.HasEnabled;
import com.google.gwt.user.client.ui.HasName;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.UIObject;

public abstract class BaseGwt extends GWTTestCase {

    /**
     * Specifies a module to use when running this test case. The returned
     * module must include the source for this class.
     *
     * @see com.google.gwt.junit.client.GWTTestCase#getModuleName()
     */
    @Override
    public String getModuleName() {
        return "org.gwtbootstrap5.GwtBootstrap5";
    }

    /**
     * HtmlUnit can't run Bootstrap's JavaScript, so its components get a stand-in that only keeps
     * one do-nothing instance per element. The tests check the markup GwtBootstrap5 writes; the
     * browser check of the demo runs the real thing.
     */
    private static final String FAKE_BOOTSTRAP = "if (!window.bootstrap) { window.bootstrap = {}; }"
            + "['Alert', 'Carousel', 'Collapse', 'Dropdown', 'Modal', 'Offcanvas', 'Popover', 'ScrollSpy',"
            + " 'Tab', 'Toast', 'Tooltip'].forEach(function (name) {"
            + "  if (window.bootstrap[name]) { return; }"
            + "  var key = '__fake' + name;"
            + "  var noop = function () {};"
            + "  window.bootstrap[name] = {"
            + "    getInstance: function (e) { return e[key] || null; },"
            + "    getOrCreateInstance: function (e) {"
            + "      if (!e[key]) {"
            + "        e[key] = { show: noop, hide: noop, toggle: noop, close: noop, update: noop, enable: noop,"
            + "          disable: noop, toggleEnabled: noop, setContent: noop, handleUpdate: noop, cycle: noop,"
            + "          pause: noop, prev: noop, next: noop, nextWhenVisible: noop, to: noop, refresh: noop,"
            + "          isShown: function () { return false; },"
            + "          dispose: function () { delete e[key]; } };"
            + "      }"
            + "      return e[key];"
            + "    }"
            + "  };"
            + "});";

    @Override
    protected void gwtSetUp() throws Exception {
        super.gwtSetUp();
        ScriptInjector.fromString(FAKE_BOOTSTRAP).setWindow(ScriptInjector.TOP_WINDOW).inject();
    }

    public <T extends UIObject & HasActive> void checkActive(T button) {
        final Element label = button.getElement();
        assertFalse(label.hasClassName(Styles.ACTIVE));
        button.setActive(true);
        assertTrue(label.hasClassName(Styles.ACTIVE));
        button.setActive(false);
        assertFalse(label.hasClassName(Styles.ACTIVE));
    }

    public <T extends UIObject & HasName> void checkName(T button) {
        final String name = "name";
        button.setName(name);
        assertEquals(name, button.getName());
    }

    public <T extends UIObject & HasFormValue> void checkFormValue(T button) {
        final String formValue = "formValue";
        button.setFormValue(formValue);
        assertEquals(formValue, button.getFormValue());
    }

    public <T extends UIObject & HasValue<Boolean>> void checkValue(T button) {
        button.setValue(true);
        assertTrue(button.getValue());
        button.setValue(false);
        assertFalse(button.getValue());
    }

    public <T extends UIObject & HasEnabled> void checkEnabled(T button) {
        final Element label = button.getElement();
        assertFalse(label.hasClassName(Styles.DISABLED));
        assertFalse(label.hasAttribute(Styles.DISABLED));
        button.setEnabled(false);
        assertTrue(label.hasClassName(Styles.DISABLED));
        assertTrue(label.hasAttribute(Styles.DISABLED));
        button.setEnabled(true);
        assertFalse(label.hasClassName(Styles.DISABLED));
        assertFalse(label.hasAttribute(Styles.DISABLED));
    }

}
