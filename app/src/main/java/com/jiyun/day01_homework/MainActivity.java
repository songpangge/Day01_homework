package com.jiyun.day01_homework;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.jiyun.day01_homework.fragments.BlankFragment;
import com.jiyun.day01_homework.adapter.MyAdapter;
import com.jiyun.day01_homework.fragments.SendFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ViewPager vp;
    private TabLayout table;
    private ArrayList<Fragment> fragments;
    private ArrayList<String> strings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();

    }

    private void initData() {
        fragments = new ArrayList<>();
        BlankFragment blankFragment = new BlankFragment();
        SendFragment sendFragment = new SendFragment();
        fragments.add(blankFragment);
        fragments.add(sendFragment);
        strings = new ArrayList<>();
        strings.add("分类");
        strings.add("首页");
        MyAdapter myAdapter = new MyAdapter(getSupportFragmentManager(),fragments,strings);
        table.setupWithViewPager(vp);
        vp.setAdapter(myAdapter);

    }

    private void initView() {
        vp = (ViewPager) findViewById(R.id.vp);
        table = (TabLayout) findViewById(R.id.table);
    }
}
