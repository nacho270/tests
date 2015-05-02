package ar.com.webframework.controller;

import java.util.Map;

public abstract class AbstractBrokerController <T extends ControllerInputData> extends AbstractController<T>{

	public void execute(Map<String, Object> model, T controllerInputData){}
	public abstract int logic(Map<String, Object> model, T controllerInputData);

}
