package com.nacho.tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class TestTag extends SimpleTagSupport {
	private String prefijo;
	private String sufijo;

	@Override
	public void doTag() throws JspException, IOException {
		getJspContext().getOut().write(getPrefijo() + " cuerpooo " + getSufijo());
	}
	
	public String getPrefijo() {
		return prefijo;
	}

	public void setPrefijo(String prefijo) {
		this.prefijo = prefijo;
	}

	public String getSufijo() {
		return sufijo;
	}

	public void setSufijo(String sufijo) {
		this.sufijo = sufijo;
	}
}
