package com.course.tests;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelRead {
	public static void main(String[] args) {
		XSSFWorkbook excelWBook;
		XSSFSheet excelWSheet;
		XSSFCell cell;
		// Location of the Excel file
		String path = "C:\\Users\\Administrator\\Desktop\\coding-231\\TestNG_All code\\TestNG_All code\\测试.xlsx";
		String sheetName = "Sheet1";

		try {
			FileInputStream excelFile = new FileInputStream(path);
			excelWBook = new XSSFWorkbook(excelFile);
			excelWSheet = excelWBook.getSheet(sheetName);
			cell = excelWSheet.getRow(1).getCell(1);
			
			String cellData = cell.getStringCellValue();
			
			System.out.println(cellData);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
