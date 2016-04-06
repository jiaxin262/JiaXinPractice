package com.example.jiaxin.qunarnews.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.astuetz.PagerSlidingTabStrip;
import com.example.jiaxin.qunarnews.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiaxin on 15-8-14.
 */
public class NewsFragment extends Fragment {

    PagerSlidingTabStrip tabStrip;
    ViewPager viewPager;
    //新闻列表页集合
    List<Fragment> newsListFragments = new ArrayList<Fragment>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news,null);
        tabStrip = (PagerSlidingTabStrip) view.findViewById(R.id.tabs);
        viewPager = (ViewPager) view.findViewById(R.id.pager);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        final String[] tabNames = getActivity().getResources().getStringArray(R.array.news_categories);
        //初始化新闻数据
        for (int i=0; i<tabNames.length; i++){
            newsListFragments.add(new NewsListFragment());
        }
        //初始化tab
        viewPager.setAdapter(new FragmentStatePagerAdapter(getFragmentManager()) {

            @Override
            public android.support.v4.app.Fragment getItem(int position) {
                return newsListFragments.get(position);
            }

            @Override
            public int getCount() {
                return newsListFragments.size();
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return tabNames[position];
            }
        });

        tabStrip.setTextSize(getResources().getDimensionPixelSize(R.dimen.tab_text_size));
        tabStrip.setTextColorResource(R.color.tab_text);
        tabStrip.setViewPager(viewPager);
        viewPager.setCurrentItem(0);

    }
}
