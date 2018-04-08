package com.mtdev.languagelibrary.fontometrics;

import android.content.Context;
import android.graphics.Typeface;

import com.mtdev.languagelibrary.R;

/**
 * Created by WarMachine on 12/25/2016.
 */
public class Fontometrics {
    private static final String TAG = "Fontometrics";

    private Fontometrics() {
    }

    private static Typeface mainTTF;

    private static Typeface constanTTF;

    private static Typeface ftTTF;

    private static Typeface zhTTF;


    public static Typeface getMainTTF(Context context) {
        if (Fontometrics.mainTTF == null) {
            Fontometrics.mainTTF = FontSource.process(R.raw.default_ttf, context);
        }
        return mainTTF;
    }



    /**
     * 切换文字之后必须调用一次
     * @param context
     */
    public static void updateMainTTF(Context context){
        Fontometrics.mainTTF = FontSource.process(R.raw.default_ttf, context);
    }

/*    public static Typeface admiration_pains(Context context){
        return FontSource.process(R.raw.admiration_pains, context);
    }*/


    public static Typeface getEnglishConstan(Context context){
        if (Fontometrics.constanTTF == null){
            Fontometrics.constanTTF = FontSource.process(R.raw.constan,context);
        }
        return constanTTF;
    }

    public static Typeface getEnglishFT(Context context){
        if (Fontometrics.ftTTF == null){
            Fontometrics.ftTTF = FontSource.process(R.raw.ft,context);
        }
        return ftTTF;
    }

    public static Typeface getZhFT(Context context){
        if (Fontometrics.zhTTF == null){
            Fontometrics.zhTTF = FontSource.process(R.raw.zh,context);
        }
        return zhTTF;
    }

}
