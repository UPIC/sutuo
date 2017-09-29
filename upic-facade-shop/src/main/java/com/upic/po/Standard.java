package com.upic.po;

import com.upic.common.entity.BaseEntity;

public class Standard extends BaseEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/** 商品第一属性 **/
	private String standardTypeFirst;
	/** 商品第一属性值 **/
	private String standardFirst;
	/** 商品第二属性 **/
	private String standardTypeSecond;
	/** 商品第二属性值 **/
	private String standardSecond;
	/** 商品第三属性 **/
	private String standardTypeThird;
	/** 商品第三属性值 **/
	private String standardThird;
	/** 价格 **/
	private double price;
	/** 数量 **/
	private int count;
	/** 商品ID **/
	private int shopId;
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

	public Standard() {
		super();
	}

	public Standard(String standardTypeFirst, String standardFirst, String standardTypeSecond, String standardSecond,
			String standardTypeThird, String standardThird, double price, int count, int shopId, String field1,
			String field2, String field3, String field4, String field5) {
		super();
		this.standardTypeFirst = standardTypeFirst;
		this.standardFirst = standardFirst;
		this.standardTypeSecond = standardTypeSecond;
		this.standardSecond = standardSecond;
		this.standardTypeThird = standardTypeThird;
		this.standardThird = standardThird;
		this.price = price;
		this.count = count;
		this.shopId = shopId;
		this.field1 = field1;
		this.field2 = field2;
		this.field3 = field3;
		this.field4 = field4;
		this.field5 = field5;
	}

	public String getStandardTypeFirst() {
		return standardTypeFirst;
	}

	public void setStandardTypeFirst(String standardTypeFirst) {
		this.standardTypeFirst = standardTypeFirst;
	}

	public String getStandardFirst() {
		return standardFirst;
	}

	public void setStandardFirst(String standardFirst) {
		this.standardFirst = standardFirst;
	}

	public String getStandardTypeSecond() {
		return standardTypeSecond;
	}

	public void setStandardTypeSecond(String standardTypeSecond) {
		this.standardTypeSecond = standardTypeSecond;
	}

	public String getStandardSecond() {
		return standardSecond;
	}

	public void setStandardSecond(String standardSecond) {
		this.standardSecond = standardSecond;
	}

	public String getStandardTypeThird() {
		return standardTypeThird;
	}

	public void setStandardTypeThird(String standardTypeThird) {
		this.standardTypeThird = standardTypeThird;
	}

	public String getStandardThird() {
		return standardThird;
	}

	public void setStandardThird(String standardThird) {
		this.standardThird = standardThird;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getShopId() {
		return shopId;
	}

	public void setShopId(int shopId) {
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
