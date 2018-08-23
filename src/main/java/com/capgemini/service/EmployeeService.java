package com.capgemini.service;

import com.capgemini.types.EmployeeSearchCriteria;
import com.capgemini.types.EmployeeTO;

import java.util.List;

public interface EmployeeService {

    public List<EmployeeTO> findEmployeeBy(EmployeeSearchCriteria employeeSearchCriteria);

    public EmployeeTO findById(Integer id);

}
