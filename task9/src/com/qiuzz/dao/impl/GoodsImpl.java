package com.qiuzz.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.qiuzz.dao.GoodsDao;
import com.qiuzz.property.Commodity;

public class GoodsImpl implements GoodsDao {
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/*
	 * 添加商品信息
	 */
	public void saveCommodity(Commodity commodity) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			session.save(commodity);
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
	 * 查找系统内所有的商品信息
	 */
	public List<Commodity> findAllGoods() {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			String sql = "select new com.qiuzz.property.Commodity(commodityId,commodityName,price,agio) from Commodity";
			List<Commodity> list = session.createQuery(sql).list();
			System.out.println(list.size());
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
