package com.example.jiaxin.animationdemo.activity;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.jiaxin.animationdemo.R;

/**
 * Created by xin.jia
 * since 2015/12/30
 */
public class NavigationActivity extends BaseActivity{

    private TextView appleTvBar;
    private TextView pearTvBar;
    private TextView orangeTvBar;
    private TextView mangoTvBar;
    private TextView grapeTvBar;
    private TextView appleTvBar2;
    private TextView pearTvBar2;
    private TextView orangeTvBar2;
    private TextView mangoTvBar2;
    private TextView grapeTvBar2;
    private TextView navigationBg;
    private LinearLayout highlightLlBar;
    private int start, startXPosition, endXPosition;
    private Animation translateAnimation;
    private ValueAnimator translateAnimator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation_bar);

        appleTvBar = (TextView) findViewById(R.id.apple);
        pearTvBar = (TextView) findViewById(R.id.pear);
        orangeTvBar = (TextView) findViewById(R.id.orange);
        mangoTvBar = (TextView) findViewById(R.id.mango);
        grapeTvBar = (TextView) findViewById(R.id.grape);
        appleTvBar2 = (TextView) findViewById(R.id.apple2);
        pearTvBar2 = (TextView) findViewById(R.id.pear2);
        orangeTvBar2 = (TextView) findViewById(R.id.orange2);
        mangoTvBar2 = (TextView) findViewById(R.id.mango2);
        grapeTvBar2 = (TextView) findViewById(R.id.grape2);
        navigationBg = (TextView) findViewById(R.id.navigation_tv_bg);
        highlightLlBar = (LinearLayout) findViewById(R.id.navigation_ll_top_view);

        appleTvBar.setOnClickListener(this);
        pearTvBar.setOnClickListener(this);
        orangeTvBar.setOnClickListener(this);
        mangoTvBar.setOnClickListener(this);
        grapeTvBar.setOnClickListener(this);

    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        initNavigationItemBg();
    }

    @Override
    public void onClick(View v) {
        startXPosition = navigationBg.getLeft();
        endXPosition = v.getLeft();
        beginBgTranslate();
        beginTextTranslate();
    }


    private void initNavigationItemBg() {
        start = appleTvBar.getLeft();
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) navigationBg.getLayoutParams();
        params.leftMargin = start;
        navigationBg.setLayoutParams(params);
        highlightLlBar.setLayoutParams(params);
    }

    private void beginBgTranslate() {
        translateAnimator = ValueAnimator.ofInt(startXPosition, endXPosition);
        translateAnimator.setDuration(500);
        translateAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                RelativeLayout.LayoutParams translateParams = (RelativeLayout.LayoutParams) navigationBg.getLayoutParams();
                translateParams.leftMargin = (Integer) animation.getAnimatedValue();
                navigationBg.setLayoutParams(translateParams);
            }
        });
        translateAnimator.start();
    }

    private void beginTextTranslate() {
        int startX = start - startXPosition;
        int endX = startX + startXPosition - endXPosition;
        translateAnimation = new TranslateAnimation(startX, endX, 0, 0);
        translateAnimation.setDuration(500);
        translateAnimation.setFillAfter(true);
        appleTvBar2.startAnimation(translateAnimation);
        pearTvBar2.startAnimation(translateAnimation);
        orangeTvBar2.startAnimation(translateAnimation);
        mangoTvBar2.startAnimation(translateAnimation);
        grapeTvBar2.startAnimation(translateAnimation);
    }

}
