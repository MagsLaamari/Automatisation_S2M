package traitement;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class NouveauBin {
	
		private static String cheminFichier = "/Users/majda/eclipse-workspace/Automatisation_Take1/src/main/resources/New_Bin_1.xlsx";
		private ArrayList<String> binInformation = new ArrayList<>();
		private static ArrayList<ArrayList<String>> allValues = new ArrayList<>();
		private InputStream input = null;
	    private Properties prop = new Properties();
	    
	    
		
	public  ArrayList<ArrayList<String>> getAllValues() {
			return allValues;
		}

	
	public NouveauBin( ) throws IOException {
		input = new FileInputStream("/Users/majda/eclipse-workspace/Automatisation_Take1/src/test/resources/connection.properties");
		prop.load(input);
		//Configuration du driver google chrome
		cheminFichier = prop.getProperty("cheminFichierNewBin");
		this.binInformation =  new ArrayList<String>();	
		
	}
	
	private static String CellValueToString(Cell cell) {
		String typeCell = cell.getCellTypeEnum().toString();
		String cellValue ="";
		if(typeCell.equals("STRING")) {
			cellValue = cell.getStringCellValue();
			System.out.println("valeur de cel = " + cellValue);
		}else if(typeCell.equals("NUMERIC")) {
			cellValue = String.valueOf((int) cell.getNumericCellValue());
			System.out.println("valeur de cel = " + cellValue);
		}
		return cellValue;
	}

	public  void readAllXslxFile(String fileName) throws IOException {
		FileInputStream inputStream = new FileInputStream(new File(fileName)); 
		Workbook workbook = new XSSFWorkbook(inputStream);
		Sheet firstSheet = workbook.getSheetAt(0);
		int rowsNumber = firstSheet.getLastRowNum();
		for (int g = 0 ; g<rowsNumber ; g++ ) {
		try {
			Row r = 	firstSheet.getRow(g);
		//  System.out.println("***" + r.getRowNum());
		//	System.out.println( " nbr of cells  : "+r.getLastCellNum());
			int cellNum = r.getLastCellNum();
			ArrayList<String> cells = new ArrayList<>() ; 
			for(int i = 0; i<cellNum ; i++) {
				System.out.println(CellValueToString(r.getCell(i)));
				try {
					cells.add(CellValueToString(r.getCell(i)));
				}catch(NullPointerException e) {
					break;
				}
			}
			//System.out.println("++++");
			allValues.add(cells)	;	
		}catch(NullPointerException e) {
			break;
		}
	}
		workbook.close();
		inputStream.close();	
	}
	
	public  ArrayList<String> readXslxFile(String fileName) throws IOException {
		FileInputStream inputStream = new FileInputStream(new File(fileName)); 
		Workbook workbook = new XSSFWorkbook(inputStream);
		Sheet firstSheet = workbook.getSheetAt(0);
		int numberOfCells = firstSheet.getRow(0).getLastCellNum();
		for(int i= 0; i<numberOfCells ; i++) {
			binInformation.add(CellValueToString(firstSheet.getRow(0).getCell(i)));
		}
		
		workbook.close();
		inputStream.close();	
		return binInformation;
	}
	

}
