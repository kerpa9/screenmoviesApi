package com.kevenreyes.searchmovies.models;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "episodes")
public class Episodes {

    //PK primary key

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long Id;
    //

    private Integer season;
    private String title;
    private Integer numEpisodes;
    private Double evaluation;
    private LocalDate releaseSeason;

    @ManyToOne
    private Serie serie;

    public Episodes(){ }

    public Episodes(Integer number, DataEpisode d) {
        this.season = season;
        this.title = d.title();
        this.numEpisodes = d.numEpisode();

        try {

            this.evaluation = Double.valueOf(d.evaluation());

        } catch (NumberFormatException e) {
            this.evaluation = 0.0;
        }
        try {

            this.releaseSeason = LocalDate.parse(d.dateReleased());
        } catch (DateTimeParseException e) {
            this.releaseSeason = null;

        }
    }

    public Serie getSerie() {
        return serie;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
    }

    public Integer getSeason() {
        return season;
    }

    public void setSeason(Integer season) {
        this.season = season;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getNumEpisodes() {
        return numEpisodes;
    }

    public void setNumEpisodes(Integer numEpisodes) {
        this.numEpisodes = numEpisodes;
    }

    public Double getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(Double evaluation) {
        this.evaluation = evaluation;
    }

    public LocalDate getReleaseSeason() {
        return releaseSeason;
    }

    public void setReleaseSeason(LocalDate releaseSeason) {
        this.releaseSeason = releaseSeason;
    }

    @Override
    public String toString() {
        return "Season= " + season +
                ", Title= " + title + '\'' +
                ", numEpisodes= " + numEpisodes +
                ", Evaluation= " + evaluation +
                ", Release Date" + releaseSeason;
    }

}
