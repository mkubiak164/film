package com.capgemini.dao;

import com.capgemini.domain.EmployeeEntity;
import com.capgemini.types.EmployeeSearchCriteria;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeDAO extends Dao<EmployeeEntity, Integer> {

    List<EmployeeEntity> findAllOfficeEmployees(Integer officeId);

    List<EmployeeEntity> findAllOfficeEmployeesByKeepCarId(Integer officeId, Integer carId);

    List<EmployeeEntity> findEmployeeBy(EmployeeSearchCriteria employeeSearchCriteria);
}
