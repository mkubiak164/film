package com.capgemini.dao;

import com.capgemini.domain.CarEntity;
import com.capgemini.domain.KeeperEntity;

import java.util.List;

public interface KeeperDAO extends Dao<KeeperEntity, Integer> {

    void assignCarToKeeper(CarEntity carEntity, Integer employeeId);

    List<CarEntity> findByKeeper(Integer keeperId);




}
