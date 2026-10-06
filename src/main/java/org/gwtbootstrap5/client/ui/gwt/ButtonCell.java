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

import org.gwtbootstrap5.client.ui.constants.*;

import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.text.shared.SimpleSafeHtmlRenderer;
import com.google.gwt.user.client.ui.HasEnabled;

/**
 * Cell of a {@link CellTable} or a {@link DataGrid} drawn as a Bootstrap button, with a type, a
 * size and an optional icon.
 */
public class ButtonCell extends com.google.gwt.cell.client.ButtonCell implements HasEnabled {

    private IconType icon;

    private ButtonType type = ButtonType.LIGHT;

    private ButtonSize size = ButtonSize.DEFAULT;

    private boolean enabled = true;

    /** Creates a light button cell. */
    public ButtonCell() {
        super(SimpleSafeHtmlRenderer.getInstance());
    }

    /**
     * Creates a button cell of a type.
     *
     * @param type the button type
     */
    public ButtonCell(ButtonType type) {
        this();
        this.type = type;
    }

    /**
     * Creates a light button cell with an icon.
     *
     * @param icon the icon, before the text
     */
    public ButtonCell(IconType icon) {
        this();
        this.icon = icon;
    }

    /**
     * Creates a light button cell of a size.
     *
     * @param size the button size
     */
    public ButtonCell(ButtonSize size) {
        this();
        this.size = size;
    }

    /**
     * Creates a button cell of a type, with an icon.
     *
     * @param type the button type
     * @param icon the icon, before the text
     */
    public ButtonCell(ButtonType type, IconType icon) {
        this();
        this.type = type;
        this.icon = icon;
    }

    /**
     * Creates a button cell of a type and a size.
     *
     * @param type the button type
     * @param size the button size
     */
    public ButtonCell(ButtonType type, ButtonSize size) {
        this();
        this.type = type;
        this.size = size;
    }

    /**
     * Creates a light button cell of a size, with an icon.
     *
     * @param icon the icon, before the text
     * @param size the button size
     */
    public ButtonCell(IconType icon, ButtonSize size) {
        this();
        this.icon = icon;
        this.size = size;
    }

    /**
     * Creates a button cell of a type and a size, with an icon.
     *
     * @param icon the icon, before the text
     * @param type the button type
     * @param size the button size
     */
    public ButtonCell(IconType icon, ButtonType type, ButtonSize size) {
        this();
        this.icon = icon;
        this.type = type;
        this.size = size;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    @Override
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public void render(com.google.gwt.cell.client.Cell.Context context, SafeHtml data, SafeHtmlBuilder sb) {
        String cssClasses = "btn" + //
                " " + //
                type.getCssName() + //
                " " + //
                size.getCssName() //
                ;

        String disabled = "";
        if (!enabled) {
            disabled = " disabled=\"disabled\"";
        }

        sb.appendHtmlConstant("<button type=\"button\" class=\"" + cssClasses + "\" tabindex=\"-1\"" + disabled + ">");
        if (icon != null) {
            String iconHtml = "<i class=\"" + //
                    " " + //
                    icon.getCssName() + //
                    "\"></i> " //
                    ;
            sb.appendHtmlConstant(iconHtml);
        }
        if (data != null) {
            sb.append(data);
        }
        sb.appendHtmlConstant("</button>");
    }

}
