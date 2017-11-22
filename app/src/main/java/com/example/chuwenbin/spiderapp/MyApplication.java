package com.example.chuwenbin.spiderapp;

import android.app.Application;

/**
 * Created by chuwenbin on 17/11/15.
 */

public class MyApplication extends Application {

    private static MyApplication mInstances;
    @Override
    public void onCreate() {
        super.onCreate();

        mInstances = this;

//        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this,"notes-db");
////        Database db = helper.getEncryptedWritableDb("super-secret");
//        DaoSession daoSession = new DaoMaster(db).newSession();
//
//        SettingDao sd = daoSession.getSettingDao();
//
//        Query<Setting> settingQuery = sd.queryBuilder().orderAsc(SettingDao.Properties.Root_url).build();

    }


    public static MyApplication getInstances(){
        return mInstances;
    }
}
