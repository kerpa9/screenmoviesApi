package com.kevenreyes.searchmovies.principal;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.kevenreyes.searchmovies.models.Category;
import com.kevenreyes.searchmovies.models.DataSeasons;
import com.kevenreyes.searchmovies.models.DatasSeries;
import com.kevenreyes.searchmovies.models.Episodes;
import com.kevenreyes.searchmovies.models.Serie;
import com.kevenreyes.searchmovies.repository.SeriesRepository;
import com.kevenreyes.searchmovies.services.ConsultApi;
import com.kevenreyes.searchmovies.services.ConverterData;

public class PrincipalApp {

    private Scanner write = new Scanner(System.in);
    private ConsultApi consultApi = new ConsultApi();
    private final String URL_BASE = "https://www.omdbapi.com/?t=";
    private final String API_KEY = "&apikey=e4009d7f";

    private ConverterData converterData = new ConverterData();
    // private List<DatasSeries> datasSeries = new ArrayList<>();
    private SeriesRepository repository;
    private List<Serie> series;

    public PrincipalApp(SeriesRepository repository) {
        this.repository = repository;
    }

    public void showMenu() {
        var option = -1;

        while (option != 0) {

            var menu = """
                    1 - Search series
                    2 - Search episodes
                    3 - Saw series finded
                    4 - Find series by title
                    5 - Top five favorite series
                    6 - Find series by category

                    0 - Close App

                    """;
            System.out.println(menu);
            option = write.nextInt();
            write.nextLine();

            switch (option) {
                case 1:
                    // System.out.println("Write name this series to find");
                    searchSeriesWeb();
                    break;
                case 2:
                    // System.out.println("Write name this episode to find");

                    searchEpisodeToSerie();
                    break;
                case 3:
                    // System.out.println("Write name this episode to find");
                    viewSeriesFound();
                    break;
                case 4:
                    // System.out.println("Write name this episode to find");
                    findSeriesByTitle();
                    break;

                case 5:
                    // System.out.println("Write name this episode to find");
                    findTopFiveSeries();
                    break;

                case 6:
                    // System.out.println("Write name this episode to find");
                    findSeriesByCategory();
                    break;

                case 0:
                    System.out.println("Close this app, Thanks");

                    break;
                default:
                    System.out.println("Option not found");
            }

        }

    }

    private DatasSeries getDataSerie() {
        System.out.println("Write name this series");
        var nameSerie = write.nextLine();
        var url = URL_BASE + nameSerie.replace(" ", "+") + API_KEY;
        var json = consultApi.dataObtain(url);
        System.out.println(json);

        DatasSeries data = converterData.obtainData(json, DatasSeries.class);

        return data;
    }

    private void searchEpisodeToSerie() {
        viewSeriesFound();
        System.out.println("------------Write name espisodes view series---------");
        var nameSerie = write.nextLine();

        Optional<Serie> serie = series.stream()
                .filter(s -> s.getTitle().toLowerCase().contains(nameSerie.toLowerCase())).findFirst();

        if (serie.isPresent()) {

            var serieFound = serie.get();
            List<DataSeasons> seasons = new ArrayList<>();

            for (int i = 1; i <= serieFound.getTotalSeasons(); i++) {
                var url = URL_BASE + serieFound.getTitle().replace(" ", "+") + "&season=" + i + API_KEY;
                var json = consultApi.dataObtain(url);
                DataSeasons dataSeasons = converterData.obtainData(json, DataSeasons.class);

                seasons.add(dataSeasons);
            }

            seasons.forEach(System.out::println);

            List<Episodes> episodes = seasons.stream()
                    .flatMap(d -> d.episodes().stream().map(e -> new Episodes(d.number(), e)))
                    .collect(Collectors.toList());

            serieFound.setepisodes(episodes);
            repository.save(serieFound);

            // System.out.println(seasons);

        } else {
            System.out.println("----------Paila-------");
        }

    }

    private void searchSeriesWeb() {
        DatasSeries datas = getDataSerie();
        // datasSeries.add(datas);
        Serie serie = new Serie(datas);
        repository.save(serie);
        System.out.println(datas);

    }

    private void viewSeriesFound() {
        series = repository.findAll();

        series.stream().sorted(Comparator.comparing(Serie::getGenre)).forEach(System.out::println);
    }

    private void findSeriesByTitle() {
        System.out.println("Write name series");
        var nameSeries = write.nextLine();

        Optional<Serie> foundSerie = repository.findByTitleContainsIgnoreCase(nameSeries);

        if (foundSerie.isPresent()) {
            System.out.println("Serie founded: " + foundSerie.get());
        } else {
            System.out.println("Serie not founded");
        }
    }

    private void findTopFiveSeries() {

        List<Serie> topSeries = repository.findTop5ByOrderByEvaluationDesc();
        topSeries.forEach(s -> System.out.println(" Serie: " + s.getTitle() + " Evaluation: " + s.getevaluation()));
    }

    private void findSeriesByCategory() {

        System.out.println("Write find genre/category serie");
        var categorySerie = write.nextLine();

        var category = Category.fromString(categorySerie);

        List<Serie> seriesByCategory = repository.findByGenre(category);

        System.out.println(" Category series: " + categorySerie);

        seriesByCategory.forEach(System.out::println);

    }
}
