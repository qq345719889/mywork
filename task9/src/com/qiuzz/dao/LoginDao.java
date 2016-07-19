package com.qiuzz.dao;

import java.util.List;

import com.qiuzz.property.Commodity;
import com.qiuzz.property.User;

public interface LoginDao {
	/*
	 * 保存传入的User类型数据
	 */
	public void saveUser(User user);

	/*
	 * 根据用户名查找密码
	 */
	public String findPwdByName(String name);

	/*
	 * 根据用户名查找该用户名所有信息
	 */
	public List<User> findAllByName(String name);

}