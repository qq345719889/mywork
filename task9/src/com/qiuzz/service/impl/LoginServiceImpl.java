package com.qiuzz.service.impl;

import com.qiuzz.dao.LoginDao;
import com.qiuzz.property.User;
import com.qiuzz.service.LoginService;

public class LoginServiceImpl implements LoginService {
	private LoginDao loginimpl;

	public LoginDao getLoginimpl() {
		return loginimpl;
	}

	public void setLoginimpl(LoginDao loginimpl) {
		this.loginimpl = loginimpl;
	}

	/*
	 * 注册方法
	 */
	public void doReg(User user) {
		loginimpl.saveUser(user);
	}

	/*
	 * 检查用户是否重复
	 */
	public boolean hasPwd(String name) {
		String result = loginimpl.findPwdByName(name);
		if (result == "") {
			return true;
		} else {
			return false;
		}
	}

	/*
	 * 查找用户是否存在
	 */
	public String findPwdByName(String username) {
		return loginimpl.findPwdByName(username);
	}
}
