package com.interface_autotest.autotest;

import org.testng.annotations.*;

public class BasicAnnotation 
{
	@org.testng.annotations.AfterMethod
	public void AfterMethod(){
		System.out.println( "AfterMethod,这是在测试方法之后!" );
	}
	//标记此处是测试方法的一部分
	@Test( enabled = false )
	public void testCase1(){
		System.out.println( "这是测试用例1!" );
	}
	@Test( enabled=true )
	public void testCase2(){
		System.out.println( "这是测试用例2!" );
	}	
	@Test( groups = "group1" )
	public void testCase3(){
		System.out.println( "这是组1 的 测试方法1 !" );
	}
	@Test( groups = "group1")
	public void testCase4(){
		System.out.println( "这是组1 的 测试方法2 !" );
	}
	@Test( groups = "group2")
	public void testCase5(){
		System.out.println( "这是组2 的 测试方法3 !" );
	}
	@Test( groups = "group2")
	public void testCase6(){
		System.out.println( "这是组2 的 测试方法4 !" );
	}
	@BeforeGroups("group1")
	public void BeforeGroup1(){
		System.out.println( "这是组1之前运行的方法 !" );
	}
	@BeforeGroups("group2")
	public void BeforeGroup2(){
		System.out.println( "这是组2之前运行的方法 !" );
	}
	@AfterGroups("group1")
	public void AfterGroup1(){
		System.out.println( "这是组1之后运行的方法 !" );
	}
	
	@BeforeMethod
	public void BeforeMethod(){
		System.out.println( "BeforeMethod,这是在测试方法之前!" );
	}
	@BeforeSuite
	public void BeforeSuite(){
		System.out.println( "BeforeSuite,测试套件!" );
	}	
	@AfterSuite
	public void AfterSuite(){
		System.out.println( "AfterSuite,测试套件!" );	
	}	
	@AfterClass
	public void AfterClass(){
		System.out.println( "AftertClass,类运行之后的方法!" );	
	}		
	@BeforeClass
	public void BeforeClass(){
		System.out.println( "BeforeClass,类运行之前的方法!" );	
	}			

}
