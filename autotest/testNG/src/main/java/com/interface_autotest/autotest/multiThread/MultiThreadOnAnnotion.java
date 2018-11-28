package com.interface_autotest.autotest.multiThread;

import org.testng.annotations.Test;

public class MultiThreadOnAnnotion {
	@Test( invocationCount=10 , threadPoolSize=3 )
	/**invocationCount请求次数，threadPoolSize线程并发数**/
	public void test() {
		System.out.println(111111);
		System.out.println("线程id："+Thread.currentThread().getId());
		
	}
}
