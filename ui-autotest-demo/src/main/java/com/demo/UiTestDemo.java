package com.demo;

import java.awt.AWTException;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.demo.operation.logintest;
import com.demo.operation.opencart;



public class UiTestDemo {
	static { System.setProperty("webdriver.chrome.driver",
			  "webdriver/chromedriver.exe"); }
	//log4j类实例化对象
	public	static Logger logger = LogManager.getLogger(UiTestDemo.class.getName());
	public static void main(String[] args) {
		try {
			logger.info("浏览器驱动加载成功。");
			long startTime =  System.currentTimeMillis();
			logintest.login();
			opencart.test();
			
			logintest.driver.quit();
			long endTime=System.currentTimeMillis();
			long usedTime=endTime-startTime;
			logger.info("测试完成，用时"+usedTime/1000+"s");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
