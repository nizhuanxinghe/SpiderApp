package com.example.chuwenbin.spiderapp.ui.mvp.bean;

/**
 * Created by chuwenbin on 17/11/10.
 */

public class SpiderRequestBean {


    /**
     * macAddress : a
     * rootUrl : b
     * urlTag : base
     * pageTitle : 吉他谱
     * pageClass : pg
     * objClass : xi2
     */

    private String macAddress;
    private String rootUrl;
    private String urlTag;
    private String pageTitle;
    private String pageClass;
    private String objClass;
    private String objTagClass;
    private String filter;

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    public String getRootUrl() {
        return rootUrl;
    }

    public void setRootUrl(String rootUrl) {
        this.rootUrl = rootUrl;
    }

    public String getUrlTag() {
        return urlTag;
    }

    public void setUrlTag(String urlTag) {
        this.urlTag = urlTag;
    }

    public String getPageTitle() {
        return pageTitle;
    }

    public void setPageTitle(String pageTitle) {
        this.pageTitle = pageTitle;
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

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }

    public String getObjTagClass() {
        return objTagClass;
    }

    public void setObjTagClass(String objTagClass) {
        this.objTagClass = objTagClass;
    }
}
