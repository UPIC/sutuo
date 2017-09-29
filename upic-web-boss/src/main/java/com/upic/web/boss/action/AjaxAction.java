package com.upic.web.boss.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.upic.service.ICityService;
import com.upic.service.IDistrictService;
import com.upic.service.IProvinceService;
import com.upic.service.IShopService;
import com.upic.service.IStoreService;
import com.upic.shop.enums.ShopStatusEnum;
import com.upic.store.emuns.StoreStatusEnum;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import wusc.edu.pay.web.boss.base.BossBaseAction;

public class AjaxAction extends BossBaseAction {
	private static final long serialVersionUID = 1L;
	private static final Log log = LogFactory.getLog(AjaxAction.class);

	@Autowired
	private IProvinceService provinceService;
	@Autowired
	private ICityService cityService;
	@Autowired
	private IDistrictService districtService;
	@Autowired
	private IStoreService storeService;
	@Autowired
	private IShopService shopService;
	private String result;
	private int provinceId;
	private int cityId;
	private String cityName;
	private String storeNum;
	private String district;

	/**
	 * 根据省ID获取所有城市
	 * 
	 * @return
	 */
	public String getAllCity() {
		try {
			Map<String, Object> paramMap = new HashMap<String, Object>(); // 业务条件查询参数
			paramMap.put("provinceId", provinceId);
			List<Object> listBy = cityService.listBy(paramMap, "listAll");
			JSONArray json = JSONArray.fromObject(listBy);
			result = json.toString();
		} catch (Exception e) {
			log.error("== listYouXuan exception:", e);
			return operateError("获取数据失败");
		}
		return SUCCESS;
	}

	/**
	 * 获取所有的区
	 * 
	 * @return
	 */
	public String getAllDistrict() {
		try {
			Map<String, Object> paramMap = new HashMap<String, Object>(); // 业务条件查询参数
			paramMap.put("cityId", cityId);
			List<Object> listBy = districtService.listBy(paramMap, "listAll");
			JSONArray json = JSONArray.fromObject(listBy);
			result = json.toString();
		} catch (Exception e) {
			log.error("== listYouXuan exception:", e);
			return operateError("获取数据失败");
		}
		return SUCCESS;
	}

	/**
	 * 获取所有的商家
	 * 
	 * @return
	 */
	public String getAllStoreByDistrict() {
		try {
			Map<String, Object> paramMap = new HashMap<String, Object>(); // 业务条件查询参数
			paramMap.put("districtName", district);
			paramMap.put("status", StoreStatusEnum.SUCCESS.name());
			List<Object> listBy = storeService.listBy(paramMap, "listAll");
			JSONArray json = JSONArray.fromObject(listBy);
			result = json.toString();
		} catch (Exception e) {
			log.error("== listYouXuan exception:", e);
			return operateError("获取数据失败");
		}
		return SUCCESS;
	}

	public String getAllShopByStoreNumber() {

		try {
			Map<String, Object> paramMap = new HashMap<String, Object>(); // 业务条件查询参数
			paramMap.put("storeNumber", storeNum);
			paramMap.put("status", 100);
			List<Object> listBy = shopService.listBy(paramMap, "listAll");
			JSONArray json = JSONArray.fromObject(listBy);
			result = json.toString();
		} catch (Exception e) {
			log.error("== listYouXuan exception:", e);
			return operateError("获取数据失败");
		}
		return SUCCESS;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public int getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(int provinceId) {
		this.provinceId = provinceId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getStoreNum() {
		return storeNum;
	}

	public void setStoreNum(String storeNum) {
		this.storeNum = storeNum;
	}

	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

}
