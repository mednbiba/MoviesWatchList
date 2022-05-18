package com.example.imdbwatchlist.Listeners;

import com.example.imdbwatchlist.models.DetailApiResponse;

public interface OnDetailsApiLister {

    void onResponse(DetailApiResponse response);
    void onError(String message);
}
