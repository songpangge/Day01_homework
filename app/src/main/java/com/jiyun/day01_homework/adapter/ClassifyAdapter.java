package com.jiyun.day01_homework.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by asus on 2017/10/17.
 */

public class ClassifyAdapter extends FragmentPagerAdapter {
    private ArrayList<String> list;
    private ArrayList<Fragment> fragments;
    public ClassifyAdapter(FragmentManager fm, ArrayList<String> list, ArrayList<Fragment> fragments) {
        super(fm);
        this.list = list;
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return list.get(position);
        //啊啊啊啊啊啊
    }
}
