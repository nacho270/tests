package ar.com.webframework.serialization;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

public class JSONSerializer implements ISerializer {

	@Override
	public void serialize(HttpServletRequest request, HttpServletResponse response, Map<String, Object> model) throws IOException {
		Gson g = new Gson();
		String json = g.toJson(model);
		ServletOutputStream outputStream = response.getOutputStream();
		outputStream.write(json.getBytes(Charset.defaultCharset()));
		outputStream.flush();
	}

}
