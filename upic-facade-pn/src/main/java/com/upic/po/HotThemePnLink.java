package com.upic.po;

import com.upic.common.entity.BaseEntity;

public class HotThemePnLink extends BaseEntity {
	private static final long serialVersionUID = 1L;
	/** 标志ID **/
	private long hotThemePnId;
	/** 总表ID **/
	private long typePnId;
	/** 标志 **/
	private String hotThemePn;
	/** 图片 **/
	private String pic;
	/** 标题 **/
	private String title;
	/** 文章名 **/
	private String articalPnName;
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
	/** 类型 **/
	private String type;

	public HotThemePnLink() {
		super();
	}

	public HotThemePnLink(long hotThemePnId, long typePnId, String hotThemePn, String pic, String title, String articalPnName,
			String field1, String field2, String field3, String field4, String field5, String type) {
		super();
		this.hotThemePnId = hotThemePnId;
		this.typePnId = typePnId;
		this.hotThemePn = hotThemePn;
		this.pic = pic;
		this.title = title;
		this.articalPnName = articalPnName;
		this.field1 = field1;
		this.field2 = field2;
		this.field3 = field3;
		this.field4 = field4;
		this.field5 = field5;
		this.type = type;
	}

	public long getHotThemePnId() {
		return hotThemePnId;
	}

	public void setHotThemePnId(long hotThemePnId) {
		this.hotThemePnId = hotThemePnId;
	}

	public long getTypePnId() {
		return typePnId;
	}

	public void setTypePnId(long typePnId) {
		this.typePnId = typePnId;
	}

	public String getHotThemePn() {
		return hotThemePn;
	}

	public void setHotThemePn(String hotThemePn) {
		this.hotThemePn = hotThemePn;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArticalPnName() {
		return articalPnName;
	}

	public void setArticalPnName(String articalPnName) {
		this.articalPnName = articalPnName;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
