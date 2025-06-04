package utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtils {

	
	public static String getCellValues(String sheetName, int rowNum, int colNum ) {
		String value="";
		
		try {
			FileInputStream fis =new FileInputStream(ConfigReader.getproprty("testdata/TestData.xlsx"));
			Workbook workbook = WorkbookFactory.create(fis);
			Sheet sheet = workbook.getSheet(sheetName);
			value =sheet.getRow(rowNum).getCell(colNum).toString();
			workbook.close();
			fis.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}
		return value;
	}
}
