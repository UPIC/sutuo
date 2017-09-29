package com.upic.po;

import java.util.Date;

import com.upic.common.entity.BaseEntity;

public class City extends BaseEntity{
	private String cityName; //城市名字
	private String zipCode; //邮编号
	private Integer provinceId; //省ID
	private Date dateUpdate;
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public Integer getProvinceId() {
		return provinceId;
	}
	public void setProvinceId(Integer provinceId) {
		this.provinceId = provinceId;
	}
	public Date getDateUpdate() {
		return dateUpdate;
	}
	public void setDateUpdate(Date dateUpdate) {
		this.dateUpdate = dateUpdate;
	}
	public City() {
		super();
	}
}
