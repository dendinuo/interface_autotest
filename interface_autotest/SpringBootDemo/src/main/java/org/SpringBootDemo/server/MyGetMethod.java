package org.SpringBootDemo.server;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags="模拟请求api --1",description="模拟的Get请求方法")
public class MyGetMethod {
	@RequestMapping(value="/getcookies",method=RequestMethod.GET)
	@ApiOperation(value="通过这个方法获取cookies")
	public String getCookies(HttpServletResponse response) {
		Cookie cookie=new Cookie("login", "sssss");
		response.addCookie(cookie);
		return "seccessful";
	}
	

	@RequestMapping(value="/get/withcookies",method=RequestMethod.GET)
	@ApiOperation("要求客户端get携带cookies访问")
	public String getwithCookies(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		if(Objects.isNull (cookies)) {
			return "no cookies";
		}
		for ( Cookie cookie:cookies ) {
			if(cookie.getName().equals("login")&&cookie.getValue().equals("sssss") ) {
				return "成功";
			}
		}
		return "失败";
	}
	


	@RequestMapping(value="/get/withparam",method=RequestMethod.GET)
	@ApiOperation(value="要求客户端携带参数访问1,浏览器输入http://127.0.0.1:8888/get/withparam?start=100&&end=203      任意两个数")
	public Map<String, Integer> getList( @RequestParam Integer start , @RequestParam Integer end ){
		Map<String, Integer>myList=new HashMap<>();
		myList.put("Prada",4000);
		myList.put("Chanel",6000);
		myList.put("Louis Vuitton",start);
		myList.put("Calvin Klein",end);
		return myList;
	}

	@RequestMapping(value="/get/withparam/{start}/{end}",method=RequestMethod.GET)
	@ApiOperation(value="要求客户端携带参数访问2, 浏览器输入http://127.0.0.1:8888/get/withparam/100/203  任意两个数值 ")
	public Map<String, Integer> getList2( @PathVariable Integer start , @PathVariable Integer end ){
		Map<String, Integer>myList=new HashMap<>();
		myList.put("Prada",4000);
		myList.put("Chanel",6000);
		myList.put("Louis Vuitton",start);
		myList.put("Calvin Klein",end);
		return myList;
	}
}
