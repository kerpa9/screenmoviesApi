package com.kevenreyes.searchmovies.models;

public class Serie {
    private String title;
    private Integer totalSeasons;
    private String imdbRating;
    private String poster;
    private String genre;
    private String actors;
    private String synopsis;

    public Serie(DatasSeries datasSeries) {
        this.title = datasSeries.title();
        this.totalSeasons = datasSeries.totalSeasons();
        this.imdbRating = datasSeries.imdbRating();
        this.poster = datasSeries.poster();
        this.genre = datasSeries.genre();
        this.actors = datasSeries.actors();
        this.synopsis = datasSeries.synopsis();
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

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
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
                ", Evaluation= " + imdbRating +
                ", Synopsis= " + synopsis;
    }

}
