package com.capgemini.types;

import com.capgemini.domain.EmpPositionEntity;
import com.capgemini.domain.OfficeEntity;

import java.util.Date;

public class EmployeeTO {


    private String name;
    private String lastName;
    private Date dateOfBirth;
    private EmpPositionEntity empPosition;
    private OfficeEntity office;

    public EmployeeTO() {

    }

    public EmployeeTO(String name, String lastName, Date dateOfBirth) {
        this.name = name;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
    }


    public EmployeeTO(String name, String lastName, Date dateOfBirth, EmpPositionEntity empPosition, OfficeEntity office) {
        this(name, lastName, dateOfBirth);
        this.empPosition = empPosition;
        this.office = office;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public EmpPositionEntity getEmpPosition() {
        return empPosition;
    }

    public void setEmpPosition(EmpPositionEntity empPosition) {
        this.empPosition = empPosition;
    }

    public OfficeEntity getOffice() {
        return office;
    }

    public void setOffice(OfficeEntity office) {
        this.office = office;
    }





}
