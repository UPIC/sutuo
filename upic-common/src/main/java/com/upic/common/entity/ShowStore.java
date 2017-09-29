package com.upic.common.entity;

public class ShowStore {
	/** 商家编号 **/
	private String storeNumber;
	/** 商家名称 **/
	private String storeName;
	/** 商家标题 **/
	private String storeTitle;
	/** 商家主题 **/
	private String themetz;
	/** 商家头像 **/
	private String storeHeadPic;
	/** 属于项目 **/
	private String project;
	/**城市**/
	private String city;
	/** 主营业务 **/
	private String mainShops;
	/** 坐标X **/
	private String labX;
	/** 坐标Y **/
	private String labY;
	/** 距离 **/
	private double distance;
	/** 扩展字段1 **/
	private String field1;
	/** 扩展字段2 **/
	private String field2;
	/** 扩展字段3 **/
	private String field3;
	/** 扩展字段4 **/
	private String field4;
	/** 扩展字段5 **/
	private String field5;
	/** 背景圖 **/
	private String backPic;
	/** 標題 **/
	private String title;
	/**人均**/
	private String avgCost;
	public ShowStore() {
		super();
	}

	public ShowStore(String storeNumber, String storeName, String storeTitle, String themetz, String storeHeadPic,
			String project, String mainShops, String labX, String labY, double distance, String field1, String field2,
			String field3, String field4, String field5, String backPic, String title) {
		super();
		this.storeNumber = storeNumber;
		this.storeName = storeName;
		this.storeTitle = storeTitle;
		this.themetz = themetz;
		this.storeHeadPic = storeHeadPic;
		this.project = project;
		this.mainShops = mainShops;
		this.labX = labX;
		this.labY = labY;
		this.distance = distance;
		this.field1 = field1;
		this.field2 = field2;
		this.field3 = field3;
		this.field4 = field4;
		this.field5 = field5;
		this.backPic = backPic;
		this.title = title;
	}

	public String getStoreNumber() {
		return storeNumber;
	}

	public void setStoreNumber(String storeNumber) {
		this.storeNumber = storeNumber;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getStoreTitle() {
		return storeTitle;
	}

	public void setStoreTitle(String storeTitle) {
		this.storeTitle = storeTitle;
	}

	public String getThemetz() {
		return themetz;
	}

	public void setThemetz(String themetz) {
		this.themetz = themetz;
	}

	public String getStoreHeadPic() {
		return storeHeadPic;
	}

	public void setStoreHeadPic(String storeHeadPic) {
		this.storeHeadPic = storeHeadPic;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public String getMainShops() {
		return mainShops;
	}

	public void setMainShops(String mainShops) {
		this.mainShops = mainShops;
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

	public String getBackPic() {
		return backPic;
	}

	public void setBackPic(String backPic) {
		this.backPic = backPic;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}

	public String getAvgCost() {
		return avgCost;
	}

	public void setAvgCost(String avgCost) {
		this.avgCost = avgCost;
	}


	
}
