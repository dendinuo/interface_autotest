package org.MybatisStudy.controller;

import org.MybatisStudy.model.User;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@Api(value="v1",tags="v1",description="这是测试链接数据库")
@RequestMapping("v1")
public class DemoController {
	@Autowired
	private SqlSessionTemplate template;
	@RequestMapping(value="/getuserlist",method=RequestMethod.GET)
	@ApiOperation(value="获取用户数",httpMethod="GET")
	public int getUserList() {
		return template.selectOne("getUserCount");
	}
	
	  @ApiOperation("添加用户接口")  
	  @RequestMapping(value="/adduser",method=RequestMethod.POST) 
	  public int addUser(@RequestBody User user) { 
		  return template.insert("addUser",user); 
		  }
	 @ApiOperation(value="update数据接口",httpMethod="POST")
	 @RequestMapping("/updateuser")
	  public int updateuser(@RequestBody User user) {
		  return template.update("updateUser",user);
	  }
	 @ApiOperation("删除用户")
	 @RequestMapping(value="/deleteuser",method=RequestMethod.GET)
	 public int deleteuser(@RequestParam int userid) {
		 return template.delete("deleteUser", userid);
	 }
}
