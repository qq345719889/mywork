package com.qiuzz.service;

import com.qiuzz.property.User;

public interface LoginService {

	/*
	 * 注册方法
	 */
	public void doReg(User user);

	/*
	 * 检查用户是否重复
	 */
	public boolean hasPwd(String name);

	/*
	 * 查找用户是否存在
	 */
	public String findPwdByName(String username);
	/*
	 * 查找用户是否存在
	 */
}