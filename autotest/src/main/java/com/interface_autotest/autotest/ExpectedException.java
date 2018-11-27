package com.interface_autotest.autotest;

import org.testng.annotations.Test;

public class ExpectedException {
	@Test( expectedExceptions = RuntimeException.class )
	public void runTimeExceptionFailed() {
		System.out.println("异常测试");
		throw new RuntimeException();
		
	}
}
