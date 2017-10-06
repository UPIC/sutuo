package com.upic.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.upic.service.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.upic.common.core.enums.PayTypeEnum;
import com.upic.common.core.enums.PayWayEnum;
import com.upic.common.web.exception.WebException;
import com.upic.order.enums.TradeStatusEnum;
import com.upic.po.Order;
import com.upic.po.StatusClass;
import com.upic.po.User;

@Controller
@RequestMapping(value = "/order")
public class OrderController {
    private static Log log = LogFactory.getLog(CollectionController.class);

    @Autowired(required = false)
    private IOrderService orderService;

    @Autowired(required = false)
    private IOrderCrowdFundingDetailsService orderCrowdFundingDetailsService;

    /**
     * 用户获取自己相关的订单（不包括已删除的）
     *
     * @param session
     * @param request
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getAllOrderByUserId")
    public List<Order> getAllOrderByUserId(Model model, HttpSession session, HttpServletRequest request,
                                           HttpServletResponse response) {
        List<Order> listBy = null;
        try {
            User u = (User) session.getAttribute("user");
            Map<String, Object> paramMap = new HashMap<String, Object>();
            paramMap.put("userId", u.getId());
//			paramMap.put("userId", 1);
            paramMap.put("noIncludestatus", TradeStatusEnum.DELETE.name());
            listBy = orderService.listBy(paramMap);
        } catch (WebException e) {
            log.error("== getAllOrderByUserId exception:", e);
            listBy = null;
        }
        return listBy;
    }

    /**
     * 根据orderId 获取详情
     *
     * @param session
     * @param request
     * @param response
     * @param orderNum
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "getOrderByOrderId/{orderNum}")
    public Order getOrderByOrderId(HttpSession session, HttpServletRequest request, HttpServletResponse response,
                                   @PathVariable String orderNum) {
        Order o = null;
        try {
            User u = (User) session.getAttribute("user");
            Map<String, Object> paramMap = new HashMap<String, Object>();
//			paramMap.put("userId", 1);
            paramMap.put("userId", u.getId());
            paramMap.put("orderId", orderNum);
            o = orderService.getBy(paramMap);
        } catch (WebException e) {
            log.error("== getOrderByOrderId exception:", e);
            o = null;
        }
        return o;
    }

    /**
     * 取消订单 ajax
     *
     * @param model
     * @param session
     * @param request
     * @param response
     * @param orderId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "cancelOrder")
    public StatusClass cancelOrderByOrderId(Model model, HttpSession session, HttpServletRequest request,
                                            HttpServletResponse response, @RequestParam("orderId") String orderId) {
        try {
            Map<String, Object> paramMap = new HashMap<String, Object>();
            paramMap.put("orderId", orderId);
            Order o = (Order) orderService.getBy(paramMap, "getByOrderId");
            StatusClass s = new StatusClass();
            if (o.getStatus().equals(TradeStatusEnum.CREATED.name())
                    || o.getStatus().equals(TradeStatusEnum.WAITING_PAYMENT.name())
                    || o.getStatus().equals(TradeStatusEnum.FAILED.name())) {
                o.setStatus(TradeStatusEnum.CANCELED.name());
                long update = orderService.update(o);
                if (update == 0) {
                    s.setStatus("ERROR");
                    s.setContent("取消订单失败");
                    return s;
                }
                s.setStatus("SUCCESS");
                s.setContent("取消订单成功");
                return s;
            } else {
                s.setStatus("ERROR");
                s.setContent("取消订单失败");
                return s;
            }
        } catch (WebException e) {
            log.error("== cancelOrderByOrderId exception:", e);
            throw new WebException("1003", "错误信息：" + e.getMessage());
        }
    }

    /**
     * 删除订单 ajax
     *
     * @param session
     * @param request
     * @param response
     * @param orderId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "deleteOrder")
    public StatusClass deleteOrderByOrderId(HttpSession session, HttpServletRequest request,
                                            HttpServletResponse response, @RequestParam("orderId") String orderId) {
        try {
            Map<String, Object> paramMap = new HashMap<String, Object>();
            paramMap.put("orderId", orderId);
            Order o = (Order) orderService.getBy(paramMap, "getByOrderId");
            StatusClass s = new StatusClass();
            if (o.getStatus().equals(TradeStatusEnum.FAILED.name())
                    || o.getStatus().equals(TradeStatusEnum.CANCELED.name())) {
                o.setStatus(TradeStatusEnum.CANCELED.name());
                paramMap.clear();
                paramMap.put("orderId", orderId);
                orderService.getBy(paramMap, "deleteById");
                s.setStatus("SUCCESS");
                s.setContent("删除订单成功");
                return s;
            } else if (o.getStatus().equals(TradeStatusEnum.SUCCESS.name())) {
                o.setStatus(TradeStatusEnum.DELETE.name());
                long update = orderService.update(o);
                if (update == 0) {
                    s.setStatus("ERROR");
                    s.setContent("删除订单失败");
                    return s;
                }
                s.setStatus("SUCCESS");
                s.setContent("删除订单成功");
                return s;
            }
            s.setStatus("ERROR");
            s.setContent("删除订单失败");
            return s;

        } catch (Exception e) {
            log.error("== deleteOrderByOrderId exception:", e);
            StatusClass s = new StatusClass();
            s.setStatus("ERROR");
            s.setContent("删除订单失败");
            return s;
        }
    }

    /**
     * 模拟支付
     *
     * @param session
     * @param request
     * @param response
     * @param storeNumber
     * @param allPrice
     * @param remarkBuy
     * @param addressJson
     * @return
     */
    @ResponseBody
//	@RequestMapping(value = "createOrder",method={RequestMethod.POST})
    @RequestMapping(value = "createOrder")
    public StatusClass createOrder(HttpSession session, HttpServletRequest request, HttpServletResponse response,
                                   String storeNumber, double allPrice, String jsonDetails, String remarkBuy, String addressJson) {
        StatusClass s = new StatusClass();
        try {
            User u = (User) session.getAttribute("user");
//			if (u == null) {
//				s.setStatus("ERROR");
//				s.setContent("创建订单失败");
//				return s;
//			}
            String orderId = genOrderNo();
            Map<String, Object> paramMap = new HashMap<String, Object>();
            paramMap.put("orderId", orderId);
            Object by = orderService.getBy(paramMap, "getByOrderId");
            //验证算法
            /**
             * ...
             */

            if (by == null) {
                Order o = new Order();
                o.setJsonOrderDetail(jsonDetails);
                o.setOrderId(orderId);
//				o.setMainId(genOrderNo()+"x");
                o.setUserId(Integer.parseInt(u.getId() + ""));
//				o.setUserId(1);
                o.setOrderClass("FARM");
                o.setStoreNumber(storeNumber);
                o.setRemarkBuy(remarkBuy);
                o.setOrderSuccess(new Date());
                o.setStatus(TradeStatusEnum.SUCCESS.name());
                o.setPayWay(PayWayEnum.WEIXIN.getDesc());
                o.setPayType(PayTypeEnum.H5PAY.getDesc());
                //地址的json
                o.setField1(addressJson);
                o.setPrice(allPrice);
                orderService.insert(o);
            }
            s.setStatus("SUCCESS");
            s.setContent("购买成功");
        } catch (Exception e) {
            log.error("== createOrder exception:", e);
        }
        return s;
    }

    public static String genOrderNo() {
        String orderNo = "upic";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmssSSS");
        String nowTime = sdf.format(new Date());
        orderNo += nowTime;
        return orderNo;
    }

    /**********************************************20171001之后添加**********************************************/

    /**
     * 根据shopNumber查询订单数
     *
     * @param shopNumber
     * @return
     */
    @GetMapping("/getOrderCountByShopNumber")
    public int getOrderCountByShopNumber(String shopNumber) {
        int orderCount = 0;
        try {
            Map<String, Object> paramMap = new HashMap<String, Object>();
            paramMap.put("shopNumber", shopNumber);
            orderCount = (Integer) orderCrowdFundingDetailsService.getBy(paramMap, "listPageCount");
        } catch (Exception e) {
            log.error("== getOrderCountByShopNumber exception:", e);
            return 0;
        }
        return orderCount;
    }

    /**
     * 根据shopNumber查询总额
     *
     * @param shopNumber
     * @return
     */
    @GetMapping("/getNowMoney")
    public double getNowMoney(String shopNumber) {
        double money = 0;
        try {
            Map<String, Object> paramMap = new HashMap<String, Object>();
            paramMap.put("shopNumber", shopNumber);
            money = (Double) orderCrowdFundingDetailsService.getBy(paramMap, "getSum");
        } catch (Exception e) {
            log.error("== getNowMoney");
        }
        return money;
    }

    /**
     * 生成农产品订单（未完成）
     */

    /**
     * 生成众筹订单（未完成）
     */
}
