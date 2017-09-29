package com.upic.po;

import com.upic.common.entity.BaseEntity;

public class ModuleList extends BaseEntity implements Comparable<ModuleList>{
	private static final long serialVersionUID = 1L;
	/** 模版列表 **/
	private String moduleName;
	/** 标题 **/
	private String title;
	/** 图片 **/
	private String pic;
	/** 跳转ID **/
	private long forwordId;
	/** 跳转地址 **/
	private String forwordAddress;
	/** 跳转类型 **/
	private String forwordType;
	/** 状态 **/
	private String status;
	/** 添加字段1 type**/
	private String field1;
	/** 添加字段2 **/
	private String field2;
	/** 添加字段3 **/
	private String field3;
	/** 添加字段4 **/
	private String field4;
	/** 添加字段5 **/
	private String field5;
	/**num编号**/
	private Integer num;
	public ModuleList() {
		super();
	}

	public ModuleList(String moduleName, String title, String pic, long forwordId, String forwordAddress,
			String forwordType, String status, String field1, String field2, String field3, String field4,
			String field5) {
		super();
		this.moduleName = moduleName;
		this.title = title;
		this.pic = pic;
		this.forwordId = forwordId;
		this.forwordAddress = forwordAddress;
		this.forwordType = forwordType;
		this.status = status;
		this.field1 = field1;
		this.field2 = field2;
		this.field3 = field3;
		this.field4 = field4;
		this.field5 = field5;
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public long getForwordId() {
		return forwordId;
	}

	public void setForwordId(long forwordId) {
		this.forwordId = forwordId;
	}

	public String getForwordAddress() {
		return forwordAddress;
	}

	public void setForwordAddress(String forwordAddress) {
		this.forwordAddress = forwordAddress;
	}

	public String getForwordType() {
		return forwordType;
	}

	public void setForwordType(String forwordType) {
		this.forwordType = forwordType;
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

	
	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	@Override
	public int compareTo(ModuleList o) {
		return this.num-o.getNum();
	}
}
