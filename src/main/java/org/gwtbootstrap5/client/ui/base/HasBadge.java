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

/*
 * @author Drew Spencer
 */
import org.gwtbootstrap5.client.ui.constants.BadgePosition;

/** A widget that shows a {@link org.gwtbootstrap5.client.ui.Badge} next to its text. */
public interface HasBadge {

    /**
     * Sets the text of the badge, creating it.
     *
     * @param badgeText the text, or {@code null} to remove the badge
     */
    void setBadgeText(String badgeText);

    /**
     * Returns the text of the badge.
     *
     * @return the text, or {@code null} if there is no badge
     */
    String getBadgeText();

    /**
     * Sets on which side of the text the badge goes.
     *
     * @param badgePosition the side
     */
    void setBadgePosition(BadgePosition badgePosition);

    /**
     * Returns on which side of the text the badge goes.
     *
     * @return the side
     */
    BadgePosition getBadgePosition();
}
