package test;


public class Test {

	public static void main(String[] args) {
		ModeloDialogoAlgo modelo = new ModeloDialogoAlgo();
		VistaDialogoAlgo vista = new VistaDialogoAlgo(modelo);
		ControladorDialogoAlgo controlador = new ControladorDialogoAlgo(modelo, vista);
		DialogoAlgo d = new DialogoAlgo(null, controlador, modelo);
		vista.setDialogo(d);
		d.setVisible(true);
	}
}
