package com.course.tests;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelUtility {

	private static XSSFWorkbook ExcelWBook;
	private static XSSFSheet ExcelWSheet;
	
	public static void main(String[] args) {
		excelUtility test=new excelUtility();
	
	}
	/*
	 * 设置文件路径, 打开 Excel 文件
	 * 
	 * @params - Excel 路径 and 表单名字
	 */
	public static void setExcelFile(String path, String sheetName) throws Exception {
		try {
			// 打开 Excel 文件
			FileInputStream ExcelFile = new FileInputStream(path);

			// 访问excel表
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet(sheetName);
		} catch (Exception e) {
			throw (e);
		}
	}

	public static String[][] getTestData(String tableName) {
		String[][] testData = null;

		try {
			// 处理单元格中的数字和字符串的
			DataFormatter formatter = new DataFormatter();
			// BoundaryCells 数组里放的是第一列和最后一列两个元素
			// 根据第一列和最后一列, 可以知道读哪些行数据
			XSSFCell[] boundaryCells = findCells(tableName);
			// 单元格开始处
			XSSFCell startCell = boundaryCells[0];
			// 单元格结束处
			XSSFCell endCell = boundaryCells[1];

			// 根据单元格开始出找到行开始处
			int startRow = startCell.getRowIndex() + 1;
			int endRow = endCell.getRowIndex() - 1;
			int startCol = startCell.getColumnIndex() + 1;
			int endCol = endCell.getColumnIndex() - 1;

			testData = new String[endRow - startRow + 1][endCol - startCol + 1];

			for (int i = startRow; i < endRow + 1; i++) {
				for (int j = startCol; j < endCol + 1; j++) {
					// testData[i-startRow][j-startCol] =
					// ExcelWSheet.getRow(i).getCell(j).getStringCellValue();
					// 取每一行里面每一列的值
					Cell cell = ExcelWSheet.getRow(i).getCell(j);
					testData[i - startRow][j - startCol] = formatter.formatCellValue(cell);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 返回这个二维数组
		return testData;
	}

	public static XSSFCell[] findCells(String tableName) {
		DataFormatter formatter = new DataFormatter();
		String pos = "begin";
		XSSFCell[] cells = new XSSFCell[2];

		for (Row row : ExcelWSheet) {
			for (Cell cell : row) {
				// if (tableName.equals(cell.getStringCellValue())) {
				if (tableName.equals(formatter.formatCellValue(cell))) {
					if (pos.equalsIgnoreCase("begin")) {
						// 找到开始单元格, 用作边界单元格
						cells[0] = (XSSFCell) cell;
						pos = "end";
					} else {
						// 找到结束单元格，用作边界单元格
						cells[1] = (XSSFCell) cell;
					}
				}
			}
		}
		// 返回单元格数组
		return cells;
	}
}
