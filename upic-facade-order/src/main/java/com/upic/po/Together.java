package com.upic.po;

import java.util.Date;

import com.upic.common.entity.BaseEntity;

public class Together extends BaseEntity {
	private static final long serialVersionUID = 1L;
	/** 组局单号 **/
	private String togetherNumber;
	/** 订单号 **/
	private long orderId;
	/** 商品名 **/
	private String shopName;
	/** 价格 **/
	private String shopPrice;
	/** 商家名 **/
	private String storeName;
	/** 详细地点 **/
	private String detialAddress;
	/** 组局人数 **/
	private int togetherNum;
	/** 购买份数 **/
	private int num;
	/** 就餐时间 **/
	private Date userTime;
	/** 联系人 **/
	private String userName;
	/** 图片 **/
	private String pic;
	/** 联系人手机号 **/
	private String phone;
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

	public Together() {
		super();
	}

	public Together(String togetherNumber, long orderId, String shopName, String shopPrice, String storeName,
			String detialAddress, int togetherNum, int num, Date userTime, String userName,String pic, String phone,
			String field1, String field2, String field3, String field4, String field5) {
		super();
		this.togetherNumber = togetherNumber;
		this.orderId = orderId;
		this.shopName = shopName;
		this.shopPrice = shopPrice;
		this.storeName = storeName;
		this.detialAddress = detialAddress;
		this.togetherNum = togetherNum;
		this.num = num;
		this.userTime = userTime;
		this.userName = userName;
		this.pic = pic;
		this.phone = phone;
		this.field1 = field1;
		this.field2 = field2;
		this.field3 = field3;
		this.field4 = field4;
		this.field5 = field5;
	}

	public String getTogetherNumber() {
		return togetherNumber;
	}

	public void setTogetherNumber(String togetherNumber) {
		this.togetherNumber = togetherNumber;
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getShopPrice() {
		return shopPrice;
	}

	public void setShopPrice(String shopPrice) {
		this.shopPrice = shopPrice;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getDetialAddress() {
		return detialAddress;
	}

	public void setDetialAddress(String detialAddress) {
		this.detialAddress = detialAddress;
	}

	public int getTogetherNum() {
		return togetherNum;
	}

	public void setTogetherNum(int togetherNum) {
		this.togetherNum = togetherNum;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public Date getUserTime() {
		return userTime;
	}

	public void setUserTime(Date userTime) {
		this.userTime = userTime;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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
