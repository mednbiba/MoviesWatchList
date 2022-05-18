package com.example.imdbwatchlist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.imdbwatchlist.Adapters.CastRecyclerAdapter;
import com.example.imdbwatchlist.Listeners.OnDetailsApiLister;
import com.example.imdbwatchlist.models.DetailApiResponse;

public class MovieDetails extends AppCompatActivity {
    TextView TextView_movieName,TextView_movieReleased,TextView_movieRuntime,TextView_movieRating,TextView_movieVotes,TextView_moviePlot;
    ImageView ImageView_Poster2;
    RecyclerView recycler_view_cast;
    CastRecyclerAdapter adapter;
    RequestManager manager;
    ProgressDialog dialog;


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
        
        manager = new RequestManager(this);
        String movie_id=getIntent().getStringExtra("data");
        manager.searchMoviesDetails(listener,movie_id);
    }
    private OnDetailsApiLister listener = new OnDetailsApiLister() {
        @Override
        public void onResponse(DetailApiResponse response) {
            if (response.equals(null)){
                Toast.makeText(MovieDetails.this, "Error Grabbing Details", Toast.LENGTH_SHORT).show();
                return;
            }
            showResults(response);
            
        }

        @Override
        public void onError(String message) {
            Toast.makeText(MovieDetails.this, "Error Grabbing Details", Toast.LENGTH_SHORT).show();

        }
    };

    private void showResults(DetailApiResponse response) {
    }
}