package com.capgemini.mappers;

import com.capgemini.domain.EmployeeEntity;
import com.capgemini.types.EmployeeTO;

import java.util.List;
import java.util.stream.Collectors;

public class EmployeeMapper {

    public static EmployeeEntity toEmployeeEntity(EmployeeTO employeeTO) {

        if(employeeTO == null)
            return null;

        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setName(employeeTO.getName());
        employeeEntity.setLastName(employeeTO.getLastName());
        employeeEntity.setDateOfBirth(employeeTO.getDateOfBirth());
        employeeEntity.setEmpPosition(employeeTO.getEmpPosition());
        employeeEntity.setOffice(employeeTO.getOffice());

        return employeeEntity;
    }


    public static EmployeeTO toEmployeeTO(EmployeeEntity employeeEntity) {

        if(employeeEntity == null)
            return null;

        EmployeeTO employeeTO = new EmployeeTO();
        employeeTO.setName(employeeEntity.getName());
        employeeTO.setLastName(employeeEntity.getLastName());
        employeeTO.setDateOfBirth(employeeEntity.getDateOfBirth());
        employeeTO.setEmpPosition(employeeEntity.getEmpPosition());
        employeeTO.setDateOfBirth(employeeEntity.getDateOfBirth());

        return employeeTO;
    }



    public static List<EmployeeTO> map2TOs(List<EmployeeEntity> employeeEntities) {
        return employeeEntities.stream().map(EmployeeMapper::toEmployeeTO).collect(Collectors.toList());
    }


}
