package com.techelevator.daos;

import com.techelevator.models.Movie;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcMovieDao implements MovieDao{

    private JdbcTemplate jdbcTemplate;

    public JdbcMovieDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Movie addNewMovie(Movie movie) {
        String sql = "INSERT INTO movie (the_one_movie_id, name, runtime_in_minutes, budget_in_millions) " +
                "VALUES (?,?,?,?) " +
                "RETURNING movie_id ";
        Integer id = jdbcTemplate.queryForObject(sql, Integer.class, movie.getTheOneMovieId(),movie.getName(),movie.getRuntimeInMinutes(),movie.getBudgetInMillions());
        return getMovieById(id);
    }

    @Override
    public List<Movie> getAllMovies() {
        List<Movie> movies = new ArrayList<>();
        String sql = "SELECT movie_id, the_one_movie_id, name, runtime_in_minutes, budget_in_millions " +
                "FROM movie ";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()){
            movies.add(mapRowToMovie(results));
        }
        return movies;
    }

    @Override
    public Movie getMovieById(int id) {
        Movie movie = null;
        String sql = "SELECT movie_id, the_one_movie_id, name, runtime_in_minutes, budget_in_millions " +
                "FROM movie " +
                "WHERE movie_id=? ";
        SqlRowSet results=jdbcTemplate.queryForRowSet(sql, id);
        if(results.next()){
            movie=mapRowToMovie(results);
        }
        return movie;
    }

    private Movie mapRowToMovie(SqlRowSet results){
        int movieId=results.getInt("movie_id");
        String theOneMovieId=results.getString("the_one_movie_id");
        String name=results.getString("name");
        int runtimeInMinutes=results.getInt("runtime_in_minutes");
        int budgetInMillions=results.getInt("budget_in_millions");
        return new Movie(movieId,theOneMovieId,name,runtimeInMinutes,budgetInMillions);
    }
}
