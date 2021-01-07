/**
 * 
 */
package com.mdambrosio.xmens.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

/**
 * @author mdambrosio
 *
 */
@ResponseStatus(value = HttpStatus.FORBIDDEN, reason = "is not a Mutant, i'm sorry.")
public class ForbiddenException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3141151097865781197L;

}
