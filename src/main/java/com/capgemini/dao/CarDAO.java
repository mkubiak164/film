package com.capgemini.dao;

import com.capgemini.domain.CarEntity;

import java.util.List;

public interface CarDAO extends Dao<CarEntity, Integer> {

    List<CarEntity> findByTypeAndMark(String type, String mark);

    List<CarEntity> findByKeeper(Integer keeperId);



}
