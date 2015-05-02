package ar.com.webframework.controller.annotations;

public @interface ReturnPage {
	int code();
	String page();
	EReturnPageMethod returnMethod();
}
