package com.techelevator.daos;

import com.techelevator.models.Movie;

import java.util.List;

public interface MovieDao {
//    CRUD
//    Create
    Movie addNewMovie(Movie movie);
//    Read
    List<Movie> getAllMovies();
    Movie getMovieById(int id);


}
