package com.nacho.struts2.actions;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

@Namespace(value="/")
@Action(value="saludo", results={@Result(name="success", location="/index.jsp")})
public class TestAction extends ActionSupport {

	private static final long serialVersionUID = 5596200658669534170L;
	
	private String mensaje;

	@Override
	public String execute() {
		mensaje = "Hola isabel";

		return SUCCESS;
	}

	public String getMensaje() {
		return mensaje;
	}

}
