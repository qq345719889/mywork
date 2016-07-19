package com.qiuzz.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.qiuzz.service.MgrSysService;

public class MgrSysAction extends ActionSupport implements SessionAware {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MgrSysService mgrsysserviceimpl;
	List<String> userinfo;
	private String usernamesg;
	private Map<String, Object> session;
	private String msg;

	public void setSession(Map<String, Object> arg0) {// 获取session对象
		session = arg0;
	}

	public MgrSysService getMgrsysserviceimpl() {
		return mgrsysserviceimpl;
	}

	public void setMgrsysserviceimpl(MgrSysService mgrsysserviceimpl) {
		this.mgrsysserviceimpl = mgrsysserviceimpl;
	}

	public List<String> getUserinfo() {
		return userinfo;
	}

	public void setUserinfo(List<String> userinfo) {
		this.userinfo = userinfo;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public String getUsernamesg() {
		return usernamesg;
	}

	public void setUsernamesg(String usernamesg) {
		this.usernamesg = usernamesg;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	/*
	 * 查看管理信息
	 */
	public String queryUser() {
		userinfo = mgrsysserviceimpl.findAllUserName();
		return "success";
	}

	/*
	 * 删除用户
	 */
	public String deleteUser() {
		if (mgrsysserviceimpl.isMgr(session.get("username").toString())) {
			mgrsysserviceimpl.deleteUser(usernamesg);
			userinfo = mgrsysserviceimpl.findAllUserName();
			msg = "删除成功！";
			return "success";
		} else {
			userinfo = mgrsysserviceimpl.findAllUserName();
			msg = "删除失败，您没有管理权限！";
			return "fail";
		}
	}

	/*
	 * 成为管理员
	 */
	public String toBeMgr() {
			if (!mgrsysserviceimpl.isMgr(usernamesg)) {
				mgrsysserviceimpl.toBeMgr(usernamesg);
				return "success";
			} else {
				return "fail";
			}
		}
	}
