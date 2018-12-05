package org.httpclient;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

/**
 *
 */
public class MyHttpClient 
{
	@Test
    public  void test1(  ) throws IOException
    {
		//存放结果
		String result;
		HttpGet get =new HttpGet("http://www.baidu.com");
		//client用来执行get方法
		HttpClient client=new DefaultHttpClient();
        HttpResponse response =client.execute(get);
        result = EntityUtils.toString(response.getEntity(),"utf-8" );
        System.out.println("result= "+result);
    }
}