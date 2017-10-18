package com.jiyun.day01_homework.fragments;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jiyun.day01_homework.R;
import com.jiyun.day01_homework.adapter.ClassifyAdapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment {


    private TabLayout table_fragment;
    private ViewPager vp_fragment;
    private ArrayList<String> list;
    private ArrayList<Fragment> fragments;
    private com.jiyun.day01_homework.fragments.classifyFragment classifyFragment;
    private ArrayList<String> list1;
    private ClassifyAdapter classifyAdapter;

    public BlankFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_blank, container,false);
        initView(inflate);
        initData();
        return inflate;
    }

    private void initData() {
        //tableLayou标题
        list = new ArrayList<>();
        list.add("分类一");
        list.add("分类二");
        list.add("分类三");
        list.add("分类四");
        list.add("分类五");
        list.add("分类六");
        list.add("分类七");
        list.add("分类八");
        list.add("分类九");
        list.add("分类十");
        //不同的type值
        list1 = new ArrayList<>();
        list1.add("top");
        list1.add("shehui");
        list1.add("guonei");
        list1.add("guoji");
        list1.add("yule");
        list1.add("tiyu");
        list1.add("junshi");
        list1.add("keji");
        list1.add("caijing");
        list1.add("shishang");

        //创建fragments  传递type值
        fragments = new ArrayList<>();
        for (int i = 0; i < list1.size() ; i++) {
            classifyFragment = new classifyFragment(list1.get(i));
             fragments.add(classifyFragment);
        }
        //适配器
        classifyAdapter = new ClassifyAdapter(getChildFragmentManager(),list,fragments);
        table_fragment.setupWithViewPager(vp_fragment);
        vp_fragment.setAdapter(classifyAdapter);

    }

    //查ID
    private void initView(View inflate) {
        table_fragment = (TabLayout) inflate.findViewById(R.id.table_fragment);
        vp_fragment = (ViewPager) inflate.findViewById(R.id.vp_fragment);
    }
}
