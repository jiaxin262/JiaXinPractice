package com.example.jiaxin.listviewdemo.entity;

import android.graphics.Color;

import java.util.ArrayList;
import java.util.List;

/**
 * 列表项
 * Created by jiaxin on 15-8-12.
 */
public class ListItem {

    public int color;
    public String text;
    public boolean isChecked = false;

    public ListItem() {
        color = Color.BLUE;
        text = "第一个view";
    }

    public ListItem(int color, String text) {
        this.color = color;
        this.text = text;
    }

    //生成假数据
    public static List<ListItem> mockItems(){
        List<ListItem> items = new ArrayList<ListItem>();
        int[] colors = new int[]{
                Color.RED, Color.BLACK, Color.BLUE, Color.CYAN, Color.DKGRAY,
                Color.GRAY, Color.GREEN, Color.LTGRAY, Color.YELLOW, Color.TRANSPARENT,
                Color.RED, Color.BLACK, Color.BLUE, Color.CYAN, Color.DKGRAY,
                Color.GRAY, Color.GREEN, Color.LTGRAY, Color.YELLOW, Color.TRANSPARENT
        };
        for (int i=0; i<20; i++){
            ListItem item = new ListItem();
            item.color = colors[i];
            item.text = "第"+i+"个view";
            items.add(item);
        }
        return items;
    }
}
