package com.capgemini.service.impl;

import com.capgemini.dao.FilmDAO;
import com.capgemini.dao.impl.FilmDAOImpl;
import com.capgemini.domain.ActorEntity;
import com.capgemini.domain.FilmEntity;
import com.capgemini.mappers.FilmMapper;
import com.capgemini.service.FilmService;
import com.capgemini.types.FilmSearchCriteria;
import com.capgemini.types.FilmTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Service
public class FilmServiceImpl implements FilmService {

    @Autowired
    private FilmDAO filmRepository;

    @Override
    @Transactional
    public FilmTO addFilm(FilmTO filmTO) {
        if(filmTO == null) {
            return null;
        }

        if(filmTO.getProfit1stWeek() != null && filmTO.getProfitTotal() != null) {
            if (filmTO.getProfit1stWeek() > filmTO.getProfitTotal()) {
                throw new IllegalArgumentException();
            }
        }
        FilmEntity filmEntity = FilmMapper.toFilmEntity(filmTO);
        filmRepository.save(filmEntity);
        return FilmMapper.toFilmTO(filmEntity);
    }

    @Override
    @Transactional
    public FilmTO showFilm(Integer id) {
        if(filmRepository.findOne(id) == null) {
            throw new NullPointerException();
        }
        return FilmMapper.toFilmTO(filmRepository.findOne(id));
    }

    @Override
    @Transactional
    public FilmTO editFilm(FilmTO filmTO) {

        if(filmTO == null) {
            return null;
        }

        FilmEntity filmEntity = FilmMapper.toFilmEntity(filmTO);
        filmRepository.update(filmEntity);
        return FilmMapper.toFilmTO(filmEntity);
    }

    @Override
    @Transactional
    public void removeFilm(Integer id) {
        if(filmRepository.findOne(id) == null) {
            throw new NullPointerException();
        }
        filmRepository.delete(id);
    }

    @Override
    @Transactional
    public List<FilmTO> findAllFilms() {
        return FilmMapper.map2TOs(filmRepository.findAll());
    }

    @Override
    public List<FilmEntity> findFilmBy(FilmSearchCriteria filmSearchCriteria) {
        return filmRepository.findFilmBy(filmSearchCriteria);
    }

    @Override
    public Double calculateWeekFilmAverage() {
        return filmRepository.calculateWeekFilmAverage();
    }

    @Override
    public Double calculateTotalFilmAverage() {
        return filmRepository.calculateTotalFilmAverage();
    }

    @Override
    public Double calculateMostExpensiveTotalProfit(Integer howManyFilms) {
        return filmRepository.calculateMostExpensiveTotalProfit(howManyFilms);
    }

    @Override
    public Double calculateBudget(LocalDate dateFrom, LocalDate dateTo) {
        return filmRepository.calculateBudget(dateFrom, dateTo);
    }

    @Override
    public List<ActorEntity> findNotPlayingActors(LocalDate dateFrom, LocalDate dateTo) {
        return filmRepository.findNotPlayingActors(dateFrom, dateTo);
    }

    @Override
    public List<FilmEntity> findLongestFilmInStudioInTime(String studioName, LocalDate dateFrom, LocalDate dateTO) {
        return filmRepository.findLongestFilmInStudioInTime(studioName, dateFrom, dateTO);
    }

    @Override
    public void countStudioFilmsInYear(LocalDate year) {
        // return filmRepository.countStudioFilmsInYear(year);
    }

}
