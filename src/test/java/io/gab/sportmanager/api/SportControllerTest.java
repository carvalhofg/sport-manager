package io.gab.sportmanager.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.gab.sportmanager.sport.controller.SportController;
import io.gab.sportmanager.sport.model.Sport;
import io.gab.sportmanager.sport.model.SportDTO;
import io.gab.sportmanager.sport.service.SportService;
import io.gab.sportmanager.util.TestUtils;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest
@ContextConfiguration(classes = {SportService.class, SportController.class, TestUtils.class})
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class SportControllerTest {

	@Autowired
	MockMvc mockMvc;

	@Autowired
	TestUtils testUtils;

	@MockBean
	SportService sportService;

	@Test
	@Order(1)
	void getAllSports() throws Exception {
		List<Sport> sportList = new ArrayList<>();

		byte[] file1 = testUtils.convertFileToByte("images/soccerIcon.png");
		byte[] file2 = testUtils.convertFileToByte("images/volleyIcon.png");

		sportList.add(new Sport(1L, "Futebol","Esporte mais famoso do mundo", "Grupo", true, file1));
		sportList.add(new Sport(2L, "V??lei de quadra","Esporte de quadra", "Grupo", true, file2));

		when(sportService.findAll()).thenReturn(sportList);

		mockMvc.perform(MockMvcRequestBuilders.get("/sport").contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$", hasSize(2)));
	}

	@Test
	@Order(2)
	void createSport() throws Exception {
		byte[] file = testUtils.convertFileToByte("images/soccerIcon.png");

		Sport sport = new Sport(1L, "T??nis","Esporte com raquetes", "Both", true, file);

		when(sportService.save(any(SportDTO.class))).thenReturn(sport);

		ObjectMapper mapper = new ObjectMapper();
		String sportJson = mapper.writeValueAsString(sport);

		ResultActions result = mockMvc.perform(MockMvcRequestBuilders.post("/sport").contentType(MediaType.APPLICATION_JSON).content(sportJson));

		result.andExpect(status().isCreated())
				.andExpect(jsonPath("$.title").value("T??nis"))
				.andExpect(jsonPath("$.description").value("Esporte com raquetes"))
				.andExpect(jsonPath("$.groupType").value("Both"))
				.andExpect(jsonPath("$.isSport").value(true))
				.andExpect(jsonPath("$.sportIcon").isNotEmpty());
	}

	@Test
	@Order(3)
	void getOneSport() throws Exception {

		byte[] file1 = testUtils.convertFileToByte("images/soccerIcon.png");
		Sport sport = new Sport(1L, "Futebol","Esporte mais famoso do mundo", "Grupo", true, file1);

		when(sportService.findById(sport.getId())).thenReturn(Optional.of(sport));

		mockMvc.perform(MockMvcRequestBuilders.get("/sport/1").contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.title").value("Futebol"))
				.andExpect(jsonPath("$.description").value("Esporte mais famoso do mundo"))
				.andExpect(jsonPath("$.groupType").value("Grupo"))
				.andExpect(jsonPath("$.isSport").value(true))
				.andExpect(jsonPath("$.sportIcon").isNotEmpty());
	}
}
