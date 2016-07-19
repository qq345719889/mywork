package com.qiuzz.dao;

import java.util.List;

import com.qiuzz.property.Commodity;
import com.qiuzz.property.Consume;
import com.qiuzz.property.Vip;

public interface VipDoDao {
	/*
	 * 将普通账号添加成为VIP账号
	 */
	public void toBeVip(Vip vip);

	/*
	 * 添加购物车信息
	 */
	public void vipBuy(Consume consume);

	/*
	 * 查询系统中的VipId号
	 */
	public List queryVipId();

	/*
	 * 根据系统中的VipId号，查名字
	 */
	public String queryVipById(int vipId);

	/*
	 * 保存传入的Consume类型数据
	 */
	public void saveConsume(Consume consume);

	/*
	 * 根据商品编号查找详细的商品信息
	 */
	public Commodity queryComById(int commodityId);
	
	/*
	 * 根据系统中的VIP号查询商品登记情况
	 */
	public List<Consume> queryConsume(int vipId);
}
