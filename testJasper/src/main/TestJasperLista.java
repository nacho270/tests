package main;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

import to.FacturaTO;
import to.ItemFacturaTO;

public class TestJasperLista {
	
	public TestJasperLista() throws JRException{
		FacturaTO facturaTO = getFacturaTO();
		Map parameters = new HashMap();
		//parameters.put("ITEMS", facturaTO.getItems());
		parameters.put("MONTO", facturaTO.getMonto());
		net.sf.jasperreports.engine.JasperReport relatoriosJasper = null;  
		// defino o caminho do report - arquivo jasper              
		relatoriosJasper = (JasperReport)JRLoader.loadObject(this.getClass().getResourceAsStream("/main/testlista.jasper"));
//		List<String> singletonList = Collections.singletonList("nacho capo");
		//parameters.put("FECHA", new java.util.Date());
		//InputStream is = this.getClass().getResourceAsStream("/main/testfactura.jrxml");
		//JasperReport report = JasperCompileManager.compileReport(is);
		System.out.println("lleno");
		JasperPrint print = JasperFillManager.fillReport(relatoriosJasper, parameters,new JRBeanCollectionDataSource(facturaTO.getItems()));
		System.out.println("fin lleno. Exporto");
		// Exporta el informe a PDF
		JasperExportManager.exportReportToPdfFile(print, "test.pdf");
		System.out.println("fin exporto");
		// Para visualizar el pdf directamente desde java
		JasperViewer.viewReport(print, false);
		
	}

	private FacturaTO getFacturaTO() {
		FacturaTO facto = new FacturaTO();
		facto.setMonto(new BigDecimal(200.5f));
		ItemFacturaTO it1 = new ItemFacturaTO();
		it1.setDescripcion("item 1");
		it1.setPrecioUnitario(new BigDecimal(100f));
		facto.getItems().add(it1);
		it1= new ItemFacturaTO();
		it1.setDescripcion("item 10000");
		it1.setPrecioUnitario(new BigDecimal(500f));
		facto.getItems().add(it1);
		return facto;
	}
	
	public static void main(String[] args){
		try {
			new TestJasperLista();
		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
