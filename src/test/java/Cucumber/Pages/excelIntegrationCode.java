package Cucumber.Pages;

import java.io.File;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelIntegrationCode {
	
//	public static String[][] main(String[] args) throws IOException {	
		public static String[][] readExcel(String fileName) throws IOException, InvalidFormatException {
			XSSFWorkbook workbook = new XSSFWorkbook(new File("./data/" + fileName + ".xlsx"));
			XSSFSheet worksheet = workbook.getSheetAt(0);
			int rowCount = worksheet.getLastRowNum();
			int cellCount = worksheet.getRow(0).getLastCellNum();
			String[][] data = new String[rowCount][cellCount];
			for (int i = 1; i <= rowCount; i++) {
				XSSFRow row = worksheet.getRow(i);
				for (int j = 0; j < cellCount; j++) {
					XSSFCell cell = row.getCell(j);
					data[i - 1][j] = cell.getStringCellValue();
					System.out.println(data[i - 1][j]);
				}
			}
			workbook.close();
			return data;
		}


		}

	


	
	


