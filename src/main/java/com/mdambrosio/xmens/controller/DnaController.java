/**
 * 
 */
package com.mdambrosio.xmens.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mdambrosio.xmens.dto.DnaListDTO;
import com.mdambrosio.xmens.exceptions.ForbiddenException;
import com.mdambrosio.xmens.service.DnaService;
import com.mdambrosio.xmens.service.IDna;
import com.mdambrosio.xmens.validation.CharacterConstraint;
import com.mdambrosio.xmens.validation.NxNMatrixConstraint;

/**
 * @author mdambrosio
 *
 */
@Validated
@RestController
@RequestMapping(value = "v1/api/mutant")
public class DnaController {

	private static final Logger logger = LogManager.getLogger(DnaController.class);

	@Autowired
	private IDna iDna;

	/**
	 * 
	 * <h1>isMutant( DnaListDTO dna )</h1> metodo encargado de recibir la cadena de
	 * dna y devolver si es un mutante o no.
	 * 
	 * @param dna
	 * @return ResponseEntity 200 OK si es mutante o un 403 FORBIDDEN si no lo es.
	 * @throws ForbiddenException
	 */
	@PostMapping()
	public ResponseEntity<?> isMutant(@RequestBody @CharacterConstraint @NxNMatrixConstraint DnaListDTO dna)
			throws ForbiddenException {

		((DnaService) iDna).isMutant(dna);

		return new ResponseEntity<Object>(HttpStatus.OK);

	}
}
