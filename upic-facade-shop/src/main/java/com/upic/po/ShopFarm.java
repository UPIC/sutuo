package com.upic.po;

import java.util.Date;

import com.upic.common.entity.BaseEntity;

public class ShopFarm extends BaseEntity {
	private static final long serialVersionUID = 1L;
	/** 原产地 **/
	private String placeOfOrgin;
	/** 食品添加剂 **/
	private String foodAddiitive;
	/** 保质期 **/
	private Date qualityGuaranteePeriod;
	/** 储存温度 **/
	private double storageTemp;
	/** shopId **/
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

	public ShopFarm() {
		super();
	}

	public ShopFarm(String placeOfOrgin, String foodAddiitive, Date qualityGuaranteePeriod, double storageTemp,
			Integer shopId, String field1, String field2, String field3, String field4, String field5) {
		super();
		this.placeOfOrgin = placeOfOrgin;
		this.foodAddiitive = foodAddiitive;
		this.qualityGuaranteePeriod = qualityGuaranteePeriod;
		this.storageTemp = storageTemp;
		this.shopId = shopId;
		this.field1 = field1;
		this.field2 = field2;
		this.field3 = field3;
		this.field4 = field4;
		this.field5 = field5;
	}

	public String getPlaceOfOrgin() {
		return placeOfOrgin;
	}

	public void setPlaceOfOrgin(String placeOfOrgin) {
		this.placeOfOrgin = placeOfOrgin;
	}

	public String getFoodAddiitive() {
		return foodAddiitive;
	}

	public void setFoodAddiitive(String foodAddiitive) {
		this.foodAddiitive = foodAddiitive;
	}

	public Date getQualityGuaranteePeriod() {
		return qualityGuaranteePeriod;
	}

	public void setQualityGuaranteePeriod(Date qualityGuaranteePeriod) {
		this.qualityGuaranteePeriod = qualityGuaranteePeriod;
	}

	public double getStorageTemp() {
		return storageTemp;
	}

	public void setStorageTemp(double storageTemp) {
		this.storageTemp = storageTemp;
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
