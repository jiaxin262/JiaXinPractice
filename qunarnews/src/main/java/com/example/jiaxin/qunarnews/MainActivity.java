package com.example.jiaxin.qunarnews;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.RadioGroup;

import com.example.jiaxin.qunarnews.fragment.DiscoveryFragment;
import com.example.jiaxin.qunarnews.fragment.MyselfFragment;
import com.example.jiaxin.qunarnews.fragment.NewsFragment;
import com.example.jiaxin.qunarnews.fragment.ReadFragment;
import com.example.jiaxin.qunarnews.fragment.VideoFragment;

public class MainActivity extends FragmentActivity {

    //底部菜单栏
    private RadioGroup menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //获取到RadioGroup控件
        menu = (RadioGroup) findViewById(R.id.menus);
        //添加默认的Fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content, new NewsFragment());
        transaction.commit();

        //为底部菜单栏绑定监听
        menu.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                Fragment fragment = null;
                switch (checkedId){
                    case R.id.nav_tab_news:
                        fragment = new NewsFragment();
                        break;
                    case R.id.nav_tab_read:
                        fragment = new ReadFragment();
                        break;
                    case R.id.nav_tab_video:
                        fragment = new VideoFragment();
                        break;
                    case R.id.nav_tab_discovery:
                        fragment = new DiscoveryFragment();
                        break;
                    case R.id.nav_tab_myself:
                        fragment = new MyselfFragment();
                        break;
                }
                if (fragment!=null){
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.content,fragment).commit();
                }
            }
        });

    }


}
