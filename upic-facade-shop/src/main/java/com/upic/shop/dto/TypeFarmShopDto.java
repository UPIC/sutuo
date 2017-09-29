package com.upic.shop.dto;

import java.io.Serializable;

public class TypeFarmShopDto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private long typeId;
	private long shopId;
	private String shopNumber;
	private String shopName;
	private String shopTitle;
	private double primeCost;
	private double shopPrice;
	private String shopClass;
	private String headPic;

	public TypeFarmShopDto() {
		super();
	}

	public TypeFarmShopDto(long typeId, long shopId, String shopNumber, String shopName, String shopTitle,
			double primeCost, double shopPrice, String shopClass, String headPic) {
		super();
		this.typeId = typeId;
		this.shopId = shopId;
		this.shopNumber = shopNumber;
		this.shopName = shopName;
		this.shopTitle = shopTitle;
		this.primeCost = primeCost;
		this.shopPrice = shopPrice;
		this.shopClass = shopClass;
		this.headPic = headPic;
	}

	public long getTypeId() {
		return typeId;
	}

	public void setTypeId(long typeId) {
		this.typeId = typeId;
	}

	public long getShopId() {
		return shopId;
	}

	public void setShopId(long shopId) {
		this.shopId = shopId;
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

	public double getPrimeCost() {
		return primeCost;
	}

	public void setPrimeCost(double primeCost) {
		this.primeCost = primeCost;
	}

	public double getShopPrice() {
		return shopPrice;
	}

	public void setShopPrice(double shopPrice) {
		this.shopPrice = shopPrice;
	}

	public String getShopClass() {
		return shopClass;
	}

	public void setShopClass(String shopClass) {
		this.shopClass = shopClass;
	}

	public String getHeadPic() {
		return headPic;
	}

	public void setHeadPic(String headPic) {
		this.headPic = headPic;
	}
}
