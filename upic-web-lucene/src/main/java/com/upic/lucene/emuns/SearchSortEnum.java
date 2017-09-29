package com.upic.lucene.emuns;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @功能说明:
 * @创建者: DTZ
 * @创建时间: 16/11/24  下午12:07
 * @版本:V1.0
 */
public enum SearchSortEnum {
	
	/**智能排序**/
	 INTELLIGENT(1),
	 /**距离排序**/
	 DISTANCE(2),
	 /**最新上线**/
	 RECENT(3),
	 /**人气最高**/
	 WELCOME(4),
	 /**价格最低**/
	 LOWEST(5),
	 /**价格最高**/
	 HIGHEST(6);

    /** 描述 */
    private int desc;

    private SearchSortEnum(int desc) {
        this.desc = desc;
    }

    public int getDesc() {
        return desc;
    }

    public void setDesc(int desc) {
        this.desc = desc;
    }

    public static Map<String, Map<String, Object>> toMap() {
        SearchSortEnum[] ary = SearchSortEnum.values();
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
        SearchSortEnum[] ary = SearchSortEnum.values();
        List list = new ArrayList();
        for (int i = 0; i < ary.length; i++) {
            Map<String, String> map = new HashMap<String, String>();
            map.put("desc", String.valueOf(ary[i].getDesc()));
            map.put("name", ary[i].name());
            list.add(map);
        }
        return list;
    }

    public static SearchSortEnum getEnum(String name) {
        SearchSortEnum[] arry = SearchSortEnum.values();
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
        SearchSortEnum[] enums = SearchSortEnum.values();
        StringBuffer jsonStr = new StringBuffer("[");
        for (SearchSortEnum senum : enums) {
            if (!"[".equals(jsonStr.toString())) {
                jsonStr.append(",");
            }
            jsonStr.append("{id:'").append(senum).append("',desc:'").append(senum.getDesc()).append("'}");
        }
        jsonStr.append("]");
        return jsonStr.toString();
    }
}
