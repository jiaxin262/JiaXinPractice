package com.example.jiaxin.sudoku;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 游戏首页
 * Created by jiaxin on 15-8-24.
 */
public class IndexActivity extends Activity {

    Context context = this;
    TextView continueGame;  //继续游戏
    TextView newGame;   //新游戏
    TextView gameGuide; //游戏说明
    TextView gameSetting;   //设置
    TextView rankingList;   //排行榜
    TextView share;     //分享

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.index);
        //获取控件
        continueGame = (TextView) findViewById(R.id.continue_game);
        newGame = (TextView) findViewById(R.id.new_game);
        gameGuide = (TextView) findViewById(R.id.game_guide);
        gameSetting = (TextView) findViewById(R.id.game_setting);
        rankingList = (TextView) findViewById(R.id.ranking_list);
        share = (TextView) findViewById(R.id.share);
        //添加监听器
        newGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(IndexActivity.this, ChooseDifficultyActivity.class);
                startActivity(intent);
            }
        });
        gameSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(IndexActivity.this, GameSettingActivity.class);
                startActivity(intent);
            }
        });
        gameGuide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(IndexActivity.this, GameGuideActivity.class);
                startActivity(intent);
            }
        });
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("image/*");
//                File f = new File(Environment.getExternalStorageDirectory()+"/sudoku.png");
//                Uri uri = Uri.fromFile(f);
//                intent.putExtra(Intent.EXTRA_STREAM,uri);
                //intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_SUBJECT, "Sudoku Share");
                intent.putExtra(Intent.EXTRA_TEXT, "I have successfully shared my message through my sudoku app");
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(Intent.createChooser(intent, getTitle()));
            }
        });

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //按键为返回键
        if (keyCode == KeyEvent.KEYCODE_BACK){
            existBy2Click();
        }
        return false;
    }

    //标记是否退出应用
    public static boolean isExist = false;
    //两次点击返回键退出应用
    private void existBy2Click() {
        Timer existTimer = null;    //计时器
        if (!isExist){
            isExist = true; //准备退出应用
            Toast.makeText(this, "再按一次退出应用", Toast.LENGTH_SHORT).show();
            existTimer = new Timer();
            //创建任务，2秒后执行run()
            Log.v("index", "准备执行定时器任务");
            existTimer.schedule(new TimerTask() {
                @Override
                public void run() {
                    Log.v("index", "执行定时器任务");
                    isExist = false;
                }
            }, 2000);
        }else{
            finish();
            System.exit(0);
        }
    }

}
