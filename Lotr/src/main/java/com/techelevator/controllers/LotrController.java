package com.techelevator.controllers;

import com.techelevator.daos.MovieDao;
import com.techelevator.models.Character;
import com.techelevator.models.Movie;
import com.techelevator.models.Quote;
import com.techelevator.services.LotrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @PostMapping(path = "/add-movie")
    @ResponseStatus(HttpStatus.CREATED)
    public Movie addMovieToDb(@RequestBody Movie movie){
        return movieDao.addNewMovie(movie);
    }

    @GetMapping("/quotesByMovie/{id}")
    public List<Quote> getAllQuotesByMovieIdFromApi(@PathVariable String id){
        return service.getAllQuotesByMovieId(id);
    }

}
