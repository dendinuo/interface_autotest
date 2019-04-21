package com.course.config;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;

import ch.qos.logback.core.db.dialect.DBUtil;


public class mysqltest {

	//测试sql
	public void test() throws SQLException {
		/***预先创建 目标数据库***/
        Connection conn = null;
        String sql;
        String url = "jdbc:mysql://149.129.84.241:3306/course?"
                + "user=root&password=abcd1234&useUnicode=true&amp&characterEncoding=utf-8"; // URL = "jdbc:mysql://localhost:3306/数据库名"  、USER = "用户名"  、PASS = "密码" 必须要有
        try {
            // 动态加载mysql驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("成功加载MySQL驱动程序");
            // Connection代表一个数据库连接， 
            //conn = DriverManager.getConnection( URL , USER , PASS );  
            conn = DriverManager.getConnection(url);
         // Statement里面带有很多方法，比如executeUpdate可以实现插入，更新和删除等
            sql = "select * from user where username = 'admin' ";//查询语句
            //预加载方法实例化 声明 对象
            PreparedStatement stmt =  conn.prepareStatement(sql);
           //普通方法实例化 声明 对象 
            //Statement stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery(sql);//执行sql并返回结果
            
            while(result.next()) {
               //使用循环轮询可返回所有结果
               String str = result.getString(1);
               
               System.out.println(str);
            }         

            System.out.println("sql执行完成！");        
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
      }
	
	//查询sql
	public void querysql() {
		
	}
	
    public static void main( String[] args ) throws SQLException{
        
    }
}
