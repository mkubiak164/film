package com.capgemini.service;

import com.capgemini.types.FilmTO;

public interface FilmService {

    FilmTO addActor(FilmTO actor);

    FilmTO showActor(Integer id);

    FilmTO editActor(FilmTO actor);

    void removeActor(Integer id);
}
