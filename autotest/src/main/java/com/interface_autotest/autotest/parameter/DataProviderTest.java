package com.interface_autotest.autotest.parameter;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DataProviderTest {
/**<!----------------------dataProvider传参--------------------------->**/	
	@Test(dataProvider="data2")
	public void paramTest1(String name , int age) {
		System.out.println("name="+name+"\n"+"age="+age);
	}
	
	@DataProvider(name="data1")
	public Object[][] providerData1(){
		Object[][] o = new Object[][] {
			{"zhangsan1",17},
			{"zhangsan2",18},
			{"zhangsan3",19}
		};
		return o;
	}
	
	@DataProvider(name="data2")
	public Object[][] providerData2(){
		Object[][] o = new Object[][] {{"luojun",27} };
		return o;
	}
/**<!----------------------dataProvider通过 方法名 传参--------------------------->**/
	
	@Test(dataProvider="methodData")
	public void Test1(String name , int age) {
		System.out.println("test1: "+"name="+name+"\n"+"age="+age);	
	}
	@Test(dataProvider="methodData")
	public void Test2(String name , int age) {
		System.out.println("test2: "+"name="+name+"\n"+"age="+age);	
	}
	
	@DataProvider(name="methodData")
	public Object[][] methodDataTest(Method method){
		Object[][] result = null;
		if(method.getName().equals("Test1")) {
			result = new Object[][] {
				{"zhangsan4",37},
				{"zhangsan5",38},
				{"zhangsan6",39}
			};
		}else if(method.getName().equals("Test2")){
			result = new Object[][] {
				{"zhangsan7",47},
				{"zhangsan8",44},
			};
		}
		return  result;
	}
	
	/**<!-----------------------主方法----调试用--------------------->**/	
	public static void main(String[] args) {
		
			Object[] o = new Object[] 
					{"zhangsan1",17};
	
			System.out.println(o[0]);
	}
}

