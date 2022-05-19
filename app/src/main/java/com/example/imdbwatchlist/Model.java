package com.example.imdbwatchlist;

public class Model {
    String title, score, time_stamp, imdb_id, Image_uri;

    public Model(String title, String score, String time_stamp, String imdb_id, String image_uri) {
        this.title = title;
        this.score = score;
        this.time_stamp = time_stamp;
        this.imdb_id = imdb_id;
        Image_uri = image_uri;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getTime_stamp() {
        return time_stamp;
    }

    public void setTime_stamp(String time_stamp) {
        this.time_stamp = time_stamp;
    }

    public String getImdb_id() {
        return imdb_id;
    }

    public void setImdb_id(String imdb_id) {
        this.imdb_id = imdb_id;
    }

    public String getImage_uri() {
        return Image_uri;
    }

    public void setImage_uri(String image_uri) {
        Image_uri = image_uri;
    }
}
