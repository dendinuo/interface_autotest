package com.demo.operation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.demo.UiTestDemo;

public class logintest {

	public static WebDriver driver =new ChromeDriver();
	public static void login() throws InterruptedException {
		
		driver.get("http://149.129.84.241:90/login/");
		WebDriverWait wait = new WebDriverWait(driver,100);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"particles-js\"]/div[1]/div[4]")));
		Thread.sleep(2000); 
		UiTestDemo.logger.info("[INFO] 登录页加载成功");
		driver.findElement(By.xpath("//*[@id=\"particles-js\"]/div[1]/div[2]/div[2]/input")).clear();Thread.sleep(500);
		driver.findElement(By.xpath("//*[@id=\"particles-js\"]/div[1]/div[2]/div[2]/input")).sendKeys
		("admin");Thread.sleep(500);
		UiTestDemo.logger.info("[INFO] 已输入用户名");
		driver.findElement(By.xpath("//*[@id=\"particles-js\"]/div[1]/div[3]/div[2]/input")).clear();Thread.sleep(500);
		driver.findElement(By.xpath("//*[@id=\"particles-js\"]/div[1]/div[3]/div[2]/input")).sendKeys("123456");
		UiTestDemo.logger.info("[INFO] 已输入密码");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"particles-js\"]/div[1]/div[4]")).click();//点击登录
		UiTestDemo.logger.info("[INFO] 点击登录");
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
	}
	
	
	public static void main(String[] args) throws InterruptedException {
		//调试用
		driver.get("http://149.129.84.241:90/login/");
		WebDriverWait wait = new WebDriverWait(driver,100);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"particles-js\"]/div[1]/div[4]")));
		Thread.sleep(2000); 
		driver.findElement(By.xpath("//*[@id=\"particles-js\"]/div[1]/div[2]/div[2]/input")).clear();Thread.sleep(500);
		driver.findElement(By.xpath("//*[@id=\"particles-js\"]/div[1]/div[2]/div[2]/input")).sendKeys("admin");Thread.sleep(500);
		driver.findElement(By.xpath("//*[@id=\"particles-js\"]/div[1]/div[3]/div[2]/input")).clear();Thread.sleep(500);
		driver.findElement(By.xpath("//*[@id=\"particles-js\"]/div[1]/div[3]/div[2]/input")).sendKeys("123456");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"particles-js\"]/div[1]/div[4]")).click();//点击登录
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
	}
}
