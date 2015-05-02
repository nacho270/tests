package ar.com.webframework.controller.annotations;

public @interface ControllerOutput {
	String outputType();
	ReturnPage[] returnPages() default {};
}
