package com.upic.po;

import java.util.Date;

import com.upic.common.entity.BaseEntity;

public class District extends BaseEntity{

	private String districtName;//区域名字
	private Integer cityId; //城市编号
	private Date dateUpdate;
	public String getDistrictName() {
		return districtName;
	}
	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}
	public Integer getCityId() {
		return cityId;
	}
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}
	public District() {
		super();
	}
	public Date getDateUpdate() {
		return dateUpdate;
	}
	public void setDateUpdate(Date dateUpdate) {
		this.dateUpdate = dateUpdate;
	}
	
}
