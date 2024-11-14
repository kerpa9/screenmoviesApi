package com.kevenreyes.searchmovies.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kevenreyes.searchmovies.dto.SerieDTO;
import com.kevenreyes.searchmovies.models.Serie;
import com.kevenreyes.searchmovies.repository.SeriesRepository;

@Service
public class SerieServices {

    @Autowired
    private SeriesRepository repository;

    public List<SerieDTO> allSeries() {

        return repository.findAll().stream().map(s -> new SerieDTO(s.getTitle(), s.getTotalSeasons(), s.getevaluation(),
                s.getPoster(), s.getGenre(), s.getActors(), s.getSynopsis())).collect(Collectors.toList());
    }

    public List<SerieDTO> topFive() {
        return dataConverter(repository.findTop5ByOrderByEvaluationDesc());
    }

    public List<SerieDTO> obtainLatestReleases() {
        return dataConverter(repository.latestReleases());
    }

    public SerieDTO obtainById(Long id) {
        Optional<Serie> serie = repository.findById(id);

        if (serie.isPresent()) {
            Serie s = serie.get();
            return new SerieDTO(s.getTitle(), s.getTotalSeasons(), s.getevaluation(), s.getPoster(), s.getGenre(),
                    s.getActors(), s.getSynopsis());

        }
        return null;
    }

    public List<SerieDTO> dataConverter(List<Serie> serie) {
        return serie.stream().map(s -> new SerieDTO(s.getTitle(), s.getTotalSeasons(), s.getevaluation(),
                s.getPoster(), s.getGenre(), s.getActors(), s.getSynopsis())).collect(Collectors.toList());
    }

}
