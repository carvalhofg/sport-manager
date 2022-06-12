package io.gab.sportmanager.service;

import io.gab.sportmanager.sport.model.Sport;
import io.gab.sportmanager.sport.model.SportDTO;
import io.gab.sportmanager.sport.model.SportRepository;
import io.gab.sportmanager.sport.service.SportService;
import io.gab.sportmanager.util.TestUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.Optional;


@RunWith(SpringRunner.class)
@SpringBootTest
class SportServiceTest {

    @Autowired
    public SportRepository sportRepository;

    @Autowired
    TestUtils testUtils;

    @AfterEach
    void tearDown() {
        sportRepository.deleteAll();
    }

    @Test
    void getAllSports() {
        Sport sportSample = new Sport("Futebol", "Esporte mais famoso","Grupo", false);
        sportRepository.save(sportSample);
        SportService sportService = new SportService(sportRepository);

        Sport firstResult = sportService.findAll().get(0);

        Assertions.assertEquals(sportSample.getDescription(), firstResult.getDescription());
        Assertions.assertEquals(sportSample.getGroupType(), firstResult.getGroupType());
        Assertions.assertEquals(sportSample.getIsSport(), firstResult.getIsSport());
    }

    @Test
    void getOneSport() throws IOException {
        byte[] file1 = testUtils.convertFileToByte("images/soccerIcon.png");
        Sport sportSample = new Sport(2L, "Futebol","Esporte mais famoso do mundo", "Grupo", true, file1);
        sportRepository.save(sportSample);
        SportService sportService = new SportService(sportRepository);

        Optional<Sport> sport = sportService.findById(2L);
        Assertions.assertTrue(sport.isPresent());
        Assertions.assertEquals(sportSample.getDescription(), sport.get().getDescription());
        Assertions.assertEquals(sportSample.getGroupType(), sport.get().getGroupType());
        Assertions.assertEquals(sportSample.getIsSport(), sport.get().getIsSport());
    }

    @Test
    void saveSport() {
        SportService sportService = new SportService(sportRepository);
        SportDTO sport = new SportDTO("Futebol", "Esporte mais famoso","Grupo", false);

        sportService.save(sport);

        Assertions.assertEquals(1.0, sportRepository.count(), 0);
    }
}
