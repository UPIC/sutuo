package com.upic.po;

import com.upic.common.entity.BaseEntity;

public class HotThemePn extends BaseEntity implements Comparable<HotThemePn>{
	private static final long serialVersionUID = 1L;
	/** 性质主题 **/
	private String hotThemePn;
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
	/** 图片 **/
	private String hotThemePnPic;
	/** 类型 **/
	private String type;
	/** 状态 **/
	private String status;
	/**num编号**/
	private Integer num;
	public HotThemePn() {
		super();
	}

	public HotThemePn(String hotThemePn, String field1, String field2, String field3, String field4, String field5,
			String hotThemePnPic, String type, String status) {
		super();
		this.hotThemePn = hotThemePn;
		this.field1 = field1;
		this.field2 = field2;
		this.field3 = field3;
		this.field4 = field4;
		this.field5 = field5;
		this.hotThemePnPic = hotThemePnPic;
		this.type = type;
		this.status = status;
	}

	public String getHotThemePn() {
		return hotThemePn;
	}

	public void setHotThemePn(String hotThemePn) {
		this.hotThemePn = hotThemePn;
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

	public String getHotThemePnPic() {
		return hotThemePnPic;
	}

	public void setHotThemePnPic(String hotThemePnPic) {
		this.hotThemePnPic = hotThemePnPic;
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

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	@Override
	public int compareTo(HotThemePn o) {
		return this.num-o.getNum();
	}

}
