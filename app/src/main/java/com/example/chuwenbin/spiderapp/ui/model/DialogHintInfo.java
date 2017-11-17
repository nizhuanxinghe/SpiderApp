package com.example.chuwenbin.spiderapp.ui.model;

/**
 * Created by pax1 on 17/3/21.
 */

public class DialogHintInfo {
    private String title;
    private String content;
    private String selectorConfirm;
    private String selectorCancel;

    public DialogHintInfo(String title, String content, String selectorLeft, String selectorRight) {
        this.content = content;
        this.title = title;
        this.selectorCancel = selectorLeft;
        this.selectorConfirm = selectorRight;
    }

    public DialogHintInfo() {
    }

    public String getTitle() {
        return title;
    }


    public void setTitle(String title) {
        this.title = title;
    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSelectorConfirm() {
        return selectorConfirm;
    }

    public void setSelectorConfirm(String selectorConfirm) {
        this.selectorConfirm = selectorConfirm;
    }

    public String getSelectorCancel() {
        return selectorCancel;
    }

    public void setSelectorCancel(String selectorCancel) {
        this.selectorCancel = selectorCancel;
    }
}
