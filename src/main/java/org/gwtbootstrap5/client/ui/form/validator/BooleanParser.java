package org.gwtbootstrap5.client.ui.form.validator;

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

import java.text.ParseException;

import com.google.gwt.text.shared.Parser;

/**
 * Parses boolean values from a {@link CharSequence}.
 * 
 * @author Steven Jardine
 */
public class BooleanParser implements Parser<Boolean> {

    private static BooleanParser instance;

    /**
     * @return the instance of the {@link BooleanParser}.
     */
    public static Parser<Boolean> instance() {
        if (instance == null) {
            instance = new BooleanParser();
        }
        return instance;
    }

    /**
     * Constructor.
     */
    protected BooleanParser() {
        super();
    }

    /** {@inheritDoc} */
    @Override
    public Boolean parse(final CharSequence text) {
        if (text != null) {
            String value = text.toString();
            if (value.equalsIgnoreCase("true") || value.equalsIgnoreCase("Yes")) {
                return true;
            }
            try {
                int i = Integer.parseInt(value);
                return i != 0;
            } catch (Exception ignored) {
                // Ignored
            }
        }
        return false;
    }

}
