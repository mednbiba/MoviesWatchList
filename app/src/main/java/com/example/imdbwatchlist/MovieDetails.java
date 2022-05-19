package com.example.imdbwatchlist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.imdbwatchlist.Adapters.CastRecyclerAdapter;
import com.example.imdbwatchlist.Listeners.OnDetailsApiLister;
import com.example.imdbwatchlist.models.DetailApiResponse;
import com.squareup.picasso.Picasso;

public class MovieDetails extends AppCompatActivity {
    TextView TextView_movieName,TextView_movieReleased,TextView_movieRuntime,TextView_movieRating,TextView_movieVotes,TextView_moviePlot,TextView_stars,TextView_IMDB_ID;
    ImageView ImageView_Poster2;
    RecyclerView recycler_view_cast;
    CastRecyclerAdapter adapter;
    RequestManager manager;
    ProgressDialog dialog;
    Button add,cinemas;
    protected DatabaseHelper DB;
    String Image_uri;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);
        //XML Items
        TextView_movieName=findViewById(R.id.TextView_movieName);
        TextView_movieReleased=findViewById(R.id.TextView_movieReleased);
        TextView_movieRuntime=findViewById(R.id.TextView_movieRuntime);
        TextView_movieRating=findViewById(R.id.TextView_movieRating);
        TextView_movieVotes=findViewById(R.id.TextView_movieVotes);
        TextView_moviePlot=findViewById(R.id.TextView_moviePlot);
        ImageView_Poster2=findViewById(R.id.ImageView_Poster2);
        TextView_IMDB_ID=findViewById(R.id.TextView_IMDB_ID);
        TextView_stars=findViewById(R.id.TextView_stars);
        add = findViewById(R.id.addmovie);
        cinemas=findViewById(R.id.cinemas);
        //API MANAGER
        manager = new RequestManager(this);
        //GRAB MOVIE ID FROM EXTRA
        String movie_id=getIntent().getStringExtra("data");
        manager.searchMoviesDetails(listener,movie_id);
        dialog = new ProgressDialog(this);
        dialog.setTitle("Please Wait...");
        dialog.show();
        DB=new DatabaseHelper(this);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                getData();



            }
        });
        cinemas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(MovieDetails.this,MyCinemas.class));

            }
        });
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


        }
    };

    private void showResults(DetailApiResponse response) {
        TextView_movieName.setText(response.getFullTitle());
        TextView_moviePlot.setText(
                "Plot : "+
                response.getPlot() +" " +
                "\n ----------------------" +
                "\nAwards : "+response.getAwards()
                                    );
        TextView_movieRating.setText(response.getImDbRating() + "/10 ⭐");
        TextView_movieReleased.setText("Released : "+ response.getReleaseDate());
        TextView_movieRuntime.setText(response.getRuntimeMins()+" Minutes");
        TextView_movieVotes.setText(response.getImDbRatingVotes()+ " Votes");
        System.out.println(response.getstars()+" Votes");
        TextView_stars.setText("Actors: "+response.getstars());
        TextView_IMDB_ID.setText(response.getId());
        TextView_IMDB_ID.setVisibility(View.GONE);
        try{

            Picasso.get().load(response.getImage()).into(ImageView_Poster2);
            Image_uri=response.getImage();
        }catch (Exception ex){
            ex.printStackTrace();
        }


    }
    private void getData(){
        String title=""+TextView_movieName.getText().toString().trim();
        String score=""+TextView_movieRating.getText().toString().trim();
        String imdb_id=""+TextView_IMDB_ID.getText().toString().trim();
        String timestamp=""+System.currentTimeMillis();
        long id = DB.insertInfo(""+title,""+score,""+timestamp,""+imdb_id,""+Image_uri);



       //Toast.makeText(this, imdb_id+":"+title+" Added", Toast.LENGTH_SHORT).show();
       startActivity(new Intent(MovieDetails.this,MyMovies.class));

    }
}