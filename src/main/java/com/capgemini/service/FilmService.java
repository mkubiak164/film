package com.capgemini.service;

import com.capgemini.types.FilmTO;

import java.util.List;

public interface FilmService {

    FilmTO addFilm(FilmTO actor);

    FilmTO showFilm(Integer id);

    FilmTO editFilm(FilmTO actor);

    void removeFilm(Integer id);

    List<FilmTO> findAllFilms();
}
