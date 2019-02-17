package com.interface_autotest.autotest.multiThread;

import org.testng.annotations.Test;

public class MultiThreadOnXml {
	@Test
	public void test1() {
		/*System.out.println("测试1通过");*/
		System.out.println("当前线程ID："+Thread.currentThread().getId() );
	}
	@Test
	public void test2() {
		/*System.out.println("测试2通过");*/
		System.out.println("当前线程ID："+Thread.currentThread().getId() );
	}
}
