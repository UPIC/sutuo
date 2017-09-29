package com.upic.order.enums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @功能说明:
 * @创建者: DTZ
 * @创建时间: 16/5/25 下午3:47
 * @版本:V1.0
 */
public enum TradeStatusEnum {
	
	/**
	 * 订单已创建
	 */
	CREATED("订单已创建"),
	
	/**
	 * 等待支付
	 */
	WAITING_PAYMENT("等待支付"),

	/**
	 * 等待支付处理结果
	 */
	WAITING_PAYMENT_RESULT("等待支付处理结果"),

	/**
	 * 交易成功
	 */
	SUCCESS("交易成功"),

	/**
	 * 交易失败
	 */
	FAILED("交易失败"),

	/**
	 * 订单已取消
	 */
	CANCELED("订单已取消"),
	
	/**
	 * 已发送快递
	 */
	SENT_EXPERSS("快递已发送"),
	/**
	 * 还没有发送快递
	 */
	NO_SENT_EXPERSS("快递未发送"),
	/**
	 * 预约成功
	 */
	TICKET("预约成功"),
	/**
	 * 取消预约（是商户同意后的取消）
	 */
	USER_REJECT("用户取消"),
	/**
	 * 预约申请中
	 */
	WAIT_TICKET("申请预约中"),
	/**
	 * 已使用
	 */
	TICKET_SPEND("已使用"),
	/**
	 * 活动筹备中
	 */
	ACTIVE_ING("筹备中"),
	/**
	 * 活动筹备成功
	 */
	ACTIVE_SUCCESS("筹备成功"),
	/**
	 * 活动筹备中
	 */
	ACTIVE_FAIL("筹备失败"),
	/**
	 * 已完结
	 */
	ACTIVE_FINISH("筹备结束"),
	/**
	 * 订单已删除
	 */
	DELETE("订单已删除"),
	;
	/** 描述 */
	private String desc;

	private TradeStatusEnum(String desc) {
		this.desc = desc;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public static Map<String, Map<String, Object>> toMap() {
		TradeStatusEnum[] ary = TradeStatusEnum.values();
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
		TradeStatusEnum[] ary = TradeStatusEnum.values();
		List list = new ArrayList();
		for (int i = 0; i < ary.length; i++) {
			Map<String, String> map = new HashMap<String, String>();
			map.put("desc", ary[i].getDesc());
			map.put("name", ary[i].name());
			list.add(map);
		}
		return list;
	}

	public static TradeStatusEnum getEnum(String name) {
		TradeStatusEnum[] arry = TradeStatusEnum.values();
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
		TradeStatusEnum[] enums = TradeStatusEnum.values();
		StringBuffer jsonStr = new StringBuffer("[");
		for (TradeStatusEnum senum : enums) {
			if (!"[".equals(jsonStr.toString())) {
				jsonStr.append(",");
			}
			jsonStr.append("{id:'").append(senum).append("',desc:'").append(senum.getDesc()).append("'}");
		}
		jsonStr.append("]");
		return jsonStr.toString();
	}
}
