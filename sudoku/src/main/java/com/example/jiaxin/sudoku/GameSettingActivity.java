package com.example.jiaxin.sudoku;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by jiaxin on 15-8-25.
 */
public class GameSettingActivity extends Activity {

    ImageView settingReturn; //返回按钮

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_setting);
        //获取控件
        settingReturn = (ImageView) findViewById(R.id.setting_return);
        //为控件添加监听器
        settingReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
