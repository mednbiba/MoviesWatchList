package com.example.imdbwatchlist;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    public DatabaseHelper(@Nullable Context context) {
        super(context,Constants.DB_NAME,null,Constants.DB_VERISON);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Constants.CREATE_TABLE);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+Constants.TABLE_NAME);
        onCreate(db);

    }
    //Insert Function

    public long insertInfo(String title,String score,String time_stamp,String imdb_id,String Image_uri){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Constants.M_TITLE,title);
        values.put(Constants.M_SCORE,score);
        values.put(Constants.M_IMDB_ID,imdb_id);
        values.put(Constants.M_TIME_STAMP,time_stamp);
        values.put(Constants.M_IMAGE_URI,Image_uri);
        long id = db.insert(Constants.TABLE_NAME,null,values);
        db.close();
        return id;
    }
}
