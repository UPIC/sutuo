package com.upic.web.boss.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ModelDriven;
import com.upic.common.enums.AccessEnum;
import com.upic.po.Access;
import com.upic.po.User;
import com.upic.service.IAccessService;
import com.upic.service.IProvinceService;
import com.upic.service.IUserService;

import wusc.edu.pay.web.boss.base.BossBaseAction;
import wusc.edu.pay.web.permission.entity.PmsOperator;
import wusc.edu.pay.web.permission.enums.OperatorTypeEnum;
import wusc.edu.pay.web.permission.enums.RoleTypeEnum;

public class AccessAction extends BossBaseAction implements ModelDriven<Access> {
	private static final long serialVersionUID = 1L;
	private static final Log log = LogFactory.getLog(AccessAction.class);
	private Access access;
	@Autowired
	private IAccessService accessService;
	@Autowired
	private IProvinceService provinceService;
	/**
	 * 查看所有商品
	 * 
	 * @return
	 */
	public String listAccessList() {
		try {
			Map<String, Object> paramMap = new HashMap<String, Object>(); // 业务条件查询参数
			paramMap.put("orderDateBegin", access.getOrderDateBegin());//注册开始
			paramMap.put("orderDateEnd", access.getOrderDateEnd());//注册结束
			//省 市 区
			paramMap.put("privince", access.getPrivince());
			paramMap.put("city", access.getCity());
			paramMap.put("county", access.getCounty());
			
			//商品编号 商品名 商店名 商店编号
			paramMap.put("shopNumber", access.getShopNumber());
			paramMap.put("shopName", access.getShopName());
			paramMap.put("storeName", access.getStoreName());
			paramMap.put("storeNumber", access.getStoreNumber());
			
			//类型
			paramMap.put("type", access.getType());
			super.pageBean = accessService.listPage(getPageParam(), paramMap);
			
			List<Object> province = provinceService.listBy(null, "listAll");
			PmsOperator operator = this.getLoginedOperator();
			super.pushData(operator);
			super.pushData(pageBean);
			// 回显查询条件值
//			super.pushData(paramMap);

			super.putData("AccessEnumList", AccessEnum.toList());
			super.putData("access", access);
			super.putData("RoleTypeEnum", RoleTypeEnum.toMap());
			super.putData("OperatorTypeEnum", OperatorTypeEnum.toMap());
			super.putData("province", province);
			return "listAccessList";
		} catch (Exception e) {
			log.error("== listBrowseRecords exception:", e);
			return operateError("获取数据失败");
		}
	}
	@Override
	public Access getModel() {
		if (access == null) {
			access = new Access();
		}
		return access;
	}

}
