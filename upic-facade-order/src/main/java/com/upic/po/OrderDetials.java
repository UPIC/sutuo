package com.upic.po;

import com.upic.common.entity.BaseEntity;

/**
 * 订单详情
 * 
 * @author zhubuqing
 *
 */
public class OrderDetials extends BaseEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/** 价格 **/
	private double price;
	/** 数量 **/
	private int shopCount;
	/** 商品名 **/
	private String shopName;
	/** 商品类型 **/
	private String shopType;
	/** 商品编号 **/
	private String shopNumber;
	/** 订单ID **/
	private int orderId;
	/** 客户姓名 **/
	private String username;
	/** 客户手机号 **/
	private String phoneNumber;
	/** 用户ID **/
	private Integer userId;
	/** url **/
	private String url;
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

	public OrderDetials() {
		super();
	}

	public OrderDetials(double price, int shopCount, String shopName, String shopType, String shopNumber, int orderId,
			String username, String phoneNumber, Integer userId, String url, String field1, String field2,
			String field3, String field4, String field5) {
		super();
		this.price = price;
		this.shopCount = shopCount;
		this.shopName = shopName;
		this.shopType = shopType;
		this.shopNumber = shopNumber;
		this.orderId = orderId;
		this.username = username;
		this.phoneNumber = phoneNumber;
		this.userId = userId;
		this.url = url;
		this.field1 = field1;
		this.field2 = field2;
		this.field3 = field3;
		this.field4 = field4;
		this.field5 = field5;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getShopCount() {
		return shopCount;
	}

	public void setShopCount(int shopCount) {
		this.shopCount = shopCount;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getShopType() {
		return shopType;
	}

	public void setShopType(String shopType) {
		this.shopType = shopType;
	}

	public String getShopNumber() {
		return shopNumber;
	}

	public void setShopNumber(String shopNumber) {
		this.shopNumber = shopNumber;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
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
}
