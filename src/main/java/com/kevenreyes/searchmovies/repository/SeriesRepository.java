package com.kevenreyes.searchmovies.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kevenreyes.searchmovies.models.Category;
import com.kevenreyes.searchmovies.models.Episodes;
import com.kevenreyes.searchmovies.models.Serie;

public interface SeriesRepository extends JpaRepository<Serie, Long> {

    // Find title contain serie
    Optional<Serie> findByTitleContainsIgnoreCase(String nameSeries);

    // Find evaluation contain serie
    List<Serie> findTop5ByOrderByEvaluationDesc();

    // Find genre serie
    List<Serie> findByGenre(Category category);

    // NATIVE QUERYS
    @Query("SELECT s FROM Serie s WHERE s.totalSeasons >= :totalSeasons AND s.evaluation >= :evaluation")
    List<Serie> seriesBySeasonsAndEvaluation(int totalSeasons, Double evaluation);

    @Query("SELECT e FROM Serie s JOIN s.episodes e WHERE e.title ILIKE %:nameEpisode%")
    List<Episodes> episodesName(String nameEpisode);

    @Query("SELECT e FROM Serie s JOIN s.episodes e WHERE s = :serie ORDER BY e.evaluation DESC LIMIT 5")
    List<Episodes> top5episodes(Serie serie);

    @Query("SELECT s FROM Serie s  JOIN s.episodes e  GROUP BY s  ORDER BY MAX(e.releaseSeason) DESC LIMIT 5")
    List<Serie> latestReleases();

}
