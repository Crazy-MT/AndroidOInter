package com.example.yoush.androidointer;

import android.content.Context;
import android.preference.PreferenceManager;

/**
 * Created by MT on 2017/1/5.
 */

public class SharedPreferencesUtils {


    private static String LANGUAGE = "language";

    public static void setLanguage(Context context, String language) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putString(LANGUAGE, language).apply();
    }

    public static String getLanguage(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getString(LANGUAGE, "");
    }
}
