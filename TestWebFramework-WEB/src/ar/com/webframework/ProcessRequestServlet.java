package ar.com.webframework;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.com.webframework.controller.AbstractBrokerController;
import ar.com.webframework.controller.AbstractController;
import ar.com.webframework.controller.ControllerCache;
import ar.com.webframework.controller.ControllerInputData;
import ar.com.webframework.controller.EvaluatorHelper;
import ar.com.webframework.controller.annotations.Controller;
import ar.com.webframework.controller.annotations.ControllerOutput;
import ar.com.webframework.controller.annotations.ControllerOutputType;
import ar.com.webframework.controller.annotations.EReturnPageMethod;
import ar.com.webframework.controller.annotations.Parameter;
import ar.com.webframework.controller.annotations.ReturnPage;
import ar.com.webframework.serialization.SerializerCache;

public class ProcessRequestServlet extends HttpServlet {

	private static final long serialVersionUID = 8719613405979431381L;
//	private static final Logger logger = Logger.getLogger(ProcessRequestServlet.class);
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AbstractController controller = ControllerCache.getInstance().getController(request.getRequestURI().replaceAll(request.getContextPath(), "").replaceAll("/", ""));
		Controller controllerAnnotation = controller.getClass().getAnnotation(Controller.class);
		ControllerOutput controllerOutput = controllerAnnotation.output();
		if(controllerOutput == null){
			return;
		}
		if(controllerAnnotation.requiresSession()){
			if(request.getSession(false) == null){
				return;
			}
		}
		ControllerInputData instance = createInputData(request, controllerAnnotation);
		Map<String, Object> model = getModel(request);
		if(controller instanceof AbstractBrokerController){
			if(!controllerOutput.outputType().equals(ControllerOutputType.WEB)){
				return;
			}
			ReturnPage[] returnPages = controllerOutput.returnPages();
			if(returnPages==null || returnPages.length == 0){
				return;
			}
			AbstractBrokerController brokerController = (AbstractBrokerController)controller;
			int returnCode = brokerController.logic(model, instance);
			doResponse(returnCode,returnPages,request, response);
		}else{
			if(controllerOutput.outputType().equals(ControllerOutputType.WEB)){
				return;
			}
			controller.execute(model, instance);
			SerializerCache.getSerializer(controllerOutput.outputType()).serialize(request, response, model);
		}
		
//		Parameter[] parameters = controllerAnnotation.parameters();
//		List<ParameterData<?>> lista = new ArrayList<ParameterData<?>>();
//		for(Parameter p : parameters){
//			if(p.fromSession() && (request.getSession(false) == null || request.getSession().getAttribute(p.name())==null)){
//				
//				continue;
//			}
//			Object doEval = EvaluatorHelper.doEval(request, p, p.parameterClass());
//			ParameterData<?> pd = new ParameterData<Object>(p.name(), doEval);
//			lista.add(pd);
//		}
//		ParameterData<?>[] paramArray = new ParameterData<?>[lista.size()];
//		System.arraycopy(lista.toArray(), 0, paramArray, 0, lista.size());
//		controller.execute(getModel(request),new ControllerInputData(paramArray));
	}


	private void doResponse(int returnCode, ReturnPage[] returnPages, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		for(ReturnPage rp : returnPages){
			if(rp.code() == returnCode){
				if(rp.returnMethod() == EReturnPageMethod.FORWARD){
					request.getRequestDispatcher(rp.page()).forward(request, response);
					break;
				}else{
					response.sendRedirect(rp.page());
					break;
				}
			}
		}
	}

	private ControllerInputData createInputData(HttpServletRequest request, Controller controllerAnnotation) throws ServletException {
		ControllerInputData instance;
		try {
			instance = controllerAnnotation.inputData().newInstance();
			Field[] declaredFields = instance.getClass().getDeclaredFields();
			for(Field field : declaredFields){
				Parameter p = field.getAnnotation(Parameter.class);
				if(p==null){
					continue;
				}
				if(p.fromSession() && (request.getSession(false) == null || request.getSession().getAttribute(p.parameterName())==null)){
					continue;
				}
				field.setAccessible(true);
				field.set(instance, EvaluatorHelper.doEval(request, p, field.getType()));
			}
			return instance;
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		throw new ServletException();
	}

	@SuppressWarnings("unchecked")
	private Map<String, Object> getModel(HttpServletRequest request) {
		if (request.getAttribute("data") == null) {
			request.setAttribute("data", new HashMap<String, Object>());
		}
		return (Map<String, Object>) request.getAttribute("data");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
}
