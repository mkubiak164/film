package com.capgemini.service;

import com.capgemini.domain.ActorEntity;
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

import static org.junit.Assert.assertEquals;

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
        List<ActorTO> allActorsAfter = actorService.findAllActors();
        Assertions.assertThat(allActorsAfter.size()).isEqualTo(sizeBefore+1);
    }

    @Test
    public void shouldNotAddActor() {
        //given
        ActorTO actorTO = null;
        List<ActorTO> allActors = actorService.findAllActors();
        final int sizeBefore = allActors.size();

        //when
        actorService.addActor(actorTO);

        //then
        List<ActorTO> allActorsAfter = actorService.findAllActors();
        Assertions.assertThat(allActorsAfter.size()).isEqualTo(sizeBefore);
    }

    @Test
    public void shouldShowActor() {
        //given
        ActorTO actorTO = new ActorTOBuilder().withFirstName("Marian").withLastName("Gałązka").build();
        actorService.addActor(actorTO);

        //when
        ActorTO actorTO1 = actorService.showActor(actorService.findAllActors().size());

        //then
        Assertions.assertThat(actorTO1.getFirstName()).isEqualToIgnoringCase("Marian");
        Assertions.assertThat(actorTO1.getLastName()).isEqualToIgnoringCase("Gałązka");
    }

    @Test
    public void shouldNotShowActorAndThrowNullPointerException() {
        //given
        ActorTO actorTO = new ActorTOBuilder().withFirstName("Marian").withLastName("Gałązka").build();

        //when
        try {
        ActorTO actorTO2 = actorService.showActor(785);
        }
        //then
        catch (Throwable expected) {
            assertEquals(NullPointerException.class, expected.getClass());
        }
    }

    @Test
    public void shouldEditActor() {
        //given
        ActorTO actorTO = new ActorTOBuilder().withFirstName("Marian").withLastName("Gałązka").build();
        actorService.addActor(actorTO);
        actorTO = new ActorTOBuilder().withFirstName("Wincenty").withLastName("Pień").build();

        //when
        actorService.editActor(actorTO);

        //then
        Assertions.assertThat(actorTO.getFirstName()).isEqualToIgnoringCase("Wincenty");
    }

    @Test
    public void shouldNotEditActorAndThrowNullPointerException() {
        // given
        ActorTO actorTO = new ActorTOBuilder().withFirstName("Marian").withLastName("Gałązka").build();
        actorService.addActor(actorTO);
        actorTO = null;

        //when
        try {
            actorService.editActor(actorTO);
        }
        //then
        catch (Throwable expected) {
            assertEquals(NullPointerException.class, expected.getClass());
        }
    }

    @Test
    public void shouldRemoveActor() {
        //given
        ActorTO actorTO = new ActorTOBuilder().withFirstName("Marian").withLastName("Gałązka").build();
        actorService.addActor(actorTO);
        ActorTO actorTO1 = new ActorTOBuilder().withFirstName("Olaf").withLastName("Biedronka").build();
        ActorTO actorTO2 = actorService.addActor(actorTO1);

        Integer id = actorTO2.getId();

        List<ActorTO> allActors = actorService.findAllActors();
        final int sizeBefore = allActors.size();

        //when
        actorService.removeActor(id);

        //then
        List<ActorTO> allAfter= actorService.findAllActors();
        final int sizeAfter = allAfter.size();
        Assertions.assertThat(sizeAfter).isEqualTo(sizeBefore-1);
    }

    @Test
    public void shouldNotRemoveActorAndThrowNullPointerException() {

        //when
        try {
            actorService.removeActor(987);
        }
        //then
        catch (Throwable expected) {
            assertEquals(NullPointerException.class, expected.getClass());
        }
    }

}
