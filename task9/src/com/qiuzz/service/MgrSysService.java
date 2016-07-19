package com.qiuzz.service;

import java.util.List;

public interface MgrSysService {
	/*
	 * 删除用户
	 */
	public void deleteUser(String username);

	/*
	 * 查询系统内所有用户
	 */
	public List<String> findAllUserName();

	/*
	 * 判断是否有管理员权限
	 */
	public boolean isMgr(String username);
	/*
	 * 成为系统管理员
	 */
		public void toBeMgr(String username);
}
