package org.SpringBootDemo.server;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Cookie;

import org.SpringBootDemo.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags="这是响应post请求的接口",description="响应的测试(这是接口描述)")
public class postmethod {
	
	@RequestMapping(value="/test/post1",method=RequestMethod.POST)
	@ApiOperation(value="登录接口，存取登录信息",httpMethod="POST")
	public  String postme(HttpServletResponse response,
			HttpServletRequest request,
			@RequestParam("userid")String names,
			@RequestParam("password")String pwds
			) {
		if(names.equals("luojun") &&pwds.equals("123456") ) {
			Cookie cookie1=new Cookie("login", "true");
			response.addCookie(cookie1);
			Cookie cookie2=new Cookie("isenable", "yes");
			response.addCookie(cookie2);
			return "登陆成功";
			}
		return "验证失败";
	}
	@RequestMapping(value="/test/post2",method=RequestMethod.POST)
	@ApiOperation("验证登录信息，获取用户信息")
	public String getlist( HttpServletRequest request,
			
			@RequestBody User user) {
		Cookie[] cookies=request.getCookies();
		User usr;
		for( Cookie cook : cookies ) {
			if( cook.getName().equals("login")&&cook.getValue().equals("true")) {
				usr=new User();
				usr.setName("zhangsan1");
				usr.setAge("16");
				return usr.toString();
			}
		}
		return "验证失败！";
	}
	
}
