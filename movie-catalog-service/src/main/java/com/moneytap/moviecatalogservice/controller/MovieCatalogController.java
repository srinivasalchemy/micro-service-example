package com.moneytap.moviecatalogservice.controller;

import com.moneytap.moviecatalogservice.model.CatalogItem;
import com.moneytap.moviecatalogservice.model.Movie;
import com.moneytap.moviecatalogservice.model.Rating;
import com.moneytap.moviecatalogservice.model.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable String userId){
        List<CatalogItem> list = new ArrayList<>();

        String movieUrl= "http://movie-info-service/movies/";
        String ratingsUrl = "http://ratings-data-service/ratings/users/";

           UserRating userRating =restTemplate.getForObject(ratingsUrl+userId, UserRating.class);
        List<Rating> ratingList = userRating.getUserRating();

        return ratingList.stream().map(rating -> {
            Movie movie=restTemplate.getForObject(movieUrl+rating.getMovieId(), Movie.class);
           return new CatalogItem(movie.getName(),"Movie Description",rating.getRating());
        } ).collect(Collectors.toList());

    }

    @PostMapping("/movies/{movieId}")

    public void putMovie(@RequestBody Movie movie){
        String movieUrl= "http://movie-info-service/movies/";
        restTemplate.postForObject(movieUrl+movie.getMovieId(),movie,Movie.class);
    }



}
