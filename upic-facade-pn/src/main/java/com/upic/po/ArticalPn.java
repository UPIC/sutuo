package com.upic.po;

import com.upic.common.entity.BaseEntity;

public class ArticalPn extends BaseEntity {
	private static final long serialVersionUID = 1L;
	/** 内容text类型 **/
	private String content;
	/** 图片 **/
	private String pic;
	/** 作者 **/
	private String author;
	/** 上传者 **/
	private long userId;
	/** 阅读量 **/
	private int pageView;
	/** 标题 **/
	private String title;
	/**文章名字**/
	private String articName;
	/** 原文链接 **/
	private String urlArtical;
	/** 编号 **/
	private String num;
	/**父类编号**/
	private String fatherId;
	/**父类编号**/
	private String fatherNumber;
	
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

	public ArticalPn() {
		super();
	}

	public ArticalPn(String content, String pic, String author, long userId, int pageView, String title,
			String urlArtical, String num, String field1, String field2, String field3, String field4, String field5) {
		super();
		this.content = content;
		this.pic = pic;
		this.author = author;
		this.userId = userId;
		this.pageView = pageView;
		this.title = title;
		this.urlArtical = urlArtical;
		this.num = num;
		this.field1 = field1;
		this.field2 = field2;
		this.field3 = field3;
		this.field4 = field4;
		this.field5 = field5;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public int getPageView() {
		return pageView;
	}

	public void setPageView(int pageView) {
		this.pageView = pageView;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrlArtical() {
		return urlArtical;
	}

	public void setUrlArtical(String urlArtical) {
		this.urlArtical = urlArtical;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
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

	public String getFatherId() {
		return fatherId;
	}

	public void setFatherId(String fatherId) {
		this.fatherId = fatherId;
	}

	public String getArticName() {
		return articName;
	}

	public void setArticName(String articName) {
		this.articName = articName;
	}

	public String getFatherNumber() {
		return fatherNumber;
	}

	public void setFatherNumber(String fatherNumber) {
		this.fatherNumber = fatherNumber;
	}
}
