package com.example.jiaxin.sudoku;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;

/**
 * 启动页
 * Created by jiaxin on 15-8-24.
 */

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, IndexActivity.class);
                startActivity(intent);
                MainActivity.this.finish();
            }
        },2000);

    }

}
