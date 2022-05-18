package com.example.imdbwatchlist;

import android.content.Context;
import android.widget.Toast;

import com.example.imdbwatchlist.Listeners.OnDetailsApiLister;
import com.example.imdbwatchlist.Listeners.OnSearchApiListener;
import com.example.imdbwatchlist.models.DetailApiResponse;
import com.example.imdbwatchlist.models.SearchApiResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

public class RequestManager {
    Context context;
    Retrofit retrofit=new Retrofit
            .Builder()
            .baseUrl("https://imdb-api.com/en/API/")
            .addConverterFactory(GsonConverterFactory.create()).build();

    public RequestManager(Context context){
        this.context=context;
    }

    public void searchMovies(OnSearchApiListener listener,String movie_name){
        getMovies getMovies = retrofit.create(RequestManager.getMovies.class);
        Call<SearchApiResponse> call = getMovies.callMovies(movie_name);
        call.enqueue(new Callback<SearchApiResponse>() {
            @Override
            public void onResponse(Call<SearchApiResponse> call, Response<SearchApiResponse> response) {
                if (!response.isSuccessful()){
                    Toast.makeText(context, "Couldn't Grab Movies", Toast.LENGTH_SHORT).show();
                    return;
                }
                listener.onResponse(response.body());

            }

            @Override
            public void onFailure(Call<SearchApiResponse> call, Throwable t) {
                listener.onError(t.getMessage());

            }
        });
    }

    public void searchMoviesDetails(OnDetailsApiLister listener, String movie_id){
        getMoviesDetails getMoviesDetails = retrofit.create(RequestManager.getMoviesDetails.class);
        Call<DetailApiResponse> call = getMoviesDetails.callMovieDetails(movie_id);
        call.enqueue(new Callback<DetailApiResponse>() {
            @Override
            public void onResponse(Call<DetailApiResponse> call, Response<DetailApiResponse> response) {
                if (!response.isSuccessful()){
                    Toast.makeText(context, "Couldn't Grab Details", Toast.LENGTH_SHORT).show();
                    return;
                }
                listener.onResponse(response.body());

            }

            @Override
            public void onFailure(Call<DetailApiResponse> call, Throwable t) {
                listener.onError(t.getMessage());

            }
        });
    }
    public interface getMovies {
        @Headers({
                "Accept: application/json"
        })
        @GET("SearchMovie/k_bos5za9b/{movie_name}")
        Call<SearchApiResponse> callMovies(
                @Path("movie_name") String movie_name
        );

    }

    public interface getMoviesDetails {
        @Headers({
                "Accept: application/json"
        })
        @GET("Title/k_bos5za9b/{movie_id}")
        Call<DetailApiResponse> callMovieDetails(
                @Path("movie_id") String movie_id
        );

    }
}
