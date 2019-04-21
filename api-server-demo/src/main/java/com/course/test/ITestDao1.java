package com.course.test;

import java.util.List;

import com.course.model.User;

public interface ITestDao1 {
	/**
     * 查询所有
     * @return
     */
    public  List<User> getAll();

    /**
     * 新增
     * @param user
     * @return
     */
    public int addUsers(User user) throws Exception;
}
