package com.example.yoush.androidointer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.mtdev.languagelibrary.util.ViewUtil;
import com.mtdev.languagelibrary.widget.AppTextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EventBus.getDefault().register(this);
    }

    public void open(View view) {
        startActivity(new Intent(MainActivity.this, LanguageActivity.class));
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onStringEvent(ClassEvent event) {
        ViewUtil.updateViewLanguage(findViewById(android.R.id.content));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
