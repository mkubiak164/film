package com.capgemini.service.impl;

import com.capgemini.dao.FilmDAO;
import com.capgemini.dao.impl.FilmDAOImpl;
import com.capgemini.domain.FilmEntity;
import com.capgemini.mappers.FilmMapper;
import com.capgemini.service.FilmService;
import com.capgemini.types.FilmTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class FilmServiceImpl implements FilmService {

    @Autowired
    private FilmDAO filmRepository;

    @Override
    @Transactional
    public FilmTO addFilm(FilmTO filmTO) {
        FilmEntity filmEntity = FilmMapper.toFilmEntity(filmTO);
        filmRepository.save(filmEntity);
        return FilmMapper.toFilmTO(filmEntity);
    }

    @Override
    @Transactional
    public FilmTO showFilm(Integer id) {
        return FilmMapper.toFilmTO(filmRepository.findOne(id));
    }

    @Override
    @Transactional
    public FilmTO editFilm(FilmTO filmTO) {
        FilmEntity filmEntity = FilmMapper.toFilmEntity(filmTO);
        filmRepository.update(filmEntity);
        return FilmMapper.toFilmTO(filmEntity);
    }

    @Override
    @Transactional
    public void removeFilm(Integer id) {
        filmRepository.delete(id);
    }

    @Override
    @Transactional
    public List<FilmTO> findAllFilms() {
        return FilmMapper.map2TOs(filmRepository.findAll());
    }
}
