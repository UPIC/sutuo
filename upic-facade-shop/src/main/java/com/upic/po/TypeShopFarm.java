package com.upic.po;

import com.upic.common.entity.BaseEntity;

/**
 * 订单
 * 
 * @author DTZ
 *
 */
public class TypeShopFarm extends BaseEntity implements Comparable<TypeShopFarm>{
	private static final long serialVersionUID = 1L;
	/** 商家ID **/
	private long storeId;
	/** 商家编号 **/
	private String storeNumber;
	/** 类型名称 **/
	private String typeName;
	/** NUM **/
	private int num;
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

	public TypeShopFarm() {
		super();
	}

	public TypeShopFarm(long storeId, String storeNumber, String typeName, int num, String field1, String field2,
			String field3, String field4, String field5) {
		super();
		this.storeId = storeId;
		this.storeNumber = storeNumber;
		this.typeName = typeName;
		this.num = num;
		this.field1 = field1;
		this.field2 = field2;
		this.field3 = field3;
		this.field4 = field4;
		this.field5 = field5;
	}

	public long getStoreId() {
		return storeId;
	}

	public void setStoreId(long storeId) {
		this.storeId = storeId;
	}

	public String getStoreNumber() {
		return storeNumber;
	}

	public void setStoreNumber(String storeNumber) {
		this.storeNumber = storeNumber;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
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

	@Override
	public int compareTo(TypeShopFarm o) {
		return o.getNum()-this.num;
	}

}
