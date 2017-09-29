package com.upic.po;

import java.io.Serializable;

import com.upic.common.entity.BaseEntity;

public class StoreCollection extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	/** 商品ID **/
	private long storeId;
	/** 商品编号 **/
	private String storeNumber;
	/** 商品名 **/
	private String storeName;
	/** 价格 **/
	private String avgCost;
	/** 图片 **/
	private String pic;
	/** 用户ID **/
	private long userId;
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
	/** 商品状态 **/
	private int sStatus;
	/** 类型 **/
	private String type;

	public StoreCollection() {
		super();
	}

	public StoreCollection(long storeId, String storeNumber, String storeName, String avgCost, String pic, long userId,
			String field1, String field2, String field3, String field4, String field5, int sStatus,
			String type) {
		super();
		this.storeId = storeId;
		this.storeNumber = storeNumber;
		this.storeName = storeName;
		this.avgCost = avgCost;
		this.pic = pic;
		this.userId = userId;
		this.field1 = field1;
		this.field2 = field2;
		this.field3 = field3;
		this.field4 = field4;
		this.field5 = field5;
		this.sStatus = sStatus;
		this.type = type;
	}

	public long getStoreId() {
		return storeId;
	}

	public void setStoreId(long storeId) {
		this.storeId = storeId;
	}

	public String getStoreNumber() {
		return storeNumber;
	}

	public void setStoreNumber(String storeNumber) {
		this.storeNumber = storeNumber;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getAvgCost() {
		return avgCost;
	}

	public void setAvgCost(String avgCost) {
		this.avgCost = avgCost;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
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

	public int getsStatus() {
		return sStatus;
	}

	public void setsStatus(int sStatus) {
		this.sStatus = sStatus;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
