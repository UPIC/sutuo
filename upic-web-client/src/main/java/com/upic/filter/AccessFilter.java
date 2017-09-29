package com.upic.filter;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.context.support.XmlWebApplicationContext;

import com.upic.common.enums.AccessEnum;
import com.upic.po.Access;
import com.upic.po.Shop;
import com.upic.po.Store;
import com.upic.po.User;
import com.upic.service.IAccessService;
import com.upic.service.IShopService;
import com.upic.service.IStoreService;
import com.upic.weixin.util.WxConst;

public class AccessFilter implements Filter {
	private static final Logger LOG = LoggerFactory.getLogger(AccessFilter.class);

	private List<String> allowurls = new ArrayList<String>();// 白名单

	private IAccessService accessService;
	
	private IShopService shopService;
	
	private IStoreService storeService;

	@Override
	public void init(FilterConfig arg0) throws ServletException {

		allowurls.add("/shop/searchBySN");
		allowurls.add("/shop/searchShopDetials");
		allowurls.add("/init/initIndex");
		allowurls.add("/init/initSelect");
	}

	@Override
	public void destroy() {

	}


	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;

		ServletContext sc = request.getSession().getServletContext();
		XmlWebApplicationContext cxt = (XmlWebApplicationContext) WebApplicationContextUtils
				.getWebApplicationContext(sc);

		if (cxt != null && cxt.getBean("shopService") != null && accessService == null) {
			accessService = (IAccessService) cxt.getBean("accessService");
			shopService=(IShopService) cxt.getBean("shopService");
			storeService= (IStoreService) cxt.getBean("storeService");
		}
		String path = request.getServletPath();
		try{
		for(String all:allowurls){
			if(path.contains(all)){
				Map<String, Object> paramMap = new HashMap<String, Object>();
				
				Access a=new Access();
				//访问首页
				if(path.contains(allowurls.get(2))){
					a.setType(AccessEnum.FIRSTPAGE.getDesc());
					accessService.insert(a);
					//选择城市
				}else if(path.contains(allowurls.get(3))){
					a.setType(AccessEnum.SELECTCITY.getDesc());
					a.setCity((String)request.getParameter("city"));
					accessService.insert(a);
					//访问商品
				}else if(path.contains(allowurls.get(0))){
					a.setType(AccessEnum.SELECTCITY.getDesc());
					paramMap.put("shopNumber", request.getParameter("shopNumber"));
					Shop s = (Shop) shopService.getBy(paramMap, "getByShopNumber");
					if(s==null){
						a.setShopNumber((String) request.getParameter("shopNumber"));
						a.setType(AccessEnum.SHOPPAGE.getDesc());
						accessService.insert(a);
						return ;
					}
					paramMap.clear();
					paramMap.put("storeNumber", s.getStoreNumber());
					Store store = (Store) storeService.getBy(paramMap, "getByStoreNumber");
					if(store!=null){
						a.setCity(store.getCityName());
						a.setPrivince(store.getProvinceName());
						a.setCounty(store.getDistrictName());
						a.setShopName(s.getShopName());
						a.setShopNumber(s.getShopNumber());
						a.setStoreName(store.getStoreName());
						a.setStoreNumber(store.getStoreNumber());
						accessService.insert(a);
					}
				}
			}
		}
		}catch(Exception e){
			chain.doFilter(request, response);
		}
		chain.doFilter(request, response);
	}

}
