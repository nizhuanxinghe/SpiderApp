package com.example.chuwenbin.spiderapp.ui.adapter;

import android.content.Context;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.example.chuwenbin.spiderapp.R;
import com.example.chuwenbin.spiderapp.ui.mvp.bean.resp.PicsBean;

/**
 * Created by chuwenbin on 17/11/9.
 */

public class PicRecyclerAdapter extends RecyclerView.Adapter<PicRecyclerAdapter.MyViewHolder> {

    private PicsBean mPicsBean;
    private LayoutInflater mLayoutInflater;
    private ItemSelectListener mItemSelectListener;

    public interface ItemSelectListener {
        void onChecked(int index);
    }

    public PicRecyclerAdapter(PicsBean mPicsBean, LayoutInflater mLayoutInflater, ItemSelectListener mItemSelectListener) {
        this.mPicsBean = mPicsBean;
        this.mLayoutInflater = mLayoutInflater;
        this.mItemSelectListener = mItemSelectListener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View convertView = mLayoutInflater.inflate(R.layout.item_pic, null);
        MyViewHolder holder = new MyViewHolder(convertView);


        return holder;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

        final PicsBean.DataListBean data = mPicsBean.getDataList().get(position);

        //存在记录的高度时先Layout再异步加载图片
        if (data.getHeight() > 0) {
            ViewGroup.LayoutParams layoutParams = holder.imgView.getLayoutParams();
            layoutParams.height = data.getHeight();
        }

//获取屏幕宽度
        WindowManager windowManager = (WindowManager)mLayoutInflater.getContext().getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        Display display = windowManager.getDefaultDisplay();
        display.getMetrics(dm);
        final int screenWidth = dm.widthPixels;

        holder.textView.setText(data.getTitle());
        String url = data.getLink();

        Glide.with(mLayoutInflater.getContext()).asGif().load(url).listener(new RequestListener<GifDrawable>() {
            @Override
            public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<GifDrawable> target, boolean isFirstResource) {

                holder.imgView.setImageResource(R.mipmap.loading);
                return false;
            }

            @Override
            public boolean onResourceReady(GifDrawable resource, Object model, Target<GifDrawable> target, DataSource dataSource, boolean isFirstResource) {
                if (data.getHeight() <= 0) {
                    int width = resource.getMinimumWidth();
                    int height = resource.getMinimumHeight();
                    int realHeight = screenWidth * height / width / 4;
                    data.setHeight(realHeight);
                    ViewGroup.LayoutParams lp = holder.imgView.getLayoutParams();
                    lp.height = realHeight;
                    if(width < screenWidth / 4)
                        lp.width = screenWidth / 4;
                }
                holder.imgView.setImageDrawable(resource);
                return false;
            }
        }).into(holder.imgView);

        holder.contentView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mItemSelectListener.onChecked(position);
            }
        });


    }

    @Override
    public int getItemCount() {
        if (mPicsBean == null)
            return 0;
        return mPicsBean.getDataList().size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        View contentView;

        ImageView imgView;
        TextView textView;

        public MyViewHolder(View view) {
            super(view);
            contentView = view;
            imgView = contentView.findViewById(R.id.img_pic);
            textView = contentView.findViewById(R.id.img_title);
        }
    }

    @Override
    public int getItemViewType(int position) {
        WindowManager windowManager = (WindowManager)mLayoutInflater.getContext().getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        Display display = windowManager.getDefaultDisplay();
        display.getMetrics(dm);
        final int screenWidth = dm.widthPixels;
        return Math.round((float) screenWidth / (float) mPicsBean.getDataList().get(position).getHeight() * 10f);
    }
}
