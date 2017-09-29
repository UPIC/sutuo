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
import com.upic.po.FirstType;
import com.upic.po.Shop;
import com.upic.po.ShopPic;
import com.upic.po.ShopType;
import com.upic.service.IFirstTypeService;
import com.upic.service.IShopService;
import com.upic.service.IShopTypeService;

import wusc.edu.pay.web.boss.base.BossBaseAction;
import wusc.edu.pay.web.permission.entity.PmsOperator;
import wusc.edu.pay.web.permission.enums.OperatorTypeEnum;
import wusc.edu.pay.web.permission.enums.RoleTypeEnum;

public class ShopTypeAction extends BossBaseAction implements ModelDriven<ShopType> {
	private static final long serialVersionUID = 1L;
	private static final Log log = LogFactory.getLog(ShopTypeAction.class);
	private ShopType shopType;
	@Autowired
	private IShopTypeService shopTypeService;

	@Autowired
	private IFirstTypeService firstTypeService;
	/**
	 * 查看所有商品类型
	 * 
	 * @return
	 */
	public String listShop() {
		try {
			Map<String, Object> paramMap = new HashMap<String, Object>(); // 业务条件查询参数
			String typeName = "";
			if (getString("typeName") != null) {
				typeName = getString("typeName");
			}
			paramMap.put("typeName", typeName); // 商品名称（模糊查询）
			paramMap.put("firstTypeName", getString("firstTypeName"));
			super.pageBean = shopTypeService.listPage(getPageParam(), paramMap);

			PmsOperator operator = this.getLoginedOperator();
			super.pushData(operator);
			super.pushData(pageBean);
			// 回显查询条件值
			super.pushData(paramMap);

			super.putData("RoleTypeEnumList", RoleTypeEnum.values());
			super.putData("RoleTypeEnum", RoleTypeEnum.toMap());
			super.putData("OperatorTypeEnum", OperatorTypeEnum.toMap());
			return "shopTypeActionList";
		} catch (Exception e) {
			log.error("== listShop exception:", e);
			return operateError("获取数据失败");
		}
	}

	/**
	 * 
	 * 查看某一个商品类型
	 *
	 */
	public String seeShopTypeDetials() {
		try {
			List<Object> listBy = firstTypeService.listBy(null, "listAll");
			ShopType s = shopTypeService.getById(shopType.getId());
			if (s == null) {
				return operateError("获取数据失败");
			}
			PmsOperator operator = this.getLoginedOperator();
			super.pushData(operator);
			// 回显查询条件值
			super.putData("shopType", s);
			super.putData("firstList", listBy);
			super.putData("RoleTypeEnumList", RoleTypeEnum.values());
			super.putData("RoleTypeEnum", RoleTypeEnum.toMap());
			super.putData("OperatorTypeEnum", OperatorTypeEnum.toMap());
			return "ShopTypeDetials";
		} catch (Exception e) {
			log.error("== seeShopDetials exception:", e);
			return operateError("获取数据失败");
		}
	}

	/**
	 * 删除商品类型
	 */
	public String deleteShopType() {
		try {
			ShopType s = shopTypeService.getById(shopType.getId());
			int id = getInteger("id");
			Map<String, Object> paramMap = new HashMap<String, Object>(); // 业务条件查询参数
			paramMap.put("shopTypeId", id);
			shopTypeService.getBy(paramMap, "deleteById");
			super.logEdit("删除类型序号编号[" + s.getId() + "类型名:" + s.getTypeName() + "]");
		} catch (Exception e) {
			log.error("== deleteShopType exception:", e);
			return operateError("删除数据失败");
		}
		return operateSuccess();
	}

	/**
	 * 新增一条记录
	 */
	public String insertData() {
		try {
			if (shopType == null) {
				operateError("获取数据失败");
			}
			FirstType byId = firstTypeService.getById(shopType.getFirstTypeId());
			if(byId==null){
				return operateError("获取一级数据失败");
			}
			shopType.setFirstTypeName(byId.getFirstType());
			long result = shopTypeService.insert(shopType);
			if (result == 0) {
				return operateError("添加数据失败");
			}
			super.logEdit("添加类型：[类型名:" + shopType.getTypeName() + "]");
		} catch (Exception e) {
			log.error("== insertData exception:", e);
			return operateError("添加数据失败");
		}
		return operateSuccess();
	}
	
	/**
	 * 更新数据
	 */
	public String updateShopType(){
		try {
			if (shopType == null) {
				operateError("获取数据失败");
			}
			FirstType byId = firstTypeService.getById(shopType.getFirstTypeId());
			if(byId==null){
				return operateError("获取一级数据失败");
			}
			shopType.setFirstTypeName(byId.getFirstType());
			long result = shopTypeService.update(shopType);
			if (result == 0) {
				return operateError("添加数据失败");
			}
			super.logEdit("添加类型：[类型名:" + shopType.getTypeName() + "]");
		} catch (Exception e) {
			log.error("== updateShopType exception:", e);
			return operateError("获取数据失败");
		}
		return operateSuccess();
		}
	/**
	 * 跳转添加页面
	 */
	public String goAdd(){
		return "shopTypeAdd";}
	@Override
	public ShopType getModel() {
		if (shopType == null) {
			shopType = new ShopType();
		}
		return shopType;
	}

}
