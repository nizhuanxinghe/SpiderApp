package com.example.chuwenbin.spiderapp.ui.mvp.bean.resp;

import java.util.List;

/**
 * Created by chuwenbin on 17/11/9.
 */

public class GuitarSheetBean{


    private List<DataList> dataList;

    public List<DataList> getDataList() {
        return dataList;
    }

    public void setDataList(List<DataList> dataList) {
        this.dataList = dataList;
    }

    public static class DataList {
        /**
         * id : 139
         * link : http://www.17jita.com/tab/tab/img/7899.html
         * title : 《七月上》吉他谱 Jam G调指法编配高清弹唱谱
         */

        private int id;
        private String link;
        private String title;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
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
