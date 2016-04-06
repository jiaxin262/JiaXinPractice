package com.example.jiaxin.animationdemo.activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Window;

import com.example.jiaxin.animationdemo.R;
import com.example.jiaxin.animationdemo.view.DetectorImageView;

/**
 * Created by xin.jia
 * since 2016/1/23
 */
public class GDImageDetailActivity extends BaseActivity {
    private DetectorImageView gdImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.gd_image_details);
        gdImageView = (DetectorImageView) findViewById(R.id.gd_image_view);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.gd_img);
        gdImageView.setImageBitmap(bitmap);
    }
}
