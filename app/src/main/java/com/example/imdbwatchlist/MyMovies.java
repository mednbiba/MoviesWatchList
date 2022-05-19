package com.example.imdbwatchlist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MyMovies extends AppCompatActivity {
    RecyclerView recyclerView;
    DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_movies);

        recyclerView=findViewById(R.id.recyclerView);
        databaseHelper=new DatabaseHelper(this);
        showRecord();
    }

    private void showRecord() {
        Adapter adapter = new Adapter(MyMovies.this,databaseHelper.getAllData(Constants.M_TIME_STAMP+" DESC"));
        recyclerView.setAdapter(adapter);




    }
    @Override
    protected void onResume(){
        super.onResume();
        showRecord();
    }
}