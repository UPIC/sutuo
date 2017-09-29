package com.upic.po;

import java.util.Date;

public class OrderCollect {
	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;
	/** 创建时间 **/
	private Date createTime;
	/** 订单号 **/
	private String mainId;
	/** 订单ID **/
	private String orderId;
	/** 订单价格 **/
	private double price;
	/** 订单状态 **/
	private String status;
	/** 订单类型 **/
	private String orderClass;
	/** 用户ID **/
	private Integer userId;
	/** 商品数量 **/
	private Integer shopCount;
	/** 商品图片 **/
	private String pic;
	/** 商品名 **/
	private String shopName;
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
	/** 商品编号 **/
	private String shopNumber;

	public OrderCollect() {
		super();
	}

	public OrderCollect(Date createTime, String mainId, String orderId, double price, String status, String orderClass, Integer userId,
			Integer shopCount, String pic, String shopName, String field1, String field2, String field3, String field4,
			String field5, String shopNumber) {
		super();
		this.createTime = createTime;
		this.mainId = mainId;
		this.orderId = orderId;
		this.price = price;
		this.status = status;
		this.orderClass = orderClass;
		this.userId = userId;
		this.shopCount = shopCount;
		this.pic = pic;
		this.shopName = shopName;
		this.field1 = field1;
		this.field2 = field2;
		this.field3 = field3;
		this.field4 = field4;
		this.field5 = field5;
		this.shopNumber = shopNumber;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getMainId() {
		return mainId;
	}

	public void setMainId(String mainId) {
		this.mainId = mainId;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getOrderClass() {
		return orderClass;
	}

	public void setOrderClass(String orderClass) {
		this.orderClass = orderClass;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getShopCount() {
		return shopCount;
	}

	public void setShopCount(Integer shopCount) {
		this.shopCount = shopCount;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
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

	public String getShopNumber() {
		return shopNumber;
	}

	public void setShopNumber(String shopNumber) {
		this.shopNumber = shopNumber;
	}
}
