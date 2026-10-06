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

import org.gwtbootstrap5.client.ui.base.HasFloat;
import org.gwtbootstrap5.client.ui.base.HasResponsiveness;
import org.gwtbootstrap5.client.ui.base.HasType;
import org.gwtbootstrap5.client.ui.base.helper.StyleHelper;
import org.gwtbootstrap5.client.ui.base.mixin.FloatMixin;
import org.gwtbootstrap5.client.ui.constants.DeviceSize;
import org.gwtbootstrap5.client.ui.constants.FloatCSS;
import org.gwtbootstrap5.client.ui.constants.ImageType;

import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.safehtml.shared.SafeUri;

/**
 * Image ({@code img}) with Bootstrap's image types: rounded, circle, thumbnail or responsive
 * ({@code img-fluid}). Unlike GWT's image it has no style name of its own.
 * <h2>UiBinder example</h2>
 * <pre>{@code
 *     <b:Image url="photo.jpg" type="THUMBNAIL" altText="A photo"/>
 * }</pre>
 *
 * @see <a href="https://getbootstrap.com/docs/5.3/content/images/">Bootstrap 5 documentation</a>
 *
 * @author Joshua Godi
 */
public class Image extends com.google.gwt.user.client.ui.Image implements HasType<ImageType>, HasResponsiveness,
        HasFloat {

    private final FloatMixin<Image> floatMixin = new FloatMixin<>(this);

    /** Creates an image without a URL. */
    public Image() {
        super();
        setStyleName("");
    }

    /**
     * Creates an image from a client bundle resource.
     *
     * @param resource the image resource
     */
    public Image(final ImageResource resource) {
        super(resource);
        setStyleName("");
    }

    /**
     * Creates a clipped image: the part of the image at the given URL inside the given rectangle.
     *
     * @param url the URL of the whole image
     * @param left the left edge of the visible rectangle, in pixels
     * @param top the top edge of the visible rectangle, in pixels
     * @param width the width of the visible rectangle, in pixels
     * @param height the height of the visible rectangle, in pixels
     */
    public Image(final SafeUri url, final int left, final int top, final int width, final int height) {
        super(url, left, top, width, height);
        setStyleName("");
    }

    /**
     * Creates an image.
     *
     * @param url the URL of the image
     */
    public Image(final SafeUri url) {
        super(url);
        setStyleName("");
    }

    /**
     * Creates a clipped image: the part of the image at the given URL inside the given rectangle.
     *
     * @param url the URL of the whole image
     * @param left the left edge of the visible rectangle, in pixels
     * @param top the top edge of the visible rectangle, in pixels
     * @param width the width of the visible rectangle, in pixels
     * @param height the height of the visible rectangle, in pixels
     */
    public Image(final String url, final int left, final int top, final int width, final int height) {
        super(url, left, top, width, height);
        setStyleName("");
    }

    /**
     * Creates an image.
     *
     * @param url the URL of the image
     */
    public Image(final String url) {
        super(url);
        setStyleName("");
    }

    @Override
    public void setType(final ImageType type) {
        StyleHelper.addEnumStyleName(this, type);
    }

    @Override
    public ImageType getType() {
        return ImageType.fromStyleName(getStyleName());
    }

    @Override
    public void setVisibleOn(final DeviceSize deviceSize) {
        StyleHelper.setVisibleOn(this, deviceSize);
    }

    @Override
    public void setHiddenOn(final DeviceSize deviceSize) {
        StyleHelper.setHiddenOn(this, deviceSize);
    }

    @Override
    public void setFloat(final FloatCSS aFloatCSS) {
        floatMixin.setFloat(aFloatCSS);
    }

    @Override
    public FloatCSS getFloat() {
        return floatMixin.getFloat();
    }

}
