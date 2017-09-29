package com.upic.po;

import com.upic.common.entity.BaseEntity;

public class ThemeArea extends BaseEntity implements Comparable<ThemeArea> {
	private static final long serialVersionUID = 1L;
	/** ͼƬ **/
	private String picUrl;
	/** ���� **/
	private String description;
	/** ��ת���� **/
	private String forwordType;
	/** ��תID **/
	private String forwordId;
	/** ���� **/
	private int themeAreaNum;
	/** ����ֶ�1 **/
	private String field1;
	/** ����ֶ�2 **/
	private String field2;
	/** ����ֶ�3 **/
	private String field3;
	/** ����ֶ�4 **/
	private String field4;
	/** ����ֶ�5 **/
	private String field5;
	
	/** 添加日期开始时间 **/
	private String orderDateBegin;
	/** 添加日期结束时间 **/
	private String orderDateEnd;
	
	private String status;
	public ThemeArea() {
		super();
	}

	public ThemeArea(String picUrl, String description, String forwordType, String forwordId, int themeAreaNum,
			String field1, String field2, String field3, String field4, String field5) {
		super();
		this.picUrl = picUrl;
		this.description = description;
		this.forwordType = forwordType;
		this.forwordId = forwordId;
		this.themeAreaNum = themeAreaNum;
		this.field1 = field1;
		this.field2 = field2;
		this.field3 = field3;
		this.field4 = field4;
		this.field5 = field5;
	}

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public int getThemeAreaNum() {
		return themeAreaNum;
	}

	public void setThemeAreaNum(int themeAreaNum) {
		this.themeAreaNum = themeAreaNum;
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
	public int compareTo(ThemeArea o) {
		if (this.getThemeAreaNum() > o.getThemeAreaNum()) {
			return 1;
		} else if (this.getThemeAreaNum() < o.getThemeAreaNum()) {
			return -1;
		}
		return 0;
	}

	public String getOrderDateBegin() {
		return orderDateBegin;
	}

	public void setOrderDateBegin(String orderDateBegin) {
		this.orderDateBegin = orderDateBegin;
	}

	public String getOrderDateEnd() {
		return orderDateEnd;
	}

	public void setOrderDateEnd(String orderDateEnd) {
		this.orderDateEnd = orderDateEnd;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
