package test;

import dialogomvc.ControladorDialogo;
import dialogomvc.ModeloDialogo;
import dialogomvc.VistaDialogoMVC;

public class ControladorDialogoAlgo extends ControladorDialogo {

	protected ControladorDialogoAlgo(ModeloDialogo mod, VistaDialogoMVC vis) {
		super(mod, vis);
	}

	public void aumentarContador() {
		((ModeloDialogoAlgo) getModelo()).setContador(((ModeloDialogoAlgo) getModelo()).getContador() + 1);
		getModelo().notifyObservers();
	}
}
