package dialogomvc;

import java.util.Observable;

import frameworkmvc.Vista;

public class VistaDialogoMVC extends Vista<ControladorDialogo>{

	private JDialogMVC<? extends ControladorDialogo,? extends  ModeloDialogo> dialogo;
	
	public VistaDialogoMVC(ModeloDialogo mod) {
		super(mod);
	}

	public void update(Observable o, Object arg) {
		dialogo.update(o, arg);
	}

	
	public JDialogMVC<? extends ControladorDialogo,? extends  ModeloDialogo> getDialogo() {
		return dialogo;
	}

	
	public void setDialogo(JDialogMVC<? extends ControladorDialogo,? extends  ModeloDialogo> dialogo) {
		this.dialogo = dialogo;
	}
}
