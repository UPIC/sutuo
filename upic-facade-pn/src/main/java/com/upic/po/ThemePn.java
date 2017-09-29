package com.upic.po;

import com.upic.common.entity.BaseEntity;

public class ThemePn extends BaseEntity implements Comparable<ThemePn>{
	private static final long serialVersionUID = 1L;
	/** 品农主题 **/
	private String themePn;
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
	/**图片**/
	private String themePnPic;
	/**排序号**/
	private int num;
	/** 类型 **/
	private String type;
	/** 状态 **/
	private String status;
	public ThemePn() {
		super();
	}

	public ThemePn(String themetzFirst, String field1, String field2, String field3, String field4, String field5) {
		super();
		this.themePn = themetzFirst;
		this.field1 = field1;
		this.field2 = field2;
		this.field3 = field3;
		this.field4 = field4;
		this.field5 = field5;
	}

	public String getThemetzFirst() {
		return themePn;
	}

	public void setThemetzFirst(String themetzFirst) {
		this.themePn = themetzFirst;
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

	public String getThemePn() {
		return themePn;
	}

	public void setThemePn(String themePn) {
		this.themePn = themePn;
	}

	public String getThemePnPic() {
		return themePnPic;
	}

	public void setThemePnPic(String themePnPic) {
		this.themePnPic = themePnPic;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public int compareTo(ThemePn o) {
		if(this.num>o.getNum()){
			return 1;
		}
		return -1;
	}
	
}
