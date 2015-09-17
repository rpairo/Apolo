package me.rpairo.apolo.glide;

import android.content.Context;
import android.widget.ImageView;


/**
 * Created by Raul on 8/9/15.
 */

public class GlideWrapper {

    //region Funciones
    public static void setImageWithResize(Context context, int drawable, int width, int height, ImageView imageView) {

        com.bumptech.glide.Glide.with(context)
                .load(drawable)
                .override(width, height)
                .into(imageView);
    }

    public static void setImageWithResizeAndAnimation(Context context, int drawable, int width, int height,
                                                      int animacion, ImageView imageView) {

        com.bumptech.glide.Glide.with(context)
                .load(drawable)
                .override(width, height)
                .animate(animacion)
                .into(imageView);
    }

    public static void setImage(Context context, String url, ImageView imageView) {

        com.bumptech.glide.Glide.with(context)
                .load(url)
                .into(imageView);
    }

    public static void setImage(Context context, int drawable, ImageView imageView) {

        com.bumptech.glide.Glide.with(context)
                .load(drawable)
                .into(imageView);
    }
    //endregion
}