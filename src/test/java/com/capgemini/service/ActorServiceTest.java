package com.capgemini.service;


import com.capgemini.types.ActorTO;
import com.capgemini.types.ActorTOBuilder;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.List;

@SpringBootTest
@Transactional
@RunWith(SpringRunner.class)
@ActiveProfiles(profiles = "localtest")
public class ActorServiceTest {

    @Autowired
    private ActorService actorService;


    @Test
    public void shouldAddActor() {
        //given
        ActorTO actorTO = new ActorTOBuilder().withFirstName("Marian").withLastName("Gałązka").build();
        List<ActorTO> allActors = actorService.findAllActors();
        final int sizeBefore = allActors.size();

        //when
        actorService.addActor(actorTO);

        //then
        Integer id = actorTO.getId();
        List<ActorTO> allActorsAfter = actorService.findAllActors();
        Assertions.assertThat(allActorsAfter.size()).isEqualTo(sizeBefore+1);
      //  Assertions.assertThat()

    }


    @Test
    public void shouldNotAddActorAndReturnNull() {
        //given
        ActorTO actorTO = new ActorTO();
        List<ActorTO> allActors = actorService.findAllActors();
        final int sizeBefore = allActors.size();

        //when
        actorService.addActor(actorTO);

        //then
        Integer id = actorTO.getId();
        List<ActorTO> allActorsAfter = actorService.findAllActors();
        Assertions.assertThat(allActorsAfter.size()).isEqualTo(sizeBefore);
    }

    @Test
    public void shouldShowActor() {
        //given
        ActorTO actorTO = new ActorTOBuilder().withID(743).withFirstName("Marian").withLastName("Gałązka").build();

        //when
        ActorTO actorTO2 = actorService.showActor(743);

        //then
        Assertions.assertThat(actorTO2.getFirstName()).isEqualToIgnoringCase("Marian");
        Assertions.assertThat(actorTO2.getLastName()).isEqualToIgnoringCase("Gałązka");

    }

    @Test
    public void shouldNotShowActorAndThrowNullPointerException() {
        //given
        ActorTO actorTO = new ActorTOBuilder().withID(743).withFirstName("Marian").withLastName("Gałązka").build();

        //when
        ActorTO actorTO2 = actorService.showActor(785);

        //then

    }

    @Test
    public void shouldEditActor() {

    }

    @Test
    public void shouldNotEditActorAndReturnNull() {

    }

    @Test
    public void shouldRemoveActor() {

    }

    @Test
    public void shouldNotRemoveActorAndThrowNullPointerException() {

    }

}
