package com.example.imdbwatchlist.models;

import java.util.List;

public class SearchApiResponse {
    public List<SearchArrayObject> getResults() {
        return results;
    }

    public void setResults(List<SearchArrayObject> results) {
        this.results = results;
    }

    List<SearchArrayObject> results =null;
}
