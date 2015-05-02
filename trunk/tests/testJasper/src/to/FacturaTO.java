package to;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class FacturaTO implements Serializable {

	private static final long serialVersionUID = 4909109560343000452L;

	private BigDecimal monto;
	private List<ItemFacturaTO> items;
	
	public FacturaTO(){
		items = new ArrayList<ItemFacturaTO>();
	}

	public BigDecimal getMonto() {
		return monto;
	}

	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}

	public List<ItemFacturaTO> getItems() {
		return items;
	}

	public void setItems(List<ItemFacturaTO> items) {
		this.items = items;
	}
}
