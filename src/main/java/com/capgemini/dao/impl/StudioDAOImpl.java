package com.capgemini.dao.impl;

import com.capgemini.dao.StudioDAO;
import com.capgemini.domain.StudioEntity;
import org.springframework.stereotype.Repository;

@Repository
public class StudioDAOImpl extends AbstractDao<StudioEntity, Integer> implements StudioDAO {
}
