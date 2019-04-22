package com.course.tests;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility_SingleDataSet {
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
			return "";
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
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

			Date dateValue = Cell.getDateCellValue();
			String dateStringFormat = df.format(dateValue);

			return dateStringFormat;
		} catch (Exception e) {
			return "";
		}
	}

	/*
	 * 写入 Excel 单元格, String 类型的结果
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
			FileOutputStream fileOut = new FileOutputStream("C:\\Users\\Administrator\\Desktop\\coding-231\\TestNG_All code\\TestNG_All code\\测试.xlsx");

			ExcelWBook.write(fileOut);
			fileOut.flush();
			fileOut.close();
		} catch (Exception e) {
			throw (e);
		}
	}

	/*
	 * 写入 Excel 单元格, double 类型的结果
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
			FileOutputStream fileOut = new FileOutputStream("C:\\Users\\Administrator\\Desktop\\coding-231\\TestNG_All code\\TestNG_All code\\13-5-2ExcelDataSingleDataSet.xlsx");

			ExcelWBook.write(fileOut);
			fileOut.flush();
			fileOut.close();
		} catch (Exception e) {
			throw (e);
		}
	}
	
	public static void main(String[] args) throws Exception {
		ExcelUtility_SingleDataSet test = new ExcelUtility_SingleDataSet();
		ExcelUtility_SingleDataSet.setCellData("123", 0, 1);
		
		
		
		
		
	}
}
