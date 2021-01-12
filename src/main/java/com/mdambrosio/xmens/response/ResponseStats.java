package com.mdambrosio.xmens.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mdambrosio.xmens.dto.StatsDTO;

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
public class ResponseStats {
	
		@JsonProperty("ADN")
		private StatsDTO stats_dto;

}
