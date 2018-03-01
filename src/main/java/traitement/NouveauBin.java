package traitement;

import java.awt.List;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class NouveauBin {
	
		private static String cheminFichier = "/Users/majda/eclipse-workspace/Automatisation_Take1/src/main/resources/New_Bin_1.xlsx";
		private ArrayList<String> binInformation;

	public NouveauBin( ) throws IOException {
		this.binInformation =  new ArrayList<String>();	
	}
	
	
	
	public  ArrayList<String> readXslxFile(String fileName) throws IOException {
		FileInputStream inputStream = new FileInputStream(new File(fileName)); 
		Workbook workbook = new XSSFWorkbook(inputStream);
		Sheet firstSheet = workbook.getSheetAt(0);
		int numberOfCells = firstSheet.getRow(0).getLastCellNum();
		for(int i= 0; i<numberOfCells ; i++) {
			binInformation.add(getCellValue(firstSheet.getRow(0).getCell(i)));
		}
		
		workbook.close();
		inputStream.close();	
		return binInformation;
	}


	private static String getCellValue(Cell cell) {
		String typeCell = cell.getCellTypeEnum().toString();
		String cellValue ="";
		if(typeCell.equals("STRING")) {
			cellValue = cell.getStringCellValue();
		}else if(typeCell.equals("NUMERIC")) {
			cellValue = String.valueOf(cell.getNumericCellValue());
		}
		return cellValue;
	}
}
