/**
 * 
 */
package com.mdambrosio.xmens.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author mdambrosio
 *
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class StatsDTO {

	@JsonProperty("count_mutant_dna")
	private Integer count_mutant_dna;

	@JsonProperty("count_human_dna")
	private Integer count_human_dna;

	@JsonProperty("ratio")
	private Double ratio;

}
