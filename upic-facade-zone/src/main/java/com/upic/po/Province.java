package com.upic.po;

import java.util.Date;

import com.upic.common.entity.BaseEntity;

public class Province extends BaseEntity{
	private String provinceName;//省名
	private Date dateUpdate; //更新时间
	public String getProvinceName() {
		return provinceName;
	}
	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}
	public Date getDateUpdate() {
		return dateUpdate;
	}
	public void setDateUpdate(Date dateUpdate) {
		this.dateUpdate = dateUpdate;
	}
	public Province(String provinceName, Date dateUpdate) {
		super();
		this.provinceName = provinceName;
		this.dateUpdate = dateUpdate;
	}
	public Province() {
		super();
	}
}
