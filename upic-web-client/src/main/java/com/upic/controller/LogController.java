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
import com.upic.po.Store;
import com.upic.service.ILogService;
import com.upic.service.IStoreService;

@Controller
@RequestMapping("/log")
public class LogController {
	private static Log log = LogFactory.getLog(LogController.class);
	
	@Autowired(required=false)
	private ILogService logService;
	
	@Autowired(required=false)
	private IStoreService storeService;
	
	/**
	 * 根据storeId获取相应的日志
	 * @param objId
	 * @param pageNumStr
	 * @param numPerPageStr
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping("listLog/{storeId}/{pageNumStr}/{numPerPageStr}")
	public PageBean listLog( @PathVariable("storeId") int objId,
			@PathVariable("pageNumStr") String pageNumStr, @PathVariable("numPerPageStr") String numPerPageStr,
			HttpSession session) {
		try{
			int numPerPage = 10;
			int pageNum = 1;
			if (StringUtils.isNotBlank(numPerPageStr)) {
				numPerPage = Integer.parseInt(numPerPageStr);
			}
			if (StringUtils.isNotBlank(pageNumStr)) {
				pageNum = Integer.valueOf(pageNumStr);
			}
			Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("storeId",objId);
			PageBean listPage = logService.listPage(new PageParam(pageNum, numPerPage), paramMap);
			return listPage;
		}catch(WebException e){
			log.error("== searchCollectionByType exception:", e);
			throw new WebException("1003", e.getMessage());
		}
	}
	/**
	 * 根据logNumber加载日志
	 * @param model
	 * @param logNumber
	 * @param session
	 * @return
	 */
	@RequestMapping("getLog/{logNumber}")
	public String getLogDetials(Model model,@PathVariable("logNumber") int logNumber,
			HttpSession session){
		try{
			Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("logNumber",logNumber);
			com.upic.po.Log by = logService.getBy(paramMap);
			if(by==null){
				
			}
			model.addAttribute("log", by);
		}catch(WebException e){
			log.error("== searchCollectionByType exception:", e);
			throw new WebException("1003", e.getMessage());
		}
		return "farmer/store/logDetialStore";
	}
	
	/**
	 * 跳转页面，到log页面
	 * @return
	 */
	@RequestMapping("loadLog/{storeId}")
	public String loadLog(Model model,@PathVariable("storeId") int storeId){
		try{
			Store byId = storeService.getById(storeId);
			model.addAttribute("storeId", storeId);
			model.addAttribute("store", byId);
			}catch(WebException e){
				log.error("== searchCollectionByType exception:", e);
				throw new WebException("1003", e.getMessage());
			}
		return "farmer/store/storeLog";}
	
}
