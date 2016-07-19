package com.qiuzz.service;

import java.util.List;

import com.qiuzz.property.Commodity;
import com.qiuzz.property.Consume;
import com.qiuzz.property.Vip;

public interface VipDoService {
	/*
	 * 添加VIP信息
	 */
	public void toBeVip(Vip vip);

	/*
	 * 查询vipid号
	 */
	public List queryVipId();

	public String queryVipById(int vipId);

	public Commodity queryCommodity(int commodityId);
	public void saveConsume(Consume consume);
	public List<Consume> queryConsume(int vipId) ;
}
