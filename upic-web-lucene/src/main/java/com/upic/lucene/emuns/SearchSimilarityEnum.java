package com.upic.lucene.emuns;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @功能说明:   相似度
 * @创建者: DTZ
 * @创建时间: 17/4/9  上午09:20
 * @版本:V1.0
 */
public enum SearchSimilarityEnum {

	LIMITSCORE("limitscore",0.3f),
	;

	/** 所属查询了性 */
    private String way;
    public String getWay() {
		return way;
	}

	public void setWay(String way) {
		this.way = way;
	}

	/** 权重 */
    private Float desc;

    private SearchSimilarityEnum(String way,Float desc) {
        this.desc = desc;
        this.way = way;
    }

    public Float getDesc() {
        return desc;
    }

    public void setDesc(Float desc) {
        this.desc = desc;
    }

    public static Map<String, Map<String, Object>> toMap() {
        SearchSimilarityEnum[] ary = SearchSimilarityEnum.values();
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
        SearchSimilarityEnum[] ary = SearchSimilarityEnum.values();
        List list = new ArrayList();
        for (int i = 0; i < ary.length; i++) {
            Map<String, String> map = new HashMap<String, String>();
            map.put("desc", ary[i].getDesc()+"");
            map.put("name", ary[i].name());
            list.add(map);
        }
        return list;
    }

    public static SearchSimilarityEnum getEnum(String name) {
        SearchSimilarityEnum[] arry = SearchSimilarityEnum.values();
        for (int i = 0; i < arry.length; i++) {
            if (arry[i].name().equalsIgnoreCase(name)) {
                return arry[i];
            }
        }
        return null;
    }
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static List getWayList(String way) {
    	SearchSimilarityEnum[] ary = SearchSimilarityEnum.values();
        List list = new ArrayList();
        for (int i = 0; i < ary.length; i++) {
        	if(ary[i].way.equals(way)){
        		Map<String, String> map = new HashMap<String, String>();
                map.put("desc", ary[i].getDesc()+"");
                map.put("name", ary[i].name());
                list.add(map);
        	}
        }
        return list;
    }

    /**
     * 取枚举的json字符串
     *
     * @return
     */
    public static String getJsonStr() {
        SearchSimilarityEnum[] enums = SearchSimilarityEnum.values();
        StringBuffer jsonStr = new StringBuffer("[");
        for (SearchSimilarityEnum senum : enums) {
            if (!"[".equals(jsonStr.toString())) {
                jsonStr.append(",");
            }
            jsonStr.append("{id:'").append(senum).append("',desc:'").append(senum.getDesc()).append("'}");
        }
        jsonStr.append("]");
        return jsonStr.toString();
    }

}
