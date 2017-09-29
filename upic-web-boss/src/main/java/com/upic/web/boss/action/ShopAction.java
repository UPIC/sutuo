package com.upic.web.boss.action;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ModelDriven;
import com.upic.po.Shop;
import com.upic.po.ShopPic;
import com.upic.service.IShopFarmService;
import com.upic.service.IShopPicService;
import com.upic.service.IShopService;
import com.upic.service.IShopSignLinkService;
import com.upic.service.IShopThemeService;
import com.upic.service.IShopTicketService;
import com.upic.service.IShopTypeService;
import com.upic.shop.enums.ShopClassEnum;
import com.upic.shop.enums.ShopStatusEnum;

import wusc.edu.pay.web.boss.base.BossBaseAction;
import wusc.edu.pay.web.permission.entity.PmsOperator;
import wusc.edu.pay.web.permission.enums.OperatorTypeEnum;
import wusc.edu.pay.web.permission.enums.RoleTypeEnum;

public class ShopAction extends BossBaseAction implements ModelDriven<Shop> {
	private static final long serialVersionUID = 1L;
	private static final Log log = LogFactory.getLog(ShopAction.class);
	private Shop shop;
	@Autowired
	private IShopService shopService;
	@Autowired
	private IShopPicService shopPicService;
	@Autowired
	private IShopTypeService shopTypeService;
	@Autowired
	private IShopThemeService shopThemeService;
	@Autowired
	private IShopSignLinkService shopSignLinkService;
	@Autowired
	private IShopFarmService shopFarmService;
	@Autowired
	private IShopTicketService shopTicketService;
	
	/**
	 * 查看所有商品
	 * 
	 * @return
	 */
	public String listShop() {
		try {
			Map<String, Object> paramMap = new HashMap<String, Object>(); // 业务条件查询参数
			paramMap.put("shopName", shop.getShopName()); // 商品名称（模糊查询）
			paramMap.put("shopNumber", shop.getShopNumber());
			paramMap.put("shopType", shop.getShopType());
			paramMap.put("storeNumber", shop.getStoreNumber());
			paramMap.put("shopStatus", ShopStatusEnum.INACTIVE.getValue());
			paramMap.put("themeName", shop.getThemeName());
			paramMap.put("shopClass", shop.getShopClass());
			paramMap.put("orderDateBegin", shop.getOrderDateBegin());
			paramMap.put("orderDateEnd", shop.getOrderDateEnd());
			
			
			super.pageBean = shopService.listPage(getPageParam(), paramMap);
			List<Object> listBy = shopThemeService.listBy(null, "listAll");
			List<Object> listBy2 = shopTypeService.listBy(null, "listAll");
			PmsOperator operator = this.getLoginedOperator();
			super.pushData(operator);
			super.pushData(pageBean);
			// 回显查询条件值
			super.pushData(paramMap);

			super.putData("RoleTypeEnumList", RoleTypeEnum.values());
			super.putData("RoleTypeEnum", RoleTypeEnum.toMap());
			super.putData("OperatorTypeEnum", OperatorTypeEnum.toMap());
			super.putData("shopClass", ShopClassEnum.toMap());
			super.putData("shopThemeList", listBy);
			super.putData("shopStatus", ShopStatusEnum.toMap());
			super.putData("shopTypeList", listBy2);
			super.putData("shop", shop);
			return "shopActionList";
		} catch (Exception e) {
			log.error("== listAllClassUpload exception:", e);
			return operateError("获取数据失败");
		}
	}

	/**
	 * 
	 * 查看某一个商品
	 *
	 */
	public String seeShopDetials() {
		try {
			Shop s = shopService.getById(shop.getId());
			if (s == null) {
				return operateError("获取数据失败");
			}
			Map<String, Object> paramMap = new HashMap<String, Object>(); // 业务条件查询参数
			paramMap.put("shopId", s.getId());
			List<Object> listBy = shopPicService.listBy(paramMap, "listAll");
			List<ShopPic> pic = new ArrayList<ShopPic>();
			for (Object obj : listBy) {
				pic.add((ShopPic) obj);
			}
			List<Object> listBy2 = shopSignLinkService.listBy(paramMap, "listAll");
			Collections.sort(pic);
			
			Object by=new Object();
			if(s.getShopClass().equals(ShopClassEnum.FARM.name())){
				 by = shopFarmService.getBy(paramMap,"getByShopId");
			}else if(s.getShopClass().equals(ShopClassEnum.TICKET.name())){
				by=shopTicketService.getBy(paramMap, "getByShopId");
			}
			
			PmsOperator operator = this.getLoginedOperator();
			super.pushData(operator);
			super.pushData(pageBean);
			// 回显查询条件值
			super.putData("shop", s);
			super.putData("shopPic", pic);
			super.putData("shopSignLink", listBy2);
			super.putData("RoleTypeEnumList", RoleTypeEnum.values());
			super.putData("RoleTypeEnum", RoleTypeEnum.toMap());
			super.putData("shopDetials", by);
			super.putData("OperatorTypeEnum", OperatorTypeEnum.toMap());
			return "shopDetials";
		} catch (Exception e) {
			log.error("== seeShopDetials exception:", e);
			return operateError("获取数据失败");
		}
	}

	/**
	 * 关于商品的强制冻结和回复
	 */
	public String changeStatusByShop() {
		try {
			Shop s=shopService.getById(shop.getId());
			s.setStatus(shop.getStatus());
			long update = shopService.update(s);
			if(update==0){
				return this.operateError("更新失败，请重试");
			}
		} catch (Exception e) {
			log.error("上架或下架操作异常", e);
			return this.operateError("操作异常，请重试");
		}
		return operateSuccess();
	}
	/**
	 * 添加数据做准备
	 * @return
	 */
//	public String readyInsert(){
//		try{
//			List<Object> shopType = shopTypeService.listBy(null, "listAll");
//			super.putData("shopType", shopType);
//		}catch (Exception e) {
//			log.error("== readyInser exception:", e);
//			return operateError("准备数据失败");
//		}
//		return "shopAdd";
//	}
	/**
	 * 新增一个商品
	 */
//	public String insertShopData() {
//		try {
//			if (shop == null) {
//				operateError("添加数据失败,请重试");
//			}
//			long result = shopService.insert(shop);
//			if (result == 0) {
//				operateError("添加数据失败,请重试");
//			}
//			super.logEdit("添加商品：[类型名:" + shop.getShopType() + "" + "商品名：" + shop.getShopNamel() + "，商品价格:"
//					+ shop.getShopPrice() + "]");
//		} catch (Exception e) {
//			log.error("== insertShopData exception:", e);
//			return operateError("添加数据失败");
//		}
//		return operateSuccess();
//	}

	/**
	 * 更新商品
	 */
//	public String updateData() {
//		try {
//			if (shop == null) {
//				operateError("更新数据失败,请重试");
//			}
//			long result = shopService.update(shop);
//			if (result == 0) {
//				return operateError("添加数据失败");
//			}
//			super.logEdit("更新商品：[类型名:" + shop.getShopType() + "" + "商品名：" + shop.getShopNamel() + "，商品价格:"
//					+ shop.getShopPrice() + "]");
//		} catch (Exception e) {
//			log.error("== updateData exception:", e);
//			return operateError("更新数据失败");
//		}
//		return operateSuccess();
//	}

	@Override
	public Shop getModel() {
		if (shop == null) {
			shop = new Shop();
		}
		return shop;
	}

}
