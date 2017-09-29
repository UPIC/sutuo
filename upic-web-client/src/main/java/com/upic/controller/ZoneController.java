package com.upic.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.upic.common.web.exception.WebException;
import com.upic.controller.emun.WordsEnum;
import com.upic.pay.common.web.springmvc.SpringMvcControllerSupport;
import com.upic.po.User;
import com.upic.service.IAddressService;
import com.upic.service.ICityService;
import com.upic.service.ICityWithoutQuService;
import com.upic.service.IDistrictService;
import com.upic.service.IProvinceService;
@Controller
@RequestMapping("/zone")
public class ZoneController extends SpringMvcControllerSupport{
	private static Log log = LogFactory.getLog(ZoneController.class);
	@Autowired
	private IProvinceService provinceService;
	@Autowired
	private ICityService cityService;
	@Autowired
	private IDistrictService districtService;
	@Autowired
	private IAddressService addressService;
	

	/**
	 * 根据省查询城市
	 * @param model
	 * @param shopType
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/getAllCity")
	public List<Object> getCityByProvinceId(@RequestParam("provinceId")Integer provinceId){
		try {
			Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("provinceId", provinceId);
			//获取默认地址
			List<Object> listBy = cityService.listBy(paramMap, "listAll");
			return listBy;
		} catch (WebException e) {
			log.error("== initFirstPage exception:", e);
			throw new WebException("1003", "错误信息：" + e.getMessage());
		}
	}
	/**
	 * 根据城市查询区域
	 * @param model
	 * @param shopType
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/getAllDistrict")
	public List<Object> getDistrictByCityId(@RequestParam("cityId")Integer cityId){
		try {
			Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("cityId", cityId);
			//获取默认地址
			List<Object> listBy = districtService.listBy(paramMap, "listAll");
			return listBy;
		} catch (WebException e) {
			log.error("== initFirstPage exception:", e);
			throw new WebException("1003", "错误信息：" + e.getMessage());
		}
	}
	

	
}
