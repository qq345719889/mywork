package com.qiuzz.action;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.qiuzz.property.Commodity;
import com.qiuzz.property.Consume;
import com.qiuzz.property.Vip;
import com.qiuzz.service.GoodsService;
import com.qiuzz.service.VipDoService;

public class VipDoAction extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = 1L;
	private VipDoService vipdoservice;
	private Map<String, Object> session;
	private Date joinTime;
	private String name;
	private Integer age;
	private String profession;
	private List<Vip> vip;
	private List goodsinfo;
	private GoodsService goodsservice;
	private int vipId;
	private int commodityId;
	private List<Consume> consumeinfo;


	public List<Consume> getConsumeinfo() {
		return consumeinfo;
	}

	public void setConsumeinfo(List<Consume> consumeinfo) {
		this.consumeinfo = consumeinfo;
	}

	public int getCommodityId() {
		return commodityId;
	}

	public void setCommodityId(int commodityId) {
		this.commodityId = commodityId;
	}

	public int getVipId() {
		return vipId;
	}

	public void setVipId(int vipId) {
		this.vipId = vipId;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public GoodsService getGoodsservice() {
		return goodsservice;
	}

	public void setGoodsservice(GoodsService goodsservice) {
		this.goodsservice = goodsservice;
	}

	public VipDoService getVipdoservice() {
		return vipdoservice;
	}

	public void setVipdoservice(VipDoService vipdoservice) {
		this.vipdoservice = vipdoservice;
	}

	public List<Vip> getVip() {
		return vip;
	}

	public void setVip(List<Vip> vip) {
		this.vip = vip;
	}

	public Date getJoinTime() {
		return joinTime;
	}

	public void setJoinTime(Date joinTime) {
		this.joinTime = joinTime;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public List getGoodsinfo() {
		return goodsinfo;
	}

	public void setGoodsinfo(List goodsinfo) {
		this.goodsinfo = goodsinfo;
	}

	public void setSession(Map<String, Object> arg0) {// 获取session对象
		session = arg0;
	}

	/*
	 * 添加VIP信息
	 */
	public String toBeVip() {
		Vip vip = new Vip(joinTime, name, age, profession);
		vipdoservice.toBeVip(vip);
		return SUCCESS;
	}

	/*
	 * 查询出vip卡号和商品信息
	 */
	public String toVipBuy() {
		vip = vipdoservice.queryVipId();
		goodsinfo = goodsservice.findAllGoods();
		return SUCCESS;
	}

	/*
	 * 登记Vip用户的购物信息
	 */
	public String vipBuy() {
		name = vipdoservice.queryVipById(vipId);
		Vip vipsg = new Vip(vipId, name);
		Commodity commoditysg = vipdoservice.queryCommodity(commodityId);
		String commodityName = commoditysg.getCommodityName();
		Double price = commoditysg.getPrice();
		Double practicePrice = price * commoditysg.getAgio();
		Consume consume = new Consume(commoditysg, vipsg, name, commodityName,
				price, practicePrice);
		vipdoservice.saveConsume(consume);
		return SUCCESS;
	}
	/*
	 * 查询出vip卡号
	 */
		public String vipIdQuery() {
			vip = vipdoservice.queryVipId();
			return SUCCESS;
		}
/*
 * 查询出vip登记购物详情
 */
	public String vipInfoQuery() {
		System.out.println(vipId);
		consumeinfo=vipdoservice.queryConsume(vipId);
		return SUCCESS;
	}
}
