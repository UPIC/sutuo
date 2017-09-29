package com.upic.po;

import com.upic.common.entity.BaseEntity;

public class BannarPn extends BaseEntity implements Comparable<BannarPn> {
	private static final long serialVersionUID = 1L;
	/** URL **/
	private String url;
	/** 图片序号 **/
	private int picNumber;
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
	/** 图片类型 **/
	private String picType;
	/** 跳转类型 **/
	private String forwordType;
	/** 跳转ID **/
	private String forwordId;
	/** 状态 **/
	private Integer status;

	public BannarPn() {
		super();
	}

	public BannarPn(String url, int picNumber, String field1, String field2, String field3, String field4,
			String field5, String picType, String forwordType, String forwordId, Integer status) {
		super();
		this.url = url;
		this.picNumber = picNumber;
		this.field1 = field1;
		this.field2 = field2;
		this.field3 = field3;
		this.field4 = field4;
		this.field5 = field5;
		this.picType = picType;
		this.forwordType = forwordType;
		this.forwordId = forwordId;
		this.status = status;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getPicNumber() {
		return picNumber;
	}

	public void setPicNumber(int picNumber) {
		this.picNumber = picNumber;
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

	public String getPicType() {
		return picType;
	}

	public void setPicType(String picType) {
		this.picType = picType;
	}

	public String getForwordType() {
		return forwordType;
	}

	public void setForwordType(String forwordType) {
		this.forwordType = forwordType;
	}

	public String getForwordId() {
		return forwordId;
	}

	public void setForwordId(String forwordId) {
		this.forwordId = forwordId;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Override
	public int compareTo(BannarPn o) {
		if (this.picNumber > o.picNumber) {
			return 0;
		}
		return -1;
	}
}
