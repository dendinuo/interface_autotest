package com.interface_autotest.autotest.parameter;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DataProviderTest {
	@Test	
	public void paramTest1(String name , int age) {
		System.out.println("name="+name+"\n"+"age="+age);
	}
	
/*	public Object[][] providerData(){
		Object[][] o = new Object[][] {
			{"zhangsan1",17},
			{"zhangsan2",18},
			{"zhangsan3",19}
		};
	}*/
	
}
