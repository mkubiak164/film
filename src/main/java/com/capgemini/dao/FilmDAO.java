package com.capgemini.dao;

import com.capgemini.domain.ActorEntity;
import com.capgemini.domain.FilmEntity;
import com.capgemini.types.FilmSearchCriteria;

import java.time.LocalDate;
import java.util.List;

public interface FilmDAO extends Dao<FilmEntity, Integer> {

    public List<FilmEntity> findFilmBy(FilmSearchCriteria filmSearchCriteria);

    public Double calculateWeekFilmAverage();

    public Double calculateTotalFilmAverage();

    public Double calculateMostExpensiveTotalProfit(Integer howManyFilms);

    public Double calculateBudget(LocalDate dateFrom, LocalDate dateTo);

    public List<ActorEntity> findNotPlayingActors(LocalDate dateFrom, LocalDate dateTo);

    public List<FilmEntity> findLongestFilmInStudioInTime(String studioName, LocalDate dateFrom, LocalDate dateTO);

    public void countStudioFilmsInYear(LocalDate year);
}
