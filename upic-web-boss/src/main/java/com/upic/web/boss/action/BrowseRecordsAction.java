package com.upic.web.boss.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ModelDriven;
import com.upic.po.BrowseRecords;
import com.upic.service.IBrowseRecordsService;
import com.upic.service.IFirstTypeService;
import com.upic.service.IShopFarmService;
import com.upic.service.IShopThemeService;
import com.upic.shop.enums.ShopClassEnum;

import wusc.edu.pay.web.boss.base.BossBaseAction;
import wusc.edu.pay.web.permission.entity.PmsOperator;
import wusc.edu.pay.web.permission.enums.OperatorTypeEnum;
import wusc.edu.pay.web.permission.enums.RoleTypeEnum;

public class BrowseRecordsAction extends BossBaseAction implements ModelDriven<BrowseRecords> {
	private static final long serialVersionUID = 1L;
	private static final Log log = LogFactory.getLog(BrowseRecordsAction.class);
	private BrowseRecords browseRecords;
	@Autowired
	private IBrowseRecordsService browseRecordsService;
	
	@Autowired
	private IShopThemeService shopThemeService;
	
	@Autowired
	private IFirstTypeService firstTypeService;
	/**
	 * 查看所有商品
	 * 
	 * @return
	 */
	public String listBrowseRecords() {
		try {
			Map<String, Object> paramMap = new HashMap<String, Object>(); // 业务条件查询参数
			paramMap.put("openId", browseRecords.getOpenId()); // 商品名称（模糊查询）
			paramMap.put("storeNumber", browseRecords.getStoreNumber()); // 商品名称（模糊查询）
			paramMap.put("shopNumber", browseRecords.getShopNumber()); // 商品名称（模糊查询）
			paramMap.put("shopTheme", browseRecords.getShopTheme()); // 商品名称（模糊查询）
			paramMap.put("shopType", browseRecords.getShopType()); // 商品名称（模糊查询）
			paramMap.put("shopClass", browseRecords.getShopClass()); // 商品名称（模糊查询）
			paramMap.put("orderDateBegin", browseRecords.getOrderDateBegin());
			paramMap.put("orderDateEnd", browseRecords.getOrderDateEnd());
			
			super.pageBean = browseRecordsService.listPage(getPageParam(), paramMap);
			//商品主题
			List<Object> listBy = shopThemeService.listBy(null, "listAll");
			//商品类型
//			List<Object> listBy2 = firstTypeService.listBy(null, "listAll");
			PmsOperator operator = this.getLoginedOperator();
			super.pushData(operator);
			super.pushData(pageBean);
			// 回显查询条件值
			super.pushData(paramMap);

			super.putData("RoleTypeEnumList", RoleTypeEnum.values());
			super.putData("browseRecords", browseRecords);
			super.putData("shopThemeList", listBy);
//			super.putData("firstTypeList", listBy2);
			super.putData("shopClassList", ShopClassEnum.toMap());
			super.putData("RoleTypeEnum", RoleTypeEnum.toMap());
			super.putData("OperatorTypeEnum", OperatorTypeEnum.toMap());
			return "browseRecordsActionList";
		} catch (Exception e) {
			log.error("== listBrowseRecords exception:", e);
			return operateError("获取数据失败");
		}
	}
	@Override
	public BrowseRecords getModel() {
		if (browseRecords == null) {
			browseRecords = new BrowseRecords();
		}
		return browseRecords;
	}

}
