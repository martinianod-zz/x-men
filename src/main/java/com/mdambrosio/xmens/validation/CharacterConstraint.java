package com.mdambrosio.xmens.validation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = CharacterConstraintValidator.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface CharacterConstraint {

	String message() default "Las cadenas de DNA deben contener solamente los siguientes caracteres válidos: [A,T,C,G]";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}
