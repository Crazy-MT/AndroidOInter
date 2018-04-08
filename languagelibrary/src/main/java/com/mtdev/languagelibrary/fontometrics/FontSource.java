package com.mtdev.languagelibrary.fontometrics;

import android.content.Context;
import android.graphics.Typeface;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;


final class FontSource {
    private static final String TAG = "FontSource";

    static Typeface process(int resource, Context context) {
        Typeface mTypeface;
        InputStream mInputStream = null;

        String mOutPath = context.getCacheDir() + "/tmp" + System.currentTimeMillis() + ".raw";
        try {
            mInputStream = context.getApplicationContext().getResources().openRawResource(resource);
        } catch (Exception e) {
        }

        try {
            byte[] mBuffer = new byte[mInputStream.available()];
            BufferedOutputStream mStream = new BufferedOutputStream(new FileOutputStream(mOutPath));
            int num;
            while ((num = mInputStream.read(mBuffer)) > 0) {
                mStream.write(mBuffer, 0, num);
            }
            mStream.close();
            mTypeface = Typeface.createFromFile(mOutPath);

            new File(mOutPath).delete();

        } catch (Exception e) {
            return null;
        }

        return mTypeface;
    }
}
