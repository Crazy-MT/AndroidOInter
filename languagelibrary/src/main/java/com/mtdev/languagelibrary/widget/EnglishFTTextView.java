package com.mtdev.languagelibrary.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

import com.mtdev.languagelibrary.fontometrics.Fontometrics;

/**
 * Created by yoush on 2017/3/10.
 */

public class EnglishFTTextView extends TextView {

    //  app:fontStyle="light" medium
    public EnglishFTTextView(Context context) {
        super(context);
        init(context, null);
    }

    public EnglishFTTextView(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
        init(paramContext, paramAttributeSet);
    }

    public EnglishFTTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
        init(paramContext, paramAttributeSet);

    }

    private static final String TAG = "AppTextView";

    /**
     * 初始化获取xml的资源id
     *
     * @param context
     * @param attributeSet
     */
    private void init(Context context, AttributeSet attributeSet) {
        setTypeface(Fontometrics.getEnglishFT(context));
    }
}
