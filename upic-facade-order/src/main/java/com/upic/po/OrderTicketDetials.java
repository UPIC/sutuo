package com.upic.po;

import java.util.Date;

import com.upic.common.entity.BaseEntity;

/**
 * 订单详情
 * 
 * @author zhubuqing
 *
 */
public class OrderTicketDetials extends BaseEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/** 订单ID **/
	private Integer orderId;
	/** 商品编号 **/
	private String shopNum;
	/** 客户姓名 **/
	private String username;
	/** 客户手机号 **/
	private String phoneNumber;
	/** 校对码 **/
	private String confirmCode;
	/** 商品名 **/
	private String shopName;
	/** 用户ID **/
	private Integer userId;
	/** url **/
	private String url;
	/** 价格 **/
	private double price;
	/** 数量 **/
	private int shopCount;
	/** 约定时间 **/
	private Date dueTime;
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

	public OrderTicketDetials() {
		super();
	}

	public OrderTicketDetials(Integer orderId, String shopNum, String username, String phoneNumber, String confirmCode,
			String shopName, Integer userId, String url, double price, int shopCount, Date dueTime, String field1,
			String field2, String field3, String field4, String field5) {
		super();
		this.orderId = orderId;
		this.shopNum = shopNum;
		this.username = username;
		this.phoneNumber = phoneNumber;
		this.confirmCode = confirmCode;
		this.shopName = shopName;
		this.userId = userId;
		this.url = url;
		this.price = price;
		this.shopCount = shopCount;
		this.dueTime = dueTime;
		this.field1 = field1;
		this.field2 = field2;
		this.field3 = field3;
		this.field4 = field4;
		this.field5 = field5;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public String getShopNum() {
		return shopNum;
	}

	public void setShopNum(String shopNum) {
		this.shopNum = shopNum;
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

	public String getConfirmCode() {
		return confirmCode;
	}

	public void setConfirmCode(String confirmCode) {
		this.confirmCode = confirmCode;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
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

	public Date getDueTime() {
		return dueTime;
	}

	public void setDueTime(Date dueTime) {
		this.dueTime = dueTime;
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
