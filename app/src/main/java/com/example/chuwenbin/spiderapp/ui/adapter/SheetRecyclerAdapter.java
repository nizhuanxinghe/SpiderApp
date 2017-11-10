package com.example.chuwenbin.spiderapp.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.chuwenbin.spiderapp.R;
import com.example.chuwenbin.spiderapp.ui.mvp.bean.GuitarSheetBean;
import com.example.chuwenbin.spiderapp.utils.LogUtil;

/**
 * Created by chuwenbin on 17/11/9.
 */

public class SheetRecyclerAdapter extends RecyclerView.Adapter<SheetRecyclerAdapter.MyViewHolder> {

    private GuitarSheetBean mGuitarSheetBean;
    private LayoutInflater mLayoutInflater;
    private ItemSelectListener mItemSelectListener;

    public interface ItemSelectListener {
        void onChecked(int index);
    }

    public SheetRecyclerAdapter(GuitarSheetBean mGuitarSheetBean, LayoutInflater mLayoutInflater, ItemSelectListener mItemSelectListener) {
        this.mGuitarSheetBean = mGuitarSheetBean;
        this.mLayoutInflater = mLayoutInflater;
        this.mItemSelectListener = mItemSelectListener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View convertView = (View) mLayoutInflater.inflate(R.layout.item_guitersheet, null);
        MyViewHolder holder = new MyViewHolder(convertView);

        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.contentView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mItemSelectListener.onChecked(position);
            }
        });

        GuitarSheetBean.DataList data = mGuitarSheetBean.getDataList().get(position);
        holder.tvSheetName.setText(data.getTitle()+"");

        LogUtil.d("title:" + data.getTitle() + ",id:" + data.getId() + ",link" + data.getLink());
    }

    @Override
    public int getItemCount() {
        return mGuitarSheetBean.getDataList().size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tvSheetName;
        View contentView;

        public MyViewHolder(View view) {
            super(view);
            contentView = view;
            tvSheetName = (TextView) view.findViewById(R.id.textView_sheetName);
        }
    }
}
