package com.upic.web.boss.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ModelDriven;
import com.upic.common.core.enums.FundInfoTypeEnum;
import com.upic.common.core.enums.PayTypeEnum;
import com.upic.common.core.enums.PayWayEnum;
import com.upic.common.core.enums.TrxTypeEnum;
import com.upic.order.enums.TradeStatusEnum;
import com.upic.po.Order;
import com.upic.po.PaymentOrderQueryVo;
import com.upic.service.IOrderDetialsService;
import com.upic.service.IOrderService;
import com.upic.service.IOrderTicketDetialsService;
import com.upic.service.IReTradService;
import com.upic.service.IShopTypeService;
import com.upic.shop.enums.ShopClassEnum;
import com.upic.shop.enums.ShopStatusEnum;

import wusc.edu.pay.web.boss.base.BossBaseAction;
import wusc.edu.pay.web.permission.entity.PmsOperator;

public class OrderAction extends BossBaseAction implements ModelDriven<Order> {
	private static final long serialVersionUID = 1L;
	private static final Log log = LogFactory.getLog(OrderAction.class);
	private Order order;
	private PaymentOrderQueryVo paymentOrderQueryVo;
	@Autowired
	private IOrderService orderService;
	@Autowired
	private IOrderDetialsService orderDetialsService;
	@Autowired
	private IShopTypeService shopTypeService;
	@Autowired
	private IReTradService reTradService;

	@Autowired
	private IOrderTicketDetialsService orderTicketDetialsService;
	/**
	 * 查看所有订单
	 * 
	 * @return
	 */
	public String listOrder() {
		try {
			Map<String, Object> paramMap = new HashMap<String, Object>(); // 业务条件查询参数
			paramMap.put("orderId", order.getOrderId());
			paramMap.put("payType", order.getPayType());
			paramMap.put("payWay", order.getPayWay());
			paramMap.put("status", order.getStatus());
			paramMap.put("orderClass", order.getOrderClass());
			paramMap.put("storeNumber", order.getStoreNumber());
			paramMap.put("orderDateBegin", order.getOrderDateBegin());
			paramMap.put("orderDateEnd", order.getOrderDateEnd());
			super.pageBean = orderService.listPage(getPageParam(), paramMap);
			// List<Object> shopType = shopTypeService.listBy(null, "listAll");
			PmsOperator operator = this.getLoginedOperator();
			super.pushData(operator);
			super.pushData(pageBean);
			// 回显查询条件值
			super.pushData(paramMap);
			super.putData("order", order);
			// super.putData("shopTypes", shopType);
			super.putData("statusEnums", TradeStatusEnum.toMap());
			super.putData("payWayNameEnums", PayWayEnum.toMap());
			super.putData("shopClass", ShopClassEnum.toMap());
			super.putData("payTypeNameEnums", PayTypeEnum.toMap());
			return "orderActionList";
		} catch (Exception e) {
			log.error("== listOrder exception:", e);
			return operateError("获取数据失败");
		}
	}

	/**
	 * 查看交易记录
	 */
	public String listPaymentRecord() {
		try {
			Map<String, Object> paramMap = new HashMap<String, Object>(); // 业务条件查询参数
			if (paymentOrderQueryVo != null) {
				paramMap.put("merchantNo", paymentOrderQueryVo.getMerchantNo());// 商户编号
				paramMap.put("merchantName", paymentOrderQueryVo.getMerchantName());// 商户名称
				paramMap.put("merchantOrderNo", paymentOrderQueryVo.getMerchantOrderNo());// 商户订单号
				paramMap.put("fundIntoType", paymentOrderQueryVo.getFundIntoType());// 资金流入类型
				paramMap.put("merchantOrderNo", paymentOrderQueryVo.getOrderDateBegin());// 订单开始时间
				paramMap.put("merchantOrderNo", paymentOrderQueryVo.getOrderDateEnd());// 订单结束时间
				paramMap.put("payTypeName", paymentOrderQueryVo.getPayTypeName());// 支付类型
				paramMap.put("payWayName", paymentOrderQueryVo.getPayWayName());// 支付类型
				paramMap.put("status", paymentOrderQueryVo.getStatus());// 支付状态

				if (paymentOrderQueryVo.getOrderDateBegin() != null) {
					paramMap.put("orderDateBegin", paymentOrderQueryVo.getOrderDateBegin());// 支付状态
				}

				if (paymentOrderQueryVo.getOrderDateEnd() != null) {
					paramMap.put("orderDateEnd", paymentOrderQueryVo.getOrderDateEnd());// 支付状态
				}
			}
			super.pageBean = reTradService.listPage(getPageParam(), paramMap);
			// 回显查询条件值
			super.pushData(paramMap);
			super.putData("rpUserInfo", paymentOrderQueryVo);
			super.putData("statusEnums", TradeStatusEnum.toMap());
			super.putData("payWayNameEnums", PayWayEnum.toMap());
			super.putData("payTypeNameEnums", PayTypeEnum.toMap());
			super.putData("trxTypeEnums", TrxTypeEnum.toMap());// 交易类型(消费、打款)
			super.putData("fundIntoTypeEnums", FundInfoTypeEnum.toMap());
		} catch (Exception e) {
			log.error("== listPaymentOrder exception:", e);
			return operateError("获取数据失败");
		}
		return "listPaymentOrder";
	}

	/**
	 * 查看订单详情
	 * 
	 * @return
	 */
	public String seeOrderDetials() {
		try {
			Map<String, Object> paramMap = new HashMap<String, Object>(); // 业务条件查询参数
			// paramMap.put("orderId", order.getOrderId());
			paramMap.put("orderId", order.getOrderId());
			Order by = (Order) orderService.getBy(paramMap, "getByOrderId");
			List<Object> listBy=new ArrayList<Object>();
			if(by.getOrderClass().equals(ShopClassEnum.FARM.name())){
				listBy = orderDetialsService.listBy(paramMap, "listAll");
			}else if(by.getOrderClass().equals(ShopClassEnum.TICKET.name())){
				listBy = orderTicketDetialsService.listBy(paramMap, "listAll");
			}
			super.putData("orderDetials", listBy);
			super.putData("order",by);
		} catch (Exception e) {
			log.error("== listPaymentOrder exception:", e);
			return operateError("获取数据失败");
		}
		return "listPaymentOrderDetials";
	}

	@Override
	public Order getModel() {
		if (order == null) {
			order = new Order();
		}
		return order;
	}

	/**
	 * 快递管理查看订单详情
	 * 
	 * @return
	 */
	public String seeDeliveryOrderDetials() {
		try {
			Map<String, Object> paramMap = new HashMap<String, Object>(); // 业务条件查询参数
			// paramMap.put("orderId", order.getOrderId());
			paramMap.put("orderId", order.getOrderId());
			List<Object> listBy = orderDetialsService.listBy(paramMap, "listAll");
			super.putData("orderDetials", listBy);
		} catch (Exception e) {
			log.error("== listPaymentOrder exception:", e);
			return operateError("获取数据失败");
		}
		return "seeDeliveryOrderDetials";
	}

}
