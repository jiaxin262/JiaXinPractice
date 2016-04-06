package com.example.jiaxin.animationdemo.activity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.BounceInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.TextView;

import com.example.jiaxin.animationdemo.Contants.JConstants;
import com.example.jiaxin.animationdemo.R;

/**
 * Created by xin.jia
 * since 2016/1/12
 */
public class ViewAnimationActivity extends BaseActivity{
    private TextView translateText, rotateText, alphaText, scaleText;
    private TextView translateText2, rotateText2, alphaText2, scaleText2;
    private Button animateButton;
    private Animation animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_animation);

        translateText = (TextView) findViewById(R.id.translate);
        rotateText = (TextView) findViewById(R.id.rotate);
        alphaText = (TextView) findViewById(R.id.alpha);
        scaleText = (TextView) findViewById(R.id.scale);
        animateButton = (Button) findViewById(R.id.animate_button);
        translateText2 = (TextView) findViewById(R.id.translate2);
        rotateText2 = (TextView) findViewById(R.id.rotate2);
        alphaText2 = (TextView) findViewById(R.id.alpha2);
        scaleText2 = (TextView) findViewById(R.id.scale2);

        translateText.setOnClickListener(this);
        rotateText.setOnClickListener(this);
        alphaText.setOnClickListener(this);
        scaleText.setOnClickListener(this);
        translateText2.setOnClickListener(this);
        rotateText2.setOnClickListener(this);
        alphaText2.setOnClickListener(this);
        scaleText2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.translate:
                animation = getTranslateAnimation(JConstants.GET_ANIMATION_FROM_CODE);
                animateButton.startAnimation(animation);
                break;
            case R.id.translate2:
                animation = getTranslateAnimation(JConstants.GET_ANIMATION_FROM_XML);
                animateButton.startAnimation(animation);
                break;
            case R.id.rotate:
                animation = getRotateAnimation(JConstants.GET_ANIMATION_FROM_CODE);
                animateButton.startAnimation(animation);
                break;
            case R.id.rotate2:
                animation = getRotateAnimation(JConstants.GET_ANIMATION_FROM_XML);
                animateButton.startAnimation(animation);
                break;
            case R.id.alpha:
                animation = getAlphaAnimation(JConstants.GET_ANIMATION_FROM_CODE);
                animateButton.startAnimation(animation);
                break;
            case R.id.alpha2:
                animation = getAlphaAnimation(JConstants.GET_ANIMATION_FROM_XML);
                animateButton.startAnimation(animation);
                break;
            case R.id.scale:
                animation = getScaleAnimation(JConstants.GET_ANIMATION_FROM_CODE);
                animateButton.startAnimation(animation);
                break;
            case R.id.scale2:
                animation = getScaleAnimation(JConstants.GET_ANIMATION_FROM_XML);
                animateButton.startAnimation(animation);
                break;
            default:
                animation = getTranslateAnimation(JConstants.GET_ANIMATION_FROM_CODE);
                animateButton.startAnimation(animation);
        }
    }

    private Animation getScaleAnimation(int fromType) {
        Animation animation = null;
        if (fromType == JConstants.GET_ANIMATION_FROM_CODE) {
            animation = new ScaleAnimation(1.0f, 2.5f, 1.0f, 2.5f, 0.2f, 0.2f);
            animation.setDuration(1000);
            animation.setFillAfter(true);
            animation.setInterpolator(new BounceInterpolator());
        }
        if (fromType == JConstants.GET_ANIMATION_FROM_XML) {
            animation = AnimationUtils.loadAnimation(this, R.anim.scale);
        }
        return animation;
    }

    private Animation getAlphaAnimation(int fromType) {
        Animation animation = null;
        if (isFromCode(fromType)) {
            animation = new AlphaAnimation(1.0f, 0.3f);
            animation.setInterpolator(new BounceInterpolator());
            animation.setFillAfter(true);
            animation.setDuration(600);
        }
        if (isFromXml(fromType)) {
            animation = AnimationUtils.loadAnimation(this, R.anim.alpha);
        }
        return animation;
    }

    private Animation getRotateAnimation(int fromType) {
        Animation animation = null;
        if (isFromCode(fromType)) {
            animation = new RotateAnimation(0f, 150f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
            animation.setDuration(1000);
            animation.setFillAfter(true);
            animation.setRepeatCount(1);
            animation.setRepeatMode(Animation.REVERSE);
            animation.setInterpolator(new BounceInterpolator());
        }
        if (isFromXml(fromType)) {
            animation = AnimationUtils.loadAnimation(this, R.anim.rotate);
        }
        return animation;
    }

    private Animation getTranslateAnimation(int fromType) {
        Animation animation = null;
        if (fromType == JConstants.GET_ANIMATION_FROM_CODE) {
            //animation = new TranslateAnimation(0, 130f, 0, 0);
            animation = new TranslateAnimation(Animation.RELATIVE_TO_PARENT, 0, Animation.RELATIVE_TO_PARENT, 0.1f,
                    Animation.RELATIVE_TO_PARENT, 0,Animation.RELATIVE_TO_PARENT, 0.2f);
            animation.setDuration(1500);
            animation.setRepeatCount(1);
            animation.setFillBefore(true);
            animation.setInterpolator(new BounceInterpolator());
            return animation;
        }
        if (fromType == JConstants.GET_ANIMATION_FROM_XML) {
            animation = AnimationUtils.loadAnimation(this, R.anim.translate);
        }
        return animation;
    }

    private boolean isFromCode(int fromType) {
        return fromType == JConstants.GET_ANIMATION_FROM_CODE;
    }

    private boolean isFromXml(int fromType) {
        return fromType == JConstants.GET_ANIMATION_FROM_XML;
    }
}
