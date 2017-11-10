package com.example.chuwenbin.spiderapp.ui.mvp.bean;

/**
 * Created by chuwenbin on 17/11/10.
 */

public class SpiderRequestBean {

    /**
     * macAddress : ssssss
     * rootUrl : sss
     */

    private String macAddress;
    private String rootUrl;

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    public String getRootUrl() {
        return rootUrl;
    }

    public void setRootUrl(String url) {
        this.rootUrl = url;
    }
}
