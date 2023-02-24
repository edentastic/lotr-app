package com.techelevator.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.techelevator.models.*;
import com.techelevator.models.Character;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class LotrService {

    @Value("${LOTR_API}")
    private String LOTR_API;
    @Value("${KEY}")
    private String KEY;

    RestTemplate restTemplate = new RestTemplate();


    public List<Movie> getAllMovies(){
//        create object to hold all the movies
        List<Movie> movies = new ArrayList<>();

//        create header to hold the bearer token
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(KEY);

        HttpEntity<Void> entity = new HttpEntity<>(headers); //wraps header into an entity to pass in get request

        ObjectMapper mapper = new ObjectMapper();//is for walking through the JSON
        JsonNode jsonNode; //for walking through the nodes

//        sends the request (address, request type, our bundled entity, and the return type
        ResponseEntity<String> responseEntity =
                restTemplate.exchange(LOTR_API + "/movie", HttpMethod.GET, entity, String.class);

        try{
            jsonNode = mapper.readTree(responseEntity.getBody());
            JsonNode docs = jsonNode.path("docs");
            for(int i=0; i<docs.size();i++){
                String movieId = docs.path(i).path("_id").asText();
                String name = docs.path(i).path("name").asText();
                int runtime = docs.path(i).path("runtimeInMinutes").asInt();
                int budget = docs.path(i).path("budgetInMillions").asInt();
                movies.add(new Movie(0, movieId,name, runtime,budget));
            }

        } catch(JsonProcessingException e){
            e.printStackTrace();
        }
        return movies;
    }

    public List<Movie> loadAllMovies(){
        ResponseEntity<MovieDocs> responseEntity =
                restTemplate.exchange(LOTR_API + "/movie", HttpMethod.GET, makeEntity(), MovieDocs.class);
        MovieDocs movieDocs = responseEntity.getBody();
        Movie[] movies = movieDocs.getMovies();

        return Arrays.asList(movies);
    }

    public List<Character> loadAllCharacters(){
        ResponseEntity<CharacterDocs> responseEntity =
                restTemplate.exchange(LOTR_API+"/character", HttpMethod.GET, makeEntity(), CharacterDocs.class);
        CharacterDocs characterDocs =responseEntity.getBody();
        Character[] characters = characterDocs.getCharacters();

        return Arrays.asList(characters);
    }
    public List<Quote> loadAllQuotes(){
        ResponseEntity<QuoteDocs> responseEntity =
                restTemplate.exchange(LOTR_API+"/quote", HttpMethod.GET, makeEntity(), QuoteDocs.class);
        QuoteDocs quoteDocs = responseEntity.getBody();
        Quote[] quotes = quoteDocs.getQuotes();

        return Arrays.asList(quotes);
    }

    public List<Quote> getAllQuotesByMovieId(String id){
        ResponseEntity<QuoteDocs> responseEntity =
                restTemplate.exchange(LOTR_API+"/movie/"+ id + "/quote", HttpMethod.GET, makeEntity(), QuoteDocs.class);
        QuoteDocs quoteDocs = responseEntity.getBody();
        Quote[] quotes = quoteDocs.getQuotes();

        return Arrays.asList(quotes);
    }

    private HttpEntity<Void> makeEntity(){
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(KEY);

        HttpEntity<Void> entity = new HttpEntity<>(headers); //wraps header into an entity to pass in get request
        return entity;
    }

}
