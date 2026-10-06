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

import org.gwtbootstrap5.client.ui.base.HasSize;
import org.gwtbootstrap5.client.ui.constants.ContainerSize;
import org.gwtbootstrap5.client.ui.html.Div;

/**
 * Container ({@code div.container}): centers and pads the content, with a fixed width at each
 * breakpoint, or the full width with {@code size="FLUID"}, or the full width up to a breakpoint.
 * <h2>UiBinder example</h2>
 * <pre>{@code
 *     <b:Container size="FLUID">
 *         <b:Row>...</b:Row>
 *     </b:Container>
 * }</pre>
 *
 * @author Sven Jacobs
 * @author Joshua Godi
 * @see Row
 * @see Column
 * @see <a href="https://getbootstrap.com/docs/5.3/layout/containers/">Bootstrap 5 documentation</a>
 */
public class Container extends Div implements HasSize<ContainerSize> {

    /** Creates a container ({@code div.container}): fixed width at each breakpoint. */
    public Container() {
        super();

        setStyleName(ContainerSize.DEFAULT.getCssName());
    }

    @Override
    public void setSize(ContainerSize size) {
        setStyleName(size.getCssName());
    }

    @Override
    public ContainerSize getSize() {
        return ContainerSize.fromStyleName(getStyleName());
    }
}
