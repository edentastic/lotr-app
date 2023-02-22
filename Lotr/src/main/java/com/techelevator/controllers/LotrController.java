package com.techelevator.controllers;

import com.techelevator.daos.MovieDao;
import com.techelevator.models.Character;
import com.techelevator.models.Movie;
import com.techelevator.models.Quote;
import com.techelevator.services.LotrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class LotrController {

    @Autowired
    MovieDao movieDao;
    @Autowired
    LotrService service;

    @GetMapping("/movie")
    public List<Movie> getAllMoviesFromApi(){
        return service.loadAllMovies();
    }

    @GetMapping("/quote")
    public List<Quote> getAllQuotesFromApi(){
        return service.loadAllQuotes();
    }

    @GetMapping("/character")
    public List<Character> getAllCharactersFromApi(){
        return service.loadAllCharacters();
    }

    @GetMapping(path = "/saved/movie")
    public List<Movie> getAllMoviesFromDb(){
        return movieDao.getAllMovies();
    }

    @GetMapping(path = "/saved/movie/{id}")
    public Movie getMovieByIdFromDb(@PathVariable int id){
        return movieDao.getMovieById(id);
    }

    @PostMapping(path = "/saved/movie")
    public Movie addMovieToDb(Movie movie){
        return movieDao.addNewMovie(movie);
    }

}
