package com.moneytap.movieinfoservice.controller;


import com.moneytap.movieinfoservice.model.Movie;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/movies")
public class MovieInfoController {
    private static HashMap<String,Movie> movieNames;
    static {
        movieNames = new HashMap<>();
        movieNames.put("M15001",new Movie("M15001","Harry Potter"));
        movieNames.put("M15002",new Movie("M15002","Lord of the Rings"));
        movieNames.put("M15003",new Movie("M15003","Sholay"));
        movieNames.put("M16002",new Movie("M16002","Fast and Furious"));
        movieNames.put("M16005",new Movie("M16005","House Full"));
    }



    @GetMapping("/{movieId}")
    public Movie getMovieInfo(@PathVariable  String movieId) {
         return movieNames.get(movieId);
    }

    @PostMapping("/{movieId}")
    public void addMovie(@RequestBody Movie movie){
        System.out.println(movie);
        System.out.println("Added to the movie list");
        movieNames.put(movie.getMovieId(),movie);
    }

}

