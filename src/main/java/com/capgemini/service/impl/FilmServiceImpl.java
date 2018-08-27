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
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class FilmServiceImpl implements FilmService {

    @Autowired
    private FilmDAO filmRepository;

   private TransactionTemplate transactionTemplate;

    public FilmServiceImpl(PlatformTransactionManager transactionManager) {
        this.transactionTemplate = new TransactionTemplate(transactionManager);
    }

    /**
     * dodawanie filmu
     * @param filmTO
     * @return
     */
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

    /**
     * podgląd filmu
     * @param id
     * @return
     */
    @Override
    @Transactional
    public FilmTO showFilm(Integer id) {
        if(filmRepository.findOne(id) == null) {
            throw new NullPointerException();
        }
        return FilmMapper.toFilmTO(filmRepository.findOne(id));
    }

    /**
     * edycja filmu
     * @param filmTO
     * @return
     */
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

    /**
     * usuwanie filmu
     * @param id
     */
    @Override
    @Transactional
    public void removeFilm(Integer id) {
        if(filmRepository.findOne(id) == null) {
            throw new NullPointerException();
        }
        filmRepository.delete(id);
    }

    /**
     * metoda potrzebna do testów
     * @return
     */
    @Override
    @Transactional
    public List<FilmTO> findAllFilms() {
        return FilmMapper.map2TOs(filmRepository.findAll());
    }

    /**
     * wyszukiwanie po zadanych kryteriach
     * @param filmSearchCriteria
     * @return
     */
    @Override
    public List<FilmEntity> findFilmBy(FilmSearchCriteria filmSearchCriteria) {
        return filmRepository.findFilmBy(filmSearchCriteria);
    }

    /**
     * obliczanie średnich zarobków filmu w ciągu tygodnia
     * @return
     */
    @Override
    public Double calculateWeekFilmAverage() {
        return filmRepository.calculateWeekFilmAverage();
    }

    /**
     * obliczanie średnich zarobków filmu ogólnie
     * @return
     */
    @Override
    public Double calculateTotalFilmAverage() {
        return filmRepository.calculateTotalFilmAverage();
    }

    /**
     * całkowity zarobek X najdroższych filmów
     * @param howManyFilms
     * @return
     */
    @Override
    public Double calculateMostExpensiveTotalProfit(Integer howManyFilms) {
        return filmRepository.calculateMostExpensiveTotalProfit(howManyFilms);
    }

    /**
     * obliczenie ile wydano na filmy w latach od-do
     * @param dateFrom
     * @param dateTo
     * @return
     */
    @Override
    public Double calculateBudget(LocalDate dateFrom, LocalDate dateTo) {
        return filmRepository.calculateBudget(dateFrom, dateTo);
    }

    /**
     * wyszukiwanie aktorów, którzy nie grali w żadnym filmie w zadanym okresie
     * @param dateFrom
     * @param dateTo
     * @return
     */
    @Override
    public List<ActorEntity> findNotPlayingActors(LocalDate dateFrom, LocalDate dateTo) {
        return filmRepository.findNotPlayingActors(dateFrom, dateTo);
    }

    /**
     * wyszukiwanie najdłuzszego filmu zrealizowanego przez podane studio w zadanym okresie
     * @param studioName
     * @param dateFrom
     * @param dateTO
     * @return
     */
    @Override
    public List<FilmEntity> findLongestFilmInStudioInTime(String studioName, LocalDate dateFrom, LocalDate dateTO) {
        return filmRepository.findLongestFilmInStudioInTime(studioName, dateFrom, dateTO);
    }

    /**
     * ile filmów wyprodukowało każde studio w zadanym roku
     * @param year
     */
    @Override
    public void countStudioFilmsInYear(LocalDate year) {
        // return filmRepository.countStudioFilmsInYear(year);
    }

}
