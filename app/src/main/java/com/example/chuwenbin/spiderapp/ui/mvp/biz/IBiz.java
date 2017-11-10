package com.example.chuwenbin.spiderapp.ui.mvp.biz;

/**
 * Created by pax1 on 17/4/12.
 */

public class IBiz {
    public interface RequestListener {
        void onSuccess(String resp);

        void onFailure(String errorMsg);
    }
}
