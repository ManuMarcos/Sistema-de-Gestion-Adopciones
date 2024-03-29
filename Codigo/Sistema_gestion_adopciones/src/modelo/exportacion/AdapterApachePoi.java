package modelo.exportacion;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import config.Config;

public class AdapterApachePoi implements IAdapterExportacionExcel{

	private String nombreArchivo;
	private XSSFWorkbook workbook;
	
	public AdapterApachePoi(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}
	
	@Override
	public String exportar(IExportable exportable) {
		// TODO Auto-generated method stub
		crearLibroDeTrabajo();
		XSSFSheet hoja = crearHoja("Hoja1");
		agregarDatos(hoja, exportable.datos());
		guardar();
		return rutaCompletaArchivo();
	}

	private void guardar() {
			FileOutputStream outputStream;
			try {
				outputStream = new FileOutputStream(rutaCompletaArchivo());
				workbook.write(outputStream);
				workbook.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	private String rutaCompletaArchivo() {
		return Config.RUTA_EXPORTACION + this.nombreArchivo + ".xlsx";
	}
	
	private void crearLibroDeTrabajo() {
		this.workbook = new XSSFWorkbook();
	}
	
	private XSSFSheet crearHoja(String nombre) {
		return workbook.createSheet(nombre);
	}
	
	private void agregarDatos(XSSFSheet hoja, Map<String, List<String>> datos) {
		int numeroDeFila = 0;
		
		for (Map.Entry<String, List<String>> entry : datos.entrySet()) {
			List<String> valores = entry.getValue();
			Row fila = crearFila(hoja, numeroDeFila);
			numeroDeFila++;
			agregarColumna(valores, fila, hoja);
		}
			
	}
	

	private Row crearFila(XSSFSheet hoja, int numeroDeFila) {
		return hoja.createRow(numeroDeFila);
	}
	
	private void agregarColumna(List<String> valores, Row fila, XSSFSheet hoja) {
		int numeroDeColumna = 0;
		for (String v : valores) {
			Cell celda = fila.createCell(numeroDeColumna);
			numeroDeColumna++;
			celda.setCellValue(v);
		}
	}
	
	
}
