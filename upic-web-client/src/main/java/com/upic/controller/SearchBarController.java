package com.upic.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.upic.common.config.PublicConfig;
import com.upic.common.core.enums.SearchTypeEnum;
import com.upic.common.entity.CenterSearch;
import com.upic.common.entity.SearchPo;
import com.upic.common.entity.ShowShop;
import com.upic.common.page.PageBean;
import com.upic.common.web.exception.WebException;
import com.upic.common.web.utils.HttpRequestUtil;
import com.upic.po.City;
import com.upic.service.ICityService;
import com.upic.service.IDistrictService;
import com.upic.service.IKeyWordKWService;
import com.upic.service.IProjectFirstService;
import com.upic.service.IProjectService;
import com.upic.service.IThemetzFirstService;
import com.upic.service.IThemetzService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("/search")
public class SearchBarController {
	private static Log log = LogFactory.getLog(SearchBarController.class);

	@Autowired(required=false)
	private ICityService cityService;
	
	@Autowired(required=false)
	private IDistrictService districtService;
	
	@Autowired(required=false)
	private IProjectFirstService projectFirstService;
	@Autowired(required=false)
	private IProjectService projectService;
	
	@Autowired
	private IThemetzFirstService themetzFirstService;
	
	@Autowired
	private IThemetzService themetzService;
	
	@Autowired
	private IKeyWordKWService keyWordKWService;
	/**
	 * 满足首页农场推介模块
	 * 
	 * @param model
	 * @param pageNumStr
	 * @param numPerPageStr
	 * @param method
	 * @param city
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "searchBySM")
	public PageBean searchSMByKywordAndType(Model model, String pageNumStr, String numPerPageStr, Integer method,
			String city) {
		try {
			int numPerPage = 10;
			int pageNum = 1;
			if (StringUtils.isNotBlank(numPerPageStr)) {
				numPerPage = Integer.parseInt(numPerPageStr);
			}
			if (StringUtils.isNotBlank(pageNumStr)) {
				pageNum = Integer.valueOf(pageNumStr);
			}
//			String searchUrl = PublicConfig.SEARCH_URL;
			 String searchUrl =PublicConfig.SEARCH_CLASS+"?data=DATA";
			System.out.println("searchUrl:" + searchUrl);
			CenterSearch<SearchPo> c = new CenterSearch<SearchPo>();
			c.setSearchClass(SearchPo.class.getSimpleName());
			c.setMethod(method);
			c.setNumPerPageStr(numPerPageStr == null ? "" + numPerPage : numPerPageStr);
			c.setPageNumStr(pageNumStr == null ? "" + pageNum : pageNumStr);
			c.setReturnType(SearchTypeEnum.SHOP.getDesc());
			SearchPo s = new SearchPo();
			s.setCity(city);
//			s.setBiosphere(city);
			c.setT(s);
			JSONObject jsonObject = JSONObject.fromObject(c);
			
			searchUrl = searchUrl.replace("DATA",URLEncoder.encode(jsonObject.toString(), "utf-8"));
			String httpRequest = HttpRequestUtil.httpRequest(searchUrl, "GET");
			if (httpRequest == null || httpRequest == "") {
				throw new WebException("1003", "服务器繁忙，请重试");
			}
			jsonObject = JSONObject.fromObject(httpRequest);
			PageBean p = (PageBean) JSONObject.toBean(jsonObject, PageBean.class);
			JSONArray jsonArray = JSONArray.fromObject(p.getRecordList());
			List<Object> list = JSONArray.toList(jsonArray,ShowShop.class);
			p.setRecordList(list);
			return p;
		} catch (WebException e) {
			log.error("== searchSMByKywordAndType exception:", e);
			throw new WebException("1003", e.getMessage());
		} catch (UnsupportedEncodingException e) {
			throw new WebException("1003", e.getMessage());
		}
	}
	/***
	 * 
	 * @param model
	 * @param city
	 * @param methodId
	 * @return
	 */
	@RequestMapping(value = "readyGetSearchData/{city}/{methodId}")
	public String getNeedSearchData(Model model,@PathVariable("city")String city,
			@PathVariable("methodId")String methodId,@RequestParam("keyWord")String keyWord,
			@RequestParam(value="theme",required=false)String theme,
			@RequestParam(value="project",required=false)String project){
		try {
			keyWord=keyWord.equals("empty")?"":keyWord;
			Map<String, Object> paramMap =new HashMap<String, Object>();
			paramMap.put("cityName", city);
			City c=(City) cityService.getBy(paramMap, "listAll");
			paramMap.put("cityId", c.getId());
			List<Object> listBy = districtService.listBy(paramMap, "listAll");
			List<Object> listBy1 = projectFirstService.listBy(null,"listAll");
			List<Object> listBy2 = projectService.listBy(null, "listAll");
			List<Object> listBy3 = themetzFirstService.listBy(null, "listAll");
			List<Object> listBy4 = themetzService.listBy(null, "listAll");
			model.addAttribute("firstProject",listBy1);
			model.addAttribute("secondProject",listBy2);
			model.addAttribute("themetzFirstService",listBy3);
			model.addAttribute("themetzService",listBy4);
			model.addAttribute("district", listBy);
			model.addAttribute("cityName", city);
			model.addAttribute("keyWord", keyWord);
			if(theme!=null &&!theme.isEmpty()){
				model.addAttribute("theme", theme);
			}
			if(project!=null && !project.isEmpty()){
				model.addAttribute("project", project);
			}
		} catch (WebException  e) {
			log.error("== getNeedSearchData exception:", e);
			throw new WebException("1003", e.getMessage());
		}
		return  "farmer/secondPage/secondSearch";
	}
	
	/***
	 * 跳转到搜索页面
	 * @param model
	 * @param city
	 * @param methodId
	 * @return
	 */
	@RequestMapping(value = "forwordSearch/{city}/{keyword}")
	public String forwordSearch(Model model,@PathVariable("city")String city,@PathVariable("keyword")String keyword){
		try {
		 	List<Object> listBy = keyWordKWService.listBy(null, "listAll");
			model.addAttribute("city", city);
			model.addAttribute("listKeyWord", listBy);
			model.addAttribute("keyWord", keyword);
		} catch (WebException  e) {
			log.error("== getNeedSearchData exception:", e);
			throw new WebException("1003", e.getMessage());
		}
		return  "farmer/common/search";
	}
}
