package com.upic.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.upic.common.page.PageBean;
import com.upic.common.page.PageParam;
import com.upic.common.web.exception.WebException;
import com.upic.po.Shop;
import com.upic.po.ShopCollection;
import com.upic.po.StatusClass;
import com.upic.po.Store;
import com.upic.po.StoreCollection;
import com.upic.po.User;
import com.upic.service.IShopCollectionService;
import com.upic.service.IShopService;
import com.upic.service.IStoreCollectionService;
import com.upic.service.IStoreService;

@Controller
@RequestMapping("/collection")
public class CollectionController {
	private static Log log = LogFactory.getLog(CollectionController.class);

	@Autowired(required = false)
	private IShopCollectionService shopCollectionService;

	@Autowired(required = false)
	private IStoreCollectionService storeCollectionService;

	@Autowired(required = false)
	private IStoreService storeService;

	@Autowired(required = false)
	private IShopService shopService;

	/**
	 * 根据收藏类型、收藏页码找出收藏信息
	 * 
	 * @param model
	 * @param pageNumStr
	 * @param numPerPageStr
	 * @param method
	 * @param city
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "searchByType/{typeId}/{pageNumStr}/{numPerPageStr}")
	public PageBean searchCollectionByType(Model model, @PathVariable("typeId") int typeId,
			@PathVariable("pageNumStr") String pageNumStr, @PathVariable("numPerPageStr") String numPerPageStr,
			HttpSession session) {
		try {
			int numPerPage = 10;
			int pageNum = 1;
			if (StringUtils.isNotBlank(numPerPageStr)) {
				numPerPage = Integer.parseInt(numPerPageStr);
			}
			if (StringUtils.isNotBlank(pageNumStr)) {
				pageNum = Integer.valueOf(pageNumStr);
			}
			User u = (User) session.getAttribute("user");
			if (u == null) {
				throw new WebException("1003", "获取用户信息失败哦");
			}
			Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("userId", u.getId());
			PageBean listPage = null;
			switch (typeId) {
			case 1:
				listPage = shopCollectionService.listPage(new PageParam(pageNum, numPerPage), paramMap,
						"findObjectByShopId");
				break;
			case 2:
				listPage = storeCollectionService.listPage(new PageParam(pageNum, numPerPage), paramMap,
						"findObjectByStoreId");
				break;
			default:
				break;
			}
			return listPage;
		} catch (WebException e) {
			log.error("== searchCollectionByType exception:", e);
			throw new WebException("1003", e.getMessage());
		}
	}

	/**
	 * 添加收藏
	 * 
	 * @param model
	 * @param typeId
	 * @param pageNumStr
	 * @param numPerPageStr
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "addCollection/{typeId}/{someID}")
	public StatusClass addCollectionByType(Model model, @PathVariable("typeId") int typeId,
			@PathVariable("someID") String someID, HttpSession session) {
		try {
			User u = (User) session.getAttribute("user");
			if (u == null) {
				throw new WebException("1003", "获取用户信息失败哦");
			}
			Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("userId", u.getId());

			StatusClass s = new StatusClass();
			switch (typeId) {
			case 1:
				paramMap.put("shopId", someID);
				// 幂等判断
				long collectionNum = (Long) shopCollectionService.getBy(paramMap, "listPageCount");
				if (collectionNum > 0) {
					collectionNum = (Long) shopCollectionService.getBy(paramMap, "listPageCount");
					s.setContent("" + collectionNum);
					s.setStatus("success");
				} else {
					Shop byId = shopService.getById(Long.parseLong(someID));
					ShopCollection collection = new ShopCollection();
					collection.setShopId(byId.getId());
					collection.setPic(byId.getHeadPic());
					collection.setPrice(byId.getShopPrice() + "");
					collection.setShopName(byId.getShopName());
					collection.setShopNumber(byId.getShopNumber());
					collection.setUserId(u.getId());
					long insert = shopCollectionService.insert(collection);
					if (insert == 0) {
						s.setStatus("error");
						s.setContent("添加失败，请重试！");
					} else {
						paramMap.clear();
						paramMap.put("shopId", someID);
						collectionNum = (Long) shopCollectionService.getBy(paramMap, "listPageCount");
						s.setContent("" + collectionNum);
						s.setStatus("success");
					}
				}
				break;
			case 2:
				Store store = storeService.getById(Long.parseLong(someID));
				StoreCollection c = new StoreCollection();
				c.setStoreId(store.getId());
				c.setPic(store.getHeadPic());
				c.setStoreName(store.getStoreName());
				c.setStoreNumber(store.getStoreNumber());
				c.setUserId(u.getId());
				long inserts = storeCollectionService.insert(c);
				if (inserts == 0) {
					s.setStatus("error");
					s.setContent("添加失败，请重试！");
				} else {
					s.setContent("添加成功");
					s.setStatus("success");
				}
				break;
			default:
				break;
			}
			return s;
		} catch (WebException e) {
			log.error("== searchCollectionByType exception:", e);
			throw new WebException("1003", e.getMessage());
		}
	}

	/**
	 * 取消收藏
	 * 
	 * @param model
	 * @param typeId
	 * @param someID
	 *            shop：是ID stroe：是number
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "cancel/{typeId}/{someID}")
	public StatusClass cancelCollectionByType(Model model, @PathVariable("typeId") int typeId,
			@PathVariable("someID") String someID, HttpSession session) {
		try {
			User u = (User) session.getAttribute("user");
			if (u == null) {
				throw new WebException("1003", "获取用户信息失败哦");
			}
			Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("userId", u.getId());
			paramMap.put("someID", someID);
			StatusClass s = new StatusClass();
			switch (typeId) {
			case 1:
				shopCollectionService.getBy(paramMap, "deleteByCondi");
				paramMap.clear();
				paramMap.put("shopId", someID);
				long collectionNum = (Long) shopCollectionService.getBy(paramMap, "listPageCount");
				s.setContent("" + collectionNum);
				s.setStatus("success");
				break;
			case 2:
				storeCollectionService.getBy(paramMap, "deleteByCondi");
				s.setContent("取消成功");
				s.setStatus("success");
				break;
			default:
				break;
			}
			return s;
		} catch (WebException e) {
			log.error("== searchCollectionByType exception:", e);
			throw new WebException("1003", e.getMessage());
		}
	}
}
