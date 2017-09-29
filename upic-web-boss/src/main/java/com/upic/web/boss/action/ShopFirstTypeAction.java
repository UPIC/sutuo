package com.upic.web.boss.action;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ModelDriven;
import com.upic.po.FirstType;
import com.upic.po.ShopTheme;
import com.upic.po.ShopType;
import com.upic.service.IFirstTypeService;
import com.upic.service.IShopThemeService;

import wusc.edu.pay.web.boss.base.BossBaseAction;
import wusc.edu.pay.web.permission.entity.PmsOperator;
import wusc.edu.pay.web.permission.enums.OperatorTypeEnum;
import wusc.edu.pay.web.permission.enums.RoleTypeEnum;

public class ShopFirstTypeAction extends BossBaseAction implements ModelDriven<FirstType> {
	private static final long serialVersionUID = 1L;
	private static final Log log = LogFactory.getLog(ShopFirstTypeAction.class);
	private FirstType firstType;
	@Autowired
	private IFirstTypeService firstTypeService;

	/**
	 * 查看所有商品一级类别
	 * 
	 * @return
	 */
	public String listShopFirstType() {
		try {
			Map<String, Object> paramMap = new HashMap<String, Object>(); // 业务条件查询参数
			paramMap.put("firstType", firstType.getFirstType()); // 商品名称（模糊查询）
			super.pageBean = firstTypeService.listPage(getPageParam(), paramMap);

			PmsOperator operator = this.getLoginedOperator();
			super.pushData(operator);
			super.pushData(pageBean);
			// 回显查询条件值
			super.pushData(paramMap);

			super.putData("RoleTypeEnumList", RoleTypeEnum.values());
			super.putData("firstType",firstType);
			super.putData("RoleTypeEnum", RoleTypeEnum.toMap());
			super.putData("OperatorTypeEnum", OperatorTypeEnum.toMap());
			return "shopFirstTypeActionList";
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
	public String seeShopFirstTypeDetials() {
		try {
			FirstType s = firstTypeService.getById(firstType.getId());
			if (s == null) {
				return operateError("获取数据失败");
			}
			PmsOperator operator = this.getLoginedOperator();
			super.pushData(operator);
			// 回显查询条件值
			super.putData("firstType", s);
			super.putData("RoleTypeEnumList", RoleTypeEnum.values());
			super.putData("RoleTypeEnum", RoleTypeEnum.toMap());
			super.putData("OperatorTypeEnum", OperatorTypeEnum.toMap());
			return "shopFirstTypeDetials";
		} catch (Exception e) {
			log.error("== seeShopDetials exception:", e);
			return operateError("获取数据失败");
		}
	}

	/**
	 * 删除商品类型
	 */
	public String deleteShopFirstType() {
		try {
			FirstType s = firstTypeService.getById(firstType.getId());
			int id = getInteger("id");
			Map<String, Object> paramMap = new HashMap<String, Object>(); // 业务条件查询参数
			paramMap.put("shopTypeId", id);
			firstTypeService.getBy(paramMap, "deleteById");
			super.logEdit("删除类型序号编号[" + s.getId() + "类型名:" + s.getFirstType() + "]");
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
			if (firstType == null) {
				operateError("获取数据失败");
			}
			long result = firstTypeService.insert(firstType);
			if (result == 0) {
				return operateError("添加数据失败");
			}
			super.logEdit("添加类型：[类型名:" + firstType.getFirstType() + "]");
		} catch (Exception e) {
			log.error("== insertData exception:", e);
			return operateError("添加数据失败");
		}
		return operateSuccess();
	}

	/**
	 * 更新数据
	 */
	public String updateshopFirstType() {
		try {
			if (firstType == null) {
				operateError("获取数据失败");
			}
			long result = firstTypeService.update(firstType);
			if (result == 0) {
				return operateError("添加数据失败");
			}
			super.logEdit("添加类型：[类型名:" + firstType.getFirstType() + "]");
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
		return "shopFirstTypeAdd";
	}

	@Override
	public FirstType getModel() {
		if (firstType == null) {
			firstType = new FirstType();
		}
		return firstType;
	}

}
