package com.qiuzz.service.impl;

import java.util.List;

import com.qiuzz.dao.GoodsDao;
import com.qiuzz.property.Commodity;
import com.qiuzz.service.GoodsService;

public class GoodsServiceImpl implements GoodsService {
	private GoodsDao goodsimpl;

	public GoodsDao getGoodsimpl() {
		return goodsimpl;
	}

	public void setGoodsimpl(GoodsDao goodsimpl) {
		this.goodsimpl = goodsimpl;
	}

	/*
	 * 添加商品
	 */
	public void addGoods(Commodity commodity) {
		goodsimpl.saveCommodity(commodity);
	}

	/*
	 * 查找系统内所有的商品信息
	 */
	public List<Commodity> findAllGoods() {
		return goodsimpl.findAllGoods();
	}
}
