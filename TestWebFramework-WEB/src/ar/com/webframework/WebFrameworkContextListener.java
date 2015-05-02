package ar.com.webframework;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;

import ar.com.webframework.controller.ControllerCache;

public class WebFrameworkContextListener implements ServletContextListener {

	private static final Logger logger = Logger.getLogger(WebFrameworkContextListener.class);

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {

	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		logger.info("Context initialized - Loading configuration...");
		ControllerCache.getInstance().loadActions(sce.getServletContext().getRealPath("/WEB-INF/config/config.xml"));
		logger.info("Configuration loaded...");
	}
}
