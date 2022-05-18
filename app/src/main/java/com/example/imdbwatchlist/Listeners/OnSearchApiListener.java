package com.example.imdbwatchlist.Listeners;

import com.example.imdbwatchlist.models.SearchApiResponse;

public interface OnSearchApiListener {
    void onResponse(SearchApiResponse response);
    void onError(String message);
}
