package utils;

import java.io.File;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadExcel {
	
	
	public static String[] [] readExcel(String sheetName) throws InvalidFormatException, IOException {
		File excelFileName = new File ("./data/Leads.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(excelFileName);
		
		XSSFSheet sheet = workbook.getSheet("Create Lead");
		
		int rowCount = sheet.getLastRowNum();
		int colCount = sheet.getRow(0).getLastCellNum();
		
		for (int i = 1; i <= rowCount; i++) {
			XSSFRow row = sheet.getRow(i);
			for (int j = 0; j < colCount; j++) {
				XSSFCell cell = row.getCell(j);
				System.out.println(cell.getStringCellValue());
			}
			
		}
		return null;
	
	}
	
	
	
	
	
	
	
	
	

}
