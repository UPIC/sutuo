package com.upic.po;

import com.upic.common.entity.BaseEntity;

@SuppressWarnings("serial")
public class LeaveMessage extends BaseEntity {

	
	/** 文本 **/
	private String content;

	/** openid **/
	private String oppenId;

	/** 用户名 **/
	private String username;

	/** 手机号 **/
	private String phoneNum;

	/** 头像 **/
	private String headPic;

	/** 添加字段 **/
	private String field1;

	/** 添加字段 **/
	private String field2;

	/** 添加字段 **/
	private String field3;

	/** 添加字段 **/
	private String field4;

	/** 添加字段 **/
	private String field5;

	public LeaveMessage(String content, String oppenId, String username, String phoneNum, String headPic, String field1,
			String field2, String field3, String field4, String field5) {
		super();
		this.content = content;
		this.oppenId = oppenId;
		this.username = username;
		this.phoneNum = phoneNum;
		this.headPic = headPic;
		this.field1 = field1;
		this.field2 = field2;
		this.field3 = field3;
		this.field4 = field4;
		this.field5 = field5;
	}

	public LeaveMessage() {
		super();
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getOppenId() {
		return oppenId;
	}

	public void setOppenId(String oppenId) {
		this.oppenId = oppenId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getHeadPic() {
		return headPic;
	}

	public void setHeadPic(String headPic) {
		this.headPic = headPic;
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
