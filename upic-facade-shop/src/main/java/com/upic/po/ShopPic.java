package com.upic.po;

import com.upic.common.entity.BaseEntity;

public class ShopPic extends BaseEntity implements Comparable<ShopPic> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer shopId;
	private String picUrl;
	private Integer picNum;
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

	public ShopPic() {
		super();
	}

	public ShopPic(Integer shopId, String picUrl, Integer picNum, String field1, String field2, String field3,
			String field4, String field5) {
		super();
		this.shopId = shopId;
		this.picUrl = picUrl;
		this.picNum = picNum;
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

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public Integer getPicNum() {
		return picNum;
	}

	public void setPicNum(Integer picNum) {
		this.picNum = picNum;
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

	@Override
	public int compareTo(ShopPic o) {
		if (this.getPicNum() > o.getPicNum()) {
			return 1;
		} else if (this.getPicNum() < o.getPicNum()) {
			return -1;
		}
		return 0;
	}
}
