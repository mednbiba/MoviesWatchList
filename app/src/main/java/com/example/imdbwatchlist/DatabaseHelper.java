package com.example.imdbwatchlist;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

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
    public void deleteInfo(String id){
        SQLiteDatabase db=getWritableDatabase();
        db.delete(Constants.TABLE_NAME,Constants.M_IMDB_ID+" = ?", new String[]{id});
        db.close();
    }
    public int movieExists(String id){
        int found=0;
        String selectQuery="select * from "+ Constants.TABLE_NAME+" where "+Constants.M_IMDB_ID+"='"+id+"'";

        SQLiteDatabase db=this.getWritableDatabase();

        Cursor cursor = db.rawQuery(selectQuery,null);
        if(cursor.moveToNext()){
            found=1;
        }
        db.close();
        return found;
    }
    public ArrayList<Model> getAllData(String orderBy){

        ArrayList<Model> arraylist = new ArrayList<>();

        //Query
        String selectQuery="SELECT * FROM "+Constants.TABLE_NAME+" ORDER BY "+ orderBy;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery,null);

        if(cursor.moveToNext()){
            do{Model model = new Model(

                      ""+cursor.getString(cursor.getColumnIndexOrThrow(Constants.M_TITLE)),
                      ""+cursor.getString(cursor.getColumnIndexOrThrow(Constants.M_SCORE)),
                      ""+cursor.getString(cursor.getColumnIndexOrThrow(Constants.M_TIME_STAMP)),
                      ""+cursor.getString(cursor.getColumnIndexOrThrow(Constants.M_IMDB_ID)),
                      ""+cursor.getString(cursor.getColumnIndexOrThrow(Constants.M_IMAGE_URI))


            );
                arraylist.add(model);


            } while(cursor.moveToNext());
        }
        db.close();
        return arraylist;

    }
}
