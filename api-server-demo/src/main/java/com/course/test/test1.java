package com.course.test;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.course.model.User;

/**
 * Hello world!
 *
 */
public class test1 
{
	@Autowired
    private SqlSessionTemplate template;
	
    /**
     * 查询
     */
    public void test() throws Exception{
    	 template.selectOne("test");
    }

    /**
     * 新增
     * @throws Exception
     */
    public void inserts() throws Exception{
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sf.openSession();
        User user=new User();
        user.setUserName("张飞");;
        int count = session.insert("com.course.test.ITestDao1.addUsers",user);
        System.out.println(count);
        session.commit();
        session.close();
    }
	
    public static void main( String[] args ) throws Exception
    {
        test1 obj=new test1();

    }
}
