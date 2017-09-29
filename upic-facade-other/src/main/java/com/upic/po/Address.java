package com.upic.po;

import com.upic.common.entity.BaseEntity;

public class Address extends BaseEntity {
	private static final long serialVersionUID = 1L;
	/** 详细地址 **/
	private String addressDetails;
	/** 用户ID **/
	private Integer userId;
	/** 邮编 **/
	private String zipCode;
	/** 省 **/
	private String provinceName;
	/** 城市 **/
	private String cityName;
	/** 县 **/
	private String districtName;
	/** 收件人姓名 **/
	private String recipientsName;
	/** 收件人手机号 **/
	private String phoneNum;
	/**是否为默认地址**/
	private Integer defaultAddress;
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

	public Address() {
		super();
	}

	public Address(String addressDetails, Integer userId, String zipCode, String provinceName, String cityName,
			String districtName, String recipientsName, String phoneNum, Integer defaultAddress, String field1, String field2, String field3,
			String field4, String field5) {
		super();
		this.addressDetails = addressDetails;
		this.userId = userId;
		this.zipCode = zipCode;
		this.provinceName = provinceName;
		this.cityName = cityName;
		this.districtName = districtName;
		this.recipientsName = recipientsName;
		this.phoneNum = phoneNum;
		this.defaultAddress = defaultAddress;
		this.field1 = field1;
		this.field2 = field2;
		this.field3 = field3;
		this.field4 = field4;
		this.field5 = field5;
	}

	public String getAddressDetails() {
		return addressDetails;
	}

	public void setAddressDetails(String addressDetails) {
		this.addressDetails = addressDetails;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getDistrictName() {
		return districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	public String getRecipientsName() {
		return recipientsName;
	}

	public void setRecipientsName(String recipientsName) {
		this.recipientsName = recipientsName;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
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

	public Integer getDefaultAddress() {
		return defaultAddress;
	}

	public void setDefaultAddress(Integer defaultAddress) {
		this.defaultAddress = defaultAddress;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
