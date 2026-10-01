package org.gwtbootstrap5.client.ui.util;

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

import com.google.gwt.user.client.ui.UIObject;
import org.gwtbootstrap5.client.ui.base.helper.EnumHelper;
import org.gwtbootstrap5.client.ui.base.helper.StyleHelper;
import org.gwtbootstrap5.client.ui.constants.IconType;
import org.gwtbootstrap5.client.ui.constants.IconTypeBI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IconUtilBI implements IIconUtil {

    public List<IconType> getValues() {
        return new ArrayList<>(Arrays.asList(IconTypeBI.values()));
    }

    public IconType fromIconType(final String enumName) {
        if (enumName == null) return null;

        return EnumHelper.fromEnumName(enumName, IconTypeBI.class, null);
    }

    public IconType fromStyleName(final String styleName) {
        if (styleName == null) return null;

        return EnumHelper.fromStyleName(styleName, IconTypeBI.class, null);
    }

    public void setType(final UIObject uiObject, final IconType type) {
        if (type instanceof IconTypeBI) {
            StyleHelper.addUniqueEnumStyleName(uiObject, IconTypeBI.class, type);
        }
    }

}
