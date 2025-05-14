package com.bp.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInit
		extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[] { AppConfig.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] { WebConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

	@Override
	public void onStartup(ServletContext sc) throws ServletException {
		super.onStartup(sc);

		sc.addFilter("hiddenHttpMethodFilter", new HiddenHttpMethodFilter())
				.addMappingForUrlPatterns(null, true, "/*");

		sc.addFilter("encodingFilter",
				new CharacterEncodingFilter("UTF-8", true))
				.addMappingForUrlPatterns(null, true, "/*");
	}
}
