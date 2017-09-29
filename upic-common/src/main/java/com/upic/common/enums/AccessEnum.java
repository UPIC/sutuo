package com.upic.common.enums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @功能说明:   各地区快递费
 * @创建者: DTZ
 * @创建时间: 16/5/20  上午11:25
 * @版本:V1.0
 */
public enum AccessEnum {

    FIRSTPAGE("FIRSTPAGE"),
    SHOPPAGE("SHOPPAGE"),
    SELECTCITY("SELECTCITY")
    ;

	/** 描述 */
	private String desc;

	private AccessEnum(String desc) {
		this.desc = desc;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public static Map<String, Map<String, Object>> toMap() {
		AccessEnum[] ary = AccessEnum.values();
		Map<String, Map<String, Object>> enumMap = new HashMap<String, Map<String, Object>>();
		for (int num = 0; num < ary.length; num++) {
			Map<String, Object> map = new HashMap<String, Object>();
			String key = ary[num].name();
			map.put("desc", ary[num].getDesc());
			enumMap.put(key, map);
		}
		return enumMap;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static List toList() {
		AccessEnum[] ary = AccessEnum.values();
		List list = new ArrayList();
		for (int i = 0; i < ary.length; i++) {
			Map<String, String> map = new HashMap<String, String>();
			map.put("desc", ary[i].getDesc());
			list.add(map);
		}
		return list;
	}

	public static AccessEnum getEnum(String name) {
		AccessEnum[] arry = AccessEnum.values();
		for (int i = 0; i < arry.length; i++) {
			if (arry[i].name().equalsIgnoreCase(name)) {
				return arry[i];
			}
		}
		return null;
	}

	/**
	 * 取枚举的json字符串
	 *
	 * @return
	 */
	public static String getJsonStr() {
		AccessEnum[] enums = AccessEnum.values();
		StringBuffer jsonStr = new StringBuffer("[");
		for (AccessEnum senum : enums) {
			if (!"[".equals(jsonStr.toString())) {
				jsonStr.append(",");
			}
			jsonStr.append("{id:'").append(senum).append("',desc:'").append(senum.getDesc()).append("'}");
		}
		jsonStr.append("]");
		return jsonStr.toString();
	}
}