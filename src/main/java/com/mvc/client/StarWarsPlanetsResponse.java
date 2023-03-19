package com.mvc.client;

import java.util.List;

public class StarWarsPlanetsResponse {
    private int count;
    private String next;
    private List<StarWarsPlanetResponse> results;

    public StarWarsPlanetsResponse() {
    }

    public int getCount() {
        return count;
    }

    public String getNext() {
        return next;
    }

    public List<StarWarsPlanetResponse> getResults() {
        return results;
    }
}
