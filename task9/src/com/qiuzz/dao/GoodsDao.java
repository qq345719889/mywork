package com.qiuzz.dao;

import java.util.List;

import com.qiuzz.property.Commodity;

public interface GoodsDao {
	/*
	 * 添加商品信息
	 */
	public void saveCommodity(Commodity commodity);

	/*
	 * 查找系统内所有的商品信息
	 */
	public List<Commodity> findAllGoods();
}
