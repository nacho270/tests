package dialogomvc;

import java.awt.Frame;
import java.util.Observable;

import javax.swing.JDialog;

public abstract class JDialogMVC<C extends ControladorDialogo, M extends ModeloDialogo> extends JDialog{

	private C controlador;
	private M modelo;
	
	private static final long serialVersionUID = 2930044728987669799L;

	public abstract void update(Observable o, Object arg);
	
	protected JDialogMVC(Frame padre, C controlaror, M modelo){
		super(padre);
		setControlador(controlaror);
		setModelo(modelo);
	}
	
	public C getControlador() {
		return controlador;
	}

	public void setControlador(C controlador) {
		this.controlador = controlador;
	}

	
	public M getModelo() {
		return modelo;
	}

	
	public void setModelo(M modelo) {
		this.modelo = modelo;
	}

	
}
