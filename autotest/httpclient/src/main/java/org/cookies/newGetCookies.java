package org.cookies;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

public class newGetCookies {
	DefaultHttpClient httpclient = new DefaultHttpClient();
	HttpPost httpPost = new HttpPost("http://127.0.0.1:8888/getcookies");
	
    
}
