package traitement;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
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
public class ExcelReader {
	public static final String chemin ="";
	
	public static void main(String[] args) throws IOException {
		readExcel("/Users/majda/eclipse-workspace/Automatisation_Take1/src/test/resources/ReadFile.xlsx");
	}

	public ExcelReader(String cheminFichier) throws IOException {
		if (cheminFichier.endsWith(".xlsx")) {
			System.out.println(".xlsx file is detected...");
			readXslxFile(cheminFichier);
		} else if (cheminFichier.endsWith(".xls")) {
			System.out.println(".xls file is detected...");
			readXslFile(cheminFichier);
		} else {
			System.out.println("Unsupported file format");
		}
	}
	
	
	private static void readExcel(String cheminFichier) throws IOException {
		if (cheminFichier.endsWith(".xlsx")) {
			System.out.println(".xlsx file is detected...");
			readXslxFile(cheminFichier);
		} else if (cheminFichier.endsWith(".xls")) {
			System.out.println(".xls file is detected...");
			readXslFile(cheminFichier);
		} else {
			System.out.println("Unsupported file format");
		}
	}
	
	private static void readXslxFile(String fileName) throws IOException {
		FileInputStream inputStream = new FileInputStream(new File(fileName)); 
		Workbook workbook = new XSSFWorkbook(inputStream);
		Sheet firstSheet = workbook.getSheetAt(0);
		System.out.println("Number of sheets is : " + workbook.getNumberOfSheets());
		Iterator<Row> iterator = firstSheet.iterator();
		
		while(iterator.hasNext()) {
			Row row = iterator.next();
			Iterator<Cell> cellIterator = row.cellIterator();
				while(cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					System.out.println(" Cell number " + cell.getColumnIndex() +" : " + cell.getStringCellValue());
				}
		}
		workbook.close();
		inputStream.close();	
	}
	
	private static void readXslFile(String fileName) throws IOException {
		FileInputStream inputStream = new FileInputStream(fileName);
		HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
		inputStream.close();
		for (int k = 0; k < workbook.getNumberOfSheets(); k++) {
			HSSFSheet sheet = workbook.getSheetAt(k);
			int rows = sheet.getPhysicalNumberOfRows();
			for (int r = 0; r < rows; r++) {
				HSSFRow row = sheet.getRow(r);
				if (row == null) {
					continue;
				}
				int cells = row.getPhysicalNumberOfCells();
				for(int c = 0; c < cells; c++) {
					HSSFCell cell = row.getCell(c);
					System.out.println(" Cell number " + cell.getColumnIndex() +" : " + cell.getStringCellValue());
				}
			}
		}
		workbook.close();
	}

}
