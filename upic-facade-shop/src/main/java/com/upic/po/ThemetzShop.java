package com.upic.po;

import com.upic.common.entity.BaseEntity;

public class ThemetzShop extends BaseEntity {
	private static final long serialVersionUID = 1L;
	/** 商品ID **/
	private Integer shopId;
	/** 主题ID **/
	private Integer themetzId;
	/** 主题 **/
	private String themetz;
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

	public ThemetzShop() {
		super();
	}

	public ThemetzShop(Integer shopId, Integer themetzId, String themetz, String field1, String field2, String field3,
			String field4, String field5) {
		super();
		this.shopId = shopId;
		this.themetzId = themetzId;
		this.themetz = themetz;
		this.field1 = field1;
		this.field2 = field2;
		this.field3 = field3;
		this.field4 = field4;
		this.field5 = field5;
	}

	public Integer getShopId() {
		return shopId;
	}

	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}

	public Integer getThemetzId() {
		return themetzId;
	}

	public void setThemetzId(Integer themetzId) {
		this.themetzId = themetzId;
	}

	public String getThemetz() {
		return themetz;
	}

	public void setThemetz(String themetz) {
		this.themetz = themetz;
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
