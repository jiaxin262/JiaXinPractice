package com.example.jiaxin.listviewdemo;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.example.jiaxin.listviewdemo.adapter.ListViewAdapter;
import com.example.jiaxin.listviewdemo.entity.ListItem;

import java.util.ArrayList;
import java.util.List;


public class ListVIewDemo extends AppCompatActivity {

    //ListVIew 对象
    private ListView listView;
    //列表项集合
    private List<ListItem> itemList = new ArrayList<ListItem>();
    //适配器
    private ListViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //调用父类onCreate（）方法
        super.onCreate(savedInstanceState);
        //为Activity配置布局文件
        setContentView(R.layout.activity_list_view_demo);
        //得到ListView控件
        listView = (ListView) findViewById(R.id.listView);
        //生成假数据
        itemList = ListItem.mockItems();
        //创建适配器
        adapter = new ListViewAdapter(this, itemList);
        //为ListView绑定适配器
        listView.setAdapter(adapter);
    }

}
