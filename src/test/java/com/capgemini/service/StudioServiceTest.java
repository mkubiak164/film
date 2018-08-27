package com.capgemini.service;


import com.capgemini.mappers.StudioMapper;
import com.capgemini.types.StudioTO;
import com.capgemini.types.StudioTOBuilder;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.List;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@Transactional
@RunWith(SpringRunner.class)
@ActiveProfiles(profiles = "localtest")
public class StudioServiceTest {

    @Autowired
    private StudioService studioService;

    @Test
    public void shouldAddStudio() {
        //given
        StudioTO studioTO = new StudioTOBuilder().withStudioName("Filmujemy").build();
        List<StudioTO> allBefore = studioService.findAll();

        //when
        studioService.addStudio(studioTO);

        //then
        List<StudioTO> allAfter = studioService.findAll();
        Assertions.assertThat(allBefore.size()).isEqualTo(allAfter.size()-1);
    }

    @Test
    public void shoulNotAddStudio() {
        //given
        StudioTO studioTO = null;
        List<StudioTO> allBefore = studioService.findAll();

        //when
        studioService.addStudio(studioTO);

        //then
        List<StudioTO> allAfter = studioService.findAll();
        Assertions.assertThat(allAfter.size()).isEqualTo(allBefore.size());
    }

    @Test
    public void shouldShowStudio() {
        //given
        StudioTO studioTO = new StudioTOBuilder().withStudioName("Filmujemy").build();
        StudioTO studioTO1 = studioService.addStudio(studioTO);

        //when
        StudioTO studioTO2 = studioService.showStudio(studioTO1.getId());

        //then
        Assertions.assertThat(studioTO2.getStudioName()).isEqualToIgnoringCase("Filmujemy");

    }

    @Test
    public void shouldNotShowStudioAndThrowNullPointerException() {
        //when
        try{
            StudioTO studioTO = studioService.showStudio(4587);
        }
        //then
        catch (Throwable expected) {
            assertEquals(NullPointerException.class, expected.getClass());
        }
    }


    @Test
    public void shouldEditStudio() {
        //given
        StudioTO studioTO = new StudioTOBuilder().withStudioName("Filmujemy").build();
        studioService.addStudio(studioTO);
        studioTO = new StudioTOBuilder().withStudioName("EkstraFilmy").build();

        //when
        studioService.editStudio(studioTO);

        //then
        Assertions.assertThat(studioTO.getStudioName()).isEqualToIgnoringCase("EkstraFilmy");
    }

    @Test
    public void shouldNotEditStudioAndThrowNullPointerException() {
        //given
        StudioTO studioTO = null;

        //when
        try{
            studioService.editStudio(studioTO);
        }

        //then
        catch(Throwable expected) {
            assertEquals(NullPointerException.class, expected.getClass());
        }
    }

    @Test
    public void shouldRemoveStudio() {
        //given
        StudioTO studioTO = new StudioTOBuilder().withStudioName("Filmujemy").build();
        StudioTO studioTO1 = studioService.addStudio(studioTO);
        Integer id = studioTO1.getId();

        List<StudioTO> allBefore = studioService.findAll();

        //when
        studioService.removeStudio(studioTO1.getId());

        //then
        List<StudioTO> allAfter = studioService.findAll();
        Assertions.assertThat(allAfter.size()).isEqualTo(allBefore.size()-1);
    }


    @Test
    public void shouldNotRemoveStudioAndThrowNullPointerException() {
        //when
        try {
            studioService.removeStudio(4587);
        }
        //then
        catch (Throwable expected) {
            assertEquals(NullPointerException.class, expected.getClass());
        }
    }

}
