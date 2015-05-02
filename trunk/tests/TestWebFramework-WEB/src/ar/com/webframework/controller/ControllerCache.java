package ar.com.webframework.controller;

import java.io.File;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;

import ar.com.webframework.controller.annotations.Controller;

public class ControllerCache {

	private static final Map<String, AbstractController<? extends ControllerInputData>> controllerCache = new ConcurrentHashMap<String, AbstractController<? extends ControllerInputData>>();
	private static final ControllerCache instance = new ControllerCache();

	public static ControllerCache getInstance() {
		return instance;
	}

	private ControllerCache() {}

	@SuppressWarnings("unchecked")
	public void loadActions(String xmlPath) {
		try{
			SAXBuilder builder = new SAXBuilder();
			File xmlFile = new File(xmlPath);
			Document document = (Document) builder.build(xmlFile);
			Element rootNode = document.getRootElement();
			Element child = rootNode.getChild("actions-package");
			String actionsPackage = child.getText();
			Class<?>[] classes = ControllerClassLoader.getClasses(actionsPackage);
			for(Class<?> cl : classes){
				String name = cl.getAnnotation(Controller.class).name();
				controllerCache.put(name+".do", (AbstractController<? extends ControllerInputData>) cl.newInstance());
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public AbstractController<? extends ControllerInputData> getController(String controller) {
		return controllerCache.get(controller);
	}
}
