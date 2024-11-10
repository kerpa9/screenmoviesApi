package com.kevenreyes.searchmovies.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kevenreyes.searchmovies.models.Serie;

public interface SeriesRepository extends JpaRepository<Serie, Long> {
    
    

}
