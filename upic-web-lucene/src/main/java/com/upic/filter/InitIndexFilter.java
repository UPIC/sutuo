package com.upic.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.upic.common.entity.CenterSearch;
import com.upic.common.entity.SearchPo;
import com.upic.lucene.emuns.SearchTypeEnum;
import com.upic.utils.ParseDataManger;

import net.sf.json.JSONObject;

public class InitIndexFilter implements Filter {
	private static Log log = LogFactory.getLog(InitIndexFilter.class);

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		HttpSession session = request.getSession();

		// 获得用户请求的URI
		String path = request.getRequestURI();
		String contextPath = request.getContextPath();
		String url = path.substring(contextPath.length());
		String data = request.getParameter("data");
		if (data == null) {
			filterChain.doFilter(request, response);
		}
		CenterSearch<SearchPo> searchBean = ParseDataManger.getSearchBean(data, CenterSearch.class);
		JSONObject fromObject = JSONObject.fromObject(searchBean.getT());
		SearchPo bean = (SearchPo) JSONObject.toBean(fromObject, SearchPo.class);
		searchBean.setT(bean);
		if (!searchBean.getT().getCity().isEmpty() && searchBean.getT().getCity() != null) {
			String substring = searchBean.getT().getCity().substring(0, searchBean.getT().getCity().length() - 1);
			searchBean.getT().setCity(substring);
		}

		if (!searchBean.getT().getBiosphere().isEmpty() && searchBean.getT().getBiosphere() != null) {
			String substring = searchBean.getT().getBiosphere().substring(0, searchBean.getT().getCity().length() - 1);
			searchBean.getT().setBiosphere(substring);
		}
		request.setAttribute("data", JSONObject.fromObject(searchBean).toString());
		filterChain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	public boolean JudgeIsMoblie(HttpServletRequest request) {
		boolean isMoblie = false;
		String[] mobileAgents = { "iphone", "android", "phone", "mobile", "wap", "netfront", "java", "opera mobi",
				"opera mini", "ucweb", "windows ce", "symbian", "series", "webos", "sony", "blackberry", "dopod",
				"nokia", "samsung", "palmsource", "xda", "pieplus", "meizu", "midp", "cldc", "motorola", "foma",
				"docomo", "up.browser", "up.link", "blazer", "helio", "hosin", "huawei", "novarra", "coolpad", "webos",
				"techfaith", "palmsource", "alcatel", "amoi", "ktouch", "nexian", "ericsson", "philips", "sagem",
				"wellcom", "bunjalloo", "maui", "smartphone", "iemobile", "spice", "bird", "zte-", "longcos", "pantech",
				"gionee", "portalmmm", "jig browser", "hiptop", "benq", "haier", "^lct", "320x320", "240x320",
				"176x220", "w3c ", "acs-", "alav", "alca", "amoi", "audi", "avan", "benq", "bird", "blac", "blaz",
				"brew", "cell", "cldc", "cmd-", "dang", "doco", "eric", "hipt", "inno", "ipaq", "java", "jigs", "kddi",
				"keji", "leno", "lg-c", "lg-d", "lg-g", "lge-", "maui", "maxo", "midp", "mits", "mmef", "mobi", "mot-",
				"moto", "mwbp", "nec-", "newt", "noki", "oper", "palm", "pana", "pant", "phil", "play", "port", "prox",
				"qwap", "sage", "sams", "sany", "sch-", "sec-", "send", "seri", "sgh-", "shar", "sie-", "siem", "smal",
				"smar", "sony", "sph-", "symb", "t-mo", "teli", "tim-", "tosh", "tsm-", "upg1", "upsi", "vk-v", "voda",
				"wap-", "wapa", "wapi", "wapp", "wapr", "webc", "winw", "winw", "xda", "xda-", "Googlebot-Mobile" };
		if (request.getHeader("User-Agent") != null) {
			for (String mobileAgent : mobileAgents) {
				if (request.getHeader("User-Agent").toLowerCase().indexOf(mobileAgent) >= 0) {
					isMoblie = true;
					break;
				}
			}
		}
		return isMoblie;
	}
}
