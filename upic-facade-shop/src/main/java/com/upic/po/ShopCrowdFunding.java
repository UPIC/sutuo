package com.upic.po;

import java.util.Date;

import com.upic.common.entity.BaseEntity;

public class ShopCrowdFunding extends BaseEntity {
	private static final long serialVersionUID = 1L;

	private Date startTime; // 开始时间

	private Date endTime; // 结束时间

	private double targetTime; // 目标金额

	private String content; // 众筹内容

	private String shopNumber; // 商品编号

	private String field1; // 添加字段1

	private String field2; // 添加字段2

	private String field3; // 添加字段3

	private String field4; // 添加字段4

	private String field5; // 添加字段5

	public ShopCrowdFunding() {
		super();
	}

	public ShopCrowdFunding(Date startTime, Date endTime, double targetTime, String content, String shopNumber,
			String field1, String field2, String field3, String field4, String field5) {
		super();
		this.startTime = startTime;
		this.endTime = endTime;
		this.targetTime = targetTime;
		this.content = content;
		this.shopNumber = shopNumber;
		this.field1 = field1;
		this.field2 = field2;
		this.field3 = field3;
		this.field4 = field4;
		this.field5 = field5;
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

	public double getTargetTime() {
		return targetTime;
	}

	public void setTargetTime(double targetTime) {
		this.targetTime = targetTime;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getShopNumber() {
		return shopNumber;
	}

	public void setShopNumber(String shopNumber) {
		this.shopNumber = shopNumber;
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
