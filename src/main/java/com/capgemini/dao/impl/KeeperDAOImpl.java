package com.capgemini.dao.impl;

import com.capgemini.dao.KeeperDAO;
import com.capgemini.domain.CarEntity;
import com.capgemini.domain.KeeperEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class KeeperDAOImpl extends AbstractDao<KeeperEntity, Integer> implements KeeperDAO {

    @Override
    public void assignCarToKeeper(CarEntity carEntity, Integer keeperId) {
        KeeperEntity keeper = findOne(keeperId);
        keeper.getCars().add(carEntity);
    }

    @Override
    public List<CarEntity> findByKeeper(Integer keeperId) {
        KeeperEntity keeper = findOne(keeperId);
        return keeper.getCars();
    }

}
