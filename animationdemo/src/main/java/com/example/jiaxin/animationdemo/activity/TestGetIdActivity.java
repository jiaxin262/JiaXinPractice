package com.example.jiaxin.animationdemo.activity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import com.example.jiaxin.animationdemo.R;

/**
 * Created by xin.jia
 * since 2016/1/26
 */
public class TestGetIdActivity extends BaseActivity {

    private Button animationButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_animation);

        animationButton = (Button) findViewById(R.id.animate_button);
        getResourceName();
    }

    private void getResourceName() {
        String resourceId = String.valueOf(animationButton.getId());
        Log.v("*getResourceId:", resourceId);
        String resourceName = getResources().getResourceEntryName(animationButton.getId());
        Log.v("**getResourceEntryName:", resourceName);
    }

}
