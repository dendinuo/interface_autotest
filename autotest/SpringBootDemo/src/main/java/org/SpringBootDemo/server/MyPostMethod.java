package org.SpringBootDemo.server;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.SpringBootDemo.bean.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value="/",tags="模拟请求api --2",description="模拟的Post请求方法")
@RequestMapping("/V1")
public class MyPostMethod {
	//cookie变量存放cookies信息
	private static Cookie cookie ;
	@RequestMapping(value="/login",method=RequestMethod.POST)
	@ApiOperation(value="登录接口，成功后获取cookies信息。",httpMethod="POST")
	public String login(HttpServletResponse response, 
			@RequestParam(value="登录名username",required=true) String username,
			@RequestParam(value="密码password",required=true) String password ) {
		if ( username.equals("admin") && password.equals("123456") ) {
			cookie = new Cookie("login", "true");
			response.addCookie(cookie);
			return "登录成功！！";
		}
		return "登陆失败";
	}
	
	@RequestMapping(value="/getUserList",method=RequestMethod.POST)
	@ApiOperation(value="获取用户列表",httpMethod="post")
	public String getUserList( HttpServletRequest request,
										@RequestBody User usr) {
		Cookie[] cookies = request.getCookies();
		User user;
		for ( Cookie i : cookies ) {
			if( i.getName().equals("login") && i.getValue().equals("true") 
					&& usr.getUsername()=="admin"
					&& usr.getPassword()=="123456") {
				user = new User();
				user.setName("luojun");
				user.setAge("18");
				user.setSex("man");
				return user.toString();
			}
		}
		return "参数不合法。";
	}
	
}
