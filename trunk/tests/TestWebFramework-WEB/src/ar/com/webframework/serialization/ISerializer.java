package ar.com.webframework.serialization;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ISerializer {
	public void serialize(HttpServletRequest request, HttpServletResponse response, Map<String, Object> model) throws IOException;
}
