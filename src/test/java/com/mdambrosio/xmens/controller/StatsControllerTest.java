/**
 * 
 */
package com.mdambrosio.xmens.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.mdambrosio.xmens.dto.StatsDTO;
import com.mdambrosio.xmens.service.IDna;
import com.mdambrosio.xmens.service.StatsService;

/**
 * @author mdambrosio
 *
 */
@RunWith(SpringRunner.class)
@WebMvcTest(StatsController.class)
public class StatsControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private StatsService statsService;

	@Test
	void testIsMutant() throws Exception {

		StatsDTO statsDTO = new StatsDTO();
		statsDTO.setCount_human_dna(2);
		statsDTO.setCount_mutant_dna(1);
		statsDTO.setRatio(0.5);

		given(statsService.getStats()).willReturn(statsDTO);

		this.mockMvc.perform(get("/v1/api/stats")).andExpect(status().isOk())
				.andExpect(jsonPath("$.count_mutant_dna", is(statsDTO.getCount_mutant_dna())))
				.andExpect(jsonPath("$.count_human_dna", is(statsDTO.getCount_human_dna())))
				.andExpect(jsonPath("$.ratio", is(statsDTO.getRatio())));
		;

	}

}
