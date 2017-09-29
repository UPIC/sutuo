package com.upic.web.boss.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ModelDriven;
import com.upic.po.ShopType;
import com.upic.po.Store;
import com.upic.service.IStoreService;
import com.upic.service.IStoreSignLinkService;
import com.upic.store.emuns.StoreStatusEnum;

import wusc.edu.pay.web.boss.base.BossBaseAction;
import wusc.edu.pay.web.permission.entity.PmsOperator;
import wusc.edu.pay.web.permission.enums.OperatorTypeEnum;
import wusc.edu.pay.web.permission.enums.RoleTypeEnum;

public class StoreAction extends BossBaseAction implements ModelDriven<Store> {
	private static final long serialVersionUID = 1L;
	private static final Log log = LogFactory.getLog(StoreAction.class);
	private Store store;
	@Autowired
	private IStoreService storeService;
	
	@Autowired
	private IStoreSignLinkService storeSignLinkService;
	/**
	 * 查看所有商品类型
	 * 
	 * @return
	 */
	public String listStore() {
		try {
			Map<String, Object> paramMap = new HashMap<String, Object>(); // 业务条件查询参数
			paramMap.put("storeNumber", store.getStoreNumber());
			paramMap.put("storeName", store.getStoreName());
			paramMap.put("orderDateBegin", store.getOrderDateBegin());// 开始时间
			paramMap.put("orderDateEnd", store.getOrderDateEnd());// 结束时间
			paramMap.put("status", store.getStatus());// 结束时间
			super.pageBean = storeService.listPage(getPageParam(), paramMap);
			PmsOperator operator = this.getLoginedOperator();
			super.pushData(operator);
			super.pushData(pageBean);
			// 回显查询条件值
			super.pushData(paramMap);
			super.putData("RoleTypeEnumList", RoleTypeEnum.values());
			super.putData("RoleTypeEnum", RoleTypeEnum.toMap());
			super.putData("OperatorTypeEnum", OperatorTypeEnum.toMap());
			super.putData("StoreStatusEnum", StoreStatusEnum.toMap());
			super.putData("store", store);
			return "storeActionList";
		} catch (Exception e) {
			log.error("== listShop exception:", e);
			return operateError("获取数据失败");
		}
	}

	/**
	 * 
	 * 通过或者冻结
	 *
	 */
	public String changeStatus() {
		try {
			Store s = storeService.getById(store.getId());
			if (s == null) {
				return operateError("获取商户数据失败");
			}
			s.setStatus(store.getStatus());
			long result = storeService.update(s);
			if (result == 0) {
				return operateError("更新数据失败");
			}
			PmsOperator operator = this.getLoginedOperator();
			super.pushData(operator);
			// 回显查询条件值
			super.putData("RoleTypeEnumList", RoleTypeEnum.values());
			super.putData("RoleTypeEnum", RoleTypeEnum.toMap());
			super.putData("OperatorTypeEnum", OperatorTypeEnum.toMap());
			super.logEdit("operator:" + operator.getRealName() + "[操作：" + s.getStatus() + "]");
			return operateSuccess();
		} catch (Exception e) {
			log.error("== seeShopDetials exception:", e);
			return operateError("获取数据失败");
		}
	}

	/**
	 * 查看商店詳情
	 * @return
	 */
	public String seeStoreDetials() {
		try {
			Store s = storeService.getById(store.getId());
			Map<String, Object> paramMap = new HashMap<String, Object>(); // 业务条件查询参数
			paramMap.put("storeId", store.getId());
			List<Object> storeSinLink = storeSignLinkService.listBy(paramMap, "listAll");
			PmsOperator operator = this.getLoginedOperator();
			super.pushData(operator);
			super.putData("store", s);
			super.putData("storeSinLink", storeSinLink);
			return "seeStoreDetials";
		} catch (Exception e) {
			log.error("== seeShopDetials exception:", e);
			return operateError("获取数据失败");
		}
	}

	@Override
	public Store getModel() {
		if (store == null) {
			store = new Store();
		}
		return store;
	}

}
