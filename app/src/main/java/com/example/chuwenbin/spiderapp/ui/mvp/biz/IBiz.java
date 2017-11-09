package com.example.chuwenbin.spiderapp.ui.mvp.biz;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by pax1 on 17/4/12.
 */

public class IBiz {
    public interface RequestListener {
        void onSuccess(Call call, Response response);

        void onFailure(Call call, IOException e);
    }
}
