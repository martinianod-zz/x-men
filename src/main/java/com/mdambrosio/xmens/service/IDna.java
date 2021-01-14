package com.mdambrosio.xmens.service;

import com.mdambrosio.xmens.dto.DnaListDTO;
import com.mdambrosio.xmens.exceptions.ForbiddenException;

/**
 * @author mdambrosio
 *
 */
public interface IDna {
	
	void isMutant(DnaListDTO dna) throws ForbiddenException;

}
