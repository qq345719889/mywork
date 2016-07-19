package com.qiuzz.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.qiuzz.dao.LoginDao;
import com.qiuzz.property.User;

public class LoginImpl implements LoginDao {
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/*
	 * 保存传入的User类型数据
	 */
	public void saveUser(User user) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			session.save(user);
			tx = session.beginTransaction();
			tx.commit(); // 提交事务
		} catch (RuntimeException e) {
			session.getTransaction().rollback(); // 回滚事务
			throw e;
		} finally {
			session.close(); // 关闭线程
		}
	}

	/*
	 * 根据用户名查找密码
	 */
	public String findPwdByName(String name) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		String pwd = null;
		try {
			tx = session.beginTransaction();
			String sql = "select password from user where username='" + name
					+ "'";
			List<String> list = session.createSQLQuery(sql).list();
			for (String str : list) {
				pwd = str;
			}
			if (pwd == null) {
				pwd = "";
			}
			System.out.println("pwd++++=" + pwd);
			tx.commit(); // 提交事务
			return pwd;
		} catch (RuntimeException e) {
			session.getTransaction().rollback();// 回滚事务
			throw e;
		} finally {
			session.close();// 关闭线程
		}
	}

	/*
	 * 根据用户名查找该用户名所有信息
	 */
	public List<User> findAllByName(String name) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			String sql = "select new com.qiuzz.property.User(username,password,quanxian) from User where username='"
					+ name + "'";
			List<User> list = session.createQuery(sql).list();
			tx.commit(); // 提交事务
			return list;
		} catch (RuntimeException e) {
			session.getTransaction().rollback();// 回滚事务
			throw e;
		} finally {
			session.close();// 关闭线程
		}
	}

}
