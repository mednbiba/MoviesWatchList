package com.example.imdbwatchlist;

import android.content.Context;
import android.widget.Toast;

import com.example.imdbwatchlist.Listeners.OnSearchApiListener;
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
            .baseUrl("https://imdb-api.com/en/API/SearchMovie/k_bos5za9b/")
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
    public interface getMovies {
        @Headers({
                "Accept: application/json"
        })
        @GET("{movie_name}")
        Call<SearchApiResponse> callMovies(
                @Path("movie_name") String movie_name
        );

    }
}
