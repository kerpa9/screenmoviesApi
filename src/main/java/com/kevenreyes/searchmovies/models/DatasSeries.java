package com.kevenreyes.searchmovies.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatasSeries(
        @JsonAlias("Title") String title,
        @JsonAlias("totalSeasons") Integer totalSeasons,
        @JsonAlias("imdbRating") String evaluation,
        @JsonAlias("Poster") String poster,
        @JsonAlias("Genre") String genre,
        @JsonAlias("Actors") String actors,
        @JsonAlias("Plot") String synopsis

) {

}
