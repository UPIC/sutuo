package com.upic.client.interptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class InitInterceptor implements HandlerInterceptor{
	private List<String> allowPass;
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		String url=request.getRequestURL().toString();
		for(String allow:allowPass){
			if(url.endsWith(allow)){
				return true;
			}
		}
		Object user=request.getSession().getAttribute("user");
		if(user!=null){
			return true;
		}
		request.setAttribute("oldurl", request.getParameter("url"));
		request.getRequestDispatcher("/weixinApp/login.jsp").forward(request, response);
//		response.sendRedirect(request.getContextPath()+"/login.jsp?oldurl="+request.getParameter("url"));
		return false;
	}
	public List<String> getAllowPass() {
		return allowPass;
	}

	public void setAllowPass(List<String> allowPass) {
		this.allowPass = allowPass;
	}
	
}
