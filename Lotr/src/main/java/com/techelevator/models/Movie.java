package com.techelevator.models;

public class Movie {
    private int movieId;
    private String theOneMovieId;
    private String name;
    private int runtimeInMinutes;
    private int budgetInMillions;

    public Movie() {
    }

    public Movie(int movieId, String theOneMovieId, String name, int runtimeInMinutes, int budgetInMillions) {
        this.movieId = movieId;
        this.theOneMovieId = theOneMovieId;
        this.name = name;
        this.runtimeInMinutes = runtimeInMinutes;
        this.budgetInMillions = budgetInMillions;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getTheOneMovieId() {
        return theOneMovieId;
    }

    public void setTheOneMovieId(String theOneMovieId) {
        this.theOneMovieId = theOneMovieId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRuntimeInMinutes() {
        return runtimeInMinutes;
    }

    public void setRuntimeInMinutes(int runtimeInMinutes) {
        this.runtimeInMinutes = runtimeInMinutes;
    }

    public int getBudgetInMillions() {
        return budgetInMillions;
    }

    public void setBudgetInMillions(int budgetInMillions) {
        this.budgetInMillions = budgetInMillions;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movieId=" + movieId +
                ", theOneMovieId='" + theOneMovieId + '\'' +
                ", name='" + name + '\'' +
                ", runtimeInMinutes=" + runtimeInMinutes +
                ", budgetInMillions=" + budgetInMillions +
                '}';
    }
}
