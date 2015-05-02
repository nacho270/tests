package ar.com.testwebframework.controllers;

import java.util.Map;

import ar.com.webframework.controller.AbstractBrokerController;
import ar.com.webframework.controller.annotations.Controller;
import ar.com.webframework.controller.annotations.ControllerOutput;
import ar.com.webframework.controller.annotations.ControllerOutputType;
import ar.com.webframework.controller.annotations.EReturnPageMethod;
import ar.com.webframework.controller.annotations.ReturnPage;

@Controller(name="broker",inputData=ControllerInputTest.class,
			output=@ControllerOutput(outputType=ControllerOutputType.WEB,
					returnPages={
						@ReturnPage(code=1,page="html/b1.html",returnMethod=EReturnPageMethod.FORWARD),
						@ReturnPage(code=2,page="html/b2.html",returnMethod=EReturnPageMethod.REDIRECT)
					})
)
public class TestBrokerController extends AbstractBrokerController<ControllerInputTest> {

	@Override
	public int logic(Map<String, Object> model, ControllerInputTest controllerInputData) {
		return 2;
	}
}
