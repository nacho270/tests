package ar.com.webframework.controller;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.http.HttpServletRequest;

import ar.com.webframework.controller.annotations.Parameter;

public class EvaluatorHelper {
	
	@SuppressWarnings("unchecked")
	public static <T> T doEval(HttpServletRequest request, Parameter p, Class<T> clazz) {
		if(!p.fromSession()){
			String parameter = request.getParameter(p.parameterName());
			return clazz.cast(getValue(clazz, parameter));
		}
		return (T) request.getSession().getAttribute(p.parameterName());
	}

	@SuppressWarnings("unchecked")
	public static <T> T getValue(Class<T> parameterClass, String value) {
		if (String.class.equals(parameterClass)) {
			return (T)value;
		}
		try {
			Constructor<T> constructor = parameterClass.getConstructor(String.class);
			return constructor.newInstance(value);
		} catch (NoSuchMethodException ignored) {
		} catch (IllegalArgumentException ignored) {
		} catch (InstantiationException ignored) {
		} catch (IllegalAccessException ignored) {
		} catch (InvocationTargetException ignored) {
		}
		return null;
	}
}
