package com.upic.listener;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.ServletContextAware;

import com.upic.common.config.PublicConfig;
import com.upic.order.enums.TradeStatusEnum;
import com.upic.service.IProjectFirstService;
import com.upic.service.IProjectService;

public class InitClassIndexListener implements ServletContextListener{
	public static final String log4jdirkey = "log4jdir";
	
	@Autowired
	private IProjectFirstService projectFirstService;
	@Autowired
	private IProjectService projectService;
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		System.getProperties().remove(log4jdirkey);
		System.out.println("服务器停止");		
	}

	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		ServletContext application = servletContextEvent.getServletContext();
		String ctx = servletContextEvent.getServletContext().getContextPath();
//		List<Object> listBy = projectFirstService.listBy(null,"listAll");
//		List<Object> listBy2 = projectService.listBy(null, "listAll");
		
		application.setAttribute("upic", ctx+"/farmer");
//		application.setAttribute("firstProject",listBy);
//		application.setAttribute("secondProject",listBy2);
		application.setAttribute("ctx", ctx);
		application.setAttribute("searchClass", PublicConfig.SEARCH_CLASS);
		application.setAttribute("searchKeyWord", PublicConfig.SEARCH_KEWORD);
		application.setAttribute("statusType", TradeStatusEnum.getJsonStr());
	}
	
	

}
