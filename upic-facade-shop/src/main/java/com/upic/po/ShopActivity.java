package com.upic.po;

import java.util.Date;

import com.upic.common.entity.BaseEntity;

/**
 * 活动类
 * @author Administrator
 *
 */
public class ShopActivity extends BaseEntity {
	private static final long serialVersionUID = 1L;
	/** 活动详情 **/
	private String activityDetails;
	/** 活动开始时间 **/
	private Date activityStartTime;
	/** 活动结束时间 **/
	private Date activityEndTime;
	/** 活动人数 **/
	private double activityPersonNum;
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

	public ShopActivity() {
		super();
	}

	public ShopActivity(String activityDetails, Date activityStartTime, Date activityEndTime,
			double activityPersonNum, Integer shopId, String field1, String field2, String field3, String field4,
			String field5) {
		super();
		this.activityDetails = activityDetails;
		this.activityStartTime = activityStartTime;
		this.activityEndTime = activityEndTime;
		this.activityPersonNum = activityPersonNum;
		this.shopId = shopId;
		this.field1 = field1;
		this.field2 = field2;
		this.field3 = field3;
		this.field4 = field4;
		this.field5 = field5;
	}

	public String getActivityDetails() {
		return activityDetails;
	}

	public void setActivityDetails(String activityDetails) {
		this.activityDetails = activityDetails;
	}

	public Date getActivityStartTime() {
		return activityStartTime;
	}

	public void setActivityStartTime(Date activityStartTime) {
		this.activityStartTime = activityStartTime;
	}

	public Date getActivityEndTime() {
		return activityEndTime;
	}

	public void setActivityEndTime(Date activityEndTime) {
		this.activityEndTime = activityEndTime;
	}

	public double getActivityPersonNum() {
		return activityPersonNum;
	}

	public void setActivityPersonNum(double activityPersonNum) {
		this.activityPersonNum = activityPersonNum;
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
