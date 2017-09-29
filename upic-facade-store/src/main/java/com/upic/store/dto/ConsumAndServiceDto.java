package com.upic.store.dto;

import java.io.Serializable;
import java.util.Date;

public class ConsumAndServiceDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private String type;

	private Date startTime;

	private Date endTime;

	private double full;

	private double down;

	private String remark;

	public ConsumAndServiceDto() {
		super();
	}

	public ConsumAndServiceDto(String type, Date startTime, Date endTime, double full, double down, String remark) {
		super();
		this.type = type;
		this.startTime = startTime;
		this.endTime = endTime;
		this.full = full;
		this.down = down;
		this.remark = remark;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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

	public double getFull() {
		return full;
	}

	public void setFull(double full) {
		this.full = full;
	}

	public double getDown() {
		return down;
	}

	public void setDown(double down) {
		this.down = down;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}
