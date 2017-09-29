package com.upic.po;

import com.upic.common.entity.BaseEntity;

public class SignPn extends BaseEntity implements Comparable<SignPn>{
	private static final long serialVersionUID = 1L;
	/** ��־ **/
	private String signPn;
	/** ����ֶ�1 **/
	private String field1;
	/** ����ֶ�2 **/
	private String field2;
	/** ����ֶ�3 **/
	private String field3;
	/** ����ֶ�4 **/
	private String field4;
	/** ����ֶ�5 **/
	private String field5;
	
	private Integer status;
	/**图片**/
	private String pic;
	/**排序**/
	private int num;
	public SignPn() {
		super();
	}

	public SignPn(String signPn, String field1, String field2, String field3, String field4, String field5) {
		super();
		this.signPn = signPn;
		this.field1 = field1;
		this.field2 = field2;
		this.field3 = field3;
		this.field4 = field4;
		this.field5 = field5;
	}

	public String getSignPn() {
		return signPn;
	}

	public void setSignPn(String signPn) {
		this.signPn = signPn;
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

	@Override
	public int compareTo(SignPn o) {
		if (this.num > o.num) {
			return 0;
		}
		return -1;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}
}
