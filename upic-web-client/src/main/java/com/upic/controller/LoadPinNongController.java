package com.upic.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
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
import org.springframework.web.bind.annotation.ResponseBody;

import com.upic.common.page.PageBean;
import com.upic.common.page.PageParam;
import com.upic.common.web.exception.WebException;
import com.upic.pay.common.web.springmvc.SpringMvcControllerSupport;
import com.upic.po.BannarPn;
import com.upic.po.HotThemePn;
import com.upic.po.SignPn;
import com.upic.po.ThemePn;
import com.upic.po.TypePn;
import com.upic.service.IArticalPnService;
import com.upic.service.IBannarPnService;
import com.upic.service.IHotThemePnLinkService;
import com.upic.service.IHotThemePnService;
import com.upic.service.IMeituPnService;
import com.upic.service.IModuleListService;
import com.upic.service.ISignPnLinkService;
import com.upic.service.ISignPnService;
import com.upic.service.IThemePnService;
import com.upic.service.ITypePnService;
import com.upic.shop.enums.TypeClassEnum;

/**
 * 品农操作层
 * 
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/pin")
public class LoadPinNongController extends SpringMvcControllerSupport {
	private static Log log = LogFactory.getLog(LoadPinNongController.class);
	@Autowired(required = false)
	private IBannarPnService bannarPnService;

	@Autowired(required = false)
	private ITypePnService typePnService;

	@Autowired(required = false)
	private IArticalPnService articalPnService;

	@Autowired(required = false)
	private IMeituPnService meituPnService;

	@Autowired(required = false)
	private ISignPnLinkService signPnLinkService;

	@Autowired(required = false)
	private ISignPnService signPnService;

	@Autowired(required = false)
	private IThemePnService themePnService;

	@Autowired(required = false)
	private IHotThemePnService hotThemePnService;

	@Autowired(required = false)
	private IHotThemePnLinkService hotThemePnLinkService;
	
	
	/**
	 * 品农首页加载商品以及公告加载(微网页端)
	 * 
	 * @param model
	 * @return
	 */
	// public String initFirstPage(Model model,String city) {
	@RequestMapping(value = "/initIndex")
	public String initFirstPage(Model model, HttpSession session) {
		try {
			Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("status", 100);
			List<BannarPn> mainPicList = bannarPnService.listBy(paramMap);
			Collections.sort(mainPicList);

			List<ThemePn> listBy2 = themePnService.listBy(null);
			Collections.sort(listBy2);
			// 加载所有上线的类型
			List<SignPn> listBy = signPnService.listBy(paramMap);
			Collections.sort(listBy);
			model.addAttribute("allSin", listBy);
			List<Object> list = new ArrayList<Object>();
			for (int i = 0; i < listBy.size(); i++) {
				int length = 4;
				if (i == (listBy.size() - 1)) {
					length = 6;
				}
				paramMap.put("signPnId", listBy.get(i).getId());
				PageBean listPage = signPnLinkService.listPage(new PageParam(1, length), paramMap);
				list.addAll(listPage.getRecordList());
			}
			// 热门主题
			paramMap.clear();
			paramMap.put("status", 100);
			List<HotThemePn> listHotTheme = hotThemePnService.listBy(paramMap);
			Collections.sort(listHotTheme);
			model.addAttribute("hotThemePn", listHotTheme);
			
			//加載最下面的4篇文章
			PageBean typePnList = typePnService.listPage(new PageParam(1, 4), paramMap);
			model.addAttribute("typePn", typePnList.getRecordList());
			
			// 内容
			model.addAttribute("content", list);
			// 根据相应类型加载出相关内容
			model.addAttribute("mainPic", mainPicList);
			// 寻味、什么的主题
			model.addAttribute("themePn", listBy2);
		} catch (WebException e) {
			log.error("== initFirstPage exception:", e);
			throw new WebException("1003", "错误信息：" + e.getMessage());
		}
		return "farmer/pin/firstPin";
	}

	/**
	 * 根据ID查询出相应的图文或者美图 如果是美图：则去查询出所有与此次相关的图片与介绍
	 */
	@RequestMapping("getByNumber/{number}")
	public String getDetialsByNumber(@PathVariable("number") String number, Model model) {
		try {
			// 根据number去寻找
			TypePn byId = typePnService.getById(Long.parseLong(number));
			if (byId.getStatus() == 101) {
				throw new WebException("1003", "对不起，该文章已下线。");
			}
			Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("fatherId", byId.getId());

			// 获得实体类后做类别分析1、图文直接查询出单条 2、美图 所有相关的 List
			if (byId.getTypePn().equals(TypeClassEnum.ARTICALPN.getDesc())) {
				Object o = articalPnService.getBy(paramMap, "listAll");
				model.addAttribute("artical", o);
				return "farmer/pin/contentDetialsPin";
			} else if (byId.getTypePn().equals(TypeClassEnum.MEITU.getDesc())) {
				List<Object> obj = meituPnService.listBy(paramMap, "listAll");
				model.addAttribute("meitu", obj);
				return "farmer/pin/picDetialsPin";
			}
			// 跳转页面
		} catch (WebException e) {
			log.error("== getDetialsByNumber exception:", e);
			throw new WebException("1003", "错误信息：" + e.getMessage());
		}
		return "";
	}

	/**
	 * 根据主题加载（寻味） 参数 主题名
	 */
	@ResponseBody
	@RequestMapping("getByThemeName")
	public PageBean getThemeId(@RequestParam("data") String themeName, String pageNumStr, String numPerPageStr) {
		try {
			// 根据number去寻找
			Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("themeName", themeName.equals("empty")?null:themeName);
			paramMap.put("status", 100);
			PageBean listPage = typePnService
					.listPage(new PageParam(Integer.parseInt(pageNumStr), Integer.parseInt(numPerPageStr)), paramMap);
			// 获得实体类后做类别分析1、图文直接查询出单条 2、美图 所有相关的 List

			// 跳转页面
			return listPage;
		} catch (WebException e) {
			log.error("== getDetialsByNumber exception:", e);
			throw new WebException("1003", "错误信息：" + e.getMessage());
		}
	}

	/**
	 * 根据标签加载相关的信息 (类似比赛、美图 品位) 分页
	 */
	@ResponseBody
	@RequestMapping("getByLinkId")
	public PageBean getLinkId(@RequestParam("data") String linkId, String pageNumStr, String numPerPageStr) {
		try {
			// 根据number去寻找
			Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("signPnId", linkId);
			paramMap.put("status", 100);
			PageBean listPage = signPnLinkService
					.listPage(new PageParam(Integer.parseInt(pageNumStr), Integer.parseInt(numPerPageStr)), paramMap);
			// 获得实体类后做类别分析1、图文直接查询出单条 2、美图 所有相关的 List
			// 跳转页面
			return listPage;
		} catch (WebException e) {
			log.error("== getDetialsByNumber exception:", e);
			throw new WebException("1003", "错误信息：" + e.getMessage());
		}
	}
	
	/**
	 * 根据标签加载相关的信息 (类似比赛、美图 品位) 分页
	 */
	@ResponseBody
	@RequestMapping("getByHotName")
	public PageBean getHotName(@RequestParam("data") String hotName, String pageNumStr, String numPerPageStr) {
		try {
			// 根据number去寻找
			Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("hotThemePn", hotName);
//			paramMap.put("status", 100);
			PageBean listPage = hotThemePnLinkService
					.listPage(new PageParam(Integer.parseInt(pageNumStr), Integer.parseInt(numPerPageStr)), paramMap);
			// 获得实体类后做类别分析1、图文直接查询出单条 2、美图 所有相关的 List
			// 跳转页面
			return listPage;
		} catch (WebException e) {
			log.error("== getDetialsByNumber exception:", e);
			throw new WebException("1003", "错误信息：" + e.getMessage());
		}
	}
	
	/**
	 * 跳转页面
	 * 
	 * @param model
	 * @param linkId
	 * @param themeName
	 * @return
	 */
	@RequestMapping("readyLoadContents")
	public String forword(Model model, @RequestParam(value = "linkId", required = false) String linkId,
			@RequestParam(value = "themeName", required = false) String themeName,
			@RequestParam(value = "hotTheme", required = false) String hotTheme) {
		try {
			// 跳转页面
			if (linkId != null && !linkId.isEmpty()) {
				SignPn byId = signPnService.getById(Integer.parseInt(linkId));
				model.addAttribute("linkName", byId.getSignPn());
			}
			model.addAttribute("linkId", linkId);
			model.addAttribute("hotTheme", hotTheme);
			model.addAttribute("themeName", themeName);

			return "farmer/pin/secondPin";
		} catch (WebException e) {
			log.error("== getDetialsByNumber exception:", e);
			throw new WebException("1003", "错误信息：" + e.getMessage());
		}
	}
}
