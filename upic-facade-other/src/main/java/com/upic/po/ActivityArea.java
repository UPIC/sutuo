package com.upic.po;

import com.upic.common.entity.BaseEntity;

public class ActivityArea extends BaseEntity implements Comparable<ActivityArea>{
	private static final long serialVersionUID = 1L;
	/** 图片地址 **/
	private String picUrl;
	/** 描述 **/
	private String description;
	/** 跳转类型 **/
	private String forwordType;
	/** 跳转ID **/
	private String forwordId;
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
	/** 排序 **/
	private int activityAreaNum;

	/**状态**/
	private Integer status;
	public ActivityArea() {
		super();
	}

	public ActivityArea(String picUrl, String description, String forwordType, String forwordId, String field1,
			String field2, String field3, String field4, String field5, int activityAreaNum) {
		super();
		this.picUrl = picUrl;
		this.description = description;
		this.forwordType = forwordType;
		this.forwordId = forwordId;
		this.field1 = field1;
		this.field2 = field2;
		this.field3 = field3;
		this.field4 = field4;
		this.field5 = field5;
		this.activityAreaNum = activityAreaNum;
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

	public int getActivityAreaNum() {
		return activityAreaNum;
	}

	public void setActivityAreaNum(int activityAreaNum) {
		this.activityAreaNum = activityAreaNum;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Override
	public int compareTo(ActivityArea o) {
		if(this.activityAreaNum>o.getActivityAreaNum()){
			return 1;
		}
		return -1;
	}
}
