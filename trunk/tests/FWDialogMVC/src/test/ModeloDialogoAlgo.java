package test;

import dialogomvc.ModeloDialogo;

public class ModeloDialogoAlgo extends ModeloDialogo{

	private Integer contador;

	public ModeloDialogoAlgo() {
		contador = 0;
	}


	public Integer getContador() {
		return contador;
	}

	
	public void setContador(Integer contador) {
		this.contador = contador;
		setChanged();
	}
}
