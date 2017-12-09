package com.example.anu.popularmovies_1.utils;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.graphics.Palette;
import android.widget.ImageView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Design on 07-12-2017.
 */

public class CommonUtils {

    public static int SWATCH_ARRAY_LENGTH = 2;

    /**
     * method to generate bitmap from image
     *
     * @param imgBackdrop image from which bitmap is to be generated
     * @return generated bitmap
     */
    public static Bitmap getBitmapFromImage(ImageView imgBackdrop) {
        return ((BitmapDrawable) imgBackdrop.getDrawable()).getBitmap();
    }

    /**
     * method to generate palette asynchronously
     *
     * @param bitmap
     */
    public static Palette.Swatch[] createPaletteAsync(Bitmap bitmap) {
        final Palette.Swatch[] pSwatches = new Palette.Swatch[SWATCH_ARRAY_LENGTH];
        Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
            /**
             *Use palette on a different thread using onGenerated
             * @param palette
             */
            @Override
            public void onGenerated(Palette palette) {
                pSwatches[0] = palette.getDarkVibrantSwatch();
                pSwatches[1] = palette.getLightVibrantSwatch();
            }
        });
        return pSwatches;
    }

    /**
     * method to change date format
     *
     * @param inputFormat  current format
     * @param outputFormat new format
     * @param inputDate    date
     * @return
     */
    public static String formatDate(String inputFormat, String outputFormat, String inputDate) {
        Date parsed;
        String outputDate = inputDate;
        SimpleDateFormat df_input = new SimpleDateFormat(inputFormat, java.util.Locale.getDefault());
        SimpleDateFormat df_output = new SimpleDateFormat(outputFormat, java.util.Locale.getDefault());
        try {
            parsed = df_input.parse(inputDate);
            outputDate = df_output.format(parsed);

        } catch (ParseException e) {
        }
        return outputDate;

    }
}
