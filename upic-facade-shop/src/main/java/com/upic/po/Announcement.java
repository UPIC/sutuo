package com.upic.po;

import com.upic.common.entity.BaseEntity;

public class Announcement extends BaseEntity {
	private static final long serialVersionUID = 1L;
	private Integer status;
	private String content;
	private String contenetUrl;
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

	public Announcement() {
		super();
	}

	public Announcement(Integer status, String content, String contenetUrl, String field1, String field2, String field3,
			String field4, String field5) {
		super();
		this.status = status;
		this.content = content;
		this.contenetUrl = contenetUrl;
		this.field1 = field1;
		this.field2 = field2;
		this.field3 = field3;
		this.field4 = field4;
		this.field5 = field5;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getContenetUrl() {
		return contenetUrl;
	}

	public void setContenetUrl(String contenetUrl) {
		this.contenetUrl = contenetUrl;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
