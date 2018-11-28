package com.interface_autotest.autotest.groups;

import org.testng.annotations.Test;

@Test( groups="Group A" )
public class GroupOnClass2 {
	
	public void method1() {
		System.out.println("GroupOnClass2: method 1 运行！");
	}
	public void method2() {
		System.out.println("GroupOnClass2: method 2 运行！");
	}
}
