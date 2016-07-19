package com.qiuzz.service.impl;

import java.util.List;

import com.qiuzz.dao.VipDoDao;
import com.qiuzz.property.Commodity;
import com.qiuzz.property.Consume;
import com.qiuzz.property.Vip;
import com.qiuzz.service.VipDoService;

public class VipDoServiceImpl implements VipDoService {
	private VipDoDao vipdoimpl;

	public VipDoDao getVipdoimpl() {
		return vipdoimpl;
	}

	public void setVipdoimpl(VipDoDao vipdoimpl) {
		this.vipdoimpl = vipdoimpl;
	}

	/*
	 * 添加VIP信息
	 */
	public void toBeVip(Vip vip) {
		vipdoimpl.toBeVip(vip);
	}

	public void vipBuy(Consume consume) {
		vipdoimpl.vipBuy(consume);
	}

	public List queryVipId() {
		return vipdoimpl.queryVipId();
	}

	public String queryVipById(int vipId) {
		return vipdoimpl.queryVipById(vipId);
	}

	public Commodity queryCommodity(int commodityId) {
		Commodity comd = vipdoimpl.queryComById(commodityId);
		return comd;
	}

	public void saveConsume(Consume consume) {
		vipdoimpl.saveConsume(consume);
	}

	public List<Consume> queryConsume(int vipId) {
		return vipdoimpl.queryConsume(vipId);
	}
}
