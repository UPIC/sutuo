package com.upic.po;

import com.upic.common.entity.BaseEntity;

@SuppressWarnings("serial")
public class Access extends BaseEntity {
	/** 类型 **/
	private String type;
	/** 省 **/
	private String privince;
	/** 市 **/
	private String city;
	/** 县 **/
	private String county;
	/** 商品名 **/
	private String shopName;
	/** 商店名 **/
	private String storeName;
	/** 商品编号 **/
	private String shopNumber;
	/** 商店编号**/
	private String storeNumber;
	/** 是否预约 **/
	private String isCall;
	/** 添加字段 **/
	private String field1;
	/** 添加字段 **/
	private String field2;
	/** 添加字段 **/
	private String field3;
	/** 添加字段 **/
	private String field4;
	/** 添加字段 **/
	private String field5;

	/** 申请日期开始时间 **/
	private String orderDateBegin;
	/** 申请日期结束时间 **/
	private String orderDateEnd;
	public Access() {
		super();
	}

	public Access(String type, String privince, String city, String county, String shopName, String storeName,
			String isCall, String field1, String field2, String field3, String field4, String field5) {
		super();
		this.type = type;
		this.privince = privince;
		this.city = city;
		this.county = county;
		this.shopName = shopName;
		this.storeName = storeName;
		this.isCall = isCall;
		this.field1 = field1;
		this.field2 = field2;
		this.field3 = field3;
		this.field4 = field4;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPrivince() {
		return privince;
	}

	public void setPrivince(String privince) {
		this.privince = privince;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getIsCall() {
		return isCall;
	}

	public void setIsCall(String isCall) {
		this.isCall = isCall;
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

	public String getStoreNumber() {
		return storeNumber;
	}

	public void setStoreNumber(String storeNumber) {
		this.storeNumber = storeNumber;
	}
	
}
