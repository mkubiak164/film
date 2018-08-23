package com.capgemini.dao.impl;

import com.capgemini.dao.EmployeeDAO;
import com.capgemini.domain.EmployeeEntity;
import com.capgemini.types.EmployeeSearchCriteria;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeDAOImpl extends AbstractDao<EmployeeEntity, Integer> implements EmployeeDAO {

    /**
     * metoda wyświetlająca wszystkich pracowników z danej placówki
     * @param officeId
     * @return zwraca listę pracowników
     */
    @Override
    public List<EmployeeEntity> findAllOfficeEmployees(Integer officeId) {
        TypedQuery<EmployeeEntity> query = entityManager.createQuery(
            "select employee from EmployeeEntity employee where employee.office.id = :office", EmployeeEntity.class);
        query.setParameter("office", officeId);
        return query.getResultList();
    }


    /**
     * metoda pozwalająca wyszukać pracowników z danej placówki, którzy opiekują sie danym autem
     * @param officeId
     * @param carId
     * @return zwraca listę pracowników
     */
    @Override
    public List<EmployeeEntity> findAllOfficeEmployeesByKeepCarId(Integer officeId, Integer carId) {
        TypedQuery<EmployeeEntity> query = entityManager.createQuery(
                "select employee from EmployeeEntity employee where employee.office.id = :officeId " +
                        "and :keepCarId in employee.keeper.cars.id", EmployeeEntity.class);
        query.setParameter("officeId", officeId);
        query.setParameter("keepCarId", carId);
        return query.getResultList();
    }

    /**
     * metoda pozwalająca wyszukać pracownika po wybranych informacjach reprezentowanych przez obiekt
     * @param employeeSearchCriteria
     * @return zwraca listę rezultatów(pracowników)
     */
    @Override
    public List<EmployeeEntity> findEmployeeBy(EmployeeSearchCriteria employeeSearchCriteria) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();

        CriteriaQuery<EmployeeEntity> query = cb.createQuery(EmployeeEntity.class);
        Root<EmployeeEntity> employeeEntity = query.from(EmployeeEntity.class);

        List<Predicate> predicates = new ArrayList<Predicate>();

        if (employeeSearchCriteria.getCarId() != null) {
            predicates.add(cb.equal(employeeEntity.get("keeper").get("cars").get("id"), employeeSearchCriteria.getCarId()));
        }

        if (employeeSearchCriteria.getOfficeId() != null) {
            predicates.add(cb.equal(employeeEntity.get("office").get("id"), employeeSearchCriteria.getOfficeId()));
        }

        if (employeeSearchCriteria.getPosition() != null) {
            predicates.add(cb.equal(employeeEntity.get("empPosition").get("id"), employeeSearchCriteria.getPosition()));
        }

        query.select(employeeEntity).where(predicates.toArray(new Predicate[]{}));

        return entityManager.createQuery(query).getResultList();
    }


}
