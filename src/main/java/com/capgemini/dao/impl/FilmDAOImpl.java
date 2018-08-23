package com.capgemini.dao.impl;

import com.capgemini.dao.FilmDAO;
import com.capgemini.domain.FilmEntity;
import org.springframework.stereotype.Repository;

@Repository
public class FilmDAOImpl extends AbstractDao<FilmEntity, Integer> implements FilmDAO {


}
