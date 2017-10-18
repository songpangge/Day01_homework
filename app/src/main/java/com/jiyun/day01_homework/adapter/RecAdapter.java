package com.jiyun.day01_homework.adapter;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jiyun.day01_homework.R;
import com.jiyun.day01_homework.bean.Bean;

import java.util.List;

/**
 * Created by asus on 2017/10/17.
 */

public class RecAdapter extends RecyclerView.Adapter<RecAdapter.ViewHolder> {
    private List<Bean.ResultBean.DataBean> data;
    private Context context;
    public RecAdapter(List<Bean.ResultBean.DataBean> data, FragmentActivity activity) {
       this.data = data;
        this.context =activity;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View inflate = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Glide.with(context).load(data.get(position).getThumbnail_pic_s()).into(holder.img);
        holder.tv_title.setText(data.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView img;
        private final TextView tv_title;

        public ViewHolder(View itemView) {
            super(itemView);
             img = itemView.findViewById(R.id.img);
             tv_title = itemView.findViewById(R.id.tv_title);
        }

    }
}
