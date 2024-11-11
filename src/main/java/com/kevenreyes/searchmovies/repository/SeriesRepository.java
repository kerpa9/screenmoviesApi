package com.kevenreyes.searchmovies.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kevenreyes.searchmovies.models.Category;
import com.kevenreyes.searchmovies.models.Serie;

public interface SeriesRepository extends JpaRepository<Serie, Long> {

    // Find title contain serie
    Optional<Serie> findByTitleContainsIgnoreCase(String nameSeries);

    // Find evaluation contain serie
    List<Serie> findTop5ByOrderByEvaluationDesc();

    List<Serie> findByGenre(Category category);

}
