package com.example.schedulemanager;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by bjj on 2017-07-25.
 */
public class DBHelper extends SQLiteOpenHelper {

    // DB NAME
    public static final String DATABASE_NAME = "schedule_manager.sqlite";
    // DB VERSION ( 숫자가 변하면 업그레이드 ( onUpgrade ) 됨 ) ( 새로 설치하면 onCreate )
    public static final int DB_VERSION_1 = 1;
    public static SQLiteDatabase DB;
    public static DBHelper dbHelper;

    public DBHelper(Context context)
    {
        super(context, DATABASE_NAME, null, DB_VERSION_1);
        dbHelper = this;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
