package com.example.jiaxin.jiaxinpractice;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.example.jiaxin.jiaxinpractice.adapter.MyAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

import static android.widget.Toast.LENGTH_LONG;

public class MainActivity extends Activity {

    //声明一个ListView对象
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //调用父类的onCreate()方法
        super.onCreate(savedInstanceState);
        //设置界面布局
        setContentView(R.layout.list_view);
        //获取到ListView对象
        listView = (ListView) findViewById(R.id.list_view);
        MyAdapter myAdapter = new MyAdapter(this);
        listView.setAdapter(myAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.v("ListView","你点击了ListView条目 "+i);
            }
        });
    }


}
