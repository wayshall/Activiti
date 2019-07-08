package org.onetwo.boot.activiti;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletException;

import org.activiti.app.servlet.WebConfigurer;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ActivitiConfiguration implements ServletContextInitializer {
	
	private WebConfigurer webConfigurer = new WebConfigurer();
	
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		ServletContextAttributeEvent event = new ServletContextAttributeEvent(servletContext, "", "");
		webConfigurer.contextInitialized(event);
	}

}
