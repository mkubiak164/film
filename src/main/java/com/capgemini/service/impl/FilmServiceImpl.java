package com.capgemini.service.impl;

import com.capgemini.dao.impl.FilmDAOImpl;
import com.capgemini.domain.FilmEntity;
import com.capgemini.mappers.FilmMapper;
import com.capgemini.service.FilmService;
import com.capgemini.types.FilmTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FilmServiceImpl implements FilmService {

    @Autowired
    private FilmDAOImpl filmRepository;

    @Override
    public FilmTO addActor(FilmTO filmTO) {
        FilmEntity filmEntity = FilmMapper.toFilmEntity(filmTO);
        filmRepository.save(filmEntity);
        return FilmMapper.toFilmTO(filmEntity);
    }

    @Override
    public FilmTO showActor(Integer id) {
        return FilmMapper.toFilmTO(filmRepository.findOne(id));
    }

    @Override
    public FilmTO editActor(FilmTO filmTO) {
        FilmEntity filmEntity = FilmMapper.toFilmEntity(filmTO);
        filmRepository.update(filmEntity);
        return FilmMapper.toFilmTO(filmEntity);
    }

    @Override
    public void removeActor(Integer id) {
        filmRepository.delete(id);
    }
}
