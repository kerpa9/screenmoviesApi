package com.kevenreyes.searchmovies.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kevenreyes.searchmovies.models.Serie;

public interface SeriesRepository extends JpaRepository<Serie, Long> {

    Optional<Serie> findByTitleContainsIgnoreCase(String nameSeries);

}
