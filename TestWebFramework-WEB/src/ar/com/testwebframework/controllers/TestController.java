package ar.com.testwebframework.controllers;

import java.util.Map;

import ar.com.webframework.controller.AbstractController;
import ar.com.webframework.controller.annotations.Controller;
import ar.com.webframework.controller.annotations.ControllerOutput;
import ar.com.webframework.controller.annotations.ControllerOutputType;

@Controller(inputData=ControllerInputTest.class,name="test",requiresSession=false,output=@ControllerOutput(outputType=ControllerOutputType.JSON))
public class TestController extends AbstractController<ControllerInputTest>{

	@Override
	public void execute(Map<String, Object> model, ControllerInputTest controllerInputData) {
		model.put("paaaaa", controllerInputData.getName());
	}

}
