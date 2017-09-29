package com.upic.controller;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import javax.servlet.http.HttpSession;
//
//import org.apache.commons.lang3.StringUtils;
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import com.upic.common.page.PageBean;
//import com.upic.common.page.PageParam;
//import com.upic.common.web.exception.WebException;
//import com.upic.order.enums.TradeStatusEnum;
//import com.upic.po.Order;
//import com.upic.po.User;
//import com.upic.service.IOrderActivityDetialsService;
//import com.upic.service.IOrderService;
//import com.upic.service.IOrderTicketDetialsService;
//import com.upic.service.ITogetherService;
//import com.upic.shop.enums.ShopClassEnum;
//import com.upic.shop.enums.ShopClassEnum;
//
//@Controller
//@RequestMapping("/order")
//public class OrderController {
//	private static Log log = LogFactory.getLog(OrderController.class);
//
//	@Autowired(required = false)
//	private IOrderService orderService;
//
//	@Autowired(required = false)
//	private IOrderActivityDetialsService orderActivityDetialsService;
//
//	@Autowired(required = false)
//	private ITogetherService togetherService;
//	@Autowired(required = false)
//	private IOrderTicketDetialsService orderTicketDetialsService;
//
//	/**
//	 * 订单、组局
//	 * 
//	 * @param model
//	 * @param pageNumStr
//	 * @param numPerPageStr
//	 * @param method
//	 * @param city
//	 * @return
//	 */
//	@ResponseBody
//	@RequestMapping(value = "searchByType/{typeId}/{pageNumStr}/{numPerPageStr}")
//	public PageBean searchCollectionByType(Model model, @PathVariable("typeId") int typeId,
//			@PathVariable("pageNumStr") String pageNumStr, @PathVariable("numPerPageStr") String numPerPageStr,
//			HttpSession session) {
//		try {
//			int numPerPage = 10;
//			int pageNum = 1;
//			if (StringUtils.isNotBlank(numPerPageStr)) {
//				numPerPage = Integer.parseInt(numPerPageStr);
//			}
//			if (StringUtils.isNotBlank(pageNumStr)) {
//				pageNum = Integer.valueOf(pageNumStr);
//			}
//			User u = (User) session.getAttribute("user");
//			if (u == null) {
//				throw new WebException("1003", "获取用户信息失败哦");
//			}
//			Map<String, Object> paramMap = new HashMap<String, Object>();
//			paramMap.put("userId", u.getId());
//			PageBean listPage = null;
//			switch (typeId) {
//			case 1:
//				// 查询所有订单
//				paramMap.put("FARM", ShopClassEnum.FARM.name());
//				paramMap.put("ACTIVITY", ShopClassEnum.ACTIVITY.name());
//				paramMap.put("TOGETHER", ShopClassEnum.TOGETHER.name());
//				paramMap.put("userId", u.getId());
//				listPage = orderService.listPage(new PageParam(pageNum, numPerPage), paramMap, "listAllOrders");
//				break;
//			case 2:
//				// 查看支付成功的订单
//				paramMap.put("status", TradeStatusEnum.SUCCESS.name());
//				listPage = orderService.listPage(new PageParam(pageNum, numPerPage), paramMap, "listAllOrders");
//				break;
//			case 3:
//				// 查看未支付的订单
//				paramMap.put("status", TradeStatusEnum.WAITING_PAYMENT.name());
//				listPage = orderService.listPage(new PageParam(pageNum, numPerPage), paramMap, "listAllOrders");
//				break;
//			case 4:
//				// 查看所有组局订单
//				paramMap.put("TOGETHER", ShopClassEnum.TOGETHER.name());
//				paramMap.put("status", TradeStatusEnum.WAITING_PAYMENT.name());
//				listPage = orderService.listPage(new PageParam(pageNum, numPerPage), paramMap, "listAllOrders");
//				break;
//			case 5:
//				// 查看所有预约
//				paramMap.put("ACTIVITY", ShopClassEnum.ACTIVITY.name());
//				listPage = orderService.listPage(new PageParam(pageNum, numPerPage), paramMap, "listAllOrders");
//				break;
//			case 6:
//				// 查看预约成功
//				paramMap.put("ACTIVITY", ShopClassEnum.ACTIVITY.name());
//				paramMap.put("status", TradeStatusEnum.TICKET.name());
//				listPage = orderService.listPage(new PageParam(pageNum, numPerPage), paramMap, "listAllOrders");
//				break;
//			case 7:
//				// 查看预约待确认
//				paramMap.put("ACTIVITY", ShopClassEnum.ACTIVITY.name());
//				paramMap.put("status", TradeStatusEnum.WAIT_TICKET.name());
//				listPage = orderService.listPage(new PageParam(pageNum, numPerPage), paramMap, "listAllOrders");
//				break;
//			default:
//				break;
//			}
//			return listPage;
//		} catch (WebException e) {
//			log.error("== searchCollectionByType exception:", e);
//			throw new WebException("1003", e.getMessage());
//		}
//	}
//	
//	@RequestMapping(value = "{orderId}/searchByorderId")
//	public String getDetilesByOrderType(@PathVariable("orderId")Long orderId,Model model){
//		try{
//			Order byId = orderService.getById(orderId);
//			if(byId==null){
//				throw new WebException("1003", "获取订单失败");
//			}
//			Map<String, Object> paramMap=new HashMap<String, Object>();
//			//活动类型
//			if(byId.getOrderClass().equals(ShopClassEnum.ACTIVITY.name())){
//					Object by = orderActivityDetialsService.getBy(paramMap, "getByOrderId");
//					if(by==null){
//						throw new WebException("1003", "获取订单详情失败");
//					}
//				model.addAttribute("detials", by);
//			}else if(byId.getOrderClass().equals(ShopClassEnum.TOGETHER.name())){
//				
//			}else if(byId.getOrderClass().equals(ShopClassEnum.TICKET.name())){
//				
//			}
//			model.addAttribute("detials", byId);
//		}catch(WebException e){
//			log.error("== searchCollectionByType exception:", e);
//			throw new WebException("1003", e.getMessage());
//		}
//		return null;}
//	/**
//	 * 查询订单
//	 * 
//	 * @param model
//	 * @return
//	 */
//	@RequestMapping(value = "radySearchOrder")
//	public String getAllOrderStatusType() {
//		return "farmer/person/order";
//	}
//
//	/**
//	 * 查询组局
//	 */
//	@RequestMapping(value = "readyTogether")
//	public String getTogether() {
//		return null;
//	}
//
//	/**
//	 * 查询活动
//	 */
//	@RequestMapping(value = "readyActive")
//	public String getAcitive() {
//		return null;
//	}
//
//	/**
//	 * 查询活动详情
//	 * 
//	 * @param model
//	 * @param orderId
//	 * @param session
//	 * @return
//	 */
//	@RequestMapping(value = "searchOrderDetials/{orderId}")
//	public String getOrderDetials(Model model, @PathVariable("orderId") String orderId, HttpSession session) {
//		String url = "";
//		try {
//			User user = (User) session.getAttribute("user");
//			if (user == null) {
//				throw new WebException("1003", "获取用户失败");
//			}
//			Order order = orderService.getById(Long.parseLong(orderId));
//			if (order == null) {
//				throw new WebException("1003", "获取订单详情失败");
//			}
//
//			Map<String, Object> paramMap = new HashMap<String, Object>();
//			if (order.getOrderClass().equals(ShopClassEnum.ACTIVITY.name())) {
//				paramMap.put("orderId", order.getId());
//				Object by = orderActivityDetialsService.getBy(paramMap, "getByOrderId");
//				if (by == null) {
//					throw new WebException("1003", "获取活动详情失败");
//				}
//				model.addAttribute("order", order);
//				model.addAttribute("detials", by);
//				url = "";
//			} else if (order.getOrderClass().equals(ShopClassEnum.TOGETHER.name())) {
//				paramMap.put("orderId", order.getId());
//				List<Object> listBy = togetherService.listBy(paramMap, "listAllTogether");
//				if (listBy == null) {
//					throw new WebException("1003", "获取组局详情失败");
//				}
//				model.addAttribute("order", order);
//				model.addAttribute("detials", listBy);
//				url = "";
//			}
//		} catch (WebException e) {
//			log.error("== getOrderDetials exception:", e);
//			throw new WebException("1003", e.getMessage());
//		}
//		return url;
//	}
//}
