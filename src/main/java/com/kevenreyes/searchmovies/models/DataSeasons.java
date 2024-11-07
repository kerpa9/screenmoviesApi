package com.kevenreyes.searchmovies.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DataSeasons(
        @JsonAlias("Season") Integer number,
        @JsonAlias("Episodes") List<DataEpisode> episodes) {

}
