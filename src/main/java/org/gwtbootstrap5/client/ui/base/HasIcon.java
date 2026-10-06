package org.gwtbootstrap5.client.ui.base;

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

/**
 * Interface for all the properties of Icons
 *
 * @author Sven Jacobs
 * @author Joshua Godi
 */
public interface HasIcon {

    /**
     * Sets the icon by name.
     *
     * @param icon the name of an {@link IconType} constant
     */
    void setIcon(String icon);

    /**
     * Sets the icon.
     *
     * @param iconType the icon
     */
    void setIcon(IconType iconType);

    /**
     * Returns the icon.
     *
     * @return the icon, or {@code null} if none
     */
    IconType getIcon();

    /**
     * Sets the size of the icon.
     *
     * @param iconSize the size
     */
    void setIconSize(IconSize iconSize);

    /**
     * Returns the size of the icon.
     *
     * @return the size
     */
    IconSize getIconSize();

    /**
     * Flips the icon.
     *
     * @param iconFlip the flip
     */
    void setIconFlip(IconFlip iconFlip);

    /**
     * Returns the flip of the icon.
     *
     * @return the flip
     */
    IconFlip getIconFlip();

    /**
     * Rotates the icon.
     *
     * @param iconRotate the rotation
     */
    void setIconRotate(IconRotate iconRotate);

    /**
     * Returns the rotation of the icon.
     *
     * @return the rotation
     */
    IconRotate getIconRotate();

    /**
     * Draws a border around the icon.
     *
     * @param iconBordered {@code true} for a border
     */
    void setIconBordered(boolean iconBordered);

    /**
     * Returns whether the icon has a border.
     *
     * @return {@code true} if it has a border
     */
    boolean isIconBordered();

    /**
     * Draws the icon in white.
     *
     * @param iconInverse {@code true} for a white icon
     */
    void setIconInverse(boolean iconInverse);

    /**
     * Returns whether the icon is white.
     *
     * @return {@code true} if it is white
     */
    boolean isIconInverse();

    /**
     * Spins the icon continuously.
     *
     * @param iconSpin {@code true} to spin
     */
    void setIconSpin(boolean iconSpin);

    /**
     * Returns whether the icon spins.
     *
     * @return {@code true} if it spins
     */
    boolean isIconSpin();

    /**
     * Spins the icon in eight steps.
     *
     * @param iconPulse {@code true} to pulse
     */
    void setIconPulse(boolean iconPulse);

    /**
     * Returns whether the icon pulses.
     *
     * @return {@code true} if it pulses
     */
    boolean isIconPulse();

    /**
     * Gives the icon a fixed width.
     *
     * @param iconFixedWidth {@code true} for a fixed width
     */
    void setIconFixedWidth(boolean iconFixedWidth);

    /**
     * Returns whether the icon has a fixed width.
     *
     * @return {@code true} if it has a fixed width
     */
    boolean isIconFixedWidth();

    /**
     * Sets the color of the icon.
     *
     * @param iconColor a CSS color
     */
    void setIconColor(String iconColor);

    /**
     * Returns the color of the icon.
     *
     * @return the CSS color, or {@code null} if none
     */
    String getIconColor();

}
