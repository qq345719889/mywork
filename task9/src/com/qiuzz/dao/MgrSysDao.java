package com.qiuzz.dao;

import java.util.List;

public interface MgrSysDao {
	/*
	 * 判断是否是管理用户
	 */
	public Boolean isMgr(String username);

	/*
	 * 成为系统管理员
	 */
	public void toBeMgr(String username);

	/*
	 * 查找系统内所有的用户
	 */
	public List<String> findAllUserName();

	/*
	 * 根据用户名删除数据
	 */
	public void deleteUser(String username);
}
