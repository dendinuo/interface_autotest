package org.extentreport;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

/**
 * 
 *
 */
public class TestMethodDemo
{
	@Test
    public  void test1()
    {
    	Assert.assertEquals( 1, 2 );
    }
	@Test
    public  void test2()
    {
    	Assert.assertEquals( 1, 1 );
    }
	@Test
	public  void test3()
    {
    	Assert.assertEquals( "a", "a" );
    }
	@Test
    public  void logDemo()
    { 	
    	Reporter.log("手动de日志");
    	throw new RuntimeException("手动抛出de异常");
    }
    
}
