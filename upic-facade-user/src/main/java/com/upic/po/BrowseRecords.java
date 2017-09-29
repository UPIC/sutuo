package com.upic.po;

import com.upic.common.entity.BaseEntity;

public class BrowseRecords extends BaseEntity{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String userName;
	private String openId;
	private String userLogo;
	private String shopName;
	private String shopNumber;
	private String storeNumber;
	/**商品主题**/
	private String shopTheme;
	/**商品类型**/
	private String shopType;
	/**商品种别**/
	private String shopClass;
	/** 浏览记录日期开始时间 **/
    private String orderDateBegin;
    /** 浏览记录日期结束时间 **/
    private String orderDateEnd;
	private String field1;
	private String field2;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getOpenId() {
		return openId;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	public String getUserLogo() {
		return userLogo;
	}
	public void setUserLogo(String userLogo) {
		this.userLogo = userLogo;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
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
	public BrowseRecords(String userName, String openId, String userLogo, String shopName, String shopNumber, String field1,
			String field2) {
		super();
		this.userName = userName;
		this.openId = openId;
		this.userLogo = userLogo;
		this.shopName = shopName;
		this.shopNumber = shopNumber;
		this.field1 = field1;
		this.field2 = field2;
	}
	public BrowseRecords() {
		super();
	}
	public String getShopTheme() {
		return shopTheme;
	}
	public void setShopTheme(String shopTheme) {
		this.shopTheme = shopTheme;
	}
	public String getShopType() {
		return shopType;
	}
	public void setShopType(String shopType) {
		this.shopType = shopType;
	}
	public String getShopClass() {
		return shopClass;
	}
	public void setShopClass(String shopClass) {
		this.shopClass = shopClass;
	}
	
}
