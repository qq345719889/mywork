package com.qiuzz.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.qiuzz.dao.VipDoDao;
import com.qiuzz.property.Commodity;
import com.qiuzz.property.Consume;
import com.qiuzz.property.User;
import com.qiuzz.property.Vip;

public class VipDoImpl implements VipDoDao {
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/*
	 * 添加VIP信息
	 */
	public void toBeVip(Vip vip) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			session.save(vip);
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
	 * 添加购物车信息
	 */
	public void vipBuy(Consume consume) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			session.save(consume);
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
	 * 查询系统中的VipId号
	 */
	public List queryVipId() {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			String sql = "select new com.qiuzz.property.Vip(vipId,name) from Vip";
			tx = session.beginTransaction();
			List list = session.createQuery(sql).list();
			tx.commit(); // 提交事务
			return list;
		} catch (RuntimeException e) {
			tx.rollback(); // 回滚事务
			throw e;
		} finally {
			session.close(); // 关闭线程
		}
	}

	/*
	 * 根据系统中的VipId号，查名字
	 */
	public String queryVipById(int vipId) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			String sql = "select name from Vip where vipId='" + vipId + "'";
			tx = session.beginTransaction();
			List list = session.createQuery(sql).list();
			String name = list.get(0).toString();
			tx.commit(); // 提交事务
			return name;
		} catch (RuntimeException e) {
			tx.rollback(); // 回滚事务
			throw e;
		} finally {
			session.close(); // 关闭线程
		}
	}

	/*
	 * 根据商品编号查找详细的商品信息
	 */
	public Commodity queryComById(int commodityId) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			String sql = "select new com.qiuzz.property.Commodity(commodityId,commodityName,price,agio) from Commodity where commodityId='"
					+ commodityId + "'";
			List<Commodity> list = session.createQuery(sql).list();
			Commodity comd = list.get(0);
			tx.commit(); // 提交事务
			return comd;
		} catch (RuntimeException e) {
			tx.rollback();// 回滚事务
			throw e;
		} finally {
			session.close();// 关闭线程
		}
	}

	/*
	 * 保存传入的Consume类型数据
	 */
	public void saveConsume(Consume consume) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			session.save(consume);
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
	 * 根据系统中的VIP号查询商品登记情况
	 */
	public List<Consume> queryConsume(int vipId) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			String sql = "select new com.qiuzz.property.Consume(name,commodityName,price,practicePrice) from Consume where vipId='"
					+ vipId + "'";
			System.out.println("333333333333333333");
			List<Consume> list = session.createQuery(sql).list();
			System.out.println(list.size());
			tx.commit(); // 提交事务
			return list;
		} catch (RuntimeException e) {
			tx.rollback(); // 回滚事务
			throw e;
		} finally {
			session.close(); // 关闭线程
		}

	}
}
