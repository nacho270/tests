package ar.com.webframework.controller;

import java.util.Map;

public abstract class AbstractController<T extends ControllerInputData> {

	public abstract void execute(Map<String, Object> model, T controllerInputData);

}
