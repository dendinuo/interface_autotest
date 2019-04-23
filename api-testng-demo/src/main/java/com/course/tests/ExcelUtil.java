package com.course.tests;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
	/*
	 * 下载地址 - http://poi.apache.org/download.html 
	 * 文件名 - poi-bin-3.17-20170915.zip 
	 * 解压下载的二进制文件压缩包 把所有的jars 
	 * 文件从你解压后的位置加到你的项目的 build path里
	 * 包括lib这个文件夹中的jar包, 不要加 log4j这个jar包 
	 * 包括 ooxml-lib这个文件夹中的所有jar包
	 */

	private static XSSFSheet ExcelWSheet;
	private static XSSFWorkbook ExcelWBook;
	private static XSSFCell Cell;
	private static XSSFRow Row;

	/*
	 * 设置文件路径, 打开 Excel 文件
	 * 
	 * @params - Excel 路径 and 表单名字
	 */
	public static void setExcelFile(String Path, String SheetName) throws Exception {
		try {
			// 打开 Excel 文件
			FileInputStream ExcelFile = new FileInputStream(Path);

			// 访问excel表
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet(SheetName);
		} catch (Exception e) {
			throw (e);
		}
	}

	/*
	 * 从 Excel 单元格读取测试数据
	 * 
	 * @params - Row num 和 Col num
	 */
	public static String getCellData(int RowNum, int ColNum) throws Exception {
		try {
			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
			String cellData = Cell.getStringCellValue();
			return cellData;
		} catch (Exception e) {
			return "未指定读取的文件";
		}
	}

	/*
	 * 从Excel单元格读取日期格式的测试数据
	 * 
	 * @params - Row num 和 Col num
	 */
	public static String getDateCellData(int RowNum, int ColNum) throws Exception {
		try {
			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

			Date dateValue = Cell.getDateCellValue();
			String dateStringFormat = df.format(dateValue);

			return dateStringFormat;
		} catch (Exception e) {
			return "";
		}
	}

	/*
	 * 写入 Excel  String 类型数据
	 * 
	 * @params - Row num 和 Col num
	 */
	public static void setCellData(String Result, int RowNum, int ColNum) throws Exception {
		try {
			Row = ExcelWSheet.getRow(RowNum);
			// 如果Row不存在就创建
			if (Row == null) {
				Row = ExcelWSheet.createRow(RowNum);
			}
			Cell = Row.getCell(ColNum);
			if (Cell == null) {
				Cell = Row.createCell(ColNum);
				Cell.setCellValue(Result);
			} else {
				Cell.setCellValue(Result);
			}
			// 文件字节输出流写入数据
			FileOutputStream fileOut = new FileOutputStream(Constants.Excel_File_Path+Constants.Excel_File_Name);
			ExcelWBook.write(fileOut);
			fileOut.flush();
			fileOut.close();
		} catch (Exception e) {
			System.out.println("错误：文件无法写入或未指定文件");
			throw (e);
			
		}
	}

	/*
	 * 写入 Excel 单元格, double 类型的数据
	 * 
	 * @params - Row num 和 Col num
	 */
	public static void setCellData(double Result, int RowNum, int ColNum) throws Exception {
		try {
			Row = ExcelWSheet.getRow(RowNum);
			Cell = Row.getCell(ColNum);
			if (Cell == null) {
				Cell = Row.createCell(ColNum);
				Cell.setCellValue(Result);
			} else {
				Cell.setCellValue(Result);
			}
			// 文件字节输出流写入数据
			FileOutputStream fileOut = new FileOutputStream(Constants.Excel_File_Path+Constants.Excel_File_Name);
			ExcelWBook.write(fileOut);
			fileOut.flush();
			fileOut.close();
		} catch (Exception e) {
			System.out.println("错误：文件无法写入或未指定文件");
			throw (e);
		}
	}
	
	/*
	 * 从excel 读取指定范围的 测试数据 
	 * 
	 * @params - Row num 和 Col num
	 */
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
/*
 * 获取操作列
 * */
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
	
	public static void main(String[] args) throws Exception {

		ExcelUtil .setExcelFile(Constants.Excel_File_Path+Constants.Excel_File_Name, "Sheet4");
		String[][] s=ExcelUtil.getTestData("test");
		for(int i=0;i<s.length;i++) {
			for(int j=0;j<3;j++) {
				System.out.println(s[i][j]);
			}
		}
		
		
		
		
	}
}
