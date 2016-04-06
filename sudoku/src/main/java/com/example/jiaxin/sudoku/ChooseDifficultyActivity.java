package com.example.jiaxin.sudoku;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

/**
 * 难度选择页
 * Created by jiaxin on 15-8-25.
 */
public class ChooseDifficultyActivity extends Activity {

    ImageView difficultyReturn; //返回按钮

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_difficulty);
        //获取控件
        difficultyReturn = (ImageView) findViewById(R.id.difficulty_return);
        //为控件添加监听器
        difficultyReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
