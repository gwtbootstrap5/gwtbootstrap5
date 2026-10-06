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

import org.gwtbootstrap5.client.ui.base.ComplexWidget;
import org.gwtbootstrap5.client.ui.base.HasEmphasis;
import org.gwtbootstrap5.client.ui.base.HasSize;
import org.gwtbootstrap5.client.ui.base.HasType;
import org.gwtbootstrap5.client.ui.base.helper.StyleHelper;
import org.gwtbootstrap5.client.ui.constants.*;

import com.google.gwt.dom.client.Document;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.uibinder.client.UiConstructor;
import org.gwtbootstrap5.client.ui.util.IconUtil;

/**
 * Icon ({@code i}) of the icon set in use, Bootstrap Icons by default, with size, rotation, flip,
 * spin and stacking options.
 * <h2>UiBinder example</h2>
 * <pre>{@code
 *     <b:Icon icon="CAMERA_FILL" size="LARGE"/>
 *     <b:Icon icon="ARROW_REPEAT" spin="true"/>
 * }</pre>
 *
 * @author Sven Jacobs
 * @see IconType
 * @see org.gwtbootstrap5.client.ui.constants.IconSize
 * @see <a href="https://icons.getbootstrap.com/">Bootstrap Icons</a>
 */
public class Icon extends ComplexWidget implements HasType<IconType>, HasSize<IconSize>, HasEmphasis, HasClickHandlers {

    /** Creates an icon without a type. */
    @UiConstructor
    public Icon() {
        super();

        setElement(Document.get().createElement(ElementTags.I));
        IconStyles.ensureInjected();
    }

    /**
     * Sets the icon by name.
     *
     * @param icon the name of an {@link IconType} constant
     */
    public void setIcon(final String icon) {
        IconType iconType = IconUtil.getInstance().fromIconType(icon);

        setType(iconType);
    }

    /**
     * Returns the name of the icon.
     *
     * @return the name of its {@link IconType}
     */
    public String getIcon() {
        return IconUtil.getInstance().fromStyleName(getStyleName()).getName();
    }

    @Override
    public void setType(final IconType type) {
        IconUtil.getInstance().setType(this, type);
    }

    @Override
    public IconType getType() {
        return IconUtil.getInstance().fromStyleName(getStyleName());
    }

    /**
     * Draws a border around the icon ({@code fa-border}).
     *
     * @param border {@code true} for a border
     */
    public void setBorder(final boolean border) {
        StyleHelper.toggleStyleName(this, border, Styles.ICON_BORDER);
    }

    /**
     * Returns whether the icon has a border.
     *
     * @return {@code true} if it has {@code fa-border}
     */
    public boolean isBorder() {
        return StyleHelper.containsStyle(getStyleName(), Styles.ICON_BORDER);
    }

    /**
     * Makes the icon the large base of an {@link IconStack} ({@code fa-stack-2x}).
     *
     * @param stackBase {@code true} for the base icon
     */
    public void setStackBase(final boolean stackBase) {
        StyleHelper.toggleStyleName(this, stackBase, Styles.ICON_STACK_BASE);
    }

    /**
     * Returns whether the icon is the base of a stack.
     *
     * @return {@code true} if it has {@code fa-stack-2x}
     */
    public boolean isStackBase() {
        return StyleHelper.containsStyle(getStyleName(), Styles.ICON_STACK_BASE);
    }

    /**
     * Gives the icon a fixed width, to align icons in a list ({@code fa-fw}).
     *
     * @param fixedWidth {@code true} for a fixed width
     */
    public void setFixedWidth(final boolean fixedWidth) {
        StyleHelper.toggleStyleName(this, fixedWidth, Styles.ICON_FIXED_WIDTH);
    }

    /**
     * Returns whether the icon has a fixed width.
     *
     * @return {@code true} if it has {@code fa-fw}
     */
    public boolean isFixedWidth() {
        return StyleHelper.containsStyle(getStyleName(), Styles.ICON_FIXED_WIDTH);
    }

    /**
     * Makes the icon the small top of an {@link IconStack} ({@code fa-stack-1x}).
     *
     * @param stackTop {@code true} for the top icon
     */
    public void setStackTop(final boolean stackTop) {
        StyleHelper.toggleStyleName(this, stackTop, Styles.ICON_STACK_TOP);
    }

    /**
     * Returns whether the icon is the top of a stack.
     *
     * @return {@code true} if it has {@code fa-stack-1x}
     */
    public boolean isStackTop() {
        return StyleHelper.containsStyle(getStyleName(), Styles.ICON_STACK_TOP);
    }

    /**
     * Draws the icon in white, for a dark stack base ({@code fa-inverse}).
     *
     * @param inverse {@code true} for a white icon
     */
    public void setInverse(final boolean inverse) {
        StyleHelper.toggleStyleName(this, inverse, Styles.ICON_INVERSE);
    }

    /**
     * Returns whether the icon is white.
     *
     * @return {@code true} if it has {@code fa-inverse}
     */
    public boolean isInverse() {
        return StyleHelper.containsStyle(getStyleName(), Styles.ICON_INVERSE);
    }

    /**
     * Spins the icon continuously ({@code fa-spin}).
     *
     * @param spin {@code true} to spin
     */
    public void setSpin(final boolean spin) {
        StyleHelper.toggleStyleName(this, spin, Styles.ICON_SPIN);
    }

    /**
     * Returns whether the icon spins.
     *
     * @return {@code true} if it has {@code fa-spin}
     */
    public boolean isSpin() {
        return StyleHelper.containsStyle(getStyleName(), Styles.ICON_SPIN);
    }

    /**
     * Spins the icon in eight steps ({@code fa-pulse}).
     *
     * @param pulse {@code true} to pulse
     */
    public void setPulse(final boolean pulse) {
        StyleHelper.toggleStyleName(this, pulse, Styles.ICON_PULSE);
    }

    /**
     * Returns whether the icon pulses.
     *
     * @return {@code true} if it has {@code fa-pulse}
     */
    public boolean isPulse() {
        return StyleHelper.containsStyle(getStyleName(), Styles.ICON_PULSE);
    }

    /**
     * Rotates the icon ({@code fa-rotate-*}).
     *
     * @param iconRotate the rotation; {@code null} is ignored
     */
    public void setRotate(final IconRotate iconRotate) {
        if (iconRotate == null) {
            return;
        }
        StyleHelper.addUniqueEnumStyleName(this, IconRotate.class, iconRotate);
    }

    /**
     * Returns the rotation of the icon.
     *
     * @return the rotation, {@code NONE} if it isn't rotated
     */
    public IconRotate getRotate() {
        return IconRotate.fromStyleName(getStyleName());
    }

    /**
     * Flips the icon ({@code fa-flip-*}).
     *
     * @param iconFlip the flip; {@code null} is ignored
     */
    public void setFlip(final IconFlip iconFlip) {
        if (iconFlip == null) {
            return;
        }

        StyleHelper.addUniqueEnumStyleName(this, IconFlip.class, iconFlip);
    }

    /**
     * Returns the flip of the icon.
     *
     * @return the flip, {@code NONE} if it isn't flipped
     */
    public IconFlip getFlip() {
        return IconFlip.fromStyleName(getStyleName());
    }

    @Override
    public void setSize(final IconSize iconSize) {
        StyleHelper.addUniqueEnumStyleName(this, IconSize.class, iconSize);
    }

    @Override
    public IconSize getSize() {
        return IconSize.fromStyleName(getStyleName());
    }

    @Override
    public void setEmphasis(final Emphasis emphasis) {
        StyleHelper.addUniqueEnumStyleName(this, Emphasis.class, emphasis);
    }

    @Override
    public Emphasis getEmphasis() {
        return Emphasis.fromStyleName(getStyleName());
    }

    @Override
    public HandlerRegistration addClickHandler(final ClickHandler handler) {
        return addDomHandler(handler, ClickEvent.getType());
    }
}
