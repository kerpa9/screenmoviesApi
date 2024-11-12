package com.kevenreyes.searchmovies.dto;

import com.kevenreyes.searchmovies.models.Category;

public record SerieDTO(

        String title,
        Integer totalSeasons,
        Double evaluation,
        String poster,
        Category genre,
        String actors,
        String synopsis) {

}
