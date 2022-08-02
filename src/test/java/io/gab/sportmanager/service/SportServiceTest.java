package io.gab.sportmanager.service;

import io.gab.sportmanager.sport.model.Sport;
import io.gab.sportmanager.sport.model.SportRepository;
import io.gab.sportmanager.sport.service.SportService;
import io.gab.sportmanager.sport.service.SportServiceImpl;
import io.gab.sportmanager.util.TestUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class SportServiceTest {

    public SportRepository sportRepository;
    private final TestUtils utils = new TestUtils();
    private Sport expectedSport;

    @BeforeEach
    void setUp() throws IOException {
        sportRepository = mock(SportRepository.class);
        expectedSport = new Sport("Soccer", "World's famous sport","group", false, utils.convertFileToByte("images/soccerIcon.png"));
    }

    @Test
    void getAllSports() {
        given(sportRepository.findById(expectedSport.getId())).willReturn(Optional.of(expectedSport));
        SportService sportService = new SportServiceImpl(sportRepository);
        Sport actual = sportService.findById(expectedSport.getId()).get();
        System.out.println(expectedSport);
        Assertions.assertEquals(expectedSport, actual);
    }

}
