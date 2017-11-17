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
    private String urlClass;
    private String headClass;
    private String pageClass;
    private String objClass;

    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

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

    public String getUrlClass() {
        return urlClass;
    }

    public void setUrlClass(String urlClass) {
        this.urlClass = urlClass;
    }

    public String getHeadClass() {
        return headClass;
    }

    public void setHeadClass(String headClass) {
        this.headClass = headClass;
    }

    public String getPageClass() {
        return pageClass;
    }

    public void setPageClass(String pageClass) {
        this.pageClass = pageClass;
    }

    public String getObjClass() {
        return objClass;
    }

    public void setObjClass(String objClass) {
        this.objClass = objClass;
    }
}
