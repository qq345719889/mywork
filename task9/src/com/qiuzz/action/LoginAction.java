package com.qiuzz.action;

import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.qiuzz.property.User;
import com.qiuzz.service.impl.LoginServiceImpl;

public class LoginAction extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = 1L;
	private LoginServiceImpl loginserviceimpl;
	private Map<String, Object> session;
	private String username;// 账号
	private String password; // 密码
	private String msg; // 提示信息

	public void setSession(Map<String, Object> arg0) {// 获取session对象
		session = arg0;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public LoginServiceImpl getLoginserviceimpl() {
		return loginserviceimpl;
	}

	public void setLoginserviceimpl(LoginServiceImpl loginserviceimpl) {
		this.loginserviceimpl = loginserviceimpl;
	}

	/*
	 * 登陆验证
	 */
	public String doLogin() {
		session.put("username", username);
		String password2 = loginserviceimpl.findPwdByName(username);
		if (password2 != "") { // 验证用户名是否已创建
			if (password.equals(password2)) {// 验证密码是否正确
				return "success";
			} else {
				msg = "密码有误，请重新输入";
				return "fail";
			}
		} else {
			msg = "用户名有误，请重新输入";
			return "noUser";
		}
	}

	/*
	 * 注册账号
	 */
	public String doReg() {
		User user = new User();
		if (loginserviceimpl.hasPwd(username)) { // user_name不重复
			user.setUsername(username);
			user.setPassword(password);
			loginserviceimpl.doReg(user);
			return "success";
		} else {
			msg = "该用户名已被注册，请更换用户名";
			return "fail";
		}
	}

}
