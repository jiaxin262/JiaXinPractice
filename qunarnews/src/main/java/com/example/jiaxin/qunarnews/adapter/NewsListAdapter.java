package com.example.jiaxin.qunarnews.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jiaxin.qunarnews.NewsItem.NewsItem;
import com.example.jiaxin.qunarnews.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiaxin on 15-8-17.
 */
public class NewsListAdapter extends BaseAdapter {

    /** 布局类型：焦点图 */
    private static final int TYPE_FOCUS_IMAGE = 0;
    /** 布局类型：新闻列表项 */
    private static final int TYPE_NEWS_ITEM = 1;

    private Context context;
    private LayoutInflater inflater;
    private List<NewsItem> newsItems;
    private List<View> focusViews;
    private PagerAdapter pagerAdapter;

    public NewsListAdapter(Context context, List<NewsItem> newsItems) {
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        this.newsItems = newsItems;
        focusViews = new ArrayList<>();
        View view = null;
        ImageView imageView = null;
        TextView textView = null;

        view = inflater.inflate(R.layout.item_news_focus, null);
        imageView = (ImageView) view.findViewById(R.id.focus_image);
        textView = (TextView) view.findViewById(R.id.focus_content_title);
        imageView.setBackgroundResource(R.drawable.image_news01);
        textView.setText("新闻1");
        focusViews.add(view);

        view = inflater.inflate(R.layout.item_news_focus, null);
        imageView = (ImageView) view.findViewById(R.id.focus_image);
        textView = (TextView) view.findViewById(R.id.focus_content_title);
        imageView.setBackgroundResource(R.drawable.image_news02);
        textView.setText("新闻2");
        focusViews.add(view);

        view = inflater.inflate(R.layout.item_news_focus, null);
        imageView = (ImageView) view.findViewById(R.id.focus_image);
        textView = (TextView) view.findViewById(R.id.focus_content_title);
        imageView.setBackgroundResource(R.drawable.image_news03);
        textView.setText("新闻3");
        focusViews.add(view);

        view = inflater.inflate(R.layout.item_news_focus, null);
        imageView = (ImageView) view.findViewById(R.id.focus_image);
        textView = (TextView) view.findViewById(R.id.focus_content_title);
        imageView.setBackgroundResource(R.drawable.image_news04);
        textView.setText("新闻4");
        focusViews.add(view);

        pagerAdapter = new PagerAdapter() {
            @Override
            public int getCount() {
                return focusViews.size();
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view==object;
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                View v = focusViews.get(position);
                if (v.getParent()!=null){
                    ((ViewGroup)v.getParent()).removeView(v);
                }
                container.addView(v);
                return v;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView(focusViews.get(position));
            }
        };
    }
        @Override
    public int getCount() {
        return newsItems.size()+1;
    }

    @Override
    public NewsItem getItem(int i) {
        if (i>0){
            return newsItems.get(i-1);
        }
        return null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public int getItemViewType(int position) {
        if(position == 0){
            return TYPE_FOCUS_IMAGE;
        }
        return TYPE_NEWS_ITEM;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        NewsHolder newsHolder = null;
        FocusHolder focusHolder = null;
        if (view==null){
            if (getItemViewType(i)==TYPE_FOCUS_IMAGE){
                view = inflater.inflate(R.layout.item_news_focus_pager, null);
                focusHolder = new FocusHolder();
                focusHolder.viewPager = (ViewPager)view.findViewById(R.id.item_pager);
                view.setTag(focusHolder);
            }else{
                view = inflater.inflate(R.layout.item_news,null);
                newsHolder = new NewsHolder();
                newsHolder.iv = (ImageView) view.findViewById(R.id.item_news_image);
                newsHolder.tvTitle = (TextView) view.findViewById(R.id.item_news_title);
                newsHolder.tvDescription = (TextView) view.findViewById(R.id.item_news_description);
                view.setTag(newsHolder);
            }
        }else{
            if (getItemViewType(i)==TYPE_FOCUS_IMAGE) {
                focusHolder = (FocusHolder) view.getTag();
            }else{
                newsHolder = (NewsHolder) view.getTag();
            }
        }
        //绑定数据
        if (getItemViewType(i)==TYPE_FOCUS_IMAGE){
            focusHolder.viewPager.setAdapter(pagerAdapter);
        }else {
            NewsItem news = getItem(i);
            if (news != null) {
                newsHolder.tvTitle.setText(news.title);
                newsHolder.tvDescription.setText(news.content);
            }
        }
        return view;
    }

    class NewsHolder {
        public ImageView iv;
        public TextView tvTitle;
        public TextView tvDescription;
    }

    class FocusHolder{
        public ViewPager viewPager;
    }

}
