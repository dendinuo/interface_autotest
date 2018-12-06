package org.cookies;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.ResourceBundle;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class newGetCookies {
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
	public static void main(String[] args) {
		newGetCookies obj = new newGetCookies();
		
	}
	
	@Test(dependsOnMethods= {"testGetCookies"})
	public static String doPost(Map<String, String> map, String charset) {
        CloseableHttpClient httpClient = null;
        HttpPost httpPost = null;
        String result = null;
        try {
            CookieStore cookieStore = new BasicCookieStore();
            httpClient = HttpClients.custom().setDefaultCookieStore(cookieStore).build();
            httpPost = new HttpPost("http://localhost:8888/getcookies");
            List<NameValuePair> list = new ArrayList<NameValuePair>();
            Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
            while (iterator.hasNext()) {
                Entry<String, String> elem = (Entry<String, String>) iterator.next();
                list.add(new BasicNameValuePair(elem.getKey(), elem.getValue()));
            }
            if (list.size() > 0) {
                UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list, charset);
                httpPost.setEntity(entity);
            }
            httpClient.execute(httpPost);
            String JSESSIONID = null;
            String cookie_user = null;
            List<Cookie> cookies = cookieStore.getCookies();
            for (int i = 0; i < cookies.size(); i++) {
                if (cookies.get(i).getName().equals("JSESSIONID")) {
                    JSESSIONID = cookies.get(i).getValue();
                }
                if (cookies.get(i).getName().equals("cookie_user")) {
                    cookie_user = cookies.get(i).getValue();
                }
            }
            if (cookie_user != null) {
                result = JSESSIONID;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }
}	

