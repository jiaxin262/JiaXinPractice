package com.example.jiaxin.listviewdemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jiaxin.listviewdemo.R;
import com.example.jiaxin.listviewdemo.entity.ListItem;

import java.util.List;

/**
 * ListView适配器
 * Created by jiaxin on 15-8-13.
 */
public class ListViewAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater inflater;
    private List<ListItem> itemList;

    public ListViewAdapter(Context context, List<ListItem> itemList) {
        this.context = context;
        this.itemList = itemList;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return itemList.size();
    }

    @Override
    public Object getItem(int i) {
        return itemList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    class ContentHolder{
        public ImageView cube;
        public TextView textView;
        public CheckBox checkBox;
    }


    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        ContentHolder holder;
        if (view == null){
            //加载布局
            view = inflater.inflate(R.layout.item_layout,null);
            holder = new ContentHolder();
            holder.cube = (ImageView) view.findViewById(R.id.cube);
            holder.textView = (TextView) view.findViewById(R.id.textView);
            holder.checkBox = (CheckBox) view.findViewById(R.id.checkbox);
            view.setTag(holder);
        }else {
            holder = (ContentHolder) view.getTag();
        }
        final ListItem item = (ListItem) getItem(i);
        holder.cube.setBackgroundColor(item.color);
        holder.textView.setText(item.text);
        holder.checkBox.setChecked(item.isChecked);
        holder.checkBox.setClickable(false);
        view.setClickable(false);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                item.isChecked = !item.isChecked;
                notifyDataSetChanged();
            }
        });
        return view;
    }
}
