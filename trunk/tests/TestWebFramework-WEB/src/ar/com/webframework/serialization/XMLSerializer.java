package ar.com.webframework.serialization;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class XMLSerializer implements ISerializer {

	@Override
	public void serialize(HttpServletRequest request, HttpServletResponse response, Map<String, Object> model) throws IOException{
//		ServletOutputStream outputStream = response.getOutputStream();
//		XMLEncoder enc = new XMLEncoder(outputStream);
//		enc.writeObject(model);
//		enc.flush();
//		outputStream.flush();
		
//		XStream x = new XStream();
//		x.toXML(outputStream);
//		outputStream.flush();
	}

}
