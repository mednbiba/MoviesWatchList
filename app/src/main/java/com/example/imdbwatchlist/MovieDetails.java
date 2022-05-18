package com.example.imdbwatchlist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MovieDetails extends AppCompatActivity {
    TextView TextView_movieName,TextView_movieReleased,TextView_movieRuntime,TextView_movieRating,TextView_movieVotes,TextView_moviePlot;
    ImageView ImageView_Poster2;
    RecyclerView recycler_view_cast;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);
        TextView_movieName=findViewById(R.id.TextView_movieName);
        TextView_movieReleased=findViewById(R.id.TextView_movieReleased);
        TextView_movieRuntime=findViewById(R.id.TextView_movieRuntime);
        TextView_movieRating=findViewById(R.id.TextView_movieRating);
        TextView_movieVotes=findViewById(R.id.TextView_movieVotes);
        TextView_moviePlot=findViewById(R.id.TextView_moviePlot);
        ImageView_Poster2=findViewById(R.id.ImageView_Poster2);
        recycler_view_cast=findViewById(R.id.recycler_view_cast);
    }
}