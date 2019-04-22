package com.demo.operation;


import java.awt.AWTException;
import java.awt.Desktop.Action;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.demo.UiTestDemo;

import org.openqa.selenium.JavascriptExecutor;

public class opencart {
	
	public static WebDriver driver =logintest.driver;
	public static void test() throws InterruptedException, IOException, AWTException {
		
		//driver.get("http://149.129.84.241:89/opencart/upload/");
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver,100);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"logo\"]/a/img")));
		UiTestDemo.logger.info("[INFO] 登录成功，进入商城首页");
		Thread.sleep(2000); 
		
		Actions action = new Actions(driver);
		WebElement position = driver.findElement(By.xpath("//*[@id=\"content\"]/div[4]/div/div[2]/div/div[1]/a/img"));
		action.moveToElement(position).perform();Thread.sleep(500);
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0,200)");Thread.sleep(500);	
		UiTestDemo.logger.info("[INFO] 已获取滚轮元素，下拉页面");
		Thread.sleep(1000);
		position.click();
		Thread.sleep(1000);
		UiTestDemo.logger.info("[INFO] 已点击所选商品");
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0,200)");Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"product\"]/div/div[1]/a[2]")).click();Thread.sleep(1000);
		UiTestDemo.logger.info("[INFO] 点击加入购物车");
		driver.findElement(By.id("button-cart")).click();//加入购物车
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"layui-layer1\"]/div[3]/a[2]")));
		Thread.sleep(1000);
		UiTestDemo.logger.info("[INFO] 返回购物页");
		driver.findElement(By.xpath("//*[@id=\"layui-layer1\"]/div[3]/a[2]")).click();//继续购物
		Thread.sleep(1000);
		
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0,-1000)");Thread.sleep(1000);
		action.moveToElement(driver.findElement(By.xpath("//*[@id=\"menu\"]/div/div/div[2]/ul/li[2]/a"))).perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"menu\"]/div/div/div[2]/ul/li[2]/ul/li[2]/a")).click();Thread.sleep(1000);
		
		action.moveToElement(driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div/div[11]/div/div[1]/a/img"))).perform();
		Thread.sleep(1000);
	
		driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div/div[11]/div/div[1]/a/img")).click();Thread.sleep(1000);
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0,200)");Thread.sleep(1000);
		driver.findElement(By.id("button-cart")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"layui-layer1\"]/div[3]/a[2]")));
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"layui-layer1\"]/div[3]/a[2]")).click();Thread.sleep(1000);
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0,-1000)");Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[@id=\"search\"]/input")).sendKeys("羊毛针织连衣裙");
		UiTestDemo.logger.info("[INFO] 已输入搜索框");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"search\"]/button")).click();Thread.sleep(2000);
		action.moveToElement(driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div/div[1]/div/div[1]/a/img"))).perform();
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0,150)");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div/div[1]/div/div[3]/button[1]")).click();
		Thread.sleep(2000);
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0,300)");
		Thread.sleep(1000);
		
		List<WebElement> fruit =driver.findElements(By.xpath("//*[@id=\"input-option224\"]/option"));
		for (WebElement option:fruit ) {			
			 if(option.getAttribute("value").equals("13")){
				 UiTestDemo.logger.info("[INFO] 找到目标元素，并点击");
				 option.click();//"找到”中号“，并点击"
				 Thread.sleep(1000);
			 }			
		}
		driver.findElement(By.id("button-cart")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"layui-layer1\"]/div[3]/a[1]")));
		Thread.sleep(1000);
		UiTestDemo.logger.info("[INFO] 进入新页面");
		driver.findElement(By.xpath("//*[@id=\"layui-layer1\"]/div[3]/a[1]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"checkout-cart\"]/ul/li[2]/a")));
		Thread.sleep(1000);
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0,2000);");Thread.sleep(1000);//滚动到底部
		driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div[2]/a")).click();//去结账
		UiTestDemo.logger.info("[INFO] 找到目标元素，并点击");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("input-email")));
		Thread.sleep(500);
		UiTestDemo.logger.info("[INFO] 进入结账登录页面");
		driver.findElement(By.id("input-email")).clear();
		driver.findElement(By.id("input-email")).sendKeys("1651082657@qq.com");
		UiTestDemo.logger.info("[INFO] 已输入用户邮箱/用户名");
		action.moveToElement(driver.findElement(By.xpath("//*[@id=\"content\"]/div/form/input"))).perform();
		Thread.sleep(1000);
		driver.findElement(By.id("input-password")).clear();
		driver.findElement(By.id("input-password")).sendKeys("123456");
		UiTestDemo.logger.info("[INFO] 已输入密码");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/form/input")).click();//点击登录
		UiTestDemo.logger.info("[INFO] 已点击登录");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"checkout-cart\"]/ul/li[2]/a")));
		Thread.sleep(1000);
		UiTestDemo.logger.info("[INFO] 登录成功，进入个人页面");
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0,2000);");Thread.sleep(1000);//滚动到底部
		driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div[2]/a")).click();//去结账
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/ul/li[3]/a")));
		Thread.sleep(2000);
		UiTestDemo.logger.info("[INFO] 进入结账、付款页面");
		driver.findElement(By.xpath("//*[@id=\"payment-method-section\"]/div[2]/label/input")).click();//货到付款
		Thread.sleep(2000);
		action.moveToElement(driver.findElement(By.name("terms"))).perform();
		Thread.sleep(2000);
		driver.findElement(By.name("terms")).click();//同意使用条款
		Thread.sleep(2000);
		driver.findElement(By.name("terms")).click();//同意使用条款
		Thread.sleep(2000);
		UiTestDemo.logger.info("[INFO] 个人信息输入完成");
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0,150)");Thread.sleep(1000);
		driver.findElement(By.id("button-submit")).click();
		UiTestDemo.logger.info("[INFO] 已提交付款信息");
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0,150)");Thread.sleep(1000);
//		driver.findElement(By.id("button-confirm")).click();//确认支付

     
        
        
 //       System.out.println(method.RandomA(13000000000, 13999999999));
        
        
        Thread.sleep(5000); 
        UiTestDemo.logger.info("[INFO] 订单流程完成");
        System.out.println("订单流程完成！");
       // driver.quit();//退出浏览器
    }
	
}
