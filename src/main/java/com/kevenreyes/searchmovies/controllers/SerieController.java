package com.kevenreyes.searchmovies.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kevenreyes.searchmovies.dto.SerieDTO;
import com.kevenreyes.searchmovies.services.SerieServices;

@RestController
public class SerieController {

    @Autowired
    SerieServices services;

    @GetMapping("/api/v1/series")
    public List<SerieDTO> allSeries() {

        return services.allSeries();
    }

    @GetMapping("/api/v1/series/top5")
    public List<SerieDTO> topFiveSeries(){
        return services.topFive();
    }
}
