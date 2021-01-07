/**
 * 
 */
package com.mdambrosio.xmens.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

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
@Entity(name = "DNA")
public class Dna {

	@Id
	@Column(name = "DNA")
	private String dna;

	@Column(name = "IS_MUTANT")
	private Boolean isMutant;

}
