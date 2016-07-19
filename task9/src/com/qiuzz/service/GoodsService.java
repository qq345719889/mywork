package com.qiuzz.service;

import java.util.List;

import com.qiuzz.property.Commodity;

public interface GoodsService {
	/*
	 * 添加商品
	 */
	public void addGoods(Commodity commodity);

	/*
	 * 查找系统内所有的商品信息
	 */
	public List<Commodity> findAllGoods();
}
