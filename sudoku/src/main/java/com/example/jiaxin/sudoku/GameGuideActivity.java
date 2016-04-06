package com.example.jiaxin.sudoku;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by jiaxin on 15-8-25.
 */
public class GameGuideActivity extends Activity {

    ImageView guideReturn;  //返回按钮
    TextView startGuide;    //开始播放教程按钮

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_guide);
        //获取控件
        guideReturn = (ImageView) findViewById(R.id.guide_return);
        startGuide = (TextView) findViewById(R.id.start_guide);
        //为控件添加监听器
        guideReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        startGuide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
