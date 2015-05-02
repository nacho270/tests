package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class TestJasper {

	public TestJasper(){
		try {
			Map parameters = new HashMap();
			parameters.put("ID_FACTURA", 3);
			Connection con = this.getConnection();
			
			net.sf.jasperreports.engine.JasperReport relatoriosJasper = null;  
			// defino o caminho do report - arquivo jasper              
			relatoriosJasper = (JasperReport)JRLoader.loadObject(this.getClass().getResourceAsStream("/main/testfactura.jasper"));
//			List<String> singletonList = Collections.singletonList("nacho capo");
			//parameters.put("FECHA", new java.util.Date());
			//InputStream is = this.getClass().getResourceAsStream("/main/testfactura.jrxml");
			//JasperReport report = JasperCompileManager.compileReport(is);
			System.out.println("lleno");
			JasperPrint print = JasperFillManager.fillReport(relatoriosJasper, parameters,con);
			System.out.println("fin lleno. Exporto");
			// Exporta el informe a PDF
			JasperExportManager.exportReportToPdfFile(print, "test.pdf");
			System.out.println("fin exporto");
			// Para visualizar el pdf directamente desde java
			JasperViewer.viewReport(print, false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private Connection getConnection() {
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/gtl","root","nacho");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) {
		new TestJasper();
	}
}
