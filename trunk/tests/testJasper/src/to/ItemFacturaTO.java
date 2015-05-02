package to;

import java.io.Serializable;
import java.math.BigDecimal;

public class ItemFacturaTO implements Serializable {

	private static final long serialVersionUID = -3290822577974290984L;

	private BigDecimal precioUnitario;
	private String descripcion;

	public BigDecimal getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(BigDecimal precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
