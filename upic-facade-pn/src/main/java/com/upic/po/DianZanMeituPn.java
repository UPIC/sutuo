package com.upic.po;

import com.upic.common.entity.BaseEntity;

public class DianZanMeituPn extends BaseEntity {
	private static final long serialVersionUID = 1L;
	/** 用户ID **/
	private String userId;
	/** 文章ID **/
	private String meituPnId;
	/** 点赞状态 **/
	private String status;
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

	public DianZanMeituPn() {
		super();
	}

	public DianZanMeituPn(String userId, String meituPnId, String status, String field1, String field2, String field3,
			String field4, String field5) {
		super();
		this.userId = userId;
		this.meituPnId = meituPnId;
		this.status = status;
		this.field1 = field1;
		this.field2 = field2;
		this.field3 = field3;
		this.field4 = field4;
		this.field5 = field5;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getMeituPnId() {
		return meituPnId;
	}

	public void setMeituPnId(String meituPnId) {
		this.meituPnId = meituPnId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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
}
