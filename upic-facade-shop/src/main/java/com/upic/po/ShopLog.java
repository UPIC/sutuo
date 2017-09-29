package com.upic.po;

import com.upic.common.entity.BaseEntity;

public class ShopLog extends BaseEntity {
	private static final long serialVersionUID = 1L;
	/** 商品编号 **/
	private String shopNumber;
	/** 商家编号 **/
	private String storeNumber;
	/** 处理后状态 **/
	private String handleStatus;
	/** 消费状态 **/
	private String consumptionStatus;
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

	public ShopLog() {
		super();
	}

	public ShopLog(String shopNumber, String handleStatus, String consumptionStatus, String field1, String field2,
			String field3, String field4, String field5) {
		super();
		this.shopNumber = shopNumber;
		this.handleStatus = handleStatus;
		this.consumptionStatus = consumptionStatus;
		this.field1 = field1;
		this.field2 = field2;
		this.field3 = field3;
		this.field4 = field4;
		this.field5 = field5;
	}

	public String getShopNumber() {
		return shopNumber;
	}

	public void setShopNumber(String shopNumber) {
		this.shopNumber = shopNumber;
	}

	public String getHandleStatus() {
		return handleStatus;
	}

	public void setHandleStatus(String handleStatus) {
		this.handleStatus = handleStatus;
	}

	public String getConsumptionStatus() {
		return consumptionStatus;
	}

	public void setConsumptionStatus(String consumptionStatus) {
		this.consumptionStatus = consumptionStatus;
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

	public String getStoreNumber() {
		return storeNumber;
	}

	public void setStoreNumber(String storeNumber) {
		this.storeNumber = storeNumber;
	}
	
}
