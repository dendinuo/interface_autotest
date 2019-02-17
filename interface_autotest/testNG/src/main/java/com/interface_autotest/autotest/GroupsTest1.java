package com.interface_autotest.autotest;

import org.testng.annotations.Test;

@Test( groups = "class group1" )
public class GroupsTest1 {
	
	public void method1() {
		System.out.println("组1类中的 测试方法1 执行。");
	}
	public void method2() {
		System.out.println("组1类中的 测试方法2 执行。");
	}
}
@Test( groups = "class group2" )
  class GroupsTest2 {

	public void method1() {
		System.out.println("组2类中的 测试方法1 执行。");
		
	}
	public void method2() {
		System.out.println("组2类中的 测试方法2 执行。");
	}
}