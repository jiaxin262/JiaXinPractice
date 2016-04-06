package com.example.jiaxin.qunarnews.fragment;


import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.example.jiaxin.qunarnews.NewsItem.NewsItem;
import com.example.jiaxin.qunarnews.R;
import com.example.jiaxin.qunarnews.adapter.NewsListAdapter;
import com.example.jiaxin.qunarnews.result.NewsListResult;
import java.util.ArrayList;
import java.util.List;
import zrc.widget.SimpleFooter;
import zrc.widget.SimpleHeader;
import zrc.widget.ZrcListView;

/**
 * Created by jiaxin on 15-8-14.
 */
public class NewsListFragment extends Fragment {

    private ZrcListView zrcListView;
    NewsListAdapter adapter;
    List<NewsItem> newsItemList = new ArrayList<>();
    private Handler handler;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news_list,null);
        zrcListView = (ZrcListView) view;
        handler = new Handler();

        // 设置下拉刷新的样式
        SimpleHeader header = new SimpleHeader(getActivity());
        header.setTextColor(0xff0066aa);
        header.setCircleColor(0xff33bbee);
        zrcListView.setHeadable(header);

        // 设置加载更多的样式
        SimpleFooter footer = new SimpleFooter(getActivity());
        footer.setCircleColor(0xff33bbee);
        zrcListView.setFootable(footer);

        // 设置列表项出现动画
        zrcListView.setItemAnimForTopIn(R.anim.topitem_in);
        zrcListView.setItemAnimForBottomIn(R.anim.bottomitem_in);

        // 下拉刷新事件回调（可选）
        zrcListView.setOnRefreshStartListener(new ZrcListView.OnStartListener() {
            @Override
            public void onStart() {
                refresh();
            }
        });

        // 加载更多事件回调（可选）
        zrcListView.setOnLoadMoreStartListener(new ZrcListView.OnStartListener() {
            @Override
            public void onStart() {
                loadMore();
            }
        });

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //添加假数据
        NewsListResult newsListResult = NewsListResult.mock();
        newsItemList.addAll(newsListResult.datas);
        adapter = new NewsListAdapter(getActivity(),newsItemList);
        zrcListView.setAdapter(adapter);
        //zrcListView.startLoadMore();
    }

    private void refresh() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                NewsListResult result = NewsListResult.mock();
                if (result.datas != null && result.datas.size() > 0) {
                    newsItemList.clear();
                    newsItemList.add(result.datas.get(0));
                }
                adapter.notifyDataSetChanged();
                zrcListView.setRefreshSuccess();
                Toast.makeText(getActivity(), "数据更新完毕。", Toast.LENGTH_SHORT).show();
            }
        }, 1000);
    }

    private void loadMore() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                NewsListResult result = NewsListResult.mock();
                if (result.datas != null && result.datas.size() > 0) {
                    newsItemList.clear();
                    newsItemList.add(result.datas.get(1));
                    newsItemList.add(result.datas.get(2));
                }
                adapter.notifyDataSetChanged();
                zrcListView.setLoadMoreSuccess();
            }
        },1000);

    }

}
