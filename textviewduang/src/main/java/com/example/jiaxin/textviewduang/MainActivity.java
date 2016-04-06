package com.example.jiaxin.textviewduang;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tv = null;
        // TextView旋转 动画效果
        tv = (TextView) findViewById(R.id.rotate);
        Animation mAnimationRight = AnimationUtils.loadAnimation(MainActivity.this, R.anim.rotate);
        tv.setAnimation(mAnimationRight);

        // TextView透明度动画效果
        tv = (TextView) findViewById(R.id.alpha);
        mAnimationRight = AnimationUtils.loadAnimation(MainActivity.this, R.anim.alpha);
        tv.setAnimation(mAnimationRight);

        // TextView缩放动画效果
        tv = (TextView) findViewById(R.id.scale);
        mAnimationRight = AnimationUtils.loadAnimation(
                MainActivity.this, R.anim.scale);
        tv.setAnimation(mAnimationRight);

        // TextView移动动画效果
        tv = (TextView) findViewById(R.id.translate);
        mAnimationRight = AnimationUtils.loadAnimation(
                MainActivity.this, R.anim.translate);
        tv.setAnimation(mAnimationRight);
    }

}
