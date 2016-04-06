package com.example.jiaxin.test;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.jiaxin.test.model.ListVIewItemHolder;

import java.util.ArrayList;
import java.util.HashMap;

import zrc.widget.SimpleFooter;
import zrc.widget.SimpleHeader;
import zrc.widget.ZrcListView;

public class MainActivity extends Activity {

    private ZrcListView listView;
    private Handler handler;
    private MyAdapter adapter;
    private int preSize, size;
    private ArrayList<HashMap<String, Object>> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ZrcListView) findViewById(R.id.listView);
        handler = new Handler();
        list = new ArrayList<HashMap<String, Object>>();
        preSize = 0;
        size = 15;
        if (preSize == 0) {
            for (int i = preSize; i < size; i++) {
                HashMap<String, Object> map = new HashMap<String, Object>();
                map.put("itemTitle", "第" + i + "行--初始");
                map.put("itemText", "这是第" + i + "行--初始");
                list.add(map);
            }
            preSize = size;
        }
        /*// 设置默认偏移量，主要用于实现透明标题栏功能。（可选）
        float density = getResources().getDisplayMetrics().density;
        listView.setFirstTopOffset((int) (50 * density));*/

        // 设置下拉刷新的样式（可选，但如果没有Header则无法下拉刷新）
        SimpleHeader header = new SimpleHeader(this);
        header.setTextColor(0xff0066aa);
        header.setCircleColor(0xff33bbee);
        listView.setHeadable(header);

        // 设置加载更多的样式（可选）
        SimpleFooter footer = new SimpleFooter(this);
        footer.setCircleColor(0xff33bbee);
        listView.setFootable(footer);

        // 设置列表项出现动画（可选）
        listView.setItemAnimForTopIn(R.anim.topitem_in);
        listView.setItemAnimForBottomIn(R.anim.bottomitem_in);

        // 下拉刷新事件回调（可选）
        listView.setOnRefreshStartListener(new ZrcListView.OnStartListener() {
            @Override
            public void onStart() {
                refresh();
            }
        });

        // 加载更多事件回调（可选）
        listView.setOnLoadMoreStartListener(new ZrcListView.OnStartListener() {
            @Override
            public void onStart() {
                loadMore();
            }
        });

        adapter = new MyAdapter(this);
        listView.setAdapter(adapter);
        listView.refresh(); // 主动下拉刷新
    }

    private void refresh() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                for (int i = preSize; i < size; i++) {
                    HashMap<String, Object> map = new HashMap<String, Object>();
                    map.put("itemTitle", "第" + i + "行--刷新");
                    map.put("itemText", "这是第" + i + "行--刷新");
                    list.add(map);
                }
                preSize = size;
                size += 5;
                adapter.notifyDataSetChanged();
                listView.setRefreshSuccess("加载成功"); // 通知加载成功
                listView.startLoadMore(); // 开启LoadingMore功能
            }
        }, 1000);
    }

    private void loadMore() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                for (int i = preSize; i < size; i++) {
                    HashMap<String, Object> map = new HashMap<String, Object>();
                    map.put("itemTitle", "第" + i + "行--加载");
                    map.put("itemText", "这是第" + i + "行--加载");
                    list.add(map);
                }
                preSize = size;
                size += 5;
                adapter.notifyDataSetChanged();
                listView.setLoadMoreSuccess();
            }

        }, 2 * 1000);
    }


    public class MyAdapter extends BaseAdapter {

        //得到一个Inflater对象来导入布局
        private LayoutInflater inflater;

        public MyAdapter(Context context) {
            this.inflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            return list == null ? 0 : list.size();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(final int position, View view, ViewGroup viewGroup) {
            ListVIewItemHolder holder;
            if (view == null) {
                view = inflater.inflate(R.layout.item, null);
                holder = new ListVIewItemHolder();
                holder.button = (Button) view.findViewById(R.id.button);
                holder.itemTitle = (TextView) view.findViewById(R.id.itemTitle);
                holder.itemText = (TextView) view.findViewById(R.id.itemText);
                view.setTag(holder);
            } else {
                holder = (ListVIewItemHolder) view.getTag();
            }

            holder.itemTitle.setText(list.get(position).get("itemTitle").toString());
            holder.itemText.setText(list.get(position).get("itemText").toString());
            holder.button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.v("ListView", "你点击了Button " + position);
                }
            });
            return view;
        }

    }

}
