package com.kevenreyes.searchmovies.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "series")
public class Serie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(unique = true)
    private String title;
    private Integer totalSeasons;
    private String imdbRating;
    private String poster;

    @Enumerated(EnumType.STRING)
    private Category genre;
    private String actors;
    private String synopsis;

    @Transient
    private List<Episodes> episodeses;

    public Serie(DatasSeries datasSeries) {
        this.title = datasSeries.title();
        this.totalSeasons = datasSeries.totalSeasons();
        this.imdbRating = datasSeries.imdbRating();
        this.poster = datasSeries.poster();
        // this.genre = datasSeries.genre();
        this.actors = datasSeries.actors();
        this.synopsis = datasSeries.synopsis();
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public void setGenre(Category genre) {
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getTotalSeasons() {
        return totalSeasons;
    }

    public void setTotalSeasons(Integer totalSeasons) {
        this.totalSeasons = totalSeasons;
    }

    public String getImdbRating() {
        return imdbRating;
    }

    public void setImdbRating(String imdbRating) {
        this.imdbRating = imdbRating;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public Category getGenre() {
        return genre;
    }

    // public void setGenre(String genre) {
    // this.genre = genre;
    // }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    @Override
    public String toString() {

        return "Genre= " + genre +
                ", Title= " + title + '\'' +
                ", numEpisodes= " + totalSeasons +
                ", Evaluation= " + imdbRating +
                ", Synopsis= " + synopsis;
    }

}
