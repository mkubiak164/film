package com.capgemini.dao.impl;

import com.capgemini.dao.CarDAO;
import com.capgemini.domain.CarEntity;

import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class CarDAOImpl extends AbstractDao<CarEntity, Integer> implements CarDAO {

    /**
     * metoda znajdująca auta na podstawie typu i marki
     * @param type
     * @param mark
     * @return zwraca listę rezultatów
     */
    @Override
    public List<CarEntity> findByTypeAndMark(String type, String mark) {
       TypedQuery<CarEntity> query = entityManager.createQuery(
               "select car from CarEntity car where car.carType like :type AND car.mark like :mark", CarEntity.class);
       query.setParameter("type", type);
       query.setParameter("mark", mark);
       return query.getResultList();
    }

    /**
     * metoda znajdująca auta, którymi opiekuje się dany pracownik
     * @param keeperId
     * @return zwraca listę rezultatów
     */
    @Override
    public List<CarEntity> findByKeeper(Integer keeperId) {

        TypedQuery<CarEntity> query = entityManager.createQuery(
                "select car from CarEntity car where :keeperId in car.keepers.id", CarEntity.class);
        query.setParameter("keeperId", keeperId);
        return query.getResultList();
    }

    public void assignCarToKeeper(Integer keepCarId, Integer employeeId) {

    }

}