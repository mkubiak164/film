package com.capgemini.service;

import com.capgemini.types.EmployeeTO;
import com.capgemini.types.OfficeTO;

import java.util.List;

public interface OfficeService {

    OfficeTO addOffice(OfficeTO office);

    void removeOffice (Integer id);

    OfficeTO editOffice (OfficeTO office);

    void addEmployeeToOffice (Integer employeeId, Integer officeId);

    void removeEmployeeFromOffice (Integer employeeId, Integer officeId);

    List<EmployeeTO> findAllOfficeEmployees (Integer officeId);

    List<EmployeeTO> findAllOfficeEmployeesByKeepCarId (Integer officeId, Integer carId);

    List<OfficeTO> findAllOffices();

    OfficeTO findbyId(Integer id);
}
