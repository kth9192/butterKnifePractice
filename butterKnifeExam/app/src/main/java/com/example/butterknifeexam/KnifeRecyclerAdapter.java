package com.example.butterknifeexam;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by kth919 on 2017-03-10.
 */

public class KnifeRecyclerAdapter extends RecyclerView.Adapter<KnifeRecyclerAdapter.ViewHolder> {


    private ArrayList<PictureInfo> picList;
    private RequestManager mRequestManager;
    private Context context;

    public KnifeRecyclerAdapter(ArrayList<PictureInfo> picList, Context context){
        this.picList = picList;
//        this.mRequestManager = requestManager;
        this.context = context;
    }


    @Override
    public int getItemCount() {
        return picList.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycle, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        PictureInfo mPictureInfo = picList.get(position);

        holder.textTitle.setText(mPictureInfo.getTitle());
        holder.textDesc.setText(mPictureInfo.getDesc());
//        mRequestManager.load(mPictureInfo.getImage()).into(holder.imgView);
        Glide.with(context).load(mPictureInfo.getImage()).into(holder.imgView);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.textTitle)
        TextView textTitle;
        @BindView(R.id.textDesc)
        TextView textDesc;
        @BindView(R.id.img)
        ImageView imgView;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
