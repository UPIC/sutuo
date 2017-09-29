package com.upic.common.entity;

import java.io.Serializable;
import java.util.Date;

public class ShowShop implements Serializable{
	/** 商品编号 **/
	private String shopNumber;
	/** 商品名 **/
	private String shopName;
	/**人次**/
	private int peopleNum;
	/** 商品标题 **/
	private String shopTitle;
	/** 商品价格 **/
	private String shopPrice;
	/** 最后上架时间 **/
	private Date lastGroundingTime;
	/** 主题（吃住游购娱） **/
	private String theme;
	/** 商品标签（烧烤） **/
	private String signName;
	/** 商品头像 **/
	private String shopHeadPic;
	/** 属于项目 **/
	private String project;
	/** 获取商品主题（户外） **/
	private String themetz;
	/** 商家ID **/
	private String storeId;
	/** 商家名 **/
	private String storeName;
	/**城市**/
	private String city;
	/**地区**/
	private String district;
	/** 坐标X **/
	private String labX;
	/** 坐标Y **/
	private String labY;
	/** 距离 **/
	private double distance;
	/**扩展字段1**/
	private String field1;
	/**扩展字段2**/
	private String field2;
	/**扩展字段3**/
	private String field3;
	/**扩展字段4**/
	private String field4;
	/**扩展字段5**/
	private String field5;
	public ShowShop() {
		super();
	}

	public ShowShop(String shopNumber, String shopName, String shopTitle, String shopPrice, Date lastGroundingTime,
			String theme, String signName, String shopHeadPic, String project, String themetz, String storeId,
			String storeName, String labX, String labY, double distance) {
		super();
		this.shopNumber = shopNumber;
		this.shopName = shopName;
		this.shopTitle = shopTitle;
		this.shopPrice = shopPrice;
		this.lastGroundingTime = lastGroundingTime;
		this.theme = theme;
		this.signName = signName;
		this.shopHeadPic = shopHeadPic;
		this.project = project;
		this.themetz = themetz;
		this.storeId = storeId;
		this.storeName = storeName;
		this.labX = labX;
		this.labY = labY;
		this.distance = distance;
	}

	public String getShopNumber() {
		return shopNumber;
	}

	public void setShopNumber(String shopNumber) {
		this.shopNumber = shopNumber;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getShopTitle() {
		return shopTitle;
	}

	public void setShopTitle(String shopTitle) {
		this.shopTitle = shopTitle;
	}

	public String getShopPrice() {
		return shopPrice;
	}

	public void setShopPrice(String shopPrice) {
		this.shopPrice = shopPrice;
	}

	public Date getLastGroundingTime() {
		return lastGroundingTime;
	}

	public void setLastGroundingTime(Date lastGroundingTime) {
		this.lastGroundingTime = lastGroundingTime;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public String getSignName() {
		return signName;
	}

	public void setSignName(String signName) {
		this.signName = signName;
	}

	public String getShopHeadPic() {
		return shopHeadPic;
	}

	public void setShopHeadPic(String shopHeadPic) {
		this.shopHeadPic = shopHeadPic;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public String getThemetz() {
		return themetz;
	}

	public void setThemetz(String themetz) {
		this.themetz = themetz;
	}

	public String getStoreId() {
		return storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getLabX() {
		return labX;
	}

	public void setLabX(String labX) {
		this.labX = labX;
	}

	public String getLabY() {
		return labY;
	}

	public void setLabY(String labY) {
		this.labY = labY;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public int getPeopleNum() {
		return peopleNum;
	}

	public void setPeopleNum(int peopleNum) {
		this.peopleNum = peopleNum;
	}
	
}
