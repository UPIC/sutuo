package com.upic.po;

import com.upic.common.entity.BaseEntity;

public class TypePn extends BaseEntity {
	private static final long serialVersionUID = 1L;
	/** 类型 **/
	private String typePn;
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
	/**表题**/
	private String title;
	/**图片地址**/
	private String picUrl;
	/**文章名字**/
	private String articName;
	/**主题**/
	private String themeName;
	/**状态**/
	private Integer status;
	/**编号**/
	private String typePnNumber;
	
	/** 申请日期开始时间 **/
	private String orderDateBegin;
	/** 申请日期结束时间 **/
	private String orderDateEnd;
	public TypePn() {
		super();
	}

	public TypePn(String typePn, String field1, String field2, String field3, String field4, String field5) {
		super();
		this.typePn = typePn;
		this.field1 = field1;
		this.field2 = field2;
		this.field3 = field3;
		this.field4 = field4;
		this.field5 = field5;
	}

	public String getTypePn() {
		return typePn;
	}

	public void setTypePn(String typePn) {
		this.typePn = typePn;
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

	public String getThemeName() {
		return themeName;
	}

	public void setThemeName(String themeName) {
		this.themeName = themeName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public String getArticName() {
		return articName;
	}

	public void setArticName(String articName) {
		this.articName = articName;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getTypePnNumber() {
		return typePnNumber;
	}

	public void setTypePnNumber(String typePnNumber) {
		this.typePnNumber = typePnNumber;
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
	
}
