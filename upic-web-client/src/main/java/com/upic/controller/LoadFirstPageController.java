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
import org.springframework.web.bind.annotation.RequestMapping;

import com.upic.common.web.exception.WebException;
import com.upic.controller.emun.WordsEnum;
import com.upic.pay.common.web.springmvc.SpringMvcControllerSupport;
import com.upic.po.ActivityArea;
import com.upic.po.MainPic;
import com.upic.po.ModuleList;
import com.upic.po.ThemeArea;
import com.upic.po.YouXuan;
import com.upic.service.IActivityAreaService;
import com.upic.service.ICityWithoutQuService;
import com.upic.service.IMainPicService;
import com.upic.service.IModuleListService;
import com.upic.service.IThemeAreaService;
import com.upic.service.IYouXuanService;

@Controller
@RequestMapping("/init")
public class LoadFirstPageController extends SpringMvcControllerSupport {
	private static Log log = LogFactory.getLog(LoadFirstPageController.class);
	@Autowired(required=false)
	private IMainPicService mainPicService;
	
	@Autowired(required=false)
	private IActivityAreaService activityAreaService;
	
	@Autowired(required=false)
	private IYouXuanService youxuanService;
	
	@Autowired(required=false)
	private ICityWithoutQuService cityWithoutQuService;
	
	@Autowired(required=false)
	private IThemeAreaService themeAreaService;
	@Autowired(required = false)
	private IModuleListService moduleListService;
	/**
	 * 首页加载商品以及公告加载(微网页端)
	 * 
	 * @param model
	 * @return
	 */
//	public String initFirstPage(Model model,String city) {
	@RequestMapping(value = "/initIndex")
	public String initFirstPage(Model model,HttpSession session) {
		try {
			String city=(String) session.getAttribute("city");
			city=city==null?"宁波市":city;
			session.setAttribute("city", city);
			//查询banner图
			Map<String,Object> paramMap=new HashMap<String, Object>();
			paramMap.put("status", 100);
			List<MainPic> mainPicList = mainPicService.listBy(paramMap);
			Collections.sort(mainPicList);
			//查询活动栏
			 paramMap=new HashMap<String, Object>();
			paramMap.put("status", 100);
			List<ActivityArea> activityAreaList = activityAreaService.listBy(paramMap);
			Collections.sort(activityAreaList);
			//优选活动
			paramMap.clear();
			paramMap=new HashMap<String, Object>();
			paramMap.put("status", 100);
			List<ModuleList> listBy = moduleListService.listBy(paramMap);
			Collections.sort(listBy);
			List<YouXuan> listBy2 =new ArrayList<YouXuan>();
			paramMap.put("city", city);
			for(ModuleList m:listBy){
				paramMap.put("moduleListId", m.getId());
				listBy2.addAll(youxuanService.listBy(paramMap));
			}
			Collections.sort(listBy2);
//			paramMap.put("city", city);
//			List<YouXuan> listBy = youxuanService.listBy(paramMap);
//			Collections.sort(listBy);
			//10个选项图
			paramMap=new HashMap<String, Object>();
			paramMap.put("status", 100);
			paramMap.put("city", city);
			List<ThemeArea> listBy1 = themeAreaService.listBy(paramMap);
			Collections.sort(listBy1);
			
			model.addAttribute("mainPic", mainPicList);
			model.addAttribute("activityArea", activityAreaList);
			model.addAttribute("moduleList", listBy);
			model.addAttribute("youXuan", listBy2);
			model.addAttribute("themeArea", listBy1);
		} catch (WebException e) {
			log.error("== initFirstPage exception:", e);
			throw new WebException("1003", "错误信息：" + e.getMessage());
		}
		return "farmer/onePage/mainPlay";
	}
	/**
	 * 初始化选择城市
	 * @param model
	 * @param session
	 * @param city
	 * @return
	 */
	@RequestMapping(value = "/initSelect")
	public String initSelect(Model model,HttpSession session,String city) {
		try {
			session.setAttribute("city", city);
		} catch (WebException e) {
			log.error("== initFirstPage exception:", e);
			throw new WebException("1003", "错误信息：" + e.getMessage());
		}
		return "redirect:/init/initIndex.do";
	}
	
	/**
	 * 获取所有县级市、地级市
	 * @return
	 */
	@RequestMapping(value="/cityWithoutQu")
	public String selectCityNeed(Model model){
		try {
			//获取默认地址
			List<Object> listBy = cityWithoutQuService.listBy(null, "listAll");
			model.addAttribute("listBy", listBy);
			model.addAttribute("words", WordsEnum.toList());
			return "farmer/common/select";
		} catch (WebException e) {
			log.error("== initFirstPage exception:", e);
			throw new WebException("1003", "错误信息：" + e.getMessage());
		}
	}
}
