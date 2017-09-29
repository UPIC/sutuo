package com.upic.po;

import com.upic.common.entity.BaseEntity;

public class MeituPn extends BaseEntity implements Comparable<MeituPn>{
	private static final long serialVersionUID = 1L;
	/** 内容text类型 **/
	private String content;
	/** 图片 **/
	private String pic;
	/**文章名字**/
	private String articName;
	/** 上传者 **/
	private long userId;
	/** 阅读量 **/
	private int pageView;
	/** 标题 **/
	private String title;
	/** 编号 **/
	private int num;
	/**父类编号**/
	private String fatherId;
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

	private String fatherNumber;
	public MeituPn() {
		super();
	}

	public MeituPn(String content, String pic, long userId, int pageView, String title, int num, String field1,
			String field2, String field3, String field4, String field5) {
		super();
		this.content = content;
		this.pic = pic;
		this.userId = userId;
		this.pageView = pageView;
		this.title = title;
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

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
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
	@Override
	public int compareTo(MeituPn o) {
		if (this.num > o.num) {
			return 1;
		}
		return -1;
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
