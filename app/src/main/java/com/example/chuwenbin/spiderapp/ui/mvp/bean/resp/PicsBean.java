package com.example.chuwenbin.spiderapp.ui.mvp.bean.resp;

import java.util.List;

/**
 * Created by chuwenbin on 17/12/5.
 */

public class PicsBean {

    private List<DataListBean> dataList;

    public List<DataListBean> getDataList() {
        return dataList;
    }

    public void setDataList(List<DataListBean> dataList) {
        this.dataList = dataList;
    }

    public static class DataListBean {
        /**
         * picId : null
         * link : http://qq.yh31.com/tp/zjbq/201712041146016186.gif
         * title : 点图看详细
         */

        private Object picId;
        private String link;
        private String title;

        private int height;

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public Object getPicId() {
            return picId;
        }

        public void setPicId(Object picId) {
            this.picId = picId;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }


    }
}
