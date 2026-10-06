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

import com.google.gwt.i18n.client.ConstantsWithLookup;
import com.google.gwt.i18n.client.LocalizableResource.DefaultLocale;

/**
 * Validation messages.
 * Message functions should be the key with "_" replacing any periods. This allows the
 * ValidationMessageResolver to find the message by key.
 * 
 * @author Steven Jardine
 */
@DefaultLocale()
public interface ValidationMessages extends ConstantsWithLookup {

    /** Keys of the messages, to override them in a properties file of your own. */
    class Keys {

        /** Creates an instance. The keys are constants, so there is no need to. */
        public Keys() {
        }

        /** Key of the message of {@link BlankValidator}. */
        public static final String BLANK = "org.gwtbootstrap5.validation.Blank.message";

        /** Key of the message of {@link DecimalMaxValidator}. */
        public static final String DECIMAL_MAX = "org.gwtbootstrap5.validation.DecimalMax.message";

        /** Key of the message of {@link DecimalMinValidator}. */
        public static final String DECIMAL_MIN = "org.gwtbootstrap5.validation.DecimalMin.message";

        /** Key of the message of {@link FieldMatchValidator}. */
        public static final String FIELD_MATCH = "org.gwtbootstrap5.validation.FieldMatch.message";

        /** Key of the message of {@link FutureValidator}. */
        public static final String FUTURE = "org.gwtbootstrap5.validation.Future.message";

        /** Key of the message of {@link PastValidator}. */
        public static final String PAST = "org.gwtbootstrap5.validation.Past.message";

        /** Key of the message of {@link RegExValidator}. */
        public static final String REGEX = "org.gwtbootstrap5.validation.RegEx.message";

        /** Key of the message of {@link SizeValidator}. */
        public static final String SIZE = "org.gwtbootstrap5.validation.Size.message";

    }

    /**
     * Returns the message of {@link BlankValidator}.
     *
     * @return the blank validation message.
     */
    @Key(Keys.BLANK)
    @DefaultStringValue("Field cannot be blank")
    String org_gwtbootstrap5_validation_Blank_message();

    /**
     * Returns the message of {@link DecimalMaxValidator}.
     *
     * @return the decimal max validation message.
     */
    @Key(Keys.DECIMAL_MAX)
    @DefaultStringValue("Value must be less than or equal to {1}")
    String org_gwtbootstrap5_validation_DecimalMax_message();

    /**
     * Returns the message of {@link DecimalMinValidator}.
     *
     * @return the decimal min validation message.
     */
    @Key(Keys.DECIMAL_MIN)
    @DefaultStringValue("Value must be greater than or equal to {1}")
    String org_gwtbootstrap5_validation_DecimalMin_message();

    /**
     * Returns the message of {@link FieldMatchValidator}.
     *
     * @return the field match validation message.
     */
    @Key(Keys.FIELD_MATCH)
    @DefaultStringValue("{1} do not match")
    String org_gwtbootstrap5_validation_FieldMatch_message();

    /**
     * Returns the message of {@link FutureValidator}.
     *
     * @return the future validation message.
     */
    @Key(Keys.FUTURE)
    @DefaultStringValue("Value must be in the future")
    String org_gwtbootstrap5_validation_Future_message();

    /**
     * Returns the message of {@link PastValidator}.
     *
     * @return the past validation message.
     */
    @Key(Keys.PAST)
    @DefaultStringValue("Value must be in the past")
    String org_gwtbootstrap5_validation_Past_message();

    /**
     * Returns the message of {@link RegExValidator}.
     *
     * @return the regular expression validation message.
     */
    @Key(Keys.REGEX)
    @DefaultStringValue("Must match regex")
    String org_gwtbootstrap5_validation_RegEx_message();

    /**
     * Returns the message of {@link SizeValidator}.
     *
     * @return the size validation message.
     */
    @Key(Keys.SIZE)
    @DefaultStringValue("Size must be between {1} and {2}")
    String org_gwtbootstrap5_validation_Size_message();

}
