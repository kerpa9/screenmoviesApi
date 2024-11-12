package com.kevenreyes.searchmovies.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kevenreyes.searchmovies.dto.SerieDTO;
import com.kevenreyes.searchmovies.repository.SeriesRepository;

@RestController
public class SerieController {

    @Autowired
    private SeriesRepository repository;

    @GetMapping("/series")
    public List<SerieDTO> allSeries() {

        return repository.findAll().stream().map(s -> new SerieDTO(s.getTitle(), s.getTotalSeasons(), s.getevaluation(),
                s.getPoster(), s.getGenre(), s.getActors(), s.getSynopsis())).collect(Collectors.toList());
    }

}
