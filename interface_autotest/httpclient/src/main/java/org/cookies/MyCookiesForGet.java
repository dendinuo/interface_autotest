package org.cookies;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyCookiesForGet {
	private String url;
	private ResourceBundle bundle;
	private CookieStore store;
	
	
	@BeforeTest
	public void beforeTest() {
		bundle = ResourceBundle.getBundle("application",Locale.CHINA);
		url=bundle.getString("test.url");
		//System.out.println(url);
	}
	@Deprecated
	@Test
	public void testGetCookies() throws ClientProtocolException, IOException {
		String result;
		String uri = bundle.getString("getCookies.uri");
		String testUrl = this.url+uri;
		
		HttpGet get = new HttpGet(testUrl);
		DefaultHttpClient client = new DefaultHttpClient();
		HttpResponse response = client.execute(get);
		
		result = EntityUtils.toString(response.getEntity(),"utf-8");
		/*System.out.println(result);*/
		
		this.store = client.getCookieStore();
		System.out.println(client.getCookieStore());
		System.out.println("store="+this.store);
		List<Cookie> cookieList = store.getCookies();
		
		for( Cookie cookie:cookieList ) {
			String name = cookie.getName();
			String value =cookie.getValue();
			System.out.println("cookie name="+name);
			System.out.println("cookie value="+value);
		}
	}
	@Test(dependsOnMethods= {"testGetCookies"})
	public void testGetWithCookies() throws ClientProtocolException, IOException {
		String uri = bundle.getString("test.get.with.cookies");
		String testUrl = this.url+uri;
		
		HttpGet get = new HttpGet(testUrl);
		DefaultHttpClient client = new DefaultHttpClient();
		//设置cookies信息
		client.setCookieStore(this.store);
		HttpResponse response = client.execute(get);
		//获取响应状态码
		int statusCode = response.getStatusLine().getStatusCode();
		System.out.println("状态码："+statusCode);
		
		if(statusCode==200) {
			String result = EntityUtils.toString(response.getEntity());
		}
	}
	
	
}
