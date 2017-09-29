package com.upic.web.boss.action;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ModelDriven;
import com.upic.po.ModuleList;
import com.upic.po.YouXuan;
import com.upic.service.IModuleListService;
import com.upic.service.IProvinceService;
import com.upic.service.IYouXuanService;

import wusc.edu.pay.web.boss.base.BossBaseAction;

public class YouXuanAction extends BossBaseAction implements ModelDriven<YouXuan> {
	private static final long serialVersionUID = 1L;
	private static final Log log = LogFactory.getLog(YouXuanAction.class);
	private YouXuan youXuan;

	@Autowired
	private IYouXuanService youXuanService;

	@Autowired
	private IProvinceService provinceService;
	@Autowired
	private IModuleListService moduleListService;
	/**
	 * 查看所有优选商品
	 * 
	 * @return
	 */
	public String listYouXuan() {
		try {
			Map<String, Object> paramMap = new HashMap<String, Object>(); // 业务条件查询参数
			paramMap.put("city", youXuan.getCity()); //
			paramMap.put("provinceName", youXuan.getProvinceName()); 
			paramMap.put("districtName", youXuan.getDistrictName()); 
			paramMap.put("shopNumber", youXuan.getShopNumber()); //
			paramMap.put("shopName", youXuan.getShopName()); //
			paramMap.put("storeName", youXuan.getStoreName()); //
			paramMap.put("storeNumber", youXuan.getStoreNumber());
			paramMap.put("orderDateBegin", youXuan.getOrderDateBegin());
			paramMap.put("orderDateEnd", youXuan.getOrderDateEnd());
			paramMap.put("you_Status", youXuan.getYou_Status());
			paramMap.put("orderDateEnd", youXuan.getOrderDateEnd());
			super.pageBean = youXuanService.listPage(getPageParam(), paramMap);
			List<Object> province = provinceService.listBy(null, "listAll");
			super.putData("province", province);
			super.putData("youXuan", youXuan);
			super.pushData(pageBean);
		} catch (Exception e) {
			log.error("== listYouXuan exception:", e);
			return operateError("获取数据失败");
		}
		return "listYouXuan";
	}

	/**
	 * 查看详情或者准备更新
	 * 
	 * @return
	 */
	public String readyUpdate() {
		try {
			Map<String, Object> paramMap = new HashMap<String, Object>(); // 业务条件查询参数
			paramMap.put("id", youXuan.getId()); //
			YouXuan by = (YouXuan) youXuanService.getBy(paramMap, "getById");
			List<Object> province = provinceService.listBy(null, "listAll");
			paramMap.clear();
			paramMap.put("status", 100); 
			List<ModuleList> moduleList = moduleListService.listBy(paramMap);
			Collections.sort(moduleList);
			super.putData("province", province);
			super.putData("moduleList", moduleList);
			super.putData("youXuan", by);
		} catch (Exception e) {
			log.error("== readyUpdate exception:", e);
			return operateError("获取数据失败");
		}
		return "youXuanDetials";
	}

	/**
	 * 更新
	 * 
	 * @return
	 */
	public String update() {
		try {
			long update = youXuanService.update(youXuan);
			if (update == 0) {
				return operateError("更新数据失败");
			}
		} catch (Exception e) {
			log.error("== readyUpdate exception:", e);
			return operateError("获取数据失败");
		}
		return operateSuccess();
	}

	/**
	 * 添加
	 * 
	 * @return
	 */
	public String insert() {
		try {
			String a[]=youXuan.getShopNumber().split("_");
			String b[]=youXuan.getStoreNumber().split("_");
			youXuan.setShopId(Long.parseLong(a[0]));
			youXuan.setStoreId(Long.parseLong(b[0]));
			youXuan.setShopNumber(a[1]);
			youXuan.setStoreNumber(b[1]);
			youXuan.setShopName(a[2]);
			youXuan.setStoreName(b[2]);
			long insert = youXuanService.insert(youXuan);
			if (insert == 0) {
				return operateError("添加数据失败");
			}
		} catch (Exception e) {
			log.error("== insert exception:", e);
			return operateError("添加数据失败");
		}
		return operateSuccess();
	}

	/**
	 * 准备添加
	 */
	public String readyInsert(){
		try {
			Map<String, Object> paramMap = new HashMap<String, Object>(); 
			List<Object> province = provinceService.listBy(null, "listAll");
			paramMap.put("status", 100); 
			List<ModuleList> moduleList = moduleListService.listBy(paramMap);
			Collections.sort(moduleList);
			super.putData("province", province);
			super.putData("moduleList", moduleList);
		} catch (Exception e) {
			log.error("== readyInsert exception:", e);
			return operateError("添加数据失败");
		}
		return "readyAdd";
	}
	/**
	 * 上下架
	 */
	public String changeStatus() {
		try {
			YouXuan y = youXuanService.getById(Long.parseLong(""+youXuan.getId()));
			y.setYou_Status(youXuan.getYou_Status());
			long update = youXuanService.update(y);
			if (update == 0) {
				return this.operateError("更新失败，请重试");
			}
		} catch (Exception e) {
			log.error("上架或下架操作异常", e);
			return this.operateError("操作异常，请重试");
		}
		return operateSuccess();
	}

	/**
	 * 删除
	 * 
	 * @return
	 */
	public String deleteByYouXuanId() {
		try {
			Map<String, Object> paramMap = new HashMap<String, Object>(); // 业务条件查询参数
			paramMap.put("id", youXuan.getId()); //
			youXuanService.getBy(paramMap, "deleteById");
		} catch (Exception e) {
			log.error("== deleteShopType exception:", e);
			return operateError("删除数据失败");
		}
		return operateSuccess();
	}

	@Override
	public YouXuan getModel() {
		if (youXuan == null) {
			youXuan = new YouXuan();
		}
		return youXuan;
	}

}
