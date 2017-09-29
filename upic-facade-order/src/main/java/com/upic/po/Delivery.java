package com.upic.po;

import com.upic.common.entity.BaseEntity;

/**
 * 订单
 * 
 * @author DTZ
 *
 */
public class Delivery extends BaseEntity {
	private static final long serialVersionUID = 1L;
	/** 快递单号 **/
	private String courierNumber;
	/** 是否发货 **/
	private int deliveryStatus;
	/** 快递费 **/
	private double deliveryMoney;
	/** 订单ID **/
	private int orderId;
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

	public Delivery() {
		super();
	}

	public Delivery(String courierNumber, int deliveryStatus, double deliveryMoney, int orderId, String field1,
			String field2, String field3, String field4, String field5) {
		super();
		this.courierNumber = courierNumber;
		this.deliveryStatus = deliveryStatus;
		this.deliveryMoney = deliveryMoney;
		this.orderId = orderId;
		this.field1 = field1;
		this.field2 = field2;
		this.field3 = field3;
		this.field4 = field4;
		this.field5 = field5;
	}

	public String getCourierNumber() {
		return courierNumber;
	}

	public void setCourierNumber(String courierNumber) {
		this.courierNumber = courierNumber;
	}

	public int getDeliveryStatus() {
		return deliveryStatus;
	}

	public void setDeliveryStatus(int deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}

	public double getDeliveryMoney() {
		return deliveryMoney;
	}

	public void setDeliveryMoney(double deliveryMoney) {
		this.deliveryMoney = deliveryMoney;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
