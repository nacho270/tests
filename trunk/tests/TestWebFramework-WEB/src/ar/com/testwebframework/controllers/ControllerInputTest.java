package ar.com.testwebframework.controllers;

import ar.com.webframework.controller.ControllerInputData;
import ar.com.webframework.controller.annotations.Parameter;

public class ControllerInputTest implements ControllerInputData {

	@Parameter(fromSession=false,nullable=false,parameterName="nombre")
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
