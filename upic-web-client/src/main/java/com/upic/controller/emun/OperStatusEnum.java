/**
 * wusc.edu.pay.common.enums.OpeStatusEnum.java
 */
package com.upic.controller.emun;

import java.util.HashMap;
import java.util.Map;

/**
 * <ul>
 * <li>Title: 机构教师操作枚举</li>
 * <li>Description:</li>
 * <li>Copyright: www.gzzyzz.com</li>
 * <li>Company:</li>
 * </ul>
 * 
 * 
 */
public enum OperStatusEnum {

	SUCCESS("操作成功", 100), FAIL("操作失败", 101);
	/**
	 * 存贮值
	 */
	private Integer value;
	/**
	 * 显示值
	 */
	private String label;

	private OperStatusEnum(String label, Integer value) {
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
	
	public static OperStatusEnum getEnum(int value){
		OperStatusEnum resultEnum = null;
		OperStatusEnum[] enumAry = OperStatusEnum.values();
		for(int i = 0;i<enumAry.length;i++){
			if(enumAry[i].getValue() == value){
				resultEnum = enumAry[i];
				break;
			}
		}
		return resultEnum;
	}
	
	public static Map<String, Map<String, Object>> toMap() {
		OperStatusEnum[] ary = OperStatusEnum.values();
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
