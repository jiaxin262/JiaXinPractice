package com.example.jiaxin.qunarnews.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;

/**
 * 根据内容自适应高度的ViewPager
 * 使用的时候请注意：PagerAdapter中的这个方法 instantiateItem 需要移除child
 * Created by qingmin.cheng on 15/7/29.
 */
public class WrapContentHeightViewPager extends ViewPager {

    public WrapContentHeightViewPager(Context context) {
        super(context);
    }

    public WrapContentHeightViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if(getAdapter() != null){
            int height = 0;
            //下面遍历所有child的高度
            for (int i = 0; i < getAdapter().getCount(); i++) {
                View child = (View)getAdapter().instantiateItem(this, i);
                child.measure(widthMeasureSpec,
                        MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));
                int h = child.getMeasuredHeight();
                if (h > height) //采用最大的view的高度。
                    height = h;
            }
            heightMeasureSpec = MeasureSpec.makeMeasureSpec(height,
                    MeasureSpec.EXACTLY);
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

}
