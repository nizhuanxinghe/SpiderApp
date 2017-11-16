package com.example.chuwenbin.spiderapp.db.dao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;


@Entity
public class Setting {

    @Id
    private Long id;                    // 数据库ID  必须要有

    private String root_url;

    private String url_class;

    @Generated(hash = 1667619148)
    public Setting(Long id, String root_url, String url_class) {
        this.id = id;
        this.root_url = root_url;
        this.url_class = url_class;
    }

    @Generated(hash = 909716735)
    public Setting() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoot_url() {
        return this.root_url;
    }

    public void setRoot_url(String root_url) {
        this.root_url = root_url;
    }

    public String getUrl_class() {
        return this.url_class;
    }

    public void setUrl_class(String url_class) {
        this.url_class = url_class;
    }

}