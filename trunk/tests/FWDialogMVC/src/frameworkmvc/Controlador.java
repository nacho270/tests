package frameworkmvc;

@SuppressWarnings("rawtypes")
public abstract class Controlador<V extends Vista, M extends Modelo> {
	private final V vista;
	private final M modelo;

	@SuppressWarnings("unchecked")
	protected Controlador(M mod, V vis) {
		vista = vis;
		modelo = mod;
		vista.addControlador(this);
	}

	public M getModelo() {
		return modelo;
	}

	public V getVista() {
		return vista;
	}
}
