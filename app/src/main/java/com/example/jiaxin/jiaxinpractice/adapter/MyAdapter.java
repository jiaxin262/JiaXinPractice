package com.example.jiaxin.jiaxinpractice.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import com.example.jiaxin.jiaxinpractice.R;
import java.util.ArrayList;
import java.util.HashMap;


/**
 * Created by jiaxin on 15-8-11.
 */
public class MyAdapter extends BaseAdapter {

    //得到一个Inflater对象来导入布局
    private LayoutInflater inflater;

    public MyAdapter(Context context) {
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return getData().size();
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
        ViewHolder holder;
        Log.v("MyListViewBase", "getView " + position + " " + view);
        if (view==null){
            view = inflater.inflate(R.layout.item,null);
            holder = new ViewHolder();
            holder.bt = (Button) view.findViewById(R.id.button);
            holder.title = (TextView) view.findViewById(R.id.itemTitle);
            holder.text = (TextView) view.findViewById(R.id.itemText);
            view.setTag(holder);
            Log.v("MyListViewBase", "创建了新的view"+position);
        }else {
            Log.v("MyListViewBase", "用的旧的view"+position);
            holder = (ViewHolder) view.getTag();
        }
        holder.title.setText(getData().get(position).get("itemTitle").toString());
        holder.text.setText(getData().get(position).get("itemText").toString());
        holder.bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.v("ListView", "你点击了Button " + position);
            }
        });
        return view;
    }

    private ArrayList<HashMap<String, Object>> getData() {
        ArrayList<HashMap<String, Object>> listItem = new ArrayList<HashMap<String, Object>>();
        for (int i = 0; i < 30; i++) {
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("image", R.mipmap.ic_launcher);
            map.put("itemTitle", "第" + i + "行");
            map.put("itemText", "这是第" + i + "行");
            listItem.add(map);
        }
        return listItem;
    }
}
