package com.capgemini.service;

import com.capgemini.dao.FilmDAO;
import com.capgemini.domain.ActorEntity;
import com.capgemini.domain.FilmEntity;
import com.capgemini.mappers.ActorMapper;
import com.capgemini.types.*;
import org.assertj.core.api.Assertions;
import org.hibernate.exception.ConstraintViolationException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@Transactional
@RunWith(SpringRunner.class)
@ActiveProfiles(profiles = "localtest")
public class FilmServiceTest {

    @Autowired
    private FilmService filmService;

    @Autowired
    private ActorService actorService;

    @Test
    public void shouldAddFilm() {
        //given
        ActorTO actorTO = new ActorTOBuilder().withFirstName("Marian").withLastName("Gałązka").build();
        ActorTO addedActor = actorService.addActor(actorTO);
        Collection<ActorEntity> actors = new ArrayList<>();
        actors.add(ActorMapper.toActorEntity(addedActor));
        FilmTO filmTO = new FilmTOBuilder().withTitle("Programiści").withActorEntities(actors).build();
        List<FilmTO> allBefore = filmService.findAllFilms();
        int sizeBefore = allBefore.size();

        //when
        filmService.addFilm(filmTO);

        //then
        List<FilmTO> allAfter = filmService.findAllFilms();
        int sizeAfter = allAfter.size();
        Assertions.assertThat(sizeAfter).isEqualTo(sizeBefore+1);
    }

    @Test
    public void shouldNotAddFilmWithoutActor() {
        //given
        FilmTO filmTO = new FilmTOBuilder().withTitle("Programiści").build();
        List<FilmTO> allBefore = filmService.findAllFilms();
        int sizeBefore = allBefore.size();

        //when
        try {
            filmService.addFilm(filmTO);
        }

        //then
        catch(Throwable expected) {
            assertEquals(DataIntegrityViolationException.class, expected.getClass());
        }
    }

    @Test
    public void shouldNotAddFilm() {
        //given
         FilmTO filmTO = null;
         List<FilmTO> allBefore = filmService.findAllFilms();

         //when
        filmService.addFilm(filmTO);

        //then
        List<FilmTO> allAfter = filmService.findAllFilms();
        Assertions.assertThat(allAfter.size()).isEqualTo(allBefore.size());
    }

    @Test
    public void shouldShowFilm() {
        //given
        FilmTO filmTO = new FilmTOBuilder().withTitle("Programiści").build();
        FilmTO filmTO1 = filmService.addFilm(filmTO);

        //when
        FilmTO filmTO2 = filmService.showFilm(filmTO1.getId());

        //then
        Assertions.assertThat(filmTO2.getTitle()).isEqualToIgnoringCase("Programiści");
    }

    @Test
    public void shouldNotShowFilmAndThrowNullPointerException() {
        //when
        try{
            FilmTO filmTO = filmService.showFilm(5874);
        }
        //then
        catch (Throwable expected) {
            assertEquals(NullPointerException.class, expected.getClass());
        }
    }

    @Test
    public void shouldEditFilm() {
        //given
        FilmTO filmTO = new FilmTOBuilder().withTitle("Programiści").build();
        filmService.addFilm(filmTO);
        filmTO = new FilmTOBuilder().withTitle("Zwierzogród").build();

        //when
        filmService.editFilm(filmTO);

        //then
        Assertions.assertThat(filmTO.getTitle()).isEqualToIgnoringCase("Zwierzogród");
    }

    @Test
    public void shouldNotEditFilmAndThrowNullPointerException() {
        //given
        FilmTO filmTO = null;

        //when
        try{
            filmService.editFilm(filmTO);
        }
        //then
        catch(Throwable expected) {
            assertEquals(NullPointerException.class, expected.getClass());
        }
    }

    @Test
    public void shouldRemoveFilm() {
        //given
        FilmTO filmTO = new FilmTOBuilder().withTitle("Programiści").build();
        FilmTO filmTO1 = filmService.addFilm(filmTO);
        List<FilmTO> allBefore = filmService.findAllFilms();

        //when
        filmService.removeFilm(filmTO1.getId());

        //then
        List<FilmTO> allAfter = filmService.findAllFilms();
        Assertions.assertThat(allAfter.size()).isEqualTo(allBefore.size()-1);
    }

    @Test
    public void shouldNotRemoveFilmAndThrowNullPointerException() {
        //when
        try{
            filmService.removeFilm(8654);
        }
        //then
        catch (Throwable expected) {
            assertEquals(NullPointerException.class, expected.getClass());
        }
    }

    @Test
    public void shouldFindAllByCriteriaNulls() {
        //given
        FilmTO filmTO = new FilmTOBuilder().withTitle("Programiści").withKind("komedia").build();
        filmService.addFilm(filmTO);
        FilmTO filmTO2 = new FilmTOBuilder().withTitle("Programiści2").withKind("dramat").build();
        filmService.addFilm(filmTO2);

        //when
        FilmSearchCriteria searchCriteria = new FilmSearchCriteria(null, null ,null ,null ,null ,null ,null, null );
        List<FilmEntity> foundFilms = filmService.findFilmBy(searchCriteria);

        //then
        Assertions.assertThat(foundFilms.size()).isEqualTo(2);
    }

    @Test
    public void shouldFindOneFilmByKind() {
        //given
        FilmTO filmTO = new FilmTOBuilder().withTitle("Programiści").withKind("komedia").build();
        filmService.addFilm(filmTO);
        FilmTO filmTO2 = new FilmTOBuilder().withTitle("Programiści2").withKind("dramat").build();
        filmService.addFilm(filmTO2);

        //when
        FilmSearchCriteria searchCriteria = new FilmSearchCriteria("komedia", null ,null ,null ,null ,null ,null, null );
        List<FilmEntity> foundFilms = filmService.findFilmBy(searchCriteria);

        //then
        Assertions.assertThat(foundFilms.size()).isEqualTo(1);
    }

    @Test
    public void shouldFindOneFilmByType() {
        FilmTO filmTO = new FilmTOBuilder().build();
        filmService.addFilm(filmTO);
        FilmTO filmTO2 = new FilmTOBuilder().withTitle("Programiści2").withKind("dramat").build();
        filmService.addFilm(filmTO2);
    }

    @Test
    public void shouldFindOneFilmByDateFrom() {
        //given
        LocalDate date1 = LocalDate.of(2001, 5, 6);
        FilmTO filmTO = new FilmTOBuilder().withTitle("wczesniejszy").withPremierDate(date1).build();
        filmService.addFilm(filmTO);
        LocalDate date2 = LocalDate.of(2006, 7, 6);
        FilmTO filmTO2 = new FilmTOBuilder().withTitle("pozniejszy").withPremierDate(date2).build();
        filmService.addFilm(filmTO2);
        LocalDate date3 = LocalDate.of(2003, 7, 6);

        //when
        FilmSearchCriteria searchCriteria = new FilmSearchCriteria(null, null ,null ,null ,date3 ,null ,null, null );
        List<FilmEntity> foundFilms = filmService.findFilmBy(searchCriteria);

        //then
        Assertions.assertThat(foundFilms.size()).isEqualTo(1);
        Assertions.assertThat(foundFilms.get(0).getTitle()).isEqualToIgnoringCase("pozniejszy");
    }

    @Test
    public void shouldFindOneFilmByDateTo() {
        //given
        LocalDate date1 = LocalDate.of(2001, 5, 6);
        FilmTO filmTO = new FilmTOBuilder().withTitle("wczesniejszy").withPremierDate(date1).build();
        filmService.addFilm(filmTO);
        LocalDate date2 = LocalDate.of(2006, 7, 6);
        FilmTO filmTO2 = new FilmTOBuilder().withTitle("pozniejszy").withPremierDate(date2).build();
        filmService.addFilm(filmTO2);
        LocalDate date3 = LocalDate.of(2003, 7, 6);

        //when
        FilmSearchCriteria searchCriteria = new FilmSearchCriteria(null, null ,null ,null ,null ,date3 ,null, null );
        List<FilmEntity> foundFilms = filmService.findFilmBy(searchCriteria);

        //then
        Assertions.assertThat(foundFilms.size()).isEqualTo(1);
        Assertions.assertThat(foundFilms.get(0).getTitle()).isEqualToIgnoringCase("wczesniejszy");
    }

    @Test
    public void shouldFindOneFilmByDateFromAndTo() {
        //given
        LocalDate date1 = LocalDate.of(2001, 5, 6);
        FilmTO filmTO = new FilmTOBuilder().withTitle("wczesniejszy").withPremierDate(date1).build();
        filmService.addFilm(filmTO);
        LocalDate date2 = LocalDate.of(2006, 7, 6);
        FilmTO filmTO2 = new FilmTOBuilder().withTitle("pozniejszy").withPremierDate(date2).build();
        filmService.addFilm(filmTO2);
        LocalDate date3 = LocalDate.of(2003, 7, 6);
        filmService.addFilm(filmTO2);
        LocalDate date4 = LocalDate.of(2010, 7, 6);

        //when
        FilmSearchCriteria searchCriteria = new FilmSearchCriteria(null, null ,null ,null ,date3, date4 ,null, null );
        List<FilmEntity> foundFilms = filmService.findFilmBy(searchCriteria);

        //then
        Assertions.assertThat(foundFilms.size()).isEqualTo(1);
        Assertions.assertThat(foundFilms.get(0).getTitle()).isEqualToIgnoringCase("pozniejszy");
    }

    @Test
    public void shouldCalculateWeekAverage() {
        //given
        FilmTO filmTO = new FilmTOBuilder().withTitle("Programiści").withProfit1stWeek(50000L).build();
        filmService.addFilm(filmTO);
        FilmTO filmTO2 = new FilmTOBuilder().withTitle("Programiści2").withProfit1stWeek(250000L).build();
        filmService.addFilm(filmTO2);

        //when
        Double avg = filmService.calculateWeekFilmAverage();

        //then
        Assertions.assertThat(avg).isEqualTo(150000);
    }

    @Test
    public void shouldCalculateTotalAverage() {
        //given
        FilmTO filmTO = new FilmTOBuilder().withTitle("Programiści").withProfitTotal(50000L).build();
        filmService.addFilm(filmTO);
        FilmTO filmTO2 = new FilmTOBuilder().withTitle("Programiści2").withProfitTotal(250000L).build();
        filmService.addFilm(filmTO2);

        //when
        Double avg = filmService.calculateTotalFilmAverage();

        //then
        Assertions.assertThat(avg).isEqualTo(150000);

    }

    @Test
    public void shouldCalculateMostExpensiveTotalProfit() {
        //given
        FilmTO filmTO = new FilmTOBuilder().withTitle("Programiści").withProfitTotal(50000L).build();
        filmService.addFilm(filmTO);
        FilmTO filmTO2 = new FilmTOBuilder().withTitle("Programiści2").withProfitTotal(250000L).build();
        filmService.addFilm(filmTO2);
        FilmTO filmTO3 = new FilmTOBuilder().withTitle("Programiści3").withProfitTotal(2000L).build();
        filmService.addFilm(filmTO3);

        //when
        Double avg = filmService.calculateMostExpensiveTotalProfit(2);

        //then
        Assertions.assertThat(avg).isEqualTo(300000);
    }

    @Test
    public void shouldCalculateBudget() {
        //given
        LocalDate date1 = LocalDate.of(2001, 5, 6);
        FilmTO filmTO = new FilmTOBuilder().withTitle("Programiści").withPremierDate(date1).withBudget(452000L).build();
        filmService.addFilm(filmTO);
        LocalDate date2 = LocalDate.of(2009, 9, 6);
        FilmTO filmTO2 = new FilmTOBuilder().withTitle("Programiści2").withPremierDate(date2).withBudget(250000L).build();
        filmService.addFilm(filmTO2);
        LocalDate date3 = LocalDate.of(2006, 2, 6);
        LocalDate date4 = LocalDate.of(2011, 2, 6);

        //when
        Double calculated = filmService.calculateBudget(date3, date4);

        //then
        Assertions.assertThat(calculated).isEqualTo(250000D);
    }

    @Test
    public void shouldFindNotPlayingActors() {

    }



}
