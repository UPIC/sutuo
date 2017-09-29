package com.upic.po;

import com.upic.common.entity.BaseEntity;

public class SignPnLink extends BaseEntity {
	private static final long serialVersionUID = 1L;
	/** 标志ID **/
	private long signPnId;
	/** 总表ID **/
	private long typePnId;
	/** 标志 **/
	private String signPn;
	/** 图片 **/
	private String pic;
	/** 标题 **/
	private String title;
	/** 文章名 **/
	private String articalName;
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

	public SignPnLink() {
		super();
	}

	public SignPnLink(long signPnId, long typePnId, String signPn, String pic, String title, String articalName,
			String field1, String field2, String field3, String field4, String field5) {
		super();
		this.signPnId = signPnId;
		this.typePnId = typePnId;
		this.signPn = signPn;
		this.pic = pic;
		this.title = title;
		this.articalName = articalName;
		this.field1 = field1;
		this.field2 = field2;
		this.field3 = field3;
		this.field4 = field4;
		this.field5 = field5;
	}

	public long getSignPnId() {
		return signPnId;
	}

	public void setSignPnId(long signPnId) {
		this.signPnId = signPnId;
	}

	public long getTypePnId() {
		return typePnId;
	}

	public void setTypePnId(long typePnId) {
		this.typePnId = typePnId;
	}

	public String getSignPn() {
		return signPn;
	}

	public void setSignPn(String signPn) {
		this.signPn = signPn;
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

	public String getArticalName() {
		return articalName;
	}

	public void setArticalName(String articalName) {
		this.articalName = articalName;
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
