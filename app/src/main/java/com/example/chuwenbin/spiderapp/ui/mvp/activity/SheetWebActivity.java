package com.example.chuwenbin.spiderapp.ui.mvp.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.chuwenbin.spiderapp.R;
import com.example.chuwenbin.spiderapp.utils.LogUtil;

/**
 * Created by chuwenbin on 17/11/10.
 */

public class SheetWebActivity extends BaseActivity {

    private WebView mWebViewSheet;
    private String mLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    void initData() {
        Intent intent = getIntent();

        mLink = intent.getStringExtra("link");

        LogUtil.i("link:" + mLink);
    }

    @Override
    void initView() {
        setContentView(R.layout.activity_sheet_web);

        mWebViewSheet = (WebView) findViewById(R.id.webView_sheet);
    }

    @Override
    void initController() {

        WebSettings webSettings = mWebViewSheet.getSettings();
        webSettings.setBuiltInZoomControls(true);
        webSettings.setJavaScriptEnabled(true);
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);

        mWebViewSheet.loadUrl(mLink);

        //设置不用系统浏览器打开,直接显示在当前Webview
        mWebViewSheet.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });

        //设置WebChromeClient类
        mWebViewSheet.setWebChromeClient(new WebChromeClient() {


            //获取网站标题
            @Override
            public void onReceivedTitle(WebView view, String title) {
                System.out.println("标题在这里");
            }


            //获取加载进度
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                if (newProgress < 100) {

                }
                else if (newProgress == 100) {

                }
            }
        });


        //设置WebViewClient类
        mWebViewSheet.setWebViewClient(new WebViewClient() {
            //设置加载前的函数
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                System.out.println("开始加载了");

            }

            //设置结束加载函数
            @Override
            public void onPageFinished(WebView view, String url) {

            }
        });

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && mWebViewSheet.canGoBack()) {
            mWebViewSheet.goBack();
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onDestroy() {
        if (mWebViewSheet != null) {
            mWebViewSheet.loadDataWithBaseURL(null, "", "text/html", "utf-8", null);
            mWebViewSheet.clearHistory();

            ((ViewGroup) mWebViewSheet.getParent()).removeView(mWebViewSheet);
            mWebViewSheet.destroy();
            mWebViewSheet = null;
        }
        super.onDestroy();

    }
}
