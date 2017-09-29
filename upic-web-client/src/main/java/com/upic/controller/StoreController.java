package com.upic.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.upic.common.web.exception.WebException;
import com.upic.po.Shop;
import com.upic.po.Store;
import com.upic.po.User;
import com.upic.service.IShopService;
import com.upic.service.IShopTypeService;
import com.upic.service.IStoreCollectionService;
import com.upic.service.IStoreService;
import com.upic.shop.enums.TypeClassEnum;

@Controller
@RequestMapping("/store")
public class StoreController {
	private static Log log = LogFactory.getLog(StoreController.class);

	@Autowired(required = false)
	private IStoreService storeService;

	@Autowired(required = false)
	private IStoreCollectionService storeCollectionService;
	

	/**
	 * 根据农场Number查找首页
	 * 
	 * @param model
	 * @param pageNumStr
	 * @param numPerPageStr
	 * @param method
	 * @param city
	 * @return
	 */
	@RequestMapping(value = "{storeNumber}/searchBySM")
	public String searchSMByKywordAndType(Model model, @PathVariable("storeNumber") String storeNumber,
			HttpSession session) {
		try {
			Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("storeNumber", storeNumber);
			paramMap.put("status", 100);
			Store s = (Store) storeService.getBy(paramMap, "getByShopNumber");
			if (s == null) {
				// 异常处理，商品下线
			}
			long allCollectionNum = (Long) storeCollectionService.getBy(paramMap, "listPageCount");
			User u = (User) session.getAttribute("user");
			if (u != null) {
				paramMap.put("userId", u.getId());
				// 查看用户是否关注
				long user = (Long) storeCollectionService.getBy(paramMap, "listPageCount");
				if (user != 0) {
					model.addAttribute("attention", user);
				}
			}
			model.addAttribute("allNum", allCollectionNum);
			model.addAttribute("storeDetials", s);
			model.addAttribute("storeNumber", s.getStoreNumber());
		} catch (WebException e) {
			log.error("== searchSMByKywordAndType exception:", e);
			throw new WebException("1003", "请求有误");
		}
		return "farmer/store/storeMain";
	}
	
	
	
}
