package com.mtdev.languagelibrary.widget;

import android.content.Context;
import android.support.annotation.ArrayRes;
import android.support.annotation.StringRes;
import android.util.AttributeSet;
import android.widget.TextView;

import com.mtdev.languagelibrary.fontometrics.Fontometrics;
import com.mtdev.languagelibrary.util.StringUtil;


/**
 * Created by george.yang on 2015/7/26.
 */
public class AppTextView extends TextView implements LanguageChangableView {
    private int textId;//文字id
    private int hintId;//hint的id
    private int arrResId, arrResIndex;

    //  app:fontStyle="light" medium
    public AppTextView(Context context) {
        super(context);
        init(context, null);
    }

    public AppTextView(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
        init(paramContext, paramAttributeSet);
    }

    public AppTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
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
        setTypeface(Fontometrics.getMainTTF(context.getApplicationContext()));
        if (attributeSet != null) {
            String textValue = attributeSet.getAttributeValue(ANDROIDXML, "text");
            if (!(textValue == null || textValue.length() < 2)) {
                //如果是 android:text="@string/testText"
                //textValue会是 @0x7f080000,去掉@号就是资源id
                textId = StringUtil.string2int(textValue.substring(1, textValue.length()));
                setTextById(textId);
            }

            String hintValue = attributeSet.getAttributeValue(ANDROIDXML, "hint");
            if (!(hintValue == null || hintValue.length() < 2)) {
                hintId = StringUtil.string2int(hintValue.substring(1, hintValue.length()));
            }
        }
//
        //setTypeface(Fontometrics.admiration_pains(context));
    }

    @Override
    public void setTextById(@StringRes int strId) {
        this.textId = strId;
        setText(getContext().getApplicationContext().getString(strId));
    }

    @Override
    public void setTextWithString(String text) {
        this.textId = 0;
        setText(text);
    }

    @Override
    public void setTextByArrayAndIndex(@ArrayRes int arrId, @StringRes int arrIndex) {
        arrResId = arrId;
        arrResIndex = arrIndex;
        String[] strs = getContext().getApplicationContext().getResources().getStringArray(arrId);
        setText(strs[arrIndex]);
    }

    @Override
    public void reLoadLanguage() {
        try {
            if (textId > 0) {
                setText(getContext().getApplicationContext().getString(textId));
                setTypeface(Fontometrics.getMainTTF(getContext().getApplicationContext()));

                /*if (getResources().getConfiguration().locale.getLanguage().equals("zh")) {
                    Typeface typeFace = Typeface.createFromAsset(getContext().getAssets(), "fonts/ch.ttf");

                    //使用字体
                    Log.e(TAG, "reLoadLanguage: " + "zh");
                    setTypeface(typeFace);
                } else {
                    Log.e(TAG, "reLoadLanguage: " + "ss");
                    Typeface typeFace = Typeface.createFromAsset(getContext().getAssets(), "fonts/admiration_pains.ttf");

                    //使用字体

                    setTypeface(typeFace);
                }*/
            } else if (arrResId > 0) {
                String[] strs = getContext().getApplicationContext().getResources().getStringArray(arrResId);
                setText(strs[arrResIndex]);
                setTypeface(Fontometrics.getMainTTF(getContext().getApplicationContext()));
            }

            if (hintId > 0) {
                setHint(hintId);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
