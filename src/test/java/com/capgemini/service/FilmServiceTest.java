package com.capgemini.service;

import com.capgemini.types.FilmTO;
import com.capgemini.types.FilmTOBuilder;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.List;

@SpringBootTest
@Transactional
@RunWith(SpringRunner.class)
@ActiveProfiles(profiles = "localtest")
public class FilmServiceTest {

    @Autowired
    private FilmService filmService;

    @Test
    public void shouldAddFilm() {
        //given
        FilmTO filmTO = new FilmTOBuilder().withTitle("Programiści").build();
        List<FilmTO> allBefore = filmService.findAllFilms();
        int sizeBefore = allBefore.size();

        //when
        filmService.addFilm(filmTO);

        //then
        List<FilmTO> allAfter = filmService.findAllFilms();
        int sizeAfter = allAfter.size();
        Assertions.assertThat(sizeAfter).isEqualTo(sizeBefore);
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


}
