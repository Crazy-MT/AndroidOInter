package com.mtdev.languagelibrary.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

import com.mtdev.languagelibrary.fontometrics.Fontometrics;


/**
 * Created by george.yang on 2015/7/26.
 */
public class ZhTextView extends TextView {
    private int textId;//文字id
    private int hintId;//hint的id
    private int arrResId, arrResIndex;

    //  app:fontStyle="light" medium
    public ZhTextView(Context context) {
        super(context);
        init(context, null);
    }

    public ZhTextView(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
        init(paramContext, paramAttributeSet);
    }

    public ZhTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
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
        setTypeface(Fontometrics.getZhFT(context));
    }
}
