package com.capgemini.service;

import com.capgemini.dao.FilmDAO;
import com.capgemini.domain.ActorEntity;
import com.capgemini.mappers.ActorMapper;
import com.capgemini.types.ActorTO;
import com.capgemini.types.ActorTOBuilder;
import com.capgemini.types.FilmTO;
import com.capgemini.types.FilmTOBuilder;
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

    public void shouldNotAddFilm() {

    }

    public void shouldShowFilm() {

    }

    public void shouldNotShowFilmAndThrowNullPointerException() {

    }

    public void shouldEditFilm() {

    }

    public void shouldNotEditFilmAndThrowNullPointerException() {

    }

    public void shouldRemoveFilm() {

    }

    public void shouldNotRemoveFilmAndThrowNullPointerException() {

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

}
