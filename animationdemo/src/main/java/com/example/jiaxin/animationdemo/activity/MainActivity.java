package com.example.jiaxin.animationdemo.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.example.jiaxin.animationdemo.R;


public class MainActivity extends BaseActivity {

    private TextView navigationBar;
    private TextView viewAnimation;
    private TextView propertyAnimation;
    private TextView carTownStreets;
    private TextView canvasDemo;
    private TextView imageDetail;
    private TextView gestureDetector;
    private TextView GDImageDetail;
    private TextView testGetId;
    private TextView calculate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navigationBar = (TextView) findViewById(R.id.navigation_bar);
        viewAnimation = (TextView) findViewById(R.id.view_animation);
        propertyAnimation = (TextView) findViewById(R.id.property_animation);
        carTownStreets = (TextView) findViewById(R.id.car_town_streets);
        canvasDemo = (TextView) findViewById(R.id.canvas_demo);
        imageDetail = (TextView) findViewById(R.id.image_detail);
        gestureDetector = (TextView) findViewById(R.id.gesture_detector);
        GDImageDetail = (TextView) findViewById(R.id.gd_image_detail);
        testGetId = (TextView) findViewById(R.id.test_getId);
        calculate = (TextView) findViewById(R.id.calculate);

        navigationBar.setOnClickListener(this);
        viewAnimation.setOnClickListener(this);
        propertyAnimation.setOnClickListener(this);
        carTownStreets.setOnClickListener(this);
        canvasDemo.setOnClickListener(this);
        imageDetail.setOnClickListener(this);
        gestureDetector.setOnClickListener(this);
        GDImageDetail.setOnClickListener(this);
        testGetId.setOnClickListener(this);
        calculate.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.navigation_bar:
                jStartActivity(NavigationActivity.class);
                break;
            case R.id.view_animation:
                jStartActivity(ViewAnimationActivity.class);
                break;
            case R.id.property_animation:
                jStartActivity(PropertyAnimationActivity.class);
                break;
            case R.id.car_town_streets:
                jStartActivity(CarTownStreetsActivity.class);
                break;
            case R.id.canvas_demo:
                jStartActivity(CanvasDemoActivity.class);
                break;
            case R.id.image_detail:
                jStartActivity(ImageDetailsActivity.class);
                break;
            case R.id.gesture_detector:
                jStartActivity(GestureDetectorActivity.class);
                break;
            case R.id.gd_image_detail:
                jStartActivity(GDImageDetailActivity.class);
                break;
            case R.id.test_getId:
                jStartActivity(TestGetIdActivity.class);
                break;
            case R.id.calculate:
                jStartActivity(MatrixActivity.class);
                break;
            default:
                jShowAlertMessage("SORRY", "NOT ACCOMPLISHED!");
        }
    }

}