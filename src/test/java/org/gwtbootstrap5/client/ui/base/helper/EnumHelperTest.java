package org.gwtbootstrap5.client.ui.base.helper;

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

import org.gwtbootstrap5.client.ui.constants.FloatCSS;
import org.junit.Test;

import static org.gwtbootstrap5.client.ui.base.helper.EnumHelper.fromStyleName;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

/**
 * @author Sven Jacobs
 */
public class EnumHelperTest {

    @Test
    public void testFromStyleName() {
        assertThat(fromStyleName("123 float-left abc", FloatCSS.class, null), is(FloatCSS.LEFT_XS));
        assertThat(fromStyleName("123 float-right abc", FloatCSS.class, null), is(FloatCSS.RIGHT_XS));
        assertThat(fromStyleName("float-left float-right abc", FloatCSS.class, null), is(FloatCSS.LEFT_XS));
        assertThat(fromStyleName("123 abc", FloatCSS.class, null), is(nullValue()));
        assertThat(fromStyleName("123 abc", FloatCSS.class, FloatCSS.LEFT_XS), is(FloatCSS.LEFT_XS));
        assertThat(fromStyleName("123 abc", null, null), is(nullValue()));
        assertThat(fromStyleName(null, FloatCSS.class, null), is(nullValue()));
    }
}
