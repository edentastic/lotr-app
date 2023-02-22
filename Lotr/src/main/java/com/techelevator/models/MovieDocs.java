package com.techelevator.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MovieDocs {

    @JsonProperty("docs")
    private Movie[] movies;

    public Movie[] getMovies() {
        return movies;
    }

    public void setMovies(Movie[] movies) {
        this.movies = movies;
    }
}
