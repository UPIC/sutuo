package com.upic.po;

import java.util.Date;

import com.upic.common.entity.BaseEntity;

public class ShopTicket extends BaseEntity {
	private static final long serialVersionUID = 1L;
	/** 票号 **/
	private String ticketNumber;
	/** 开始时间 **/
	private Date startTime;
	/** 结束时间 **/
	private Date endTime;
	/** 使用时间 **/
	private String useTime;
	/** 地点ID **/
	private Integer addressId;
	/** 活动详情 **/
	private String activityDetials;
	/** shopId **/
	private Integer shopId;
	/** 活动规则 **/
	private String relus;
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
	/** 推荐 **/
	private String advice;
	/** 简介 **/
	private String projectBrief;

	public ShopTicket() {
		super();
	}

	public ShopTicket(String ticketNumber, Date startTime, Date endTime, String useTime, Integer addressId,
			String activityDetials, Integer shopId, String relus, String field1, String field2, String field3,
			String field4, String field5, String advice, String projectBrief) {
		super();
		this.ticketNumber = ticketNumber;
		this.startTime = startTime;
		this.endTime = endTime;
		this.useTime = useTime;
		this.addressId = addressId;
		this.activityDetials = activityDetials;
		this.shopId = shopId;
		this.relus = relus;
		this.field1 = field1;
		this.field2 = field2;
		this.field3 = field3;
		this.field4 = field4;
		this.field5 = field5;
		this.advice = advice;
		this.projectBrief = projectBrief;
	}

	public String getTicketNumber() {
		return ticketNumber;
	}

	public void setTicketNumber(String ticketNumber) {
		this.ticketNumber = ticketNumber;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getUseTime() {
		return useTime;
	}

	public void setUseTime(String useTime) {
		this.useTime = useTime;
	}

	public Integer getAddressId() {
		return addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}

	public String getActivityDetials() {
		return activityDetials;
	}

	public void setActivityDetials(String activityDetials) {
		this.activityDetials = activityDetials;
	}

	public Integer getShopId() {
		return shopId;
	}

	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}

	public String getRelus() {
		return relus;
	}

	public void setRelus(String relus) {
		this.relus = relus;
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

	public String getAdvice() {
		return advice;
	}

	public void setAdvice(String advice) {
		this.advice = advice;
	}

	public String getProjectBrief() {
		return projectBrief;
	}

	public void setProjectBrief(String projectBrief) {
		this.projectBrief = projectBrief;
	}
}
