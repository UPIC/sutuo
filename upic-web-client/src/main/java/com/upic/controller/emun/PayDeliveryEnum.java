package com.upic.controller.emun;

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
public enum PayDeliveryEnum {

    ZHEJIANG("浙江省","0"),
    JIANGSU("江苏省","0"),
    JIANGXI("江西省","0"),
    SHANGHAI("上海市","0"),
    ANHUI("安徽省","0"),
    GUANGDONG("广东省","0"),
    HUBEI("湖北省","0"),
    HUNAN("湖南省","0"),
    FUJIAN("福建省","0"),
    GUIZHOU("贵州省","10"),
    HENAN("河南省","10"),
    SICHUAN("四川省","10"),
    CHONGQIN("重庆市","10"),
    GUANGXI("广西省","10"),
    BEIJING("北京市","10"),
    TIANJIN("天津市","10"),
    SHANDONG("山东省","10"),
    HEBEI("河北省","10"),
    SHANXI("山西省","20"),
    SHAIXI("陕西省","20"),
    NEIMENGGU("内蒙古省","20"),
    HEILONGJIANG("黑龙江省","20"),
    HAINAN("海南省","20"),
    NINGXIA("宁夏省","20"),
    YUNNAN("云南省","20"),
    LIAONING("辽宁省","20"),
    JILIN("吉林省","20")
    ;

	/** 所属支付方式 */
    private String way;
    public String getWay() {
		return way;
	}

	public void setWay(String way) {
		this.way = way;
	}

	/** 描述 */
    private String desc;

    private PayDeliveryEnum(String way,String desc) {
        this.desc = desc;
        this.way = way;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public static Map<String, Map<String, Object>> toMap() {
    	PayDeliveryEnum[] ary = PayDeliveryEnum.values();
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
    	PayDeliveryEnum[] ary = PayDeliveryEnum.values();
        List list = new ArrayList();
        for (int i = 0; i < ary.length; i++) {
            Map<String, String> map = new HashMap<String, String>();
            map.put("desc", ary[i].getDesc());
            map.put("name", ary[i].name());
            list.add(map);
        }
        return list;
    }

    public static PayDeliveryEnum getEnum(String name) {
    	PayDeliveryEnum[] arry = PayDeliveryEnum.values();
        for (int i = 0; i < arry.length; i++) {
            if (arry[i].name().equalsIgnoreCase(name)) {
                return arry[i];
            }
        }
        return null;
    }
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static List getWayList(String way) {
    	PayDeliveryEnum[] ary = PayDeliveryEnum.values();
        List list = new ArrayList();
        for (int i = 0; i < ary.length; i++) {
        	if(ary[i].way.equals(way)){
        		Map<String, String> map = new HashMap<String, String>();
                map.put("desc", ary[i].getDesc());
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
    	PayDeliveryEnum[] enums = PayDeliveryEnum.values();
        StringBuffer jsonStr = new StringBuffer("[");
        for (PayDeliveryEnum senum : enums) {
            if (!"[".equals(jsonStr.toString())) {
                jsonStr.append(",");
            }
            jsonStr.append("{id:'").append(senum).append("',desc:'").append(senum.getDesc()).append("'}");
        }
        jsonStr.append("]");
        return jsonStr.toString();
    }

}
