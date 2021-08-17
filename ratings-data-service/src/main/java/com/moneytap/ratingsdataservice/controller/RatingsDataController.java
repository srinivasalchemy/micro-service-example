package com.moneytap.ratingsdataservice.controller;

import com.moneytap.ratingsdataservice.model.Rating;
import com.moneytap.ratingsdataservice.model.UserRating;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingsDataController {

    @RequestMapping("/{movieId}")
    public Rating getMovieRating(@PathVariable String movieId){
        return new Rating(movieId,4);
    }

    @RequestMapping("/users/{userId}")
    public UserRating getUserRating(@PathVariable String userId){
        UserRating userRating = new UserRating();
        if(userId.equals("1001")) {
            userRating.setUserRating(Arrays.asList(
                    new Rating("M15001", 4),
                    new Rating("M15002", 3),
                    new Rating("M15003", 5)
            ));
        }
        if(userId.equals("1002")) {
            userRating.setUserRating(Arrays.asList(
                    new Rating("M16002", 4),
                    new Rating("M16005", 4),
                    new Rating("M15003", 5)
            ));
        }
        return userRating;
    }


}
