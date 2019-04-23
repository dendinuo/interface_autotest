package com.demo.test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.demo.Utils.ExcelUtil;

public class testDataProvider {
	@DataProvider(name = "testData")
	public Object[][] dataProvider() {
		Object[][] result;
		Object[][] testData = ExcelUtil.getTestData("Invalid");
		 result=new Object[][]{ {"zhangsan",10}, {"lisi",20}, {"wangwu",30} };
		return testData;
	}

	@BeforeClass
	public void beforetest() throws Exception {
		ExcelUtil.setExcelFile(Constants.Excel_File_Path+Constants.Excel_File_Name, "登录");
	}
  @Test(dataProvider="testData")
  public void test(String username,String password){
	  System.out.println("账户名："+username+"  密码："+password);
  }
  
  public static void main(String[] args) throws Exception {
		/*
		 * testDataProvider testp=new testDataProvider(); ExcelUtil
		 * .setExcelFile(Constants.Excel_File_Path+Constants.Excel_File_Name, "Sheet4");
		 */
	//String[][] s=ExcelUtil.getTestData("Invalid");

}
}
