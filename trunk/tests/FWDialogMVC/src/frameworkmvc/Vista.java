package frameworkmvc;

import java.util.Observer;

@SuppressWarnings("rawtypes")
public abstract class Vista<C extends Controlador> implements Observer {
	private C controlador;

	public Vista(Modelo mod) {
		mod.addObserver(this);
	}

	public void addControlador(C cp) {
		controlador = cp;
	}
	
	public C getControlador() {
		return controlador;
	}
}
