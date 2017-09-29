package com.upic.po;

import com.upic.common.entity.BaseEntity;

public class StoreOwnRecommend extends BaseEntity implements Comparable<StoreOwnRecommend> {
	private static final long serialVersionUID = 1L;
	/** 地区市 **/
	private String city;
	/** 区 **/
	private String districtName;
	/** 省 **/
	private String provinceName;
	/** 商品ID **/
	private long shopId;
	/** 商品编号 **/
	private String shopNumber;
	/** 商品名 **/
	private String shopName;
	/** 价格 **/
	private String price;
	/** 图片 **/
	private String pic;
	/** 店铺ID **/
	private long storeId;
	/** 店铺编号 **/
	private String storeNumber;
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
	/** 添加日期开始时间 **/
	private String orderDateBegin;
	/** 添加日期结束时间 **/
	private String orderDateEnd;
	/** 排序 **/
	private int num;
	/** 商品状态 **/
	private int sStatus;

	public StoreOwnRecommend() {
		super();
	}

	public StoreOwnRecommend(String city, String districtName, String provinceName, long shopId, String shopNumber,
			String shopName, String price, String pic, long storeId, String storeNumber, String field1, String field2,
			String field3, String field4, String field5, String orderDateBegin, String orderDateEnd, int num,
			int sStatus) {
		super();
		this.city = city;
		this.districtName = districtName;
		this.provinceName = provinceName;
		this.shopId = shopId;
		this.shopNumber = shopNumber;
		this.shopName = shopName;
		this.price = price;
		this.pic = pic;
		this.storeId = storeId;
		this.storeNumber = storeNumber;
		this.field1 = field1;
		this.field2 = field2;
		this.field3 = field3;
		this.field4 = field4;
		this.field5 = field5;
		this.orderDateBegin = orderDateBegin;
		this.orderDateEnd = orderDateEnd;
		this.num = num;
		this.sStatus = sStatus;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrictName() {
		return districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
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

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public long getStoreId() {
		return storeId;
	}

	public void setStoreId(long storeId) {
		this.storeId = storeId;
	}

	public String getStoreNumber() {
		return storeNumber;
	}

	public void setStoreNumber(String storeNumber) {
		this.storeNumber = storeNumber;
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

	public String getOrderDateBegin() {
		return orderDateBegin;
	}

	public void setOrderDateBegin(String orderDateBegin) {
		this.orderDateBegin = orderDateBegin;
	}

	public String getOrderDateEnd() {
		return orderDateEnd;
	}

	public void setOrderDateEnd(String orderDateEnd) {
		this.orderDateEnd = orderDateEnd;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getsStatus() {
		return sStatus;
	}

	public void setsStatus(int sStatus) {
		this.sStatus = sStatus;
	}

	@Override
	public int compareTo(StoreOwnRecommend o) {
		if (o.num > this.num) {
			return -1;
		}
		return 1;
	}

}
