package com.kevenreyes.searchmovies.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kevenreyes.searchmovies.dto.EpisodesDTO;
import com.kevenreyes.searchmovies.dto.SerieDTO;
import com.kevenreyes.searchmovies.services.SerieServices;

@RestController
@RequestMapping("/api/v1/series")
public class SerieController {

    @Autowired
    SerieServices services;

    @GetMapping
    public List<SerieDTO> allSeries() {

        return services.allSeries();
    }

    @GetMapping("/top5")
    public List<SerieDTO> topFiveSeries() {
        return services.topFive();
    }

    @GetMapping("/releases")
    public List<SerieDTO> latestReleases() {
        return services.obtainLatestReleases();
    }

    @GetMapping("/{id}")
    public SerieDTO obtainById(@PathVariable Long id){
        return services.obtainById(id);

    }

    @GetMapping("/{id}/seasons/all")
    public List<EpisodesDTO> obtainAllSeasons(@PathVariable Long id){

        return services.obtainAllDatas(id);
        
    }

    @GetMapping("/{id}/seasons/{numSeason}")
    public List<EpisodesDTO> obtainSeasonByNum(@PathVariable Long id, @PathVariable Long numSeason){

        return services.obtainSeasonByNum(id, numSeason);

    }

    @GetMapping("/category/{nameGenre}")
    public List<SerieDTO> obtainSeriesByCategory(@PathVariable String nameGenre){
        return services.obtainSeriesByCategory(nameGenre);
    }

}
