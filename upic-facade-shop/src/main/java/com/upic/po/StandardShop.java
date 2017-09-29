package com.upic.po;

import com.upic.common.entity.BaseEntity;

public class StandardShop extends BaseEntity {
	private static final long serialVersionUID = 1L;
	/** 商品属性Id **/
	private String standardShopId;
	/** 商品类型1 **/
	private String standardTypeFirst;
	/** 商品类型2 **/
	private String standardTypeSecond;
	/** 商品类型3 **/
	private String standardTypeThird;
	/** 商品Id **/
	private Integer shopId;
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

	public StandardShop() {
		super();
	}

	public StandardShop(String standardShopId, String standardTypeFirst, String standardTypeSecond,
			String standardTypeThird, Integer shopId, String field1, String field2, String field3, String field4,
			String field5) {
		super();
		this.standardShopId = standardShopId;
		this.standardTypeFirst = standardTypeFirst;
		this.standardTypeSecond = standardTypeSecond;
		this.standardTypeThird = standardTypeThird;
		this.shopId = shopId;
		this.field1 = field1;
		this.field2 = field2;
		this.field3 = field3;
		this.field4 = field4;
		this.field5 = field5;
	}

	public String getStandardShopId() {
		return standardShopId;
	}

	public void setStandardShopId(String standardShopId) {
		this.standardShopId = standardShopId;
	}

	public String getStandardTypeFirst() {
		return standardTypeFirst;
	}

	public void setStandardTypeFirst(String standardTypeFirst) {
		this.standardTypeFirst = standardTypeFirst;
	}

	public String getStandardTypeSecond() {
		return standardTypeSecond;
	}

	public void setStandardTypeSecond(String standardTypeSecond) {
		this.standardTypeSecond = standardTypeSecond;
	}

	public String getStandardTypeThird() {
		return standardTypeThird;
	}

	public void setStandardTypeThird(String standardTypeThird) {
		this.standardTypeThird = standardTypeThird;
	}

	public Integer getShopId() {
		return shopId;
	}

	public void setShopId(Integer shopId) {
		this.shopId = shopId;
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
