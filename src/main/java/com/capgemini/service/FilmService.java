package com.capgemini.service;

import com.capgemini.domain.ActorEntity;
import com.capgemini.domain.FilmEntity;
import com.capgemini.types.FilmSearchCriteria;
import com.capgemini.types.FilmTO;

import java.time.LocalDate;
import java.util.List;

public interface FilmService {

    FilmTO addFilm(FilmTO actor);

    FilmTO showFilm(Integer id);

    FilmTO editFilm(FilmTO actor);

    void removeFilm(Integer id);

    List<FilmTO> findAllFilms();

    public List<FilmEntity> findFilmBy(FilmSearchCriteria filmSearchCriteria);

    public Double calculateWeekFilmAverage();

    public Double calculateTotalFilmAverage();

    public Double calculateMostExpensiveTotalProfit(Integer howManyFilms);

    public Double calculateBudget(LocalDate dateFrom, LocalDate dateTo);

    public List<ActorEntity> findNotPlayingActors(LocalDate dateFrom, LocalDate dateTo);

    public List<FilmEntity> findLongestFilmInStudioInTime(String studioName, LocalDate dateFrom, LocalDate dateTO);

    public void countStudioFilmsInYear(LocalDate year);

}
