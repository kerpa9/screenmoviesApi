package com.kevenreyes.searchmovies.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public record DataEpisode(
    @JsonAlias("Title") String title,
    @JsonAlias("Episode")Integer numEpisode,
    @JsonAlias("imdbRating")String evaluation,
    @JsonAlias("Released")String dateReleased
){

}
