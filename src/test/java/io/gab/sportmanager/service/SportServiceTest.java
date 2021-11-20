package io.gab.sportmanager.service;

import io.gab.sportmanager.sport.model.Sport;
import io.gab.sportmanager.sport.model.SportRepository;
import io.gab.sportmanager.sport.service.SportService;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class SportServiceTest {

    @Autowired
    public SportRepository sportRepository;

    @AfterEach
    void tearDown() {
        sportRepository.deleteAll();
    }

    @Test
    public void getAllSports() {
        Sport sportSample = new Sport("Futebol", "Esporte mais famoso","Grupo", false);
        sportRepository.save(sportSample);
        SportService sportService = new SportService(sportRepository);

        Sport firstResult = sportService.findAll().get(0);

        Assertions.assertEquals(sportSample.getDescription(), firstResult.getDescription());
        Assertions.assertEquals(sportSample.getGroupType(), firstResult.getGroupType());
        Assertions.assertEquals(sportSample.getIsSport(), firstResult.getIsSport());
    }

    @Test
    public void saveSport() {
        SportService sportService = new SportService(sportRepository);
        Sport sport = new Sport("Futebol", "Esporte mais famoso","Grupo", false);

        sportService.save(sport);

        Assertions.assertEquals(1.0, sportRepository.count(), 0);
    }
}
