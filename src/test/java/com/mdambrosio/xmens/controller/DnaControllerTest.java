/**
 * 
 */
package com.mdambrosio.xmens.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.StandardCharsets;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mdambrosio.xmens.dto.DnaListDTO;
import com.mdambrosio.xmens.exceptions.ForbiddenException;
import com.mdambrosio.xmens.service.DnaService;

/**
 * @author mdambrosio
 *
 */
@RunWith(SpringRunner.class)
@WebMvcTest(DnaController.class)
public class DnaControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Mock
	private DnaController dnaController;

	@MockBean
	private DnaService dnaService;

	@Autowired
	private ObjectMapper objectMapper;

	@Test
	void testIsMutant() throws JsonProcessingException, Exception {

		final String[] cadenaDna = { "AAAAGA", "AAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TAACTG" };
		final String[] cadenaDnaHuman = { "AAGAGA", "AAGTGC", "TTCTGT", "AGAACG", "CTCCTA", "TAACTG" };

		final DnaListDTO dna = new DnaListDTO();
		final DnaListDTO dnaHuman = new DnaListDTO();

		dna.setDna(cadenaDna);
		dnaHuman.setDna(cadenaDnaHuman);

		when(dnaController.isMutant(dnaHuman)).thenThrow(new ForbiddenException());

		this.mockMvc
				.perform(post("/v1/api/mutant").contentType(MediaType.APPLICATION_JSON)
						.characterEncoding(StandardCharsets.UTF_8.name()).content(objectMapper.writeValueAsBytes(dna)))

				.andExpect(status().isOk());
	}

}
