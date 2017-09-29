package com.upic.po;

import java.util.Date;

import com.upic.common.entity.BaseEntity;
import com.upic.common.utils.string.StringUtil;

/**
 * 订单
 * 
 * @author DTZ
 *
 */
public class Order extends BaseEntity {
	private static final long serialVersionUID = 1L;
	private String mainId = StringUtil.get32UUID();
	/** 订单号 **/
	private String orderId;
	/** 支付方式 **/
	private String payWay;
	/** 支付类型 **/
	private String payType;
	/** 订单价格 **/
	private double price;
	/** 订单状态 **/
	private String status;
	/** 收件地址 **/
	private Integer addressId;
	/** 订单日期开始时间 **/
	private String orderDateBegin;
	/** 订单日期结束时间 **/
	private String orderDateEnd;
	/** 用户ID **/
	private Integer userId;
	/** 快递号录入时间 **/
	private Date deliveryAddTime;
	/** 购买留言 **/
	private String remarkBuy;
	/** 退单理由 **/
	private String remarkOut;
	/** 用户确认收获，订单完成 **/
	private String confirmReceipt;
	/** 交易成功时间 **/
	private Date orderSuccess;
	/** 订单类型 **/
	private String orderClass;
	/** 商户编号 **/
	private String storeNumber;
	/** JSON字符串（包含订单中各个商品的名称、编号、价格） **/
	private String jsonOrderDetail;
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
	/** 商品数量 **/
	private Integer shopCount;
	/** 商品编号 **/
	private String shopNumber;

	public Order() {
		super();
	}

	public Order(String mainId, String orderId, String payWay, String payType, double price, String status,
			Integer addressId, String orderDateBegin, String orderDateEnd, Integer userId, Date deliveryAddTime,
			String remarkBuy, String remarkOut, String confirmReceipt, Date orderSuccess, String orderClass,
			String storeNumber, String field1, String field2, String field3, String field4, String field5,
			Integer shopCount, String shopNumber,String jsonOrderDetail) {
		super();
		this.mainId = mainId;
		this.orderId = orderId;
		this.payWay = payWay;
		this.payType = payType;
		this.price = price;
		this.status = status;
		this.addressId = addressId;
		this.orderDateBegin = orderDateBegin;
		this.orderDateEnd = orderDateEnd;
		this.userId = userId;
		this.deliveryAddTime = deliveryAddTime;
		this.remarkBuy = remarkBuy;
		this.remarkOut = remarkOut;
		this.confirmReceipt = confirmReceipt;
		this.orderSuccess = orderSuccess;
		this.orderClass = orderClass;
		this.storeNumber = storeNumber;
		this.field1 = field1;
		this.field2 = field2;
		this.field3 = field3;
		this.field4 = field4;
		this.field5 = field5;
		this.shopCount = shopCount;
		this.shopNumber = shopNumber;
		this.jsonOrderDetail = jsonOrderDetail;
	}

	public String getMainId() {
		return mainId;
	}

	public void setMainId(String mainId) {
		this.mainId = mainId;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getPayWay() {
		return payWay;
	}

	public void setPayWay(String payWay) {
		this.payWay = payWay;
	}

	public String getPayType() {
		return payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getAddressId() {
		return addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}

	public String getOrderDateBegin() {
		return orderDateBegin;
	}

	public void setOrderDateBegin(String orderDateBegin) {
		this.orderDateBegin = orderDateBegin;
	}

	public String getOrderDateEnd() {
		return orderDateEnd;
	}

	public void setOrderDateEnd(String orderDateEnd) {
		this.orderDateEnd = orderDateEnd;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Date getDeliveryAddTime() {
		return deliveryAddTime;
	}

	public void setDeliveryAddTime(Date deliveryAddTime) {
		this.deliveryAddTime = deliveryAddTime;
	}

	public String getRemarkBuy() {
		return remarkBuy;
	}

	public void setRemarkBuy(String remarkBuy) {
		this.remarkBuy = remarkBuy;
	}

	public String getRemarkOut() {
		return remarkOut;
	}

	public void setRemarkOut(String remarkOut) {
		this.remarkOut = remarkOut;
	}

	public String getConfirmReceipt() {
		return confirmReceipt;
	}

	public void setConfirmReceipt(String confirmReceipt) {
		this.confirmReceipt = confirmReceipt;
	}

	public Date getOrderSuccess() {
		return orderSuccess;
	}

	public void setOrderSuccess(Date orderSuccess) {
		this.orderSuccess = orderSuccess;
	}

	public String getOrderClass() {
		return orderClass;
	}

	public void setOrderClass(String orderClass) {
		this.orderClass = orderClass;
	}

	public String getStoreNumber() {
		return storeNumber;
	}

	public void setStoreNumber(String storeNumber) {
		this.storeNumber = storeNumber;
	}

	public String getJsonOrderDetail() {
		return jsonOrderDetail;
	}

	public void setJsonOrderDetail(String jsonOrderDetail) {
		this.jsonOrderDetail = jsonOrderDetail;
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

	public Integer getShopCount() {
		return shopCount;
	}

	public void setShopCount(Integer shopCount) {
		this.shopCount = shopCount;
	}

	public String getShopNumber() {
		return shopNumber;
	}

	public void setShopNumber(String shopNumber) {
		this.shopNumber = shopNumber;
	}
}
