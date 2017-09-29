package com.upic.po;

import java.util.Date;

import com.upic.common.entity.BaseEntity;

public class Shop extends BaseEntity {
	private static final long serialVersionUID = 1L;
	/** 人次 **/
	private String avgCost = "1";
	/** 商品头像 **/
	private String headPic;
	/** 商家编号 **/
	private String storeNumber;
	/** 商品编号 **/
	private String shopNumber;
	/** 商品类型 **/
	private String shopType;
	/** 商品名字 **/
	private String shopName;
	/** 商品标题 **/
	private String shopTitle;
	/** 商品最终销售价格 **/
	private double shopPrice;
	/** 商品内容简介 **/
	private String content;
	/** 商品状况 **/
	private Integer status;
	/** 商品原价 **/
	private double primeCost;
	/** 库存 **/
	private Integer inventory;
	/** 运费 **/
	private double freight;
	/** 购买方式 **/
	private String buyWay;
	/** 商品类型（虚拟产物）（实体产物） **/
	private String shopClass;
	/** 是否预售 **/
	private int isPresell;
	/** 预售时间 **/
	private Date presellTime;
	/** 预计发货开始时间 **/
	private Date predeliverStartTime;
	/** 预计发货结束时间 **/
	private Date predeliverEndTime;
	/** 最后上架时间 **/
	private Date lastGroundingTime;
	/** 购买的最小数额 **/
	private Integer limitCount;
	/** 浏览量 **/
	private int pageView;
	/** 主题 **/
	private String themeName;
	/** 添加字段1 **/
	private String field1;
	/** 添加字段2 **/
	private String field2;
	/** 添加字段3 **/
	private String field3;
	/** 添加字段4 **/
	private String field4;
	/** 添加字段5 **/
	private String field5;
	/** 申请日期开始时间 **/
	private String orderDateBegin;
	/** 申请日期结束时间 **/
	private String orderDateEnd;
	/** 购买须知 **/
	private String purchaseNotes;
	/** 限购 **/
	private int limitBuy;

	public Shop() {
		super();
	}

	public Shop(String avgCost, String headPic, String storeNumber, String shopNumber, String shopType, String shopName,
			String shopTitle, double shopPrice, String content, Integer status, double primeCost, Integer inventory,
			double freight, String buyWay, String shopClass, int isPresell, Date presellTime, Date predeliverStartTime,
			Date predeliverEndTime, Date lastGroundingTime, Integer limitCount, int pageView, String themeName,
			String field1, String field2, String field3, String field4, String field5, String orderDateBegin,
			String orderDateEnd, String purchaseNotes, int limitBuy) {
		super();
		this.avgCost = avgCost;
		this.headPic = headPic;
		this.storeNumber = storeNumber;
		this.shopNumber = shopNumber;
		this.shopType = shopType;
		this.shopName = shopName;
		this.shopTitle = shopTitle;
		this.shopPrice = shopPrice;
		this.content = content;
		this.status = status;
		this.primeCost = primeCost;
		this.inventory = inventory;
		this.freight = freight;
		this.buyWay = buyWay;
		this.shopClass = shopClass;
		this.isPresell = isPresell;
		this.presellTime = presellTime;
		this.predeliverStartTime = predeliverStartTime;
		this.predeliverEndTime = predeliverEndTime;
		this.lastGroundingTime = lastGroundingTime;
		this.limitCount = limitCount;
		this.pageView = pageView;
		this.themeName = themeName;
		this.field1 = field1;
		this.field2 = field2;
		this.field3 = field3;
		this.field4 = field4;
		this.field5 = field5;
		this.orderDateBegin = orderDateBegin;
		this.orderDateEnd = orderDateEnd;
		this.purchaseNotes = purchaseNotes;
		this.limitBuy = limitBuy;
	}

	public String getStoreNumber() {
		return storeNumber;
	}

	public void setStoreNumber(String storeNumber) {
		this.storeNumber = storeNumber;
	}

	public String getShopNumber() {
		return shopNumber;
	}

	public void setShopNumber(String shopNumber) {
		this.shopNumber = shopNumber;
	}

	public String getShopType() {
		return shopType;
	}

	public void setShopType(String shopType) {
		this.shopType = shopType;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getShopTitle() {
		return shopTitle;
	}

	public void setShopTitle(String shopTitle) {
		this.shopTitle = shopTitle;
	}

	public double getShopPrice() {
		return shopPrice;
	}

	public void setShopPrice(double shopPrice) {
		this.shopPrice = shopPrice;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public double getPrimeCost() {
		return primeCost;
	}

	public void setPrimeCost(double primeCost) {
		this.primeCost = primeCost;
	}

	public Integer getInventory() {
		return inventory;
	}

	public void setInventory(Integer inventory) {
		this.inventory = inventory;
	}

	public double getFreight() {
		return freight;
	}

	public void setFreight(double freight) {
		this.freight = freight;
	}

	public String getBuyWay() {
		return buyWay;
	}

	public void setBuyWay(String buyWay) {
		this.buyWay = buyWay;
	}

	public String getShopClass() {
		return shopClass;
	}

	public void setShopClass(String shopClass) {
		this.shopClass = shopClass;
	}

	public int getIsPresell() {
		return isPresell;
	}

	public void setIsPresell(int isPresell) {
		this.isPresell = isPresell;
	}

	public Date getPresellTime() {
		return presellTime;
	}

	public void setPresellTime(Date presellTime) {
		this.presellTime = presellTime;
	}

	public Date getPredeliverStartTime() {
		return predeliverStartTime;
	}

	public void setPredeliverStartTime(Date predeliverStartTime) {
		this.predeliverStartTime = predeliverStartTime;
	}

	public Date getPredeliverEndTime() {
		return predeliverEndTime;
	}

	public void setPredeliverEndTime(Date predeliverEndTime) {
		this.predeliverEndTime = predeliverEndTime;
	}

	public Date getLastGroundingTime() {
		return lastGroundingTime;
	}

	public void setLastGroundingTime(Date lastGroundingTime) {
		this.lastGroundingTime = lastGroundingTime;
	}

	public Integer getLimitCount() {
		return limitCount;
	}

	public void setLimitCount(Integer limitCount) {
		this.limitCount = limitCount;
	}

	public int getPageView() {
		return pageView;
	}

	public void setPageView(int pageView) {
		this.pageView = pageView;
	}

	public String getThemeName() {
		return themeName;
	}

	public void setThemeName(String themeName) {
		this.themeName = themeName;
	}

	public String getField1() {
		return field1;
	}

	public void setField1(String field1) {
		this.field1 = field1;
	}

	public String getField2() {
		return field2;
	}

	public void setField2(String field2) {
		this.field2 = field2;
	}

	public String getField3() {
		return field3;
	}

	public void setField3(String field3) {
		this.field3 = field3;
	}

	public String getField4() {
		return field4;
	}

	public void setField4(String field4) {
		this.field4 = field4;
	}

	public String getField5() {
		return field5;
	}

	public void setField5(String field5) {
		this.field5 = field5;
	}

	public String getOrderDateBegin() {
		return orderDateBegin;
	}

	public void setOrderDateBegin(String orderDateBegin) {
		this.orderDateBegin = orderDateBegin;
	}

	public String getOrderDateEnd() {
		return orderDateEnd;
	}

	public void setOrderDateEnd(String orderDateEnd) {
		this.orderDateEnd = orderDateEnd;
	}

	public String getPurchaseNotes() {
		return purchaseNotes;
	}

	public void setPurchaseNotes(String purchaseNotes) {
		this.purchaseNotes = purchaseNotes;
	}

	public String getHeadPic() {
		return headPic;
	}

	public void setHeadPic(String headPic) {
		this.headPic = headPic;
	}

	public String getAvgCost() {
		return avgCost;
	}

	public void setAvgCost(String avgCost) {
		this.avgCost = avgCost;
	}

	public int getLimitBuy() {
		return limitBuy;
	}

	public void setLimitBuy(int limitBuy) {
		this.limitBuy = limitBuy;
	}
}
