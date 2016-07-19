package com.qiuzz.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.qiuzz.dao.MgrSysDao;
import com.qiuzz.property.User;

public class MgrSysImpl implements MgrSysDao {
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/*
	 * 判断是否是管理用户
	 */
	public Boolean isMgr(String username) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			User user = (User) session.get(User.class, username);
			if ((user.getQuanxian() != null) &&( user.getQuanxian() == 1)) {
				tx = session.beginTransaction();
				tx.commit(); // 提交事务
				return true;
			} else {
				tx = session.beginTransaction();
				tx.commit(); // 提交事务
				return false;
			}
		} catch (RuntimeException e) {
			tx.rollback(); // 回滚事务
			throw e;
		} finally {
			session.close(); // 关闭线程
		}
	}

	/*
	 * 成为系统管理员
	 */
	public void toBeMgr(String username) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			User user = (User) session.get(User.class, username);
			user.setQuanxian(1);// vip权限为1
			session.update(user);
			tx = session.beginTransaction();
			tx.commit(); // 提交事务
		} catch (RuntimeException e) {
			tx.rollback(); // 回滚事务
			throw e;
		} finally {
			session.close(); // 关闭线程
		}
	}

	/*
	 * 查找系统内所有的用户
	 */
	public List<String> findAllUserName() {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			String sql = "select username from user";
			List<String> list = session.createSQLQuery(sql).list();
			tx.commit(); // 提交事务
			return list;
		} catch (RuntimeException e) {
			tx.rollback();// 回滚事务
			throw e;
		} finally {
			session.close();// 关闭线程
		}
	}

	/*
	 * 根据用户名删除数据
	 */
	public void deleteUser(String username) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			String hql = "delete from user where username='" + username + "'";
			session.createSQLQuery(hql).executeUpdate();
			tx.commit(); // 提交事务
		} catch (RuntimeException e) {
			tx.rollback();// 回滚事务
			throw e;
		} finally {
			session.close();// 关闭线程
		}
	}
}
