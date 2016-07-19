package com.qiuzz.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.qiuzz.property.Commodity;
import com.qiuzz.service.GoodsService;

public class GoodsAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private GoodsService goodsservice;
	private String commodityName;
	private double price;
	private double agio;
	private List<Commodity> goodsinfo;

	public GoodsService getGoodsservice() {
		return goodsservice;
	}

	public void setGoodsservice(GoodsService goodsservice) {
		this.goodsservice = goodsservice;
	}

	public String getCommodityName() {
		return commodityName;
	}

	public void setCommodityName(String commodityName) {
		this.commodityName = commodityName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getAgio() {
		return agio;
	}

	public void setAgio(double agio) {
		this.agio = agio;
	}

	public List<Commodity> getGoodsinfo() {
		return goodsinfo;
	}

	public void setGoodsinfo(List<Commodity> goodsinfo) {
		this.goodsinfo = goodsinfo;
	}

	public String addGoods() {
		Commodity commodity = new Commodity(commodityName, price, agio);
		goodsservice.addGoods(commodity);
		return SUCCESS;
	}

	public String queryGoods() {
		goodsinfo = goodsservice.findAllGoods();
		return SUCCESS;
	}
}
