package com.example.jiaxin.nightmodle;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    boolean isNightFlag = false;
    TextView setNight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setTheme(R.style.DayTheme);
        setContentView(R.layout.setting);
        setNight = (TextView) findViewById(R.id.setting_Title);
        setNight.setOnClickListener(new onClickListenerImp());
    }

    class onClickListenerImp implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            if(!isNightFlag){
                setTheme(R.style.NightTheme);
                isNightFlag = true;
            }else {
                setTheme(R.style.DayTheme);
                isNightFlag = false;
            }
            setContentView(R.layout.setting);
            setNight = (TextView) findViewById(R.id.setting_Title);
            setNight.setOnClickListener(new onClickListenerImp());
        }

    }
}
