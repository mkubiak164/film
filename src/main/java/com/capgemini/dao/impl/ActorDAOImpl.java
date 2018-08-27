package com.capgemini.dao.impl;

import com.capgemini.dao.ActorDAO;
import com.capgemini.domain.ActorEntity;
import org.springframework.stereotype.Repository;

@Repository
public class ActorDAOImpl extends AbstractDao<ActorEntity, Integer> implements ActorDAO {


}
