package com.example.imdbwatchlist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.imdbwatchlist.Adapters.CastRecyclerAdapter;
import com.example.imdbwatchlist.Listeners.OnDetailsApiLister;
import com.example.imdbwatchlist.models.DetailApiResponse;
import com.squareup.picasso.Picasso;

public class MovieDetails extends AppCompatActivity {
    TextView TextView_movieName,TextView_movieReleased,TextView_movieRuntime,TextView_movieRating,TextView_movieVotes,TextView_moviePlot,TextView_stars;
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

        TextView_stars=findViewById(R.id.TextView_stars);
        
        manager = new RequestManager(this);
        String movie_id=getIntent().getStringExtra("data");
        manager.searchMoviesDetails(listener,movie_id);
        dialog = new ProgressDialog(this);
        dialog.setTitle("Please Wait...");
        dialog.show();
    }
    private OnDetailsApiLister listener = new OnDetailsApiLister() {
        @Override
        public void onResponse(DetailApiResponse response) {
            dialog.dismiss();
            if (response.equals(null)){
                Toast.makeText(MovieDetails.this, "Error Grabbing Details", Toast.LENGTH_SHORT).show();
                return;
            }
            showResults(response);
            
        }

        @Override
        public void onError(String message) {
            dialog.dismiss();
            Toast.makeText(MovieDetails.this, "Error Grabbing Details", Toast.LENGTH_SHORT).show();

        }
    };

    private void showResults(DetailApiResponse response) {
        TextView_movieName.setText(response.getFullTitle());
        TextView_moviePlot.setText(response.getPlot());
        TextView_movieRating.setText(response.getImDbRating() + "⭐");
        TextView_movieReleased.setText("Released : "+ response.getReleaseDate());
        TextView_movieRuntime.setText(response.getRuntimeMins()+" Minutes");
        TextView_movieVotes.setText(response.getImDbRatingVotes()+ " Votes");
        System.out.println(response.getstars()+" Votes");
        TextView_stars.setText("Actors: "+response.getstars());
        try{
            Picasso.get().load(response.getImage()).into(ImageView_Poster2);
        }catch (Exception ex){
            ex.printStackTrace();
        }


    }
}