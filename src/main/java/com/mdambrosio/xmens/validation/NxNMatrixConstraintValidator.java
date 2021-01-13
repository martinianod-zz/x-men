/**
 * 
 */
package com.mdambrosio.xmens.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.mdambrosio.xmens.dto.DnaListDTO;

/**
 * @author mdambrosio
 *
 */
public class NxNMatrixConstraintValidator implements ConstraintValidator<NxNMatrixConstraint, DnaListDTO> {

	@Override
	public boolean isValid(DnaListDTO values, ConstraintValidatorContext context) {

		// Valida si la matriz es de [N x N ] elementos.
		if (values.getDna().length != values.getDna()[0].length())
			return false;

		return true;

	}

}
