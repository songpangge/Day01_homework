package com.jiyun.day01_homework.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.jiyun.day01_homework.R;
import com.jiyun.day01_homework.adapter.RecAdapter;
import com.jiyun.day01_homework.bean.Bean;
import com.jiyun.day01_homework.httputils.OkHttpUtils;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class classifyFragment extends Fragment {


    private RecyclerView rec;
    private String s;
    //把传来的type值全局化
     public classifyFragment(String s){
         this.s = s;
     }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_classify, container, false);

        initView(inflate);
        //根据不同的type  获取不同的数据
        //http://v.juhe.cn/toutiao/index?type=top&key=097060266650f67b2cebd2a06aded587
        String url ="http://v.juhe.cn/toutiao/index?type=";
        String key="&key=097060266650f67b2cebd2a06aded587";
        initData(url+s+key);
        return inflate;
    }

    private void initData(String ss) {
        OkHttpUtils.getInstance().sendGet(ss, new Callback() {
            private String string;

            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                 string = response.body().string();
              getActivity().runOnUiThread(new Runnable() {
                  @Override
                  public void run() {

                      //gson 解析
                      Gson gson = new Gson();
                      Bean bean = gson.fromJson(string, Bean.class);
                      List<Bean.ResultBean.DataBean> data = bean.getResult().getData();
                      //适配器
                      LinearLayoutManager m = new LinearLayoutManager(getActivity());
                      rec.setLayoutManager(m);
                      RecAdapter recAdapter = new RecAdapter(data,getActivity());
                      rec.setAdapter(recAdapter);
                  }
              });
            }
        });
    }

    private void initView(View inflate) {
        rec = (RecyclerView) inflate.findViewById(R.id.rec);
    }
}
