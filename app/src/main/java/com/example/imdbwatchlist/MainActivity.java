package com.example.imdbwatchlist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.imdbwatchlist.Adapters.HomeRecyclerAdapter;
import com.example.imdbwatchlist.Listeners.OnMovieClickListener;
import com.example.imdbwatchlist.Listeners.OnSearchApiListener;
import com.example.imdbwatchlist.models.SearchApiResponse;

public class MainActivity extends AppCompatActivity implements OnMovieClickListener {
    SearchView search_view;
    RecyclerView recycler_view_home;
    HomeRecyclerAdapter adapter;
    RequestManager manager;
    ProgressDialog dialog;
    Button mymovies,mycinemas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        search_view=findViewById(R.id.search_view);
        recycler_view_home=findViewById(R.id.recycler_view_home);
        mymovies=findViewById(R.id.movz);
        mycinemas=findViewById(R.id.cinemaz);
        dialog=new ProgressDialog(this);

        manager=new RequestManager(this);
        mymovies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,MyMovies.class));
            }
        });
        mycinemas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,MyCinemas.class));
            }
        });
        search_view.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                dialog.setTitle("Searching...");
                dialog.show();

                manager.searchMovies(listener,query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
    }

    private final OnSearchApiListener listener = new OnSearchApiListener() {
        @Override
        public void onResponse(SearchApiResponse response) {
            dialog.dismiss();
            if (response==null){
                Toast.makeText(MainActivity.this,"No Data Found",Toast.LENGTH_SHORT).show();
                return;
            }
            showResult(response);
        }

        @Override
        public void onError(String message) {
            dialog.dismiss();
            Toast.makeText(MainActivity.this, "An Error Occured", Toast.LENGTH_SHORT).show();

        }
    };

    private void showResult(SearchApiResponse response) {

        recycler_view_home.setHasFixedSize(true);

        //Number of movies per line
        recycler_view_home.setLayoutManager(new GridLayoutManager(MainActivity.this, 3));

        adapter = new HomeRecyclerAdapter(this,response.getResults(), this);
        recycler_view_home.setAdapter(adapter);


    }

    @Override
    public void onMovieClicked(String id) {
        //Toast.makeText(MainActivity.this,id,Toast.LENGTH_SHORT).show();
        startActivity(new Intent(MainActivity.this,MovieDetails.class).putExtra("data",id));

    }
}