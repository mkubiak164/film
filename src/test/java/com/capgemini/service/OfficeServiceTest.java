package com.capgemini.service;


import com.capgemini.types.EmployeeTO;
import com.capgemini.types.EmployeeTOBuilder;
import com.capgemini.types.OfficeTO;
import com.capgemini.types.OfficeTOBuilder;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.List;

@SpringBootTest
@Transactional
@RunWith(SpringRunner.class)
@ActiveProfiles(profiles = "localtest")
public class OfficeServiceTest {

    static {
        System.setProperty("spring.profiles.active", "hsql");
    }

    @Autowired
    private OfficeService officeService;

    @Autowired
    private EmployeeService employeeService;

    @Test
    @Sql({"officeInsert.sql"})
    public void shouldAddOffice() {
        //given
        OfficeTO officeTO = new OfficeTOBuilder().withAdress("Mielno").withEmail("mielno@samochod.pl").build();
        List<OfficeTO> allOffices = officeService.findAllOffices();
        final int sizeBefore = allOffices.size();

        //when
        officeService.addOffice(officeTO);

        //then
        List<OfficeTO> allOfficesAfter = officeService.findAllOffices();
        Assertions.assertThat(allOfficesAfter.size()).isEqualTo(sizeBefore+1);
    }

   @Test
   @Sql({"officeInsert.sql"})
    public void shouldRemoveOffice() {
        //given
        List<OfficeTO> allOffices = officeService.findAllOffices();
        final int sizeBefore = allOffices.size();
        Integer id = allOffices.get(allOffices.size()-1).getId();

        //when
        officeService.removeOffice(id);

        //then
        List<OfficeTO> allOfficesAfter = officeService.findAllOffices();
        Assertions.assertThat(allOfficesAfter.size()).isEqualTo(sizeBefore-1);
    }

    @Test
    @Sql({"officeInsert.sql"})
    public void shouldUpdateOffice() {
        //given
        OfficeTO officeTO = new OfficeTOBuilder().withAdress("lalaland").withEmail("lalaland@auto.pl").build();
        List<OfficeTO> all = officeService.findAllOffices();
        Integer id = all.get(all.size()-1).getId();

        //when
        officeService.editOffice(officeTO);

        //then
        OfficeTO officeTO1 = officeService.findbyId(id);
        Assertions.assertThat(officeTO1.getAdress().equalsIgnoreCase("lalaland"));
    }

    @Test
    @Sql({"officeInsert.sql"})
    public void shouldAddEmployeeToOffice() {
        //given
        List<OfficeTO> allOffices = officeService.findAllOffices();
        OfficeTO officeTO = allOffices.get(allOffices.size()-1);
        Integer id = officeTO.getId();

        //when
        officeService.addEmployeeToOffice(88, id);

        //then
        Assertions.assertThat(employeeService.findById(88).getOffice().getId()).isEqualTo(id);
    }

    @Test
    @Sql({"officeInsert.sql"})
    public void shouldRemoveEmployeeFromOffice() {
        //when
        officeService.removeEmployeeFromOffice(63, 96 );

        //then
        Assertions.assertThat(employeeService.findById(63).getOffice()).isEqualTo(null);
    }

    @Test
    @Sql({"officeInsert.sql"})
    public void shouldShowOfficeEmployees() {
        //given
        List<OfficeTO> allOffices = officeService.findAllOffices();
        OfficeTO officeTO = allOffices.get(allOffices.size()-1);
        Integer id = officeTO.getId();

        //when
        List<EmployeeTO> allOfficeEmployees = officeService.findAllOfficeEmployees(id);

        //then
        Assertions.assertThat(allOfficeEmployees.size()).isEqualTo(1);
    }


}
