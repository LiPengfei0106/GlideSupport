package com.lipengfei.glidesupport;

import android.content.Context;
import android.graphics.drawable.PictureDrawable;
import android.support.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Registry;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.module.AppGlideModule;
import com.caverock.androidsvg.SVG;
import com.lipengfei.glidesupport.svg.SvgDecoder;
import com.lipengfei.glidesupport.svg.SvgDrawableTranscoder;
import com.lipengfei.glidesupport.webp.WebpBytebufferDecoder;
import com.lipengfei.glidesupport.webp.WebpDrawable;
import com.lipengfei.glidesupport.webp.WebpDrawableEncoder;
import com.lipengfei.glidesupport.webp.WebpResourceDecoder;

import java.io.InputStream;
import java.nio.ByteBuffer;


/**
 * @author Lee
 * @date 2019/4/18
 */
@GlideModule
public class CustomModule extends AppGlideModule {
    @Override
    public void registerComponents(@NonNull Context context, @NonNull Glide glide,
                                   @NonNull Registry registry) {

        registry.register(WebpDrawable.class, new WebpDrawableEncoder())
                .append(InputStream.class, WebpDrawable.class, new WebpResourceDecoder(context, glide))
                .append(ByteBuffer.class, WebpDrawable.class, new WebpBytebufferDecoder(context, glide))
                .register(SVG.class, PictureDrawable.class, new SvgDrawableTranscoder())
                .append(InputStream.class, SVG.class, new SvgDecoder());
    }

    // Disable manifest parsing to avoid adding similar modules twice.
    @Override
    public boolean isManifestParsingEnabled() {
        return false;
    }
}