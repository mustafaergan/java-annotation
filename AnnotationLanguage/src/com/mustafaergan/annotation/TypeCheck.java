package com.mustafaergan.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface TypeCheck {
	enum Type {INT,DATE,STRING}
}
