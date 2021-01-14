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
public class DnaListDTO {

	@JsonProperty("dna")
	private String[] dna;

}
