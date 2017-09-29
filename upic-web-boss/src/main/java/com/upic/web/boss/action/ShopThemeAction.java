package com.upic.web.boss.action;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ModelDriven;
import com.upic.po.ShopTheme;
import com.upic.po.ShopType;
import com.upic.service.IShopThemeService;

import wusc.edu.pay.web.boss.base.BossBaseAction;
import wusc.edu.pay.web.permission.entity.PmsOperator;
import wusc.edu.pay.web.permission.enums.OperatorTypeEnum;
import wusc.edu.pay.web.permission.enums.RoleTypeEnum;

public class ShopThemeAction extends BossBaseAction implements ModelDriven<ShopTheme> {
	private static final long serialVersionUID = 1L;
	private static final Log log = LogFactory.getLog(ShopThemeAction.class);
	private ShopTheme shopTheme;
	@Autowired
	private IShopThemeService shopThemeService;

	/**
	 * 查看所有商品主题
	 * 
	 * @return
	 */
	public String listShopTheme() {
		try {
			Map<String, Object> paramMap = new HashMap<String, Object>(); // 业务条件查询参数
			paramMap.put("theme", shopTheme.getTheme()); // 商品名称（模糊查询）
			super.pageBean = shopThemeService.listPage(getPageParam(), paramMap);

			PmsOperator operator = this.getLoginedOperator();
			super.pushData(operator);
			super.pushData(pageBean);
			// 回显查询条件值
			super.pushData(paramMap);

			super.putData("RoleTypeEnumList", RoleTypeEnum.values());
			super.putData("shopTheme",shopTheme);
			super.putData("RoleTypeEnum", RoleTypeEnum.toMap());
			super.putData("OperatorTypeEnum", OperatorTypeEnum.toMap());
			return "shopThemeActionList";
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
			ShopTheme s = shopThemeService.getById(shopTheme.getId());
			if (s == null) {
				return operateError("获取数据失败");
			}
			PmsOperator operator = this.getLoginedOperator();
			super.pushData(operator);
			// 回显查询条件值
			super.putData("shopType", s);
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
			ShopTheme s = shopThemeService.getById(shopTheme.getId());
			int id = getInteger("id");
			Map<String, Object> paramMap = new HashMap<String, Object>(); // 业务条件查询参数
			paramMap.put("shopTypeId", id);
			shopThemeService.getBy(paramMap, "deleteById");
			super.logEdit("删除类型序号编号[" + s.getId() + "类型名:" + s.getTheme() + "]");
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
			if (shopTheme == null) {
				operateError("获取数据失败");
			}
			long result = shopThemeService.insert(shopTheme);
			if (result == 0) {
				return operateError("添加数据失败");
			}
			super.logEdit("添加类型：[类型名:" + shopTheme.getTheme() + "]");
		} catch (Exception e) {
			log.error("== insertData exception:", e);
			return operateError("添加数据失败");
		}
		return operateSuccess();
	}

	/**
	 * 更新数据
	 */
	public String updateshopTheme() {
		try {
			if (shopTheme == null) {
				operateError("获取数据失败");
			}
			long result = shopThemeService.update(shopTheme);
			if (result == 0) {
				return operateError("添加数据失败");
			}
			super.logEdit("添加类型：[类型名:" + shopTheme.getTheme() + "]");
		} catch (Exception e) {
			log.error("== updateShopType exception:", e);
			return operateError("获取数据失败");
		}
		return operateSuccess();
	}

	/**
	 * 跳转添加页面
	 */
	public String goAdd() {
		return "shopThemeAdd";
	}

	@Override
	public ShopTheme getModel() {
		if (shopTheme == null) {
			shopTheme = new ShopTheme();
		}
		return shopTheme;
	}

}
