package com.kevenreyes.searchmovies.models;

import java.util.List;
import java.util.OptionalDouble;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "series")
public class Serie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(unique = true)
    private String title;
    private Integer totalSeasons;
    private Double evaluation;
    private String poster;

    @Enumerated(EnumType.STRING)
    private Category genre;
    private String actors;
    private String synopsis;

    @OneToMany(mappedBy = "serie", cascade = CascadeType.ALL, fetch=FetchType.EAGER)
    private List<Episodes> episodes;

    public Serie() {
    }

    public Serie(DatasSeries datasSeries) {
        this.title = datasSeries.title();
        this.totalSeasons = datasSeries.totalSeasons();
        this.evaluation = OptionalDouble.of(Double.valueOf(datasSeries.evaluation())).orElse(0);
        this.poster = datasSeries.poster();
        this.genre = Category.fromString(datasSeries.genre().split(",")[0].trim());
        this.actors = datasSeries.actors();
        this.synopsis = datasSeries.synopsis();
    }

    public List<Episodes> getepisodes() {
        return episodes;
    }

    public void setepisodes(List<Episodes> episodes) {
        episodes.forEach(e -> e.setSerie(this));
        this.episodes = episodes;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Category getGenre() {
        return genre;
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

    public Double getevaluation() {
        return evaluation;
    }

    public void setevaluation(Double evaluation) {
        this.evaluation = evaluation;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

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
                ", Evaluation= " + evaluation +
                ", Poster= " + poster +
                ", Actors= " + actors +
                ", Episodes= " + episodes +
                ", Synopsis= " + synopsis;
    }

}
