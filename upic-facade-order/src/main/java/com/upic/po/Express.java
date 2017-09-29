package com.upic.po;

import java.io.Serializable;

/**
 * 快递
 * 
 * @author Administrator
 *
 */
public class Express implements Serializable {
	private static final long serialVersionUID = 1L;
	/** 订单号 **/
	private String orderId;
	/** 创建时间 **/
	private String createTime;
	/** 邮编 **/
	private String zipCode;
	/** 省 **/
	private String provinceName;
	/** 市 **/
	private String cityName;
	/** 区 **/
	private String districtName;
	/** 详细地址 **/
	private String addressDetils;
	/** 收件人 **/
	private String recipentsName;
	/** 手机号 **/
	private String phoneNum;
	/** 是否发货 **/
	private String deliveryStatus;
	/** 订单日期开始时间 **/
	private String orderDateBegin;
	/** 订单日期结束时间 **/
	private String orderDateEnd;
	/** 商品名 **/
	private String shopName;
	/** 商品数量 **/
	private int shopCount;
	/** 快递单号 **/
	private String courierNumber;
	/** 用户确认收获，订单完成 **/
	private String confirmReceipt;

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getDistrictName() {
		return districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	public String getAddressDetils() {
		return addressDetils;
	}

	public void setAddressDetils(String addressDetils) {
		this.addressDetils = addressDetils;
	}

	public String getRecipentsName() {
		return recipentsName;
	}

	public void setRecipentsName(String recipentsName) {
		this.recipentsName = recipentsName;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public Express(String orderId, String createTime, String zipCode, String provinceName, String cityName,
			String districtName, String addressDetils, String recipentsName, String phoneNum) {
		super();
		this.orderId = orderId;
		this.createTime = createTime;
		this.zipCode = zipCode;
		this.provinceName = provinceName;
		this.cityName = cityName;
		this.districtName = districtName;
		this.addressDetils = addressDetils;
		this.recipentsName = recipentsName;
		this.phoneNum = phoneNum;
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

	public Express() {
		super();
	}

	public String getDeliveryStatus() {
		return deliveryStatus;
	}

	public void setDeliveryStatus(String deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public int getShopCount() {
		return shopCount;
	}

	public void setShopCount(int shopCount) {
		this.shopCount = shopCount;
	}

	public String getCourierNumber() {
		return courierNumber;
	}

	public void setCourierNumber(String courierNumber) {
		this.courierNumber = courierNumber;
	}

	public String getConfirmReceipt() {
		return confirmReceipt;
	}

	public void setConfirmReceipt(String confirmReceipt) {
		this.confirmReceipt = confirmReceipt;
	}
}
