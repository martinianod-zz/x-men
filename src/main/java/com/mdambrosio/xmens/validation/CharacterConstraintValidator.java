/**
 * 
 */
package com.mdambrosio.xmens.validation;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.mdambrosio.xmens.dto.DnaListDTO;

/**
 * @author marti
 *
 */
public class CharacterConstraintValidator implements ConstraintValidator<CharacterConstraint, DnaListDTO> {
	@Override
	public boolean isValid(DnaListDTO values, ConstraintValidatorContext context) {

		List<String> list = Arrays.asList(values.getDna());

		// Valida si contiene solo los caracteres [A, T, C, G]
		for (String cadena : list) {
			Pattern my_pattern = Pattern.compile("[^atcg]", Pattern.CASE_INSENSITIVE);
			Matcher my_match = my_pattern.matcher(cadena);
			if (my_match.find())
				return false;
		}

		return true;

	}
}
