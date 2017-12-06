package com.example.chuwenbin.spiderapp.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.chuwenbin.spiderapp.R;
import com.example.chuwenbin.spiderapp.ui.mvp.bean.resp.GuitarSheetBean;

/**
 * Created by chuwenbin on 17/11/9.
 */

public class SheepListAdapter extends BaseAdapter {
    private GuitarSheetBean mGuitarSheetBean;
    private LayoutInflater mLayoutInflater;

    private ItemSelectListener mItemSelectListener;

    interface ItemSelectListener {
        void onChecked(int index);
    }

    public GuitarSheetBean getmGuitarSheetBean() {
        return mGuitarSheetBean;
    }

    public void setmGuitarSheetBean(GuitarSheetBean mGuitarSheetBean) {
        this.mGuitarSheetBean = mGuitarSheetBean;
    }

    public SheepListAdapter(GuitarSheetBean mGuitarSheetBean, LayoutInflater mLayoutInflater, ItemSelectListener mItemSelectListener) {
        this.mGuitarSheetBean = mGuitarSheetBean;
        this.mLayoutInflater = mLayoutInflater;
        this.mItemSelectListener = mItemSelectListener;
    }

    @Override
    public int getCount() {
        return mGuitarSheetBean.getDataList().size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        SheetViewHold sheetViewHold = null;
        if (convertView == null) {
            sheetViewHold = new SheetViewHold();

            convertView = mLayoutInflater.inflate(R.layout.item_guitersheet, null);
            sheetViewHold.textViewSheetName = convertView.findViewById(R.id.textView_sheetName);
            convertView.setTag(sheetViewHold);
        }else {
            sheetViewHold = (SheetViewHold) convertView.getTag();
        }

        sheetViewHold.textViewSheetName.setText(mGuitarSheetBean.getDataList().get(position).toString());

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mItemSelectListener.onChecked(position);
            }
        });

        return convertView;
    }

    class SheetViewHold {
        TextView textViewSheetName;
    }
}
