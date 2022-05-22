package com.example.imdbwatchlist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.net.Uri;
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
    //Cast RV
    RecyclerView recycler_view_cast;
    CastRecyclerAdapter adapter;
    RequestManager manager;
    ProgressDialog dialog;
    Button add,cinemas,mvlist,sms;
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
        mvlist=findViewById(R.id.mvlist);
        sms=findViewById(R.id.sms);
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
                int status=DB.movieExists(TextView_IMDB_ID.getText().toString());

                if (status==1){
                    Toast.makeText(MovieDetails.this, "Movie Already Exists in your WatchList", Toast.LENGTH_SHORT).show();

                }else{
                    getData();
                }





            }
        });
        cinemas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(MovieDetails.this,MyCinemas.class));

            }

        });
        mvlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MovieDetails.this,MyMovies.class));
            }
        });
        sms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phoneNo = "+21628531776";//The phone number you want to text
                String sms= "Hello I would like to reserve a ticket for the following movie : "+TextView_movieName.getText().toString();//The message you want to text to the phone

                Intent smsIntent = new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", phoneNo, null));
                smsIntent.putExtra("sms_body",sms);
                startActivity(smsIntent);
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
        int status=DB.movieExists(TextView_IMDB_ID.getText().toString());
        if (status==1){
            add.setBackgroundColor(Color.GRAY);
            add.setTextColor(Color.BLACK);
            add.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
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