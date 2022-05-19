package com.example.imdbwatchlist;

public class Constants {
    public static final String DB_NAME="MOVIE_DB";
    public static final int DB_VERISON =1;
    public static final String TABLE_NAME="MOVIE_TABLE";
    public static final String M_ID ="ID";
    public static final String M_TITLE ="TITLE";
    public static final String M_SCORE ="SCORE";
    public static final String M_IMDB_ID="IMDB_ID";
    public static final String M_IMAGE_URI="IMAGE_URI";
    public static final String M_TIME_STAMP="TIME_STAMP";

    public static final String CREATE_TABLE = "CREATE TABLE "+TABLE_NAME+" ("
            +M_ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"
            +M_TITLE+" TEXT,"
            +M_SCORE+" TEXT,"
            +M_IMDB_ID+" TEXT,"
            +M_IMAGE_URI+" TEXT,"


            +M_TIME_STAMP+" TEXT"
            //ADD OTHER VALUES HERE
            //ADD OTHER VALUES HERE
            +");";



}
