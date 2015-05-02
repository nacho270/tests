package ar.com.webframework.controller.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import ar.com.webframework.controller.ControllerInputData;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Controller {
	String name();
	boolean requiresSession() default false;
	Class<? extends ControllerInputData> inputData();
	ControllerOutput output();
}
