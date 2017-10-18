package com.jiyun.day01_homework.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.jiyun.day01_homework.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SendFragment extends Fragment {


    private WebView webview;

    public SendFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_send, container, false);

        initView(inflate);
        initData();
        return inflate;
    }

    private void initData() {
        webview.loadUrl("http://www.csdn.net");
        WebSettings settings = webview.getSettings();
        settings.setJavaScriptEnabled(true);
        webview.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
             view.loadUrl(url);
                return true;
            }
        });
    }

    private void initView(View inflate) {
        webview = (WebView) inflate.findViewById(R.id.webview);
    }
}
