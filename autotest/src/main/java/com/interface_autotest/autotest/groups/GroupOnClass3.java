package com.interface_autotest.autotest.groups;

import org.testng.annotations.Test;

@Test( groups="Group B" )
public class GroupOnClass3 {
	
	public void method1() {
		System.out.println("GroupOnClass3: method 1 运行！");
	}
	public void method2() {
		System.out.println("GroupOnClass3: method 2 运行！");
	}
}
