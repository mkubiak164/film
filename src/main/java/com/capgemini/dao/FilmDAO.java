package com.capgemini.dao;

import com.capgemini.domain.FilmEntity;
import com.capgemini.types.FilmSearchCriteria;

import java.util.List;

public interface FilmDAO extends Dao<FilmEntity, Integer> {

    public List<FilmEntity> findFilmBy(FilmSearchCriteria filmSearchCriteria);

    public Double calculateWeekFilmAverage();

    public Double calculateTotalFilmAverage();

    public Double calculateMostExpensiveTotalProfit(Integer howManyFilms);
}
