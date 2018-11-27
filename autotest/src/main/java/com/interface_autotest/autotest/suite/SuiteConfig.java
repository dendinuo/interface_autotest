package com.interface_autotest.autotest.suite;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class SuiteConfig {
	@AfterSuite
	public void afterSuite() {
		System.out.println("在suite之后运行");
	}
	
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("在suite之前运行");
	}
	@BeforeTest
	public void beforeTest() {
		System.out.println("beforeTest");
	}
	@AfterTest
	public void afterTest() {
		System.out.println("afterTest");
	}
}
