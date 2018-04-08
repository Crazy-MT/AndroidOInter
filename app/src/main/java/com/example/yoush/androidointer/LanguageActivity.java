package com.example.yoush.androidointer;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;

import com.mtdev.languagelibrary.fontometrics.Fontometrics;
import com.mtdev.languagelibrary.util.ViewUtil;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.Locale;

public class LanguageActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language);
        EventBus.getDefault().register(this);
        findViewById(R.id.id_chinese).setOnClickListener(this);
        findViewById(R.id.id_fanti).setOnClickListener(this);
        findViewById(R.id.id_kor).setOnClickListener(this);
        findViewById(R.id.id_english).setOnClickListener(this);
        findViewById(R.id.id_jp).setOnClickListener(this);
        findViewById(R.id.id_de).setOnClickListener(this);
        findViewById(R.id.id_close).setOnClickListener(this);
        findViewById(R.id.id_fragment_activity).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.id_chinese:
                //"zh_CN"
                switchLanguage(Locale.SIMPLIFIED_CHINESE);
                SharedPreferencesUtils.setLanguage(this, Locale.SIMPLIFIED_CHINESE.toString());
                break;
            case R.id.id_fanti:
                //zh_TW
                switchLanguage(Locale.TRADITIONAL_CHINESE);
                SharedPreferencesUtils.setLanguage(this, Locale.TRADITIONAL_CHINESE.toString());
                break;
            case R.id.id_kor:
                //ko_KR   ko
                switchLanguage(Locale.KOREA);
                SharedPreferencesUtils.setLanguage(this, Locale.KOREA.toString());
                break;
            case R.id.id_english:
                //en
                switchLanguage(Locale.ENGLISH);
                SharedPreferencesUtils.setLanguage(this, Locale.ENGLISH.toString());
                break;
            case R.id.id_jp:
                //ja
                switchLanguage(Locale.JAPANESE);
                SharedPreferencesUtils.setLanguage(this, Locale.JAPANESE.toString());
                break;
            case R.id.id_de:
                //de
                switchLanguage(Locale.GERMANY);
                SharedPreferencesUtils.setLanguage(this, Locale.GERMANY.toString());
                break;
            case R.id.id_close:
                finish();
                return;
            case R.id.id_fragment_activity:
                startActivity(new Intent(LanguageActivity.this,FragmentActivity.class));
                break;
        }

        Fontometrics.updateMainTTF(this);

        ClassEvent event = new ClassEvent();
        event.msg = "do it";
        EventBus.getDefault().post(event);

        finish();

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onStringEvent(ClassEvent event) {
        ViewUtil.updateViewLanguage(findViewById(android.R.id.content));
    }

    public void switchLanguage(Locale locale) {
        Configuration config = getApplicationContext().getResources().getConfiguration();
        Resources resources = getApplicationContext().getResources();
        DisplayMetrics dm = resources.getDisplayMetrics();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            config.setLocale(locale);
        } else {
            config.locale = locale;
        }
        resources.updateConfiguration(config, dm);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
