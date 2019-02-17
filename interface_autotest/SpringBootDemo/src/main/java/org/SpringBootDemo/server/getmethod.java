package org.SpringBootDemo.server;

import java.net.CookieStore;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.web.servlet.server.Session.Cookie;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags="这是模拟get的api",description="测试用")
public class getmethod {
	@RequestMapping("/test/test")
	@ApiOperation(value="测试api",httpMethod="GET")
	public String getmet( HttpServletRequest request, HttpServletResponse response
									,@RequestParam("param")String para) {
		
		if( para.equals("123456") ) {return "seccuss";}
		return "fail";
	}
	
	@RequestMapping(value="/test/test2",method=RequestMethod.GET)
	@ApiOperation(value="要求客户端携带参数访问1,浏览器输入http://127.0.0.1:8888/get/withparam?start=100&&end=203      任意两个数")
	public Map<String, Integer> getList( @RequestParam Integer start , @RequestParam Integer end ){
		Map<String, Integer>myList=new HashMap<>();
		myList.put("Prada",4000);
		myList.put("Chanel",6000);
		myList.put("Louis Vuitton",start);
		myList.put("Calvin Klein",end);
		return myList;
	}
	@RequestMapping(value="/test/test3",method=RequestMethod.GET)
	@ApiOperation(value="sdfwqfwq是的晚饭潜伏期",httpMethod="GET")
	public Map<String, String>testtest(){
		Map<String, String>mymap=new HashMap<>();
		mymap.put("hehe1", "111");
		mymap.put("hehe2", "213");
		mymap.put("hehe3", "saaf");
		return mymap;
	}
	
}
