package org.SpringBootDemo.server;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyGetMethod {
	@RequestMapping(value="/getcookies",method=RequestMethod.GET)
	public String getCookies(HttpServletResponse response) {
		Cookie cookie=new Cookie("login", "true");
		response.addCookie(cookie);
		return "seccessful";
	}
}
