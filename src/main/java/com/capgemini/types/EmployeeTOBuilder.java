package com.capgemini.types;

import com.capgemini.domain.EmpPositionEntity;
import com.capgemini.domain.OfficeEntity;

import java.util.Date;

public class EmployeeTOBuilder {

    private String name;
    private String lastName;
    private Date dateOfBirth;
    private EmpPositionEntity empPosition;
    private OfficeEntity office;

    public EmployeeTOBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public EmployeeTOBuilder withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public EmployeeTOBuilder withDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return this;
    }

    public EmployeeTOBuilder withEmpPosition(EmpPositionEntity empPosition) {
        this.empPosition = empPosition;
        return this;
    }

    public EmployeeTOBuilder withOffice(OfficeEntity office) {
        this.office = office;
        return this;
    }


    public EmployeeTO build() {
        return new EmployeeTO(this.name, this.lastName, this.dateOfBirth, this.empPosition, this.office);
    }










}
