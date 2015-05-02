package frameworkmvc.vista;

import frameworkmvc.controlador.*;
import frameworkmvc.modelo.*;

import java.util.Observer;

public abstract class Vista implements Observer 
{
	Modelo modelo;
	Controlador controlador;
	
	public Vista(Modelo mod) 
	{
		modelo = mod;
		mod.addObserver(this);
	}
	
	public void addControlador(Controlador cp)
	{
		controlador = cp;
	}
	
	public Modelo getModelo() 
	{
		return modelo;
	}
	
	public Controlador getControlador() 
	{
		return controlador;
	}
}
