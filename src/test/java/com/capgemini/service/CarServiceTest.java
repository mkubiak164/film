package com.capgemini.service;

import com.capgemini.types.CarTO;
import com.capgemini.types.CarToBuilder;
import org.assertj.core.api.Assertions;
import org.junit.Before;
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
public class CarServiceTest {

    static {
        System.setProperty("spring.profiles.active", "hsql");
    }

    @Autowired
    private CarService carService;

    @Test
    public void shouldAddCar() {
        //given
        CarTO carTO = new CarToBuilder().withCarType("Kombi").withMark("KIA").build();
        List<CarTO> allCars = carService.findAllCars();
        final int sizeBefore = allCars.size();

        //when
        carService.addCar(carTO);

        //then
        List<CarTO> allCarsAfter = carService.findAllCars();
        Assertions.assertThat(allCarsAfter.size()).isEqualTo(sizeBefore + 1);
    }

    @Test
    @Sql({"carInsert.sql"})
    public void shouldRemoveCar() {
        //given
        List<CarTO> allCars = carService.findAllCars();
        final int sizeBefore = allCars.size();
        Integer id = allCars.get(allCars.size()-1).getId();

        //when
        carService.removeCar(id);

        //then
        List<CarTO> allCarsAfter = carService.findAllCars();
        Assertions.assertThat(allCarsAfter.size()).isEqualTo(sizeBefore - 1);
    }

    @Test
    @Sql({"carInsert.sql"})
    public void shouldUpdateCar() {
        //given
        CarTO carTO = new CarToBuilder().withCarType("Kombi").withMark("KIA").build();
        List<CarTO> all = carService.findAllCars();
        Integer id = all.get(all.size()-1).getId();

        //when
        carService.editCar(carTO);

        //then
        CarTO carTO2 = carService.findById(id);
        Assertions.assertThat(carTO2.getCarType().equalsIgnoreCase("Kombi"));
    }

    @Test
    @Sql({"carInsert.sql"})
    public void shouldFindByTypeAndMark() {

        //when
        List<CarTO> foundCars = carService.findByTypeAndMark("Kombi", "KIA");

        //then
        Assertions.assertThat(foundCars.size()).isEqualTo(1);
    }

    @Test
    @Sql({"carInsert.sql"})
    public void shouldFindByKeeper() {

        //when
        List<CarTO> foundCars = carService.findByKeeper(34);

        //then
        Assertions.assertThat(foundCars.size()).isEqualTo(1);
    }


}
