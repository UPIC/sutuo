/**
 * wusc.edu.pay.common.enums.OpeStatusEnum.java
 */
package com.upic.controller.emun;

import java.util.HashMap;
import java.util.Map;

/**
 * <ul>
 * <li>Title: 企业操作枚举</li>
 * <li>Description:</li>
 * <li>Copyright: www.gzzyzz.com</li>
 * <li>Company:</li>
 * </ul>
 * 
 * 
 */
public enum OperUnitStatusEnum {

	SUCCESS("通过", 100), FAIL("未通过", 101),
	WAIT("审核", 102);
	/**
	 * 存贮值
	 */
	private Integer value;
	/**
	 * 显示值
	 */
	private String label;

	private OperUnitStatusEnum(String label, Integer value) {
		this.value = value;
		this.label = label;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
	
	public static OperUnitStatusEnum getEnum(int value){
		OperUnitStatusEnum resultEnum = null;
		OperUnitStatusEnum[] enumAry = OperUnitStatusEnum.values();
		for(int i = 0;i<enumAry.length;i++){
			if(enumAry[i].getValue() == value){
				resultEnum = enumAry[i];
				break;
			}
		}
		return resultEnum;
	}
	
	public static Map<String, Map<String, Object>> toMap() {
		OperUnitStatusEnum[] ary = OperUnitStatusEnum.values();
		Map<String, Map<String, Object>> enumMap = new HashMap<String, Map<String, Object>>();
		for (int num = 0; num < ary.length; num++) {
			Map<String, Object> map = new HashMap<String, Object>();
			String key = String.valueOf(getEnum(ary[num].getValue()));
			map.put("value", String.valueOf(ary[num].getValue()));
			map.put("label", ary[num].getLabel());
			enumMap.put(key, map);
		}
		return enumMap;
	}

}
