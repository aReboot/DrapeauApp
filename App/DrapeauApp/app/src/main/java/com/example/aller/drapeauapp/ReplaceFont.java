package com.example.aller.drapeauapp;


import android.content.Context;
import android.graphics.Typeface;
import java.lang.reflect.Field;

/**
 * Created by user on 29/09/2017.
 */

public class ReplaceFont {

   public static void replaceDefaultFont(Context context,
                                         String nameOfBeingReplaced,
                                         String nameOfFontInAssets){
       Typeface customFont = Typeface.createFromAsset(context.getAssets(),nameOfFontInAssets);
       replaceFont(nameOfBeingReplaced, customFont);
   }

    private static void replaceFont(String nameOfBeingReplaced, Typeface customFont) {
        try {
            Field field = Typeface.class.getDeclaredField(nameOfBeingReplaced);
            field.setAccessible(true);
            field.set(null, customFont);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
