package com.upic.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.IndexWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.upic.lucene.service.ILuceneService;
import com.upic.po.Shop;
import com.upic.service.IShopService;
import com.upic.shop.enums.ShopStatusEnum;
import com.upic.utils.LuceneInitUtils;

@Controller
@RequestMapping("/luceneOper")
public class LuceneOperController {
	private static Log log = LogFactory.getLog(LuceneOperController.class);

	@Autowired(required = false)
	private IShopService shopService;

	@Autowired
	private IndexWriter indexWrtier;

	@Autowired
	private ILuceneService luceneService;

	@Autowired
	LuceneInitUtils l;
	/**
	 * 根据商品Number增加数据到缓存
	 * 
	 * @param shopNumber
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "addShopField")
	public String addFiled(String shopNumber) {
		try {
			Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("status", ShopStatusEnum.ACTIVE.getValue());
			paramMap.put("shopNumber", shopNumber);
			Shop by = (Shop) shopService.getBy(paramMap, "getByShopNumber");
			if (by == null) {
				return "error";
			}
			Document initData = l.initData(by);
			luceneService.addField(initData);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "success";
	}

	/**
	 * 当商品删除或者下架时候根据特性条件进行删除
	 * 
	 * @param condi 
	 * @param value
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "deleteShopField")
	public String deleteByCondi(String condi, String value) {
		try {
			luceneService.deleteFiled(condi, value);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "success";
	}
	/**
	 * 更新商品
	 * @param shopNumber
	 * @param condi shopNumber
	 * @param value 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "updateShopField")
	public String update(String shopNumber, String condi, String value) {
		try {
			Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("status", ShopStatusEnum.ACTIVE.getValue());
			paramMap.put("shopNumber", shopNumber);
			Shop by = (Shop) shopService.getBy(paramMap, "getByShopNumber");
			if (by == null) {
				return "error";
			}
			Document initData = l.initData(shopNumber);
			luceneService.updateField(initData, condi, value);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "success";
	}
}
