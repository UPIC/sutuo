package com.upic.po;

import com.upic.common.entity.BaseEntity;

/**
 * 订单
 * 
 * @author DTZ
 *
 */
public class StoreFarm extends BaseEntity {
	private static final long serialVersionUID = 1L;
	/** 商家ID **/
	private long storeId;
	/** Json字符串 **/
	private String consumAndService;
	/** 多少起送 **/
	private double canTransport;
	/** 商家编号 **/
	private String storeNumber;
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

	public StoreFarm() {
		super();
	}

	public StoreFarm(long storeId, String consumAndService, double canTransport, String field1, String field2,
			String field3, String field4, String field5, String storeNumber) {
		super();
		this.storeId = storeId;
		this.consumAndService = consumAndService;
		this.canTransport = canTransport;
		this.field1 = field1;
		this.field2 = field2;
		this.field3 = field3;
		this.field4 = field4;
		this.field5 = field5;
		this.storeNumber = storeNumber;
	}

	public long getStoreId() {
		return storeId;
	}

	public void setStoreId(long storeId) {
		this.storeId = storeId;
	}

	public String getConsumAndService() {
		return consumAndService;
	}

	public void setConsumAndService(String consumAndService) {
		this.consumAndService = consumAndService;
	}

	public double getCanTransport() {
		return canTransport;
	}

	public void setCanTransport(double canTransport) {
		this.canTransport = canTransport;
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
