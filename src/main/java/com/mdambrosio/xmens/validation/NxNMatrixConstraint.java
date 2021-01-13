/**
 * 
 */
package com.mdambrosio.xmens.validation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * @author mdambrosio
 *
 */
@Constraint(validatedBy = NxNMatrixConstraintValidator.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface NxNMatrixConstraint {

	String message() default "La matriz o tabla que se forma debe ser de [ N x N ].";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}
