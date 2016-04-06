package com.example.jiaxin.animationdemo.activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Window;

import com.example.jiaxin.animationdemo.R;
import com.example.jiaxin.animationdemo.view.ZoomImageView;

public class ImageDetailsActivity extends BaseActivity {

	private ZoomImageView zoomImageView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.image_details);
		zoomImageView = (ZoomImageView) findViewById(R.id.zoom_image_view);
		Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.img_detail);
		zoomImageView.setImageBitmap(bitmap);
	}
	
}