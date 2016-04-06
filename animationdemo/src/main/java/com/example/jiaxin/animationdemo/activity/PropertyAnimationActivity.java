package com.example.jiaxin.animationdemo.activity;

import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.BounceInterpolator;
import android.widget.Button;
import android.widget.TextView;

import com.example.jiaxin.animationdemo.R;
import com.example.jiaxin.animationdemo.model.ButtonParam;

/**
 * Created by xin.jia
 * since 2016/1/12
 */
public class PropertyAnimationActivity extends BaseActivity {

    private Button animationButton;
    private TextView valueAnimatorTv;
    private TextView objectAnimatorTv;
    private ValueAnimator valueAnimator;
    private ObjectAnimator objectAnimator;
    private int startPosition, endPosition;
    private ButtonParam buttonParam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.property_animation);

        buttonParam = new ButtonParam();
        animationButton = (Button) findViewById(R.id.animate_button);
        valueAnimatorTv = (TextView) findViewById(R.id.value_animator);
        objectAnimatorTv = (TextView) findViewById(R.id.object_animator);

        valueAnimatorTv.setOnClickListener(this);
        objectAnimatorTv.setOnClickListener(this);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        startPosition = animationButton.getLeft();
        endPosition = animationButton.getRight();
        buttonParam.setLeftPos(startPosition);
        buttonParam.setRightPos(endPosition);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.value_animator:
                executeValueAnimator();
                break;
            case R.id.object_animator:
                executeObjectAnimator();
                break;
            default:
        }
    }

    private void executeValueAnimator() {
        //valueAnimator = ValueAnimator.ofInt(-30, 100);
        valueAnimator = ValueAnimator.ofObject(new MyTypeEvaluator(), -30, 100);
        valueAnimator.setDuration(1000);
        valueAnimator.setInterpolator(new BounceInterpolator());
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int distance = (int) valueAnimator.getAnimatedValue();
                animationButton.setRight(endPosition + distance);
                animationButton.setLeft(startPosition + distance);
            }
        });
        valueAnimator.start();
    }

    private void executeObjectAnimator() {
        objectAnimator = ObjectAnimator.ofInt(buttonParam, "leftPos", -20, 220);
        objectAnimator.setDuration(700);
        objectAnimator.setInterpolator(new AnticipateOvershootInterpolator());
        objectAnimator.start();
        objectAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                animationButton.setLeft(buttonParam.getLeftPos());
            }
        });
    }

    public class MyTypeEvaluator implements TypeEvaluator {
        @Override
        public Object evaluate(float fraction, Object startValue, Object endValue) {
            int leftPos = ((Number)startValue).intValue();
            float resultPos = leftPos + fraction*(((Number)endValue).intValue()-leftPos)*2.5f;
            String result = String.valueOf(resultPos);
            return Integer.parseInt(result.substring(0, result.indexOf('.')));
        }
    }
}
