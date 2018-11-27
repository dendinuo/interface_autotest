package com.interface_autotest.autotest.parameter;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterTest {
	@Test
	@Parameters( { "name","age" } ) //从配置文件传入参数
	public void paramTest1(String name , int age) {
		System.out.println("name="+name+"\n"+"age="+age);
	}
}
