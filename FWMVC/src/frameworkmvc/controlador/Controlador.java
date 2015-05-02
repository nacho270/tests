package frameworkmvc.controlador;

import frameworkmvc.modelo.*;
import frameworkmvc.vista.*;

public abstract class Controlador 
{
	Vista vista;
	Modelo modelo;
	
	protected Controlador(Modelo mod, Vista vis) 
	{
		vista = vis;
		modelo = mod;
		vista.addControlador(this);
	}

	public Modelo getModelo() 
	{
		return modelo;
	}
	
	public Vista getVista() 
	{
		return vista;
	}
}
