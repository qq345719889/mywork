package com.qiuzz.service.impl;

import java.util.List;

import com.qiuzz.dao.impl.MgrSysImpl;
import com.qiuzz.service.MgrSysService;

public class MgrSysServiceImpl implements MgrSysService{
	private MgrSysImpl mgrsysimpl;

	public MgrSysImpl getMgrsysimpl() {
		return mgrsysimpl;
	}

	public void setMgrsysimpl(MgrSysImpl mgrsysimpl) {
		this.mgrsysimpl = mgrsysimpl;
	}
/*
 * 成为系统管理员
 */
	public void toBeMgr(String username) {
		mgrsysimpl.toBeMgr(username);
	}

	/*
	 * 删除用户
	 */
	public void deleteUser(String username) {
		mgrsysimpl.deleteUser(username);
	}

	/*
	 * 查询系统内所有用户
	 */
	public List<String> findAllUserName() {
		return mgrsysimpl.findAllUserName();
	}

	/*
	 * 判断是否有管理员权限
	 */
	public boolean isMgr(String username) {
		return mgrsysimpl.isMgr(username);
	}
}
